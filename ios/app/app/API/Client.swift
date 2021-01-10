//
//  Client.swift
//  app
//
//  Created by wenzhong zheng on 2021-01-10.
//

import Foundation
import Combine
import RxSwift

protocol Client {
    var baseURL: URL { get }
    
    func callCombine<DataType: Codable>(for endpoint: Endpoint<DataType>, decoder: JSONDecoder) -> AnyPublisher<DataType, Error>
    
    func call<DataType: Codable>(for endpoint: Endpoint<DataType>, decoder: JSONDecoder, completion: @escaping (Result<DataType, Error>) -> Void) -> URLSessionDataTask?
    
    func callRx<DataType: Codable>(for endpoint: Endpoint<DataType>, decoder: JSONDecoder) -> Observable<DataType>
}
