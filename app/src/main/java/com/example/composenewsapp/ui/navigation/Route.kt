package com.example.composenewsapp.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")

    object AppStartNavigation : Route(route = "appStartNavigation")

    object NewsAppHomeNavigation : Route(route = "newsAppHomeNavigation")

    object NewsAppHomeScreen : Route(route = "newsAppHomeScreen")

    object SearchScreen : Route(route = "searchScreen")
}