package com.jincal.valorantstory.`object`

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.jincal.valorantstory.R
import com.jincal.valorantstory.ResourceAccessor

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

    fun highlightSelectedTab(selectedTab: TextView, unSelectedTab1: TextView, unSelectedTab2: TextView) {
        setTextColorOfTextView(selectedTab, ResourceAccessor.res!!.getString(R.string.color_deep_pink))
        setTextColorOfTextView(unSelectedTab1, ResourceAccessor.res!!.getString(R.string.color_white))
        setTextColorOfTextView(unSelectedTab2, ResourceAccessor.res!!.getString(R.string.color_white))
    }
}