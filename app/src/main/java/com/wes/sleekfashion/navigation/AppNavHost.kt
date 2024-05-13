package com.wes.sleekfashion.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wes.sleekfashion.ui.theme.Home.HomeScreen
import com.wes.sleekfashion.ui.theme.Login.LoginScreen
import com.wes.sleekfashion.ui.theme.Products.MAINProductScreen
import com.wes.sleekfashion.ui.theme.Register.RegisterScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController= rememberNavController()
               , startDestination:String = ROUTE_HOME) {

    NavHost(navController = navController ,
        modifier = Modifier,
        startDestination = startDestination) {
        composable(ROUTE_HOME){ HomeScreen(navController = navController)}
        composable(ROUTE_LOGIN){ LoginScreen(navController = navController) }
        composable(ROUTE_REGISTER){ RegisterScreen(navController = navController) }
        composable(ROUTE_MAIN_PRODUCTS_SCREEN){ MAINProductScreen(navController = navController) }

    }
}