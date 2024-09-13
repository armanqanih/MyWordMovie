package org.lotka.xenonx.presentation.ui.app




import android.annotation.SuppressLint
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.pager.ExperimentalPagerApi
import org.lotka.xenonx.presentation.screens.detail.DetailScreen
import org.lotka.xenonx.presentation.screens.home.HomeScreen
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
                startDestination = ScreensNavigation.detailScreen .route,
              ) {
                composable(
                    route = ScreensNavigation.homeScreen .route,
                ) {

                    HomeScreen(
                        onNavigate = navController::navigate
                    )


                }
                composable(
                    route = ScreensNavigation.detailScreen .route,
                ) {

                    DetailScreen()


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



