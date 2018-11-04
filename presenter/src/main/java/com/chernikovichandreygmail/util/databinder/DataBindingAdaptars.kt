package com.chernikovichandreygmail.util.databinder

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.chernikovichandreygmail.util.picasso.CircularTransformation
import com.squareup.picasso.Picasso

@BindingAdapter("android:src")
fun loadImage(imageView: ImageView, url: String) {
    Picasso.get()
            .load(url)
            .transform(CircularTransformation())
            .into(imageView)
}

@BindingAdapter("visibility")
fun View.visibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
}
