package com.jincal.valorantstory.`object`

import android.app.Activity
import android.util.DisplayMetrics

object ScreenSizeHolder {
    var screenWidth = 0
    var screenHeight = 0

    fun getPixelInfo(activity: Activity) {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels
        screenHeight = displayMetrics.heightPixels
    }
}