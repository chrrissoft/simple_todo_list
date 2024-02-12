package com.chrrissoft.simpletodolist.permissions.view

import com.chrrissoft.simpletodolist.base.view.event.BaseEvent
import com.chrrissoft.simpletodolist.permissions.view.PermissionsViewModel.EventHandler

sealed interface PermissionsEvent : BaseEvent<EventHandler>
