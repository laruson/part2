package com.andreygmail.studentmvvm.util.recycler

import andrey.chernikovich.domain.entity.Student

interface OnLongItemClick {
    fun onLongClick(student: Student)
}