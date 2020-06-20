package com.jincal.valorantstory.`object`

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.jincal.valorantstory.R
import kotlinx.android.synthetic.main.activity_main.*

object ViewManager {
    fun setWidthOf(view: View, value: Int) {
        view.layoutParams.width = value
    }

    fun setHeightOf(view: View, value: Int) {
        view.layoutParams.height = value
    }

    private fun setTextColorOfTextView(textView: TextView, color: String) {
        textView.setTextColor(Color.parseColor(color))
    }

    private fun setTextSizeOfTextView(textView: TextView, size: Int) {
        textView.textSize = size.toFloat()
    }

    fun changeTheTabColorAndSize(selectedTab: TextView, activity: Activity, unSelectedTab1: TextView, unSelectedTab2: TextView) {
        setTextColorOfTextView(selectedTab, activity.getString(R.string.color_deep_pink))
        setTextSizeOfTextView(selectedTab, 32)
        setTextColorOfTextView(unSelectedTab1, activity.getString(R.string.color_white))
        setTextSizeOfTextView(unSelectedTab1, 22)
        setTextColorOfTextView(unSelectedTab2, activity.getString(R.string.color_white))
        setTextSizeOfTextView(unSelectedTab2, 22)
    }
}