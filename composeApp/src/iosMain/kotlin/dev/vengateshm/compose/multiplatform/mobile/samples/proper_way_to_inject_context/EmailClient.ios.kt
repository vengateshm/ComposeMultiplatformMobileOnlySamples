package dev.vengateshm.compose.multiplatform.mobile.samples.proper_way_to_inject_context

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class EmailClient {
    actual fun open(
        title: String,
        body: String,
        onComplete: (Boolean) -> Unit
    ) {
        val emailUrl = "mailto:vengateshm.13@gmail.com?subject=$title&body=$body"
        val url = NSURL(string = emailUrl)
        UIApplication.sharedApplication.openURL(
            url = url,
            options = emptyMap<Any?, Any?>(),
            completionHandler = { completed: Boolean ->
                onComplete(completed)
            }
        )
    }
}