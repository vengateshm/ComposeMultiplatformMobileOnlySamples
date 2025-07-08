package dev.vengateshm.compose.multiplatform.mobile.samples.location

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.jordond.compass.geocoder.MobileGeocoder
import dev.jordond.compass.geocoder.placeOrNull
import dev.jordond.compass.geolocation.Geolocator
import dev.jordond.compass.geolocation.GeolocatorResult
import dev.jordond.compass.geolocation.mobile

@Composable
fun CurrentLocationApp(modifier: Modifier = Modifier) {
    MaterialTheme {
        val geoLocation = remember { Geolocator.mobile() }

        LaunchedEffect(Unit) {
            when (val result = geoLocation.current()) {
                is GeolocatorResult.Success -> {
                    println("LOCATION SUCCESS: ${result.data.coordinates}")
                    println("LOCATION NAME: ${MobileGeocoder().placeOrNull(result.data.coordinates)?.locality}")
                }

                is GeolocatorResult.Error -> when (result) {
                    is GeolocatorResult.NotFound -> println("LOCATION SUCCESS: ${result.message}")
                    is GeolocatorResult.NotSupported -> println("LOCATION SUCCESS: ${result.message}")
                    is GeolocatorResult.PermissionError -> println("LOCATION SUCCESS: ${result.message}")
                    is GeolocatorResult.GeolocationFailed -> println("LOCATION SUCCESS: ${result.message}")
                    else -> println("LOCATION SUCCESS: ${result.message}")
                }
            }
        }
    }
}