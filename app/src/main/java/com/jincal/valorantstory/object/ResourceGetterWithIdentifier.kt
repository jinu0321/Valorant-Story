package com.jincal.valorantstory.`object`

import android.app.Activity

object ResourceGetterWithIdentifier {
    fun getStringWithIdentifier(resourceName: String, activity: Activity): String {
        val packageName: String = activity.packageName
        val resourceId = activity.resources.getIdentifier(resourceName, "string", packageName)
        return if (resourceId != 0) activity.getString(resourceId) else ""
    }

    fun getImageIdWithIdentifier(resourceName: String, activity: Activity): Int {
        val packageName: String = activity.packageName
        return activity.resources.getIdentifier(resourceName, "drawable", packageName)
    }
}