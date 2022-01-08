package zafar.abdulloev.aliftest.domain.model

sealed class Screen(val route: String) {

    object MasterScreen : Screen("master_screen")

    object DetailsScreen : Screen("detail_screen")

}