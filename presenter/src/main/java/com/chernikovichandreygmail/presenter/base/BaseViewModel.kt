package com.chernikovichandreygmail.presenter.base

import android.arch.lifecycle.ViewModel

abstract class BaseViewModel<R : BaseRouter<*>> : ViewModel() {
    protected var router: R? = null

    fun addRouter(router : R?) {
        this.router = router
    }

    fun removeRouter() {
        router = null
    }

}