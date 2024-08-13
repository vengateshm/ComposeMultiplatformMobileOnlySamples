package dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication

@OptIn(ExperimentalForeignApi::class)
@Composable
fun UIKitAlertDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit
) {
    UIKitView(
        modifier = modifier,
        factory = {
            val rootViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
            val alert = UIAlertController.alertControllerWithTitle(
                title = "Alert Title",
                message = "Alert Message",
                preferredStyle = UIAlertControllerStyleAlert
            )
            val actionOk = UIAlertAction.actionWithTitle(
                title = "Ok",
                style = UIAlertActionStyleDefault,
                handler = {
                    alert.dismissViewControllerAnimated(
                        flag = true,
                        completion = null
                    )
                    onDismissRequest()
                }
            )
            val actionCancel = UIAlertAction.actionWithTitle(
                title = "Cancel",
                style = UIAlertActionStyleDefault,
                handler = {
                    alert.dismissViewControllerAnimated(
                        flag = true,
                        completion = null
                    )
                    onDismissRequest()
                }
            )
            alert.addAction(actionOk)
            alert.addAction(actionCancel)
            rootViewController?.presentViewController(
                viewControllerToPresent = alert,
                animated = true,
                completion = null
            )
            alert.view
        },
        update = {

        }
    )
}