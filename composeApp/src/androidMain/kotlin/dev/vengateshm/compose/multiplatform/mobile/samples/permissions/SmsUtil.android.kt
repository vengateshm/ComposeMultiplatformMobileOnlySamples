package dev.vengateshm.compose.multiplatform.mobile.samples.permissions

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import dev.vengateshm.compose.multiplatform.mobile.samples.MyApplication

actual fun sendSms(number: String, message: String) {
    val smsIntent = Intent(Intent.ACTION_SENDTO)
        .apply {
            data = Uri.parse("smsto:$number")
            putExtra("sms_body", message)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
    val context = MyApplication.getApplicationContext()
    if (smsIntent.resolveActivity(context.packageManager) != null) {
        startActivity(context, smsIntent, null)
    }
}