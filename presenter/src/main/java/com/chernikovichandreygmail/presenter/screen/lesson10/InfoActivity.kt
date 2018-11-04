package com.chernikovichandreygmail.presenter.screen.lesson10

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.databinding.ActivityInfoLesson10Binding
import com.chernikovichandreygmail.presenter.base.BaseMvvmActivity
import com.chernikovichandreygmail.util.ButtonClick

class InfoActivity : BaseMvvmActivity<
        InfoViewModel,
        InfoRouter,
        ActivityInfoLesson10Binding>() {

    override fun provideViewModel(): InfoViewModel {
        return ViewModelProviders
                .of(this)
                .get(InfoViewModel::class.java)
    }

    override fun provideRouter(): InfoRouter {
        return InfoRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_info_lesson10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.onClick = ButtonClick()
    }

}