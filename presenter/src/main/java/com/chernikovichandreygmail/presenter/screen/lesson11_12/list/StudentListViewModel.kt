package com.chernikovichandreygmail.presenter.screen.lesson11_12.list

import andrey.chernikovich.domain.entity.StudentSearch
import android.view.View
import com.chernikovichandreygmail.factory.UseCaseProvider
import com.chernikovichandreygmail.presenter.base.BaseViewModel
import com.chernikovichandreygmail.presenter.screen.lesson11_12.StudentRouter
import com.chernikovichandreygmail.util.recycler.StudentListAdapter
import io.reactivex.rxkotlin.subscribeBy

class StudentListViewModel : BaseViewModel<StudentRouter>() {
    private val students = UseCaseProvider.provideStudentsUseCase()
    private val searchStudent = UseCaseProvider.provideSearchStudentUseCase()
    private val studentDelete = UseCaseProvider.provideDeleteStudentUseCase()

    val adapter: StudentListAdapter = StudentListAdapter()

    init {

        adapter.setClick {
            router?.showDetails(it.id)
        }


        addToDisposable(students.get().subscribeBy(
                onNext = {
                    adapter.setStudents(it)
                    adapter.notifyDataSetChanged()
                },
                onError = {
                    router?.showError(it)
                }
        ))

        adapter.setOnLongClick { it ->
            addToDisposable(studentDelete.delete(it.id)
                    .subscribeBy(onError = {
                    }))
            adapter.notifyDataSetChanged()
        }
    }

    fun search(name: String) {
        val search = StudentSearch(name)

        addToDisposable(searchStudent.search(search).subscribeBy(
                onNext = {
                    adapter.setStudents(it)
                    adapter.notifyDataSetChanged()

                },
                onError = {
                    router?.showError(it)
                }
        ))
    }

    fun save(view:View){
        router?.showDetails()
    }
}