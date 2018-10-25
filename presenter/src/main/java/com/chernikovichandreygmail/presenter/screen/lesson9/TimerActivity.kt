package com.chernikovichandreygmail.presenter.screen.lesson9

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.android.databinding.library.baseAdapters.BR
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.databinding.ActivityTimerLesson9Binding
import com.chernikovichandreygmail.presenter.base.BaseMvvmActivity

class TimerActivity : BaseMvvmActivity<
        TimerViewModel,
        TimerRouter,
        ActivityTimerLesson9Binding>() {

    override fun provideViewModel(): TimerViewModel {
        return ViewModelProviders
                .of(this)
                .get(TimerViewModel::class.java)
    }

    override fun provideRouter(): TimerRouter {
        return TimerRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_timer_lesson9


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.setVariable(BR.timer, viewModel)
    }
}