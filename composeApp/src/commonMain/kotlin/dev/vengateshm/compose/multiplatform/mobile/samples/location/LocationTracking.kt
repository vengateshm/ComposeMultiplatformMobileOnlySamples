package dev.vengateshm.compose.multiplatform.mobile.samples.location

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.jordond.compass.Coordinates
import dev.jordond.compass.Priority
import dev.jordond.compass.geocoder.MobileGeocoder
import dev.jordond.compass.geocoder.placeOrNull
import dev.jordond.compass.geolocation.Geolocator
import dev.jordond.compass.geolocation.LocationRequest
import dev.jordond.compass.geolocation.TrackingStatus
import dev.jordond.compass.geolocation.isPermissionDeniedForever
import dev.jordond.compass.geolocation.mobile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun LocationTracking(modifier: Modifier = Modifier) {
    MaterialTheme {
        val scope = rememberCoroutineScope()
        val geoLocator = remember { Geolocator.mobile() }
        val trackingStatus by geoLocator.trackingStatus.collectAsState(initial = null)
        var currentLocation by remember { mutableStateOf<Coordinates?>(null) }
        var currentCity by remember { mutableStateOf<String?>(null) }

        LaunchedEffect(Unit) {
            geoLocator.trackingStatus.collectLatest { status ->
                when (status) {
                    is TrackingStatus.Idle -> {}
                    is TrackingStatus.Tracking -> {}
                    is TrackingStatus.Update -> {
                        currentLocation = status.location.coordinates
                        currentCity = MobileGeocoder().placeOrNull(status.location.coordinates)?.locality
                    }
                    is TrackingStatus.Error -> {
                        val error = status.cause
                        println("TRACKING ERROR $error")
                        val permissionDeniedForever = error.isPermissionDeniedForever()
                        println("TRACKING PERMISSION DENIED $permissionDeniedForever")
                    }
                }
            }
        }

        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = currentCity ?: "Fetching..."
            )
            Spacer(modifier = Modifier.height(height = 16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "LAT: ${currentLocation?.latitude}\nLNG: ${currentLocation?.longitude}"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    enabled = trackingStatus == TrackingStatus.Idle,
                    onClick = {
                        scope.launch(Dispatchers.IO) {
                            geoLocator.startTracking(request = LocationRequest(priority = Priority.HighAccuracy))
                        }
                    }
                ) {
                    Text(text = "Start")
                }
                Spacer(modifier = Modifier.width(width = 16.dp))
                Button(
                    enabled = trackingStatus != TrackingStatus.Idle,
                    onClick = {
                        scope.launch(Dispatchers.IO) {
                            geoLocator.stopTracking()
                            currentLocation = null
                            currentCity = null
                        }
                    }
                ) {
                    Text(text = "Stop")
                }
            }
        }
    }
}