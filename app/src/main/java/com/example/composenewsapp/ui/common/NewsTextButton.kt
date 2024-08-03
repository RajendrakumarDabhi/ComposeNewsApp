package com.example.composenewsapp.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NewsTextButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
) {
    TextButton(modifier = modifier, onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
private fun Preview() {
    NewsTextButton(modifier = Modifier.fillMaxWidth(), text = "Click here") {

    }
}