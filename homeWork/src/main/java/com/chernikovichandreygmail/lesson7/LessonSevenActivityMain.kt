package com.chernikovichandreygmail.lesson7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.lesson7.dao.StudentDao
import com.chernikovichandreygmail.lesson7.fragments.RecyclerStudent

class LessonSevenActivityMain : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_lesson7)
        val transactionFragment = supportFragmentManager.beginTransaction()
        transactionFragment.replace(R.id.fragment_site, RecyclerStudent.getInstance())
                .commit()
    }
}