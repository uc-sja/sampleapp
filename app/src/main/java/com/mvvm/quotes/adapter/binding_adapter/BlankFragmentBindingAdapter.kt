package com.mvvm.quotes.adapter.binding_adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mvvm.quotes.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.task)
                .into(view);

    }
