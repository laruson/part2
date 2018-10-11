package com.chernikovichandreygmail.lesson7.adapter

import com.chernikovichandreygmail.lesson7.domain.Student

interface OnItemClick {
    fun onClick(student: Student)
}