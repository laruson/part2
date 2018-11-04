package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.Student
import andrey.chernikovich.domain.executer.PostExecutorThread
import andrey.chernikovich.domain.repository.StudentRepository
import io.reactivex.Observable

class GetStudentsUseCase(postExecutorThread : PostExecutorThread,
                         private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {
    fun get(): Observable<List<Student>> {
        return studentRepository
                .getStudents()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}