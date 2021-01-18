//
//  DefaultClient.swift
//  app
//
//  Created by wenzhong zheng on 2021-01-10.
//

import Foundation
import Combine
import RxSwift

class DefaultClient: Client {
    
    var baseURL: URL = URL(string: "")! //TODO: Replace with an actual URL
    
    let urlSession = URLSession.shared
    
    func callCombine<EndpointType>(for endpoint: EndpointType) -> AnyPublisher<EndpointType.DataType, Error> where EndpointType : Endpoint {
        let request = endpoint.makeRequest(baseURL: baseURL)
        
        return urlSession
            .dataTaskPublisher(for: request)
            .map(\.data)
            .decode(type: EndpointType.DataType.self, decoder: endpoint.decoder)
            .receive(on: DispatchQueue.main)
            .eraseToAnyPublisher()
    }
    
    func call<EndpointType>(for endpoint: EndpointType, completion: @escaping (Result<EndpointType.DataType, Error>) -> Void) -> URLSessionDataTask? where EndpointType : Endpoint {
        let request = endpoint.makeRequest(baseURL: baseURL)
        
        let task = urlSession.dataTask(with: request) { data, _, error in
            if let error = error {
                completion(.failure(error))
                return
            }
            
            guard let data = data else {
                let error = NSError(domain: "InvalidDataError", code: 0, userInfo: nil)
                completion(.failure(error))
                return
            }
            
            let result = Result {
                try endpoint.decoder.decode(EndpointType.DataType.self, from: data)
            }
            
            completion(result)
        }
        task.resume()
        return task
    }
    
    func callRx<EndpointType>(for endpoint: EndpointType) -> Observable<EndpointType.DataType> where EndpointType : Endpoint {
        return Observable<EndpointType.DataType>.create { observer -> Disposable in
            let request = endpoint.makeRequest(baseURL: self.baseURL)
            let task = self.urlSession.dataTask(with: request) { data, response, error in
                do {
                    if let error = error {
                        throw error
                    }
                    
                    guard let data = data else {
                        throw NSError(domain: "InvalidDataError", code: 0, userInfo: nil)
                    }
                    
                    let model = try endpoint.decoder.decode(EndpointType.DataType.self, from: data)
                    observer.onNext(model)
                    observer.onCompleted()
                } catch let error {
                    observer.onError(error)
                    observer.onCompleted()
                }
            }
            task.resume()
            
            return Disposables.create {
                task.cancel()
            }
        }
    }
}
