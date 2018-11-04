package com.chernikovichandreygmail.util.recycler

import andrey.chernikovich.domain.entity.Student

interface OnItemClick {
    fun onClick(student: Student)
}