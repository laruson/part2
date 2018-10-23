package com.chernikovichandreygmail.presenter.screen.lesson7.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.presenter.screen.lesson7.adapter.PicturesAdapter
import com.chernikovichandreygmail.presenter.screen.lesson7.domain.Student

class EditStudent : Fragment() {
    private val picturesAdapter = PicturesAdapter()

    private lateinit var progress: ProgressBar
    private lateinit var imageView: ImageView
    private lateinit var photoEdit: EditText
    private lateinit var nameEdit: EditText
    private lateinit var surNameEdit: EditText
    private lateinit var ageEdit: EditText
    private lateinit var editButton: Button
    private lateinit var deleteButton: Button

    companion object {
        private lateinit var photo: String
        private lateinit var name: String
        private lateinit var surName: String
        private var age: Int = 0

        fun getInstance(): EditStudent = EditStudent()

        fun getStudent(student: Student) {
            photo = student.image
            name = student.name
            surName = student.surName
            age = student.age
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_student_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.editImage)
        photoEdit = view.findViewById(R.id.editPhoto)
        nameEdit = view.findViewById(R.id.editName)
        surNameEdit = view.findViewById(R.id.editSurname)
        ageEdit = view.findViewById(R.id.editAge)
        progress = view.findViewById(R.id.editProgress)
        editButton = view.findViewById(R.id.editButton)
        deleteButton = view.findViewById(R.id.deleteButton)

        picturesAdapter.setImage(EditStudent.photo, imageView, progress)
        photoEdit.setText(photo)
        nameEdit.setText(name)
        surNameEdit.setText(surName)
        ageEdit.setText(age.toString())

        editButton.setOnClickListener {
            RecyclerStudent.editStudent(Student(
                    photoEdit.text.toString()
                    , nameEdit.text.toString()
                    , surNameEdit.text.toString()
                    , ageEdit.text.toString().toInt()))
            activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_site, RecyclerStudent.getInstance())
                    .addToBackStack(null)
                    .commit()
        }

        deleteButton.setOnClickListener {
            RecyclerStudent.deleteStudent()
            activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_site, RecyclerStudent.getInstance())
                    .addToBackStack(null)
                    .commit()
        }
    }
}