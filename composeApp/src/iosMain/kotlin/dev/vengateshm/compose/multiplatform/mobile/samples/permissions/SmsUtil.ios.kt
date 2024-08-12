package dev.vengateshm.compose.multiplatform.mobile.samples.permissions

import dev.vengateshm.compose.multiplatform.mobile.samples.sms.SMSHandler
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual fun sendSms(number: String, message: String) {
    SMSHandler.sendSmsWithNumber(number = number, message = message)
}