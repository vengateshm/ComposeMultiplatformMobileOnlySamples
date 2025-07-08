package dev.vengateshm.compose.multiplatform.mobile.samples.currency_picker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.stevdza_san.library.component.CountryPickerDialog
import com.stevdza_san.library.component.CountryPickerField
import com.stevdza_san.library.domain.Country

@Composable
fun CurrencyPickerSample() {
    var selectedCountry by remember { mutableStateOf(Country.Serbia) }
    var showDialog by remember { mutableStateOf(false) }

    AnimatedVisibility(visible = showDialog) {
        CountryPickerDialog(
            selectedCountry = selectedCountry,
            onConfirmClick = { country ->
                selectedCountry = country
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }

    Box(
        modifier = Modifier.fillMaxSize().safeContentPadding(),
        contentAlignment = Alignment.Center
    ) {
        CountryPickerField(
            selectedCountry = selectedCountry,
            onClick = { showDialog = true }
        )
    }
}