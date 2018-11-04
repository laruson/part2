package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.executer.PostExecutorThread
import andrey.chernikovich.domain.repository.StudentRepository
import io.reactivex.Observable

class DeleteStudentUseCase(
        postExecutorThread : PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {
    fun delete(id: String): Observable<String> {
        return studentRepository
                .deleteStudent(id)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}