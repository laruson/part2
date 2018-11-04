package com.chernikovichandreygmail.presenter.screen.lesson11_12.list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.databinding.FragmentStudentListBinding
import com.chernikovichandreygmail.presenter.base.BaseMvvmFragment
import com.chernikovichandreygmail.presenter.screen.lesson11_12.StudentRouter
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.subscribeBy

class StudentListFragment: BaseMvvmFragment<
        StudentListViewModel,
        StudentRouter,
        FragmentStudentListBinding>() {
    override fun provideViewModel(): StudentListViewModel {
        return ViewModelProviders.of(this).get(StudentListViewModel::class.java)
    }

    companion object {
        fun getInstance(): StudentListFragment {
            return StudentListFragment()
        }
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_student_list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter=viewModel.adapter
        binding.recycler.layoutManager= LinearLayoutManager(context)
        binding.recycler.setHasFixedSize(true)
        RxTextView.textChanges(binding.searchEdit)
                .subscribeBy {
                    viewModel.search(it.toString())
                }
    }
}