package com.chernikovichandreygmail.util

import android.util.Log
import android.view.View
import com.chernikovichandreygmail.presenter.screen.lesson10.InfoViewModel

class ButtonClick : View.OnClickListener {

    override fun onClick(view: View) {
        if(InfoViewModel.staticSex.get())
            InfoViewModel.staticSex.set(false)
        else
            InfoViewModel.staticSex.set(true)
    }
}