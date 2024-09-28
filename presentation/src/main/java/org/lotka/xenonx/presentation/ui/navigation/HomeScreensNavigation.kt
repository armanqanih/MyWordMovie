package org.lotka.xenonx.presentation.ui.navigation

sealed class ScreensNavigation(val route: String) {


    object spalshScreen : ScreensNavigation(route = "splash")
    object playVideoScreen : ScreensNavigation(route = "play_video")
    object homeScreen : ScreensNavigation(route = "home")
    object detailScreen : ScreensNavigation(route = "homeDetails")
    object seeAllScreen : ScreensNavigation(route = "seeAll")
    object genryVisyScreen : ScreensNavigation(route = "genreWiseMovie")
    object searchScreen : ScreensNavigation(route = "search")
    object aboutScreen : ScreensNavigation(route = "about")
    object bookmarkScreen : ScreensNavigation(route = "book_mark")





}