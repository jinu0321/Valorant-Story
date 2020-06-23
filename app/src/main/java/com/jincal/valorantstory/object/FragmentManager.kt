package com.jincal.valorantstory.`object`

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

object FragmentManager {
    fun replaceFragmentInContainer(container: Int, fragment: Fragment, activity: FragmentActivity) {
        val fragmentManager = activity.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(container, fragment)
        fragmentTransaction.commit()
    }
}