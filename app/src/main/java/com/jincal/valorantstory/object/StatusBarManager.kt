package com.jincal.valorantstory.`object`

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.WindowManager

object StatusBarManager {
    fun changeStausBarColor(activity: Activity, colorAddress: Int) {
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = activity.getColor(colorAddress)
        }
    }
}