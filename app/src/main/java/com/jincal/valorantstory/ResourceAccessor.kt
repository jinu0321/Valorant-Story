package com.jincal.valorantstory

import android.app.Application
import android.content.res.Resources
import com.google.android.gms.ads.MobileAds

class ResourceAccessor: Application() {
    companion object {
        var mInstance: ResourceAccessor? = null
        var res: Resources? = null
    }

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)

        mInstance = this
        res = resources
    }
}