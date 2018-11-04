package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.Student
import andrey.chernikovich.domain.executer.PostExecutorThread
import andrey.chernikovich.domain.repository.StudentRepository
import io.reactivex.Observable

class SaveStudentUseCase(
        postExecutorThread : PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {
    fun save(student: Student): Observable<Student> {
        return studentRepository
                .saveStudent(student)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}