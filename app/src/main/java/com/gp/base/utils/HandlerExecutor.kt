package com.gp.base.utils

import android.os.Handler
import android.os.Looper

import java.util.concurrent.Executor

class HandlerExecutor(looper: Looper) : Executor {
    private val handler = Handler(looper)

    override fun execute(r: Runnable) {
        handler.post(r)
    }
}