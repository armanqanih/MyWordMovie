package org.lotka.xenonx.presentation.ui.app




import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import org.lotka.xenonx.presentation.screens.SearchScreen
import org.lotka.xenonx.presentation.screens.detail.DetailScreen
import org.lotka.xenonx.presentation.screens.home.HomeScreen
import org.lotka.xenonx.presentation.screens.see_all.SeeAllScreen
import org.lotka.xenonx.presentation.screens.splash.SplashScreen

import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeApp(
    activity: HomeActivity,
    navController: NavHostController,
    onNavigateToRecipeDetailScreen: (String) -> Unit,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    keyboardController: SoftwareKeyboardController,

    ) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val scaffoldState = rememberScaffoldState()




    Scaffold(

        content = { _ ->
            NavHost(navController = navController,
                startDestination = ScreensNavigation.homeScreen.route,
              ) {
                composable(
                    route = ScreensNavigation.homeScreen .route,
                ) {

                    HomeScreen(
                        onNavigate = navController::navigate
                        , onNavigateToPlayNow =  navController::navigate,
                        onSearchClick = navController::navigate
                    )


                }
                composable(
                    route = ScreensNavigation.searchScreen .route,
                ) {

                    SearchScreen(
                        onNavigateUp =  navController::navigateUp

                    )


                }
                composable(
                    route = ScreensNavigation.seeAllScreen .route,
                ) {

                    SeeAllScreen(
                        onNavigateUp =  navController::navigateUp

                    )


                }
                composable(
                    route = ScreensNavigation.detailScreen .route,
                ) {

                    DetailScreen(
                        onNavigateUp = navController::navigateUp
                    )


                }

                composable(
                    route = ScreensNavigation.spalshScreen.route,
                ) {

                    SplashScreen(
                        onNavigate = navController::navigate,

                    )


                }


            }

        },
    )

}



