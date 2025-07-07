package com.ulbra.kotlin_record_collection_app.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @BindingAdapter("bindImageResource")
    @JvmStatic
    fun ImageView.setImageFromUri(uriString: String?) {
        uriString?.let {
            Glide.with(this.context)
                .load(Uri.parse(it))
                .into(this)
        }
    }
}