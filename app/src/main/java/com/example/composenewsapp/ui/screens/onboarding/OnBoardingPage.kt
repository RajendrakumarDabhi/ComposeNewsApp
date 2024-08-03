package com.example.composenewsapp.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenewsapp.R
import com.example.composenewsapp.domain.models.getSamplePages
import com.example.composenewsapp.ui.common.NewsButton
import com.example.composenewsapp.ui.common.NewsTextButton
import com.example.composenewsapp.ui.common.PageIndicator
import com.example.composenewsapp.ui.common.Space
import com.example.composenewsapp.ui.theme.Dimens.MediumPadding1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPage(currentPage: Int, modifier: Modifier) {

    Column(modifier = modifier.background(Color.White)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.70f),
            painter = painterResource(id = R.drawable.onboarding1),
            contentDescription = "Onboarding Image",
            contentScale = ContentScale.Crop
        )
        Space(value = MediumPadding1)
        Text(
            text = "Loriem ipsom is simply dummy text",
            modifier = Modifier.padding(start = 4.dp, 4.dp),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Lorem ipsum is simply dummy text of the printing and typesetting industry.",
            modifier = Modifier.padding(start = 4.dp, 4.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    OnBoardingPage(1, modifier = Modifier.fillMaxHeight())
}