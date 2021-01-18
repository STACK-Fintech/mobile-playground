//
//  Date+Extensions.swift
//  app
//
//  Created by Wenzhong on 2021-01-16.
//

import Foundation

extension Date {
    func toDateString() -> String {
        let formatter = DateFormatter()
        formatter.timeStyle = .none
        formatter.dateStyle = .medium
        return formatter.string(from: self)
    }
}
