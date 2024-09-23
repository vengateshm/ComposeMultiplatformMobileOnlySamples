package dev.vengateshm.compose.multiplatform.mobile.samples.proper_way_to_inject_context

import android.content.Context
import android.content.Intent
import android.net.Uri

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class EmailClient(
    private val context: Context
) {
    actual fun open(
        title: String,
        body: String,
        onComplete: (Boolean) -> Unit
    ) {
        try {
            val intent = Intent(Intent.ACTION_SENDTO)
                .apply {
                    data = Uri.parse("mailto:vengateshm.13@gmail.com")
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
                onComplete(true)
            } else {
                onComplete(false)
            }
        } catch (e: Exception) {
            onComplete(false)
        }
    }
}