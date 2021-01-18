//
//  DefaultJSONDecodeer.swift
//  app
//
//  Created by Wenzhong on 2021-01-16.
//

import Foundation

class DefaultDecoder: JSONDecoder {
    override init() {
        super.init()
        let formatter = DateFormatter()
        formatter.dateFormat = "YYYY-MM-dd'T'HH:mm:ss.sss'Z'"
        dateDecodingStrategy = .formatted(formatter)
    }
}
