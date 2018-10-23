package com.chernikovichandreygmail.presenter.screen.lesson7.adapter

import com.chernikovichandreygmail.presenter.screen.lesson7.domain.Student

interface OnItemClick {
    fun onClick(student: Student)
}