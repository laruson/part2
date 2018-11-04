package com.chernikovichandreygmail.presenter.screen.lesson11_12

import android.view.View
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.presenter.base.BaseRouter
import com.chernikovichandreygmail.presenter.screen.lesson11_12.details.StudentDetailsFragment
import com.chernikovichandreygmail.presenter.screen.lesson11_12.list.StudentListFragment

class StudentRouter(activity: StudentActivity) : BaseRouter<StudentActivity>(activity) {

    fun showList() {
        replaceFragment(StudentListFragment.getInstance(),
                activity.supportFragmentManager,
                StudentListFragment.getInstance(),
                R.id.container, false)
    }

    fun showDetails(id:String){
        val view= activity.findViewById<View>(R.id.container_details)
        if(view==null){
            replaceFragment(StudentListFragment.getInstance(),
                    activity.supportFragmentManager,
                    StudentDetailsFragment.getInstance(id),
                    R.id.container, true)
        }else{
            replaceFragment(StudentListFragment.getInstance(),
                    activity.supportFragmentManager,
                    StudentDetailsFragment.getInstance(id),
                    R.id.container_details, false)
        }
    }

    fun showDetails(){
        val view= activity.findViewById<View>(R.id.container_details)
        if(view==null){
            replaceFragment(StudentListFragment.getInstance(),
                    activity.supportFragmentManager,
                    StudentDetailsFragment.getInstance(),
                    R.id.container, true)
        }else{
            replaceFragment(StudentListFragment.getInstance(),
                    activity.supportFragmentManager,
                    StudentDetailsFragment.getInstance(),
                    R.id.container_details, false)
        }

    }
}