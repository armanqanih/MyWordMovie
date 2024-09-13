package org.lotka.xenonx.presentation.ui.navigation

sealed class ScreensNavigation(val route: String) {


    object spalshScreen : ScreensNavigation(route = "splash")
    object homeScreen : ScreensNavigation(route = "home")
    object detailScreen : ScreensNavigation(route = "homeDetails")
    object seeAllScreen : ScreensNavigation(route = "seeAll")
    object genryVisyScreen : ScreensNavigation(route = "genreWiseMovie")
    object searchScreen : ScreensNavigation(route = "search")
    object aboutScreen : ScreensNavigation(route = "about")
    object watchListScreen : ScreensNavigation(route = "watch")





}