package com.wes.myapp.navigation

//import com.example.morningmvvm.ui.theme.screens.home.HomeScreen
//import com.example.morningmvvm.ui.theme.screens.login.LoginScreen
//import com.example.morningmvvm.ui.theme.screens.register.RegisterScreen
import AboutScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.morningmvvm.ui.theme.screens.login.LoginScreen
import com.wes.myapp.ui.theme.Screens.Home.HomeScreen
import com.wes.myapp.ui.theme.Screens.Profile.Profile
import com.wes.myapp.ui.theme.Screens.Register.RegisterScreen
import com.wes.myapp.ui.theme.Screens.gallery.Gallery
import com.wes.myapp.ui.theme.Screens.products.AddProducts
import com.wes.myapp.ui.theme.Screens.products.UpdateProductsScreen
import com.wes.myapp.ui.theme.Screens.products.ViewProductsScreen
import com.wes.myapp.ui.theme.Screens.products.ViewUploadsScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController: NavHostController= rememberNavController()
                    ,startDestination:String = ROUTE_REGISTER){

    NavHost(navController = navController,
        modifier=modifier,
       startDestination = startDestination ){
        composable(ROUTE_HOME){ HomeScreen(navController)}
        composable(ROUTE_ABOUT){ AboutScreen(navController)}
        composable(ROUTE_REGISTER){ RegisterScreen(navController)}
        composable(ROUTE_LOGIN){ LoginScreen(navController)}
        composable(ROUTE_PROFILE){ Profile(navController)}
        composable(ROUTE_GALLERY){ Gallery(navController)}
        composable(ROUTE_ADD_PRODUCT){ AddProducts(navController) }
        composable(ROUTE_VIEW_PRODUCT){ ViewProductsScreen(navController) }
        composable(ROUTE_UPDATE_PRODUCT + "/{id}"){ passedData -> UpdateProductsScreen(
            navController, passedData.arguments?.getString("id") !!
        )}
   composable(ROUTE_VIEW_UPLOAD_PRODUCT){
ViewUploadsScreen(navController)
}}}
