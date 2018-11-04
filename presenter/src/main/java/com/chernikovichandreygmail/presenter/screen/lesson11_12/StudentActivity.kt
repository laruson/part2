package com.chernikovichandreygmail.presenter.screen.lesson11_12

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.databinding.ActivityStudentMvvmBinding
import com.chernikovichandreygmail.presenter.base.BaseMvvmActivity

class StudentActivity : BaseMvvmActivity<
        StudentViewModel,
        StudentRouter,
        ActivityStudentMvvmBinding>() {
    override fun provideViewModel(): StudentViewModel {
        return ViewModelProviders.of(this).get(StudentViewModel::class.java)
    }

    override fun provideRouter(): StudentRouter {
        return StudentRouter(this)
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_student_mvvm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            router.showList()
        }
    }
}