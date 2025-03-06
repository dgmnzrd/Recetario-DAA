package com.example.apprecetario.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.apprecetario.views.MenuView
import com.example.apprecetario.views.RecipeView
import com.example.apprecetario.views.Recipe
import com.google.gson.Gson
import java.net.URLEncoder
import java.net.URLDecoder

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavManager() {
    val navController = rememberNavController()
    val gson = Gson()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            MenuView(
                onRecipeSelected = { recipe ->
                    val recipeJson = gson.toJson(recipe)
                    val encodedRecipe =
                        URLEncoder.encode(recipeJson, "UTF-8")
                    navController.navigate("recipe/$encodedRecipe")
                }
            )
        }

        composable(
            route = "recipe/{recipeJson}",
            arguments = listOf(
                navArgument("recipeJson") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("recipeJson") ?: ""
            val decodedJson = URLDecoder.decode(json, "UTF-8")
            val recipe =
                gson.fromJson(decodedJson, Recipe::class.java)

            RecipeView(
                recipe = recipe,
                onBack = { navController.popBackStack() }
            )
        }
    }
}