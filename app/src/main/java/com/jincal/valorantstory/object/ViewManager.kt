package com.jincal.valorantstory.`object`

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.jincal.valorantstory.MainActivity
import com.jincal.valorantstory.R
import com.jincal.valorantstory.ResourceAccessor
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

    fun highlightSelectedTab(selectedTab: TextView, unSelectedTab1: TextView, unSelectedTab2: TextView, selectedTabColor: String) {
        setTextColorOfTextView(selectedTab, selectedTabColor)
        setTextColorOfTextView(unSelectedTab1, ResourceAccessor.res!!.getString(R.string.color_white))
        setTextColorOfTextView(unSelectedTab2, ResourceAccessor.res!!.getString(R.string.color_white))
        when (selectedTabColor) {
            "#00897B" -> selectedTab.setBackgroundResource(R.drawable.background_main_agent)
            "#7C46EA" -> selectedTab.setBackgroundResource(R.drawable.background_main_arsenal)
            "#F19E36" -> selectedTab.setBackgroundResource(R.drawable.background_main_map)
        }
        unSelectedTab1.setBackgroundResource(R.drawable.background_tabselector)
        unSelectedTab2.setBackgroundResource(R.drawable.background_tabselector)
    }
}