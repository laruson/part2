package com.chernikovichandreygmail.presenter.screen.lesson7.adapter

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.presenter.screen.lesson3.CircularTransformation
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class PicturesAdapter {

    fun setImage(url: String, image: ImageView, progressItem: ProgressBar) {
        if (url == "") {
            Picasso.get()
                    .load(R.drawable.sova_anmation_1)
                    .into(image, object : Callback {
                        override fun onSuccess() {
                            progressItem.visibility = View.GONE
                        }

                        override fun onError(e: Exception) {
                        }
                    })
        } else {
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
    }
}