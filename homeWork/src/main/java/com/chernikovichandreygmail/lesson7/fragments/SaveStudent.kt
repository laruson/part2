package com.chernikovichandreygmail.lesson7.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.lesson7.dao.StudentDao
import com.chernikovichandreygmail.lesson7.domain.Student
import kotlinx.android.synthetic.main.activity_recycler_view_lesson7.view.*

class SaveStudent : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var save: Button
    private lateinit var photo: EditText
    private lateinit var name: EditText
    private lateinit var surName: EditText
    private lateinit var age: EditText

    companion object {
        const val URL_KEY = "URL_KEY"
        const val NAME_KEY = "NAME_KEY"
        const val SURNAME_KEY = "SURNAME_KEY"
        const val AGE_KEY = "AGE_KEY"

        fun getInstance(): SaveStudent {
            return SaveStudent()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save = view.findViewById(R.id.save)
        photo = view.findViewById(R.id.addPhoto)
        name = view.findViewById(R.id.addName)
        surName = view.findViewById(R.id.addSurName)
        age = view.findViewById(R.id.addAge)

        save.setOnClickListener {
            if(emptyCheck()){
                StudentDao.students.add(Student(
                        photo.text.toString()
                        ,name.text.toString()
                        ,surName.text.toString()
                        ,age.text.toString().toInt()))
                val transactionFragment = activity!!.supportFragmentManager.beginTransaction()
                transactionFragment.replace(R.id.fragment_site, RecyclerStudent.getInstance())
                        .addToBackStack(null)
                        .commit()
            }
        }
    }

    private fun emptyCheck(): Boolean {
        if (photo.text.toString() == "") {
            Toast.makeText(view!!.context, "Загрузите фото", Toast.LENGTH_LONG).show()
            return false
        } else if (name.text.toString() == "") {
            Toast.makeText(view!!.context, "Введите имя", Toast.LENGTH_LONG).show()
            return false
        } else if (surName.text.toString() == "") {
            Toast.makeText(view!!.context, "Введите фамилию", Toast.LENGTH_LONG).show()
            return false
        } else if (age.text.toString() == "") {
            Toast.makeText(view!!.context, "Введите возраст", Toast.LENGTH_LONG).show()
            return false
        } else
            return true
    }


}