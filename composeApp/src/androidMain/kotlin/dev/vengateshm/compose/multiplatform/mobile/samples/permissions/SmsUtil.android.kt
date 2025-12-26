package dev.vengateshm.compose.multiplatform.mobile.samples.permissions

import android.content.Intent
import androidx.core.net.toUri
import dev.vengateshm.compose.multiplatform.mobile.samples.MyApplication

actual fun sendSms(number: String, message: String) {
    val smsIntent = Intent(Intent.ACTION_SENDTO)
        .apply {
            data = "smsto:$number".toUri()
            putExtra("sms_body", message)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
    val context = MyApplication.getApplicationContext()
    if (smsIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(smsIntent, null)
    }
}