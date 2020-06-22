package com.jincal.valorantstory.arsenal.arsenalcard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jincal.valorantstory.R
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.arsenal.Arsenal
import kotlinx.android.synthetic.main.recyclerview_item_arsenal_card.view.*

class ArsenalContentsRecyclerViewAdapter(val arsenals: Array<Arsenal>):
    RecyclerView.Adapter<ArsenalContentsRecyclerViewAdapter.ArsenalViewHolder>() {
    inner class ArsenalViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArsenalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_arsenal_card, parent, false)
        view.ItemArsenalCardImageView.layoutParams.height = ScreenSizeHolder.screenHeight / 7
        return ArsenalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arsenals.size
    }

    override fun onBindViewHolder(holder: ArsenalViewHolder, position: Int) {
        with(holder.view) {
            val arsenal = arsenals[position]
            ItemArsenalCardImageView.setImageResource(arsenal.imageId)
            ItemArsenalCardNameTextView.text = arsenal.name
            ItemArsenalCardTypeTextView.text = arsenal.type
        }

    }
}