package com.chernikovichandreygmail.factory

import andrey.chernikovich.data.net.RestService
import andrey.chernikovich.data.repository.StudentRepositoryImpl
import andrey.chernikovich.domain.usecase.*
import com.chernikovichandreygmail.executer.UIThread


object UseCaseProvider {
    private val thread = UIThread()
    private val restService = RestService("https://api.backendless.com/98B5864F-3782-B965-FFE7-C2C8ED158600/4EC3BD97-9B44-D52E-FF86-63E87CEE8300/data/")
    private val studentRep = StudentRepositoryImpl(restService)

    fun provideStudentsUseCase(): GetStudentsUseCase {
        return GetStudentsUseCase(thread, studentRep)
    }

    fun provideStudentByIdUseCase(): GetStudentByIdUseCase {
        return GetStudentByIdUseCase(thread, studentRep)
    }

    fun provideSearchStudentUseCase(): SearchStudentUseCase {
        return SearchStudentUseCase(thread, studentRep)
    }

    fun provideUpdateStudentUseCase(): UpdateStudentUseCase {
        return UpdateStudentUseCase(thread, studentRep)
    }

    fun provideSaveStudentUseCase(): SaveStudentUseCase {
        return SaveStudentUseCase(thread, studentRep)
    }

    fun provideDeleteStudentUseCase(): DeleteStudentUseCase {
        return DeleteStudentUseCase(thread, studentRep)
    }
}