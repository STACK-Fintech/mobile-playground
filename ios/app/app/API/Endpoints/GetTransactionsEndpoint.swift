//
//  GetTransactionsEndpoint.swift
//  app
//
//  Created by Wenzhong on 2021-01-16.
//

import Foundation

struct GetTransactionsEndpoint: Endpoint {
    typealias DataType = [Transaction]
    
    var path: String = "transactions"
    
    var queryItems: [URLQueryItem] = []
}
