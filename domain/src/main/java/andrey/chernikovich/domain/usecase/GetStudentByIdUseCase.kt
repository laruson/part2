package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.Student
import andrey.chernikovich.domain.executer.PostExecutorThread
import andrey.chernikovich.domain.repository.StudentRepository
import io.reactivex.Observable

class GetStudentByIdUseCase(
        postExecutorThread : PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {
    fun getById(id: String): Observable<Student> {
        return studentRepository
                .getStudentById(id)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
