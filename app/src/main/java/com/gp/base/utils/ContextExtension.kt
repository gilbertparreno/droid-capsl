package com.gp.base.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.widget.Toast
import java.util.concurrent.Executor


fun Context.showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}

fun Context.mainExecutor(): Executor {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        mainExecutor
    } else {
        HandlerExecutor(mainLooper)
    }
}

fun Context.hasInternet() : Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    if (activeNetwork != null) {
        if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
            return true
        } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
            return true
        }

        return false
    } else {
        return false
    }
}