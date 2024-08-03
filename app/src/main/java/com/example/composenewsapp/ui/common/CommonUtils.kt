package com.example.composenewsapp.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.Space(value: Dp) {
    Spacer(modifier = Modifier.width(value))
}

@Composable
fun ColumnScope.Space(value: Dp) {
    Spacer(modifier = Modifier.height(value))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Column(modifier = Modifier.padding(4.dp).fillMaxWidth())
    {
        NewsTextButton(Modifier.fillMaxWidth(),text = "Welcome") {

        }
        Space(24.dp)
        NewsButton(Modifier.fillMaxWidth(), text = "Welcome 2") {

        }
    }
}