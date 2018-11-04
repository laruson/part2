package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.Student
import andrey.chernikovich.domain.entity.StudentSearch
import andrey.chernikovich.domain.executer.PostExecutorThread
import andrey.chernikovich.domain.repository.StudentRepository
import io.reactivex.Observable

class SearchStudentUseCase(
        postExecutorThread : PostExecutorThread,
        private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {
    fun search(search: StudentSearch): Observable<List<Student>> {
        return studentRepository
                .searchStudent(search)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}