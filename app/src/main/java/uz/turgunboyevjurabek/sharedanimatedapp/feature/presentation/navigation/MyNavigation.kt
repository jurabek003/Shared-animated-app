@file:OptIn(ExperimentalSharedTransitionApi::class)

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import uz.turgunboyevjurabek.sharedanimatedapp.feature.presentation.navigation.AddItemRout
import uz.turgunboyevjurabek.sharedanimatedapp.feature.presentation.navigation.DetailRout
import uz.turgunboyevjurabek.sharedanimatedapp.feature.presentation.navigation.MainRout
import uz.turgunboyevjurabek.sharedanimatedapp.feature.presentation.screens.AddItemScreen
import uz.turgunboyevjurabek.sharedanimatedapp.feature.presentation.screens.DetailScreen
import uz.turgunboyevjurabek.sharedanimatedapp.feature.presentation.screens.MainScreen


@Composable
fun MyNavigation(modifier: Modifier = Modifier,navController : NavHostController) {

    val fabColor = MaterialTheme.colorScheme.inversePrimary
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = MainRout,
            modifier = Modifier
                .fillMaxSize()
        ) {
            composable<MainRout> {
                MainScreen(
                    fabColor = fabColor,
                    animatedVisibilityScope = this,
                    navHostController = navController,
                    onFabClick = {
                        navController.navigate(AddItemRout)
                    }
                )
            }
            composable<DetailRout> {
                val args = it.toRoute<DetailRout>()
                DetailScreen(
                    detailRout = args,
                    animatedVisibilityScope = this
                )
            }

            composable<AddItemRout> {
                AddItemScreen(
                    fabColor = fabColor,
                    animatedVisibilityScope = this,
                    navController = navController
                )
            }
        }

    }
}