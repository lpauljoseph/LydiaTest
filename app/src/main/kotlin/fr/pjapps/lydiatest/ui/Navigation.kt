package fr.pjapps.lydiatest.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import fr.pjapps.lydiatest.details.ContactDetailsScreenNavigation
import fr.pjapps.lydiatest.model.Route
import fr.pjapps.lydiatest.search.SearchScreenNavigation

const val CONTACT_ID_ARGUMENT = "contactId"

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {
    val onGoBack: () -> Unit = { navController.popBackStack() }

    NavHost(navController = navController, startDestination = Route.Search.name) {

        composable(route = Route.Search.name) {
            SearchScreenNavigation(navigateToDetail = { contactId ->
                navController.navigate("${Route.Details.name}/$contactId")
            })
        }

        composable(
            route = "${Route.Details.name}/{$CONTACT_ID_ARGUMENT}",
            arguments = listOf(navArgument(CONTACT_ID_ARGUMENT) { type = NavType.StringType })
        ) {
            ContactDetailsScreenNavigation(contactUUID = it.arguments?.getString(CONTACT_ID_ARGUMENT), onGoBack = onGoBack)
        }
    }
}
