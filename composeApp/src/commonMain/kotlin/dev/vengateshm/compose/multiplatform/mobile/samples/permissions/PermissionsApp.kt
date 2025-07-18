package dev.vengateshm.compose.multiplatform.mobile.samples.permissions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.compose.BindEffect
import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory

@Composable
fun PermissionsApp(modifier: Modifier = Modifier) {
    MaterialTheme {
        val factory = rememberPermissionsControllerFactory()
        val controller = remember(factory) {
            factory.createPermissionsController()
        }

        BindEffect(controller)

        val viewModel = viewModel {
            PermissionsViewModel(controller)
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (viewModel.state) {
                PermissionState.Granted -> {
                    Text("Record audio permission granted!")
                }

                PermissionState.DeniedAlways -> {
                    Text("Permission was permanently declined.")
                    Button(onClick = {
                        controller.openAppSettings()
                    }) {
                        Text("Open app settings")
                    }
                }

                else -> {
                    Button(
                        onClick = {
                            viewModel.provideOrRequestRecordAudioPermission()
                        }
                    ) {
                        Text("Request permission")
                    }
                }
            }
        }
    }
}