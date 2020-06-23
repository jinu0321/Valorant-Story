package com.jincal.valorantstory.map.mapcard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jincal.valorantstory.R
import com.jincal.valorantstory.map.Map
import kotlinx.android.synthetic.main.recyclerview_item_map_card.view.*

class MapCardRecyclerViewAdapter(private val maps: Array<Map>): RecyclerView.Adapter<MapCardRecyclerViewAdapter.MapCardViewHolder>() {
    inner class MapCardViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_map_card, parent, false)
        view.ItemMapCardImageView.clipToOutline = true
        return MapCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return maps.size
    }

    override fun onBindViewHolder(holder: MapCardViewHolder, position: Int) {
        with(holder.view) {
            ItemMapCardImageView.setImageResource(maps[position].cardImageId)
            ItemMapNameTextView.text = maps[position].name
        }
    }
}