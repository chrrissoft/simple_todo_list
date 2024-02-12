package com.chrrissoft.simpletodolist.navigation


sealed class Screen(val baseRoute: String) {
    abstract val route: String

    object Splash : Screen("splash") {
        override val route = baseRoute
    }

    object Permissions : Screen("permissions") {
        override val route = baseRoute
    }

    object Demo : Screen("demo") {
        override val route = baseRoute
    }

    object Main : Screen("auth") {
        override val route = baseRoute
    }
}
