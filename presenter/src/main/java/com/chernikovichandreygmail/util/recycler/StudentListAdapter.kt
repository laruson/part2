package com.chernikovichandreygmail.util.recycler

import andrey.chernikovich.domain.entity.Student
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.util.picasso.transformImg
import kotlinx.android.synthetic.main.item_student_mvvm.view.*

class StudentListAdapter : RecyclerView.Adapter<StudentListAdapter.Holder>() {

    private var students: MutableList<Student> = mutableListOf()
    private lateinit var s : ArrayList<Student>
    private lateinit var onItemClick: (Student) -> Unit
    private lateinit var onLongClick: (Student) -> Unit

    fun setClick(onItemClick: (Student) -> Unit) {
        this.onItemClick = onItemClick
    }

    fun setOnLongClick(onLongClick: (Student) -> Unit) {
        this.onLongClick = onLongClick
    }

    fun setStudents(students: List<Student>) {
        this.students = students as MutableList<Student>
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_student_mvvm, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val student = students[position]
        holder.bind(student)

        holder.itemView.setOnClickListener {
            onItemClick(student)
        }

        holder.itemView.isLongClickable = true

        holder.itemView.setOnLongClickListener {
            onLongClick(student)
            students.remove(student)
        }
    }


    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(student: Student) {
            itemView.nameStudent.text = student.name
            itemView.ageStudent.text = student.age.toString()
            transformImg(student.img, itemView.img, itemView.progress)
        }
    }
}