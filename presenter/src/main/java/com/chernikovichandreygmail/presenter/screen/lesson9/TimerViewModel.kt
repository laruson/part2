package com.chernikovichandreygmail.presenter.screen.lesson9

import android.databinding.ObservableField
import android.util.Log
import com.chernikovichandreygmail.presenter.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class TimerViewModel : BaseViewModel<TimerRouter>() {

    val times = ObservableField<String>("0")
    private val disposable: Disposable

    init {
        Log.e("AAA", "im 9")

        disposable = Observable.interval(1, TimeUnit.SECONDS)
                .timeInterval()
                .subscribe { time ->
                    if ((time.value() % 2).toInt() == 0)
                        times.set(time.value().toString())
                }
    }


    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}

