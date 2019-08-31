package com.gp.base.screen.base

interface FingerprintAuthListener {
    fun onSuccess()
    fun onError(throwable: Throwable)
}