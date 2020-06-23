package com.jincal.valorantstory.arsenal.arsenalcard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.jincal.valorantstory.ArsenalDetailActivity
import com.jincal.valorantstory.R
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.arsenal.Arsenal
import kotlinx.android.synthetic.main.recyclerview_item_arsenal_card.view.*
import org.jetbrains.anko.support.v4.startActivity

class ArsenalCardRecyclerViewAdapter(val arsenals: Array<Arsenal>, val fragment: Fragment):
    RecyclerView.Adapter<ArsenalCardRecyclerViewAdapter.ArsenalViewHolder>() {
    inner class ArsenalViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                fragment.startActivity<ArsenalDetailActivity>("identifier" to arsenals[adapterPosition].identifier)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArsenalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_arsenal_card, parent, false)
        view.layoutParams.height = ScreenSizeHolder.screenHeight / 8
        view.ItemArsenalCardImageView.layoutParams.height = ScreenSizeHolder.screenHeight / 8
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