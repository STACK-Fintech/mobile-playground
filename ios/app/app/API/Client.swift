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
    
    func callCombine<EndpointType: Endpoint>(for endpoint: EndpointType) -> AnyPublisher<EndpointType.DataType, Error>
    
    func call<EndpointType: Endpoint>(for endpoint: EndpointType, completion: @escaping (Result<EndpointType.DataType, Error>) -> Void) -> URLSessionDataTask?
    
    func callRx<EndpointType: Endpoint>(for endpoint: EndpointType) -> Observable<EndpointType.DataType>
}
