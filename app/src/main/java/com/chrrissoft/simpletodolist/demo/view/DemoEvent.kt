package com.chrrissoft.simpletodolist.demo.view

import com.chrrissoft.simpletodolist.base.view.event.BaseEvent
import com.chrrissoft.simpletodolist.demo.view.DemoViewModel.EventHandler

sealed interface DemoEvent : BaseEvent<EventHandler>
