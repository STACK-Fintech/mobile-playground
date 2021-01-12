//
//  EndPoint.swift
//  app
//
//  Created by wenzhong zheng on 2021-01-09.
//

import Foundation
import Combine

struct Endpoint<DataType: Codable> {
    var path: String
    var queryItems = [URLQueryItem]()
}

extension Endpoint {
    func makeRequest(baseURL: URL) -> URLRequest {
        guard var components = URLComponents(url: baseURL.appendingPathComponent(path), resolvingAgainstBaseURL: false) else {
            fatalError("Unable to create URL components \(self)")
        }
                
        components.path = "/" + path
        components.queryItems = queryItems.isEmpty ? nil : queryItems
        
        guard let url = components.url else {
            fatalError("Could not get url from \(components)")
        }
        
        return URLRequest(url: url)
    }
}

struct InvalidEndpointError<R>: Error where R : Codable {
    let endpoint: Endpoint<R>
}




