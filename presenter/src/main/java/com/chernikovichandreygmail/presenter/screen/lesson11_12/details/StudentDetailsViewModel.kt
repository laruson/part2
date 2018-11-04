package com.chernikovichandreygmail.presenter.screen.lesson11_12.details

import andrey.chernikovich.domain.entity.Student
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.view.View
import com.chernikovichandreygmail.presenter.screen.lesson11_12.StudentRouter
import com.chernikovichandreygmail.factory.UseCaseProvider
import com.chernikovichandreygmail.presenter.base.BaseViewModel
import io.reactivex.rxkotlin.subscribeBy

class StudentDetailsViewModel : BaseViewModel<StudentRouter>() {
    private val studentByIdUseCase = UseCaseProvider.provideStudentByIdUseCase()
    private val studentSave = UseCaseProvider.provideSaveStudentUseCase()
    private val studentUpdate = UseCaseProvider.provideUpdateStudentUseCase()

    private lateinit var id: String

    val isProgressEnabled = ObservableBoolean(true)
    val isNewStudent = ObservableBoolean(false)
    val cursorVisibility = ObservableBoolean(false)

    val imageStudent = ObservableField<String>("https://image.freepik.com/free-icon/no-translate-detected_318-31510.jpg")
    val nameStudent = ObservableField<String>("")
    val ageStudent = ObservableField<String>("")

    fun setStudentId(id: String) {
        this.id = id
        addToDisposable(studentByIdUseCase
                .getById(id)
                .subscribeBy(
                        onNext = {
                            nameStudent.set(it.name)
                            ageStudent.set(it.age.toString())
                            imageStudent.set(it.img)
                            isProgressEnabled.set(false)
                        },
                        onError = {
                            isProgressEnabled.set(true)
                            router?.showError(it)
                        }
                )
        )
    }

    fun saveStudent(view: View) {
        val student = Student(name = nameStudent.get()!!, age = ageStudent.get()!!.toInt(), img = imageStudent.get()!!)
        addToDisposable(studentSave
                .save(student)
                .subscribeBy(
                        onError = {
                            router?.showError(it)
                        }
                ))
        router?.showList()
    }

    fun clickEdit(view: View) {
        cursorVisibility.set(true)
    }

    fun updateStudent(view: View) {
        val student = Student(name = nameStudent.get()!!, age = ageStudent.get()!!.toInt(), img = imageStudent.get()!!)
        addToDisposable(studentUpdate
                .update(id, student)
                .subscribeBy(
                        onError = {
                            router?.showError(it)
                        }))
        router?.showList()
    }
}