package com.ulbra.kotlin_record_collection_app.ui.adapter

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("bindImageResource")
    @JvmStatic
    fun ImageView.setImageFromUri(uriString: String?) {
        if(!uriString.isNullOrEmpty()) {
            Glide.with(this.context)
                .load(uriString.toUri())
                .into(this)
        }
    }
}