package com.chernikovichandreygmail.lesson7.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.chernikovichandreygmail.R
import com.chernikovichandreygmail.lesson7.dao.StudentDao
import com.chernikovichandreygmail.lesson7.domain.Student

class StudentListAdapter(private var students: ArrayList<Student>, var onItemClick: (Student) -> Unit) : RecyclerView.Adapter<StudentListAdapter.Holder>() {

    private val pictureAdapter = PicturesAdapter()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_student, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val student = students[position]
        holder.nameText.text = student.name
        holder.surNameText.text = student.surName
        holder.ageText.text = student.age.toString()
        pictureAdapter.setImage(student.image, holder.image, holder.progress)

        holder.itemView.setOnClickListener{
            onItemClick(student)
        }
    }

    override fun getItemCount(): Int = students.size

    fun filterList(list : ArrayList<Student>){
        students=list
        notifyDataSetChanged()
    }


    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        var nameText: TextView = view.findViewById(R.id.nameItem)
        var surNameText: TextView = view.findViewById(R.id.surnameItem)
        var ageText: TextView = view.findViewById(R.id.ageItem)
        var image : ImageView = view.findViewById(R.id.imageItem)
        var progress : ProgressBar = view.findViewById(R.id.progressItem)

    }
}