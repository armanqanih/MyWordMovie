package org.lotka.xenonx.presentation.ui.app




import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import org.lotka.xenonx.presentation.screens.search.SearchScreen
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
//                composable(
//                    route = ScreensNavigation.playVideoScreen .route,
//                ) {
//                    PlayVideoScreen()
//
//                }
                    composable(
                    route = ScreensNavigation.homeScreen .route,
                ) {

                    HomeScreen(
                        onNavigateToDetailPlayNow = navController::navigate,
                        onSearchClick = navController::navigate,
                        onNavigateToPopular = navController::navigate,
                        onNavigateToDiscover = navController::navigate,
                        onNavigateToUpCommon = navController::navigate,
                        onNavigateToMorePlayNow = navController::navigate

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
                    route = ScreensNavigation.seeAllScreen .route+ "/{seeAllTags}",
                    arguments = listOf(navArgument("seeAllTags")
                    { type = NavType.StringType })
                ) {

                    SeeAllScreen(
                        it.arguments?.getString("seeAllTags")?:"1",
                        onNavigateDetailScreen = navController::navigate,
                        onNavigateToSearchScreen = navController::navigate
                    )


                }


                composable(
                    route = ScreensNavigation.genryVisyScreen .route
                    + "/{genId}" + "/{genName}",
                    arguments = listOf(
                        navArgument("genId"){type=NavType.StringType},
                        navArgument("genName"){type=NavType.StringType}
                    )
                    ,
                ) {

                    SearchScreen(
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



