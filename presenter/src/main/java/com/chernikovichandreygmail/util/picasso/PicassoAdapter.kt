package com.chernikovichandreygmail.util.picasso

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.chernikovichandreygmail.util.recycler.StudentListAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun StudentListAdapter.Holder.transformImg(url: String, image: ImageView, progressItem: ProgressBar){
    Picasso.get()
            .load(url)
            .transform(CircularTransformation())
            .into(image, object : Callback {
                override fun onSuccess() {
                    progressItem.visibility = View.GONE
                }
                override fun onError(e: Exception) {
                }
            })
}