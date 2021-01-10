//
//  Transaction.swift
//  app
//
//  Created by wenzhong zheng on 2021-01-10.
//

import Foundation

struct Transaction: Codable {
    let transactionId: String
    let transactionDescription: String
    let transactionType: String
    let transactionDate: Date
    let transactionAmount: Double
}
