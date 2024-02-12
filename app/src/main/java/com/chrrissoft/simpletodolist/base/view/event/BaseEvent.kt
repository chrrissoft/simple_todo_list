package com.chrrissoft.simpletodolist.base.view.event

import com.chrrissoft.simpletodolist.base.view.handler.BaseEventHandler

interface BaseEvent<H : BaseEventHandler> {
    fun resolve(handler: H)
}
