package com.chrrissoft.simpletodolist.splash.view

import com.chrrissoft.simpletodolist.base.view.event.BaseEvent
import com.chrrissoft.simpletodolist.splash.view.SplashViewModel.EventHandler

sealed interface SplashEvent : BaseEvent<EventHandler>
