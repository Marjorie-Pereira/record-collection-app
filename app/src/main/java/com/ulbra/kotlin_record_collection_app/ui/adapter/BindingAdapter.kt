package com.ulbra.kotlin_record_collection_app.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @BindingAdapter("bindImageResource")
    @JvmStatic
    fun bindImageResource(imageView: ImageView, resId: Int) {
        imageView.setImageResource(resId)
    }
}