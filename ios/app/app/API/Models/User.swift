//
//  User.swift
//  app
//
//  Created by wenzhong zheng on 2021-01-10.
//

import Foundation

struct User: Codable {
    let firstName: String
    let lastName: String
    let transactions: [String]
}
