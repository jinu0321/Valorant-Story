package com.jincal.valorantstory.`object`

import android.graphics.Color
import android.view.View
import android.widget.TextView
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

    fun highlightSelectedTab(selectedTab: TextView, unSelectedTab1: TextView, unSelectedTab2: TextView, selectedTabColor: String) {
        setTextColorOfTextView(selectedTab, ResourceAccessor.res!!.getString(R.string.color_white))
        setTextColorOfTextView(unSelectedTab1, ResourceAccessor.res!!.getString(R.string.color_gray))
        setTextColorOfTextView(unSelectedTab2, ResourceAccessor.res!!.getString(R.string.color_gray))
        when (selectedTabColor) {
            "#00897B" -> selectedTab.setBackgroundResource(R.drawable.background_tab_agent)
            "#7C46EA" -> selectedTab.setBackgroundResource(R.drawable.background_tab_arsenal)
            "#F19E36" -> selectedTab.setBackgroundResource(R.drawable.background_tab_map)
        }
        unSelectedTab1.setBackgroundResource(R.drawable.background_tab_unselected)
        unSelectedTab2.setBackgroundResource(R.drawable.background_tab_unselected)
    }
}