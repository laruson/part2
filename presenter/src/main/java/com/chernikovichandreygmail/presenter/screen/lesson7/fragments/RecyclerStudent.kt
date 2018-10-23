package com.chernikovichandreygmail.presenter.screen.lesson7.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.presenter.screen.lesson7.adapter.StudentListAdapter
import com.chernikovichandreygmail.presenter.screen.lesson7.dao.StudentDao
import com.chernikovichandreygmail.presenter.screen.lesson7.domain.Student

class RecyclerStudent : Fragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var add: ImageView
    private lateinit var search: EditText

    private val adapter = StudentListAdapter(StudentDao.students) {
        student = it
        EditStudent.getStudent(student)
        if(this.resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE) {
            val transactionFragment = activity!!.supportFragmentManager.beginTransaction()
            transactionFragment.hide(RecyclerStudent.getInstance())
                    .replace(R.id.info_side, EditStudent.getInstance())
                    .addToBackStack(null)
                    .commit()
        }else{
            val transactionFragment = activity!!.supportFragmentManager.beginTransaction()
            transactionFragment.replace(R.id.fragment_site, EditStudent.getInstance())
                    .addToBackStack(null)
                    .commit()
        }
    }

    companion object {
        private lateinit var student: Student
        fun getInstance(): RecyclerStudent = RecyclerStudent()

        fun editStudent(student: Student) {
            if (this.student != student) {
                this.student.image = student.image
                this.student.name = student.name
                this.student.surName = student.surName
                this.student.age = student.age
            }
        }

        fun deleteStudent() {
            StudentDao.students.remove(student)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add = view.findViewById(R.id.add)
        search = view.findViewById(R.id.search)
        recycler = view.findViewById(R.id.recycler)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(view.context)
        recycler.setHasFixedSize(true)

        add.setOnClickListener {
            if(this.resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE) {
                val transactionFragment = activity!!.supportFragmentManager.beginTransaction()
                transactionFragment.replace(R.id.info_side, SaveStudent.getInstance())
                        .addToBackStack(null)
                        .commit()
            }else{
                val transactionFragment = activity!!.supportFragmentManager.beginTransaction()
                transactionFragment.replace(R.id.fragment_site, SaveStudent.getInstance())
                        .addToBackStack(null)
                        .commit()
            }

        }

        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    fun filter(text: String) {
        val items = ArrayList<Student>()
        for (item: Student in StudentDao.students) {
            when {
                item.name.toLowerCase().contains(text.toLowerCase()) -> items.add(item)
                item.surName.toLowerCase().contains(text.toLowerCase()) -> items.add(item)
                item.age.toString().contains(text.toLowerCase()) -> items.add(item)
            }
        }
        adapter.filterList(items)
    }
}