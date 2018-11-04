package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.Student
import andrey.chernikovich.domain.executer.PostExecutorThread
import andrey.chernikovich.domain.repository.StudentRepository
import io.reactivex.Observable

class UpdateStudentUseCase(
        postExecutorThread : PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {
    fun update(id:String, student: Student): Observable<Student> {
        return studentRepository
                .updateStudent(id,student)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}