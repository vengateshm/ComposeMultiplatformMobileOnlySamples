//
//  SimpleIOSButton.swift
//  iosApp
//
//  Created by Vengatesh on 03/03/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

class IOSNativeViewFactory : NativeViewFactory {
    static var shared = IOSNativeViewFactory()
    func createButtonView(
        label: String,
        onClick: @escaping () -> Void
    ) -> UIViewController {
        let view = SimpleIOSButton(label: label, action: onClick)
        return UIHostingController(rootView: view)
    }
}

struct SimpleIOSButton: View {
    var label:String
    var action: () -> Void
    var body: some View {
        Button(action: action) {
            Text(label)
                .font(.headline)
        }
    }
}

#Preview {
    SimpleIOSButton(label:"Hello!", action:{})
}
