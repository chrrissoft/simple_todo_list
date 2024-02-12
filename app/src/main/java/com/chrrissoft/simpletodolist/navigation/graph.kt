package com.chrrissoft.simpletodolist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chrrissoft.simpletodolist.demo.view.DemoScreen
import com.chrrissoft.simpletodolist.demo.view.DemoViewModel
import com.chrrissoft.simpletodolist.main.view.MainScreen
import com.chrrissoft.simpletodolist.main.view.MainViewModel
import com.chrrissoft.simpletodolist.permissions.view.PermissionsScreen
import com.chrrissoft.simpletodolist.permissions.view.PermissionsViewModel
import com.chrrissoft.simpletodolist.splash.view.SplashScreen
import com.chrrissoft.simpletodolist.splash.view.SplashViewModel
import com.chrrissoft.simpletodolist.utils.ComposeUtils.setBarsColors

@Composable
fun SimpleTodoAppGraph() {
    val controller = rememberNavController()
    val currentStack by controller.currentBackStackEntryAsState()


    NavHost(controller, Screen.Main.route) {
        screen(Screen.Splash) {
            val viewModel = hiltViewModel<SplashViewModel>()
            val state by viewModel.stateFlow.collectAsState()
            SplashScreen(
                state = state,
                onEvent = { viewModel.handleEvent(it) },
            )
        }

        screen(Screen.Demo) {
            val viewModel = hiltViewModel<DemoViewModel>()
            val state by viewModel.stateFlow.collectAsState()
            DemoScreen(
                state = state,
                onEvent = { viewModel.handleEvent(it) },
            )
        }

        screen(Screen.Permissions) {
            val viewModel = hiltViewModel<PermissionsViewModel>()
            val state by viewModel.stateFlow.collectAsState()
            PermissionsScreen(
                state = state,
                onEvent = { viewModel.handleEvent(it) },
            )
        }

        screen(Screen.Main) {
            setBarsColors()
            val viewModel = hiltViewModel<MainViewModel>()
            val state by viewModel.stateFlow.collectAsState()
            MainScreen(
                state = state,
                onEvent = { viewModel.handleEvent(it) },
            )
        }
    }
}
