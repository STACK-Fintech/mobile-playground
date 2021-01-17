//
//  GetUsersEndpoint.swift
//  app
//
//  Created by Wenzhong on 2021-01-16.
//

import Foundation

struct GetUsersEndpoint: Endpoint {
    typealias DataType = [User]
    
    var path: String = "users"
    
    var queryItems: [URLQueryItem] = []
}
