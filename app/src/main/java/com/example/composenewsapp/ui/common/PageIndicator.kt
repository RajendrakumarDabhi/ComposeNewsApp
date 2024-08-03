package com.example.composenewsapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    selectedPage: Int,
    pageSize: Int
) {
    Row {
        repeat(pageSize) {
            val isSelected = it == selectedPage
            val color = if (isSelected) Color.Blue else Color.Gray
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .padding(start = 6.dp, end = 6.dp, top = 6.dp, bottom = 6.dp)
                    .then(modifier)
                    .clip(androidx.compose.foundation.shape.CircleShape)
                    .background(color),
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    PageIndicator(selectedPage = 1, pageSize = 3)
}