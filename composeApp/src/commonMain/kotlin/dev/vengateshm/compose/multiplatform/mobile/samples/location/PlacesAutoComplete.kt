package dev.vengateshm.compose.multiplatform.mobile.samples.location

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.jordond.compass.Place
import dev.jordond.compass.autocomplete.Autocomplete
import dev.jordond.compass.autocomplete.mobile
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlacesAutoComplete(modifier: Modifier = Modifier) {
    MaterialTheme {
        val scope = rememberCoroutineScope()
        val autoComplete = remember { Autocomplete.mobile() }
        var expanded by remember { mutableStateOf(false) }
        var searchQuery by remember { mutableStateOf("") }
        var places = remember { mutableStateListOf<Place?>() }
        var selectedPlace by remember { mutableStateOf<Place?>(null) }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = if (selectedPlace != null) "${selectedPlace?.locality} ${selectedPlace?.country}\nLAT: ${selectedPlace?.coordinates?.latitude}\nLNG: ${selectedPlace?.coordinates?.longitude}" else "No place selected."
            )
            Spacer(modifier = Modifier.height(height = 16.dp))
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {}
            ) {
                TextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            scope.launch {
                                autoComplete.search(searchQuery).getOrNull().let {
                                    places.clear()
                                    places.addAll(it?.toList() ?: emptyList())
                                }
                            }
                            expanded = !expanded
                        }
                    )
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    if (places.isNotEmpty()) {
                        places.forEach { selectionOption ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedPlace = selectionOption
                                    expanded = false
                                }
                            ) {
                                Text(text = selectionOption?.locality ?: "Unknown place")
                            }
                        }
                    }
                }
            }
        }
    }
}