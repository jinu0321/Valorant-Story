package com.jincal.valorantstory.map

import com.jincal.valorantstory.R
import com.jincal.valorantstory.ResourceAccessor

class Map(val identifier: String) {
    var name = ""
    var cardImageId = 0
    var fullImageId = 0

    init {
        when (identifier) {
            "ascent" -> {
                cardImageId = R.drawable.ascent_card
                name = ResourceAccessor.res!!.getString(R.string.map_ascent)
            }
            "bind" -> {
                cardImageId = R.drawable.bind_card
                name = ResourceAccessor.res!!.getString(R.string.map_bind)
            }
            "heaven" -> {
                cardImageId = R.drawable.heaven_card
                name = ResourceAccessor.res!!.getString(R.string.map_heaven)
            }
            "split" -> {
                cardImageId = R.drawable.split_card
                name = ResourceAccessor.res!!.getString(R.string.map_split)
            }
            else -> {
                cardImageId = R.drawable.bind_card
                name = ResourceAccessor.res!!.getString(R.string.map_bind)
            }
        }
        if (ResourceAccessor.res!!.getString(R.string.language) == "English") {
            fullImageId = when (identifier) {
                "ascent" -> R.drawable.ascent_full_en
                "bind" -> R.drawable.bind_full_en
                "heaven" -> R.drawable.heaven_full_en
                "split" -> R.drawable.split_full_en
                else -> R.drawable.bind_full_en
            }
        } else {
            fullImageId = when (identifier) {
                "ascent" -> R.drawable.ascent_full_kr
                "bind" -> R.drawable.bind_full_kr
                "heaven" -> R.drawable.heaven_full_kr
                "split" -> R.drawable.split_full_kr
                else -> R.drawable.bind_full_kr
            }
        }
    }
}