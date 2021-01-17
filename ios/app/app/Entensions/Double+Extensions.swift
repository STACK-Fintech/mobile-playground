//
//  Double+Extensions.swift
//  app
//
//  Created by Wenzhong on 2021-01-16.
//

import Foundation

extension Double {
    func toCurrencyString() -> String {
        let numberFormatter = NumberFormatter()
        numberFormatter.numberStyle = .currency
        return numberFormatter.string(from: NSNumber(value: self)) ?? ""
    }
}
