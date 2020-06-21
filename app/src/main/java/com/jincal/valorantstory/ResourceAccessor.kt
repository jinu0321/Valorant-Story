package com.jincal.valorantstory

import android.app.Application
import android.content.res.Resources

class ResourceAccessor: Application() {
    companion object {
        var mInstance: ResourceAccessor? = null
        var res: Resources? = null
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        res = resources
    }
}