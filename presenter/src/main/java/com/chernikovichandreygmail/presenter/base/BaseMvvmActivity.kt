package com.chernikovichandreygmail.presenter.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.android.databinding.library.baseAdapters.BR

abstract class BaseMvvmActivity<
        VM : BaseViewModel<R>,
        R : BaseRouter<*>,
        B : ViewDataBinding> : BaseActivity() {
    protected lateinit var viewModel: VM
    protected lateinit var binding: B
    public lateinit var router: R


    abstract fun provideViewModel(): VM

    abstract fun provideRouter(): R

    abstract fun provideLayoutId(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
        binding = DataBindingUtil.setContentView(this, provideLayoutId())


        router = provideRouter()
    }

    override fun onResume() {
        super.onResume()
        viewModel.addRouter(router)
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeRouter()
    }
}