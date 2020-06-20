package com.jincal.valorantstory

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class DataBindingAdapters {
    @BindingAdapter("srcCompat")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}