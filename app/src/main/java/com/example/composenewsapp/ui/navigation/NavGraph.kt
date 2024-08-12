package com.example.composenewsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.composenewsapp.ui.screens.home.HomeScreen
import com.example.composenewsapp.ui.screens.home.HomeScreenViewModel
import com.example.composenewsapp.ui.screens.onboarding.OnBoardingScreen
import com.example.composenewsapp.ui.screens.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(viewModel)
            }
        }

        navigation(
            route = Route.NewsAppHomeNavigation.route,
            startDestination = Route.NewsAppHomeScreen.route
        ) {
            composable(route = Route.NewsAppHomeScreen.route) {
                val viewModel = hiltViewModel<HomeScreenViewModel>()
                val items = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(listArticle = items) {

                }
            }
        }
    }
}