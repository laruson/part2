package com.chernikovichandreygmail.presenter.screen.lesson11_12.details

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.databinding.FragmentDetailsStudentBinding
import com.chernikovichandreygmail.presenter.base.BaseMvvmFragment
import com.chernikovichandreygmail.presenter.screen.lesson11_12.StudentRouter

class StudentDetailsFragment : BaseMvvmFragment<
        StudentDetailsViewModel,
        StudentRouter,
        FragmentDetailsStudentBinding>() {

    override fun provideViewModel(): StudentDetailsViewModel {
        return ViewModelProviders.of(this).get(StudentDetailsViewModel::class.java)
    }

    companion object {
        private const val ID_EXTRA = "ID_EXTRA"

        fun getInstance(id: String=""): StudentDetailsFragment {
            val fragment = StudentDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_details_student
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.get(ID_EXTRA) as String
        if (id != "") {
            viewModel.setStudentId(id)
        } else{
            viewModel.isNewStudent.set(true)
            viewModel.isProgressEnabled.set(false)
        }
    }
}