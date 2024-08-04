package com.example.composenewsapp.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composenewsapp.domain.models.getSamplePages
import com.example.composenewsapp.ui.common.NewsButton
import com.example.composenewsapp.ui.common.NewsTextButton
import com.example.composenewsapp.ui.common.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(viewModel: OnBoardingViewModel) {
    val pagerState = rememberPagerState(initialPage = 0) {
        getSamplePages().size
    }
    val buttonsState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                2 -> listOf("Back", "Get Started")
                else -> listOf("", "")
            }
        }
    }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(pagerState.currentPage, Modifier.fillMaxWidth())
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(100.dp),
                selectedPage = pagerState.currentPage,
                pageSize = getSamplePages().size
            )
            Row(Modifier.padding()) {
                NewsTextButton(
                    modifier = Modifier
                        .height(40.dp)
                        .navigationBarsPadding(),
                    text = buttonsState.value.get(0)
                )
                {
                    scope.launch {
                        if (pagerState.currentPage == 0) {
                            pagerState.animateScrollToPage(0)
                        } else {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage - 1
                            )
                        }
                    }
                }
                NewsButton(modifier = Modifier.height(40.dp), text = buttonsState.value.get(1)) {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            viewModel.onEvent(OnBoardingScreenEvents.OnGetStarted)
                        } else {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
                        }
                    }
                }

            }
        }

    }
}

@Preview
@Composable
private fun Preview() {
    OnBoardingScreen(hiltViewModel())
}