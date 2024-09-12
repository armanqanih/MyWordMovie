package org.lotka.xenonx.presentation.ui.navigation

sealed class ScreensNavigation(val route: String) {




    object HomeScreen : ScreensNavigation(route = "home_screen")
    object single_chat_screen : ScreensNavigation(route = "SingleChatScreen")





}