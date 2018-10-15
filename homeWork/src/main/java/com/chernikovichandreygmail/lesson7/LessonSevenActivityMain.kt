package com.chernikovichandreygmail.lesson7

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.lesson7.dao.StudentDao
import com.chernikovichandreygmail.lesson7.fragments.RecyclerStudent
import com.chernikovichandreygmail.lesson7.fragments.SaveStudent
import com.chernikovichandreygmail.lesson7.load.LoadData

class LessonSevenActivityMain : AppCompatActivity() {
    private val load = LoadData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_lesson7)
        if (StudentDao.students.size == 0) {
            Thread {
                load.load()
            }.start()
            if (StudentDao.students.size == 0)
                waiting()
        }

        var transactionFragment = supportFragmentManager.beginTransaction()
        transactionFragment.replace(R.id.fragment_site, RecyclerStudent.getInstance())
                .commit()
        if(this.resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE) {
            transactionFragment = supportFragmentManager.beginTransaction()
            transactionFragment.replace(R.id.info_side, SaveStudent.getInstance())
                    .commit()
        }


        }

    private fun waiting() {
        if (StudentDao.students.size == 0) {
            Thread.sleep(10)
            waiting()
        }
    }
}