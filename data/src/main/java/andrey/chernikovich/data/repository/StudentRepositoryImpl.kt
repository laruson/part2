package andrey.chernikovich.data.repository


import andrey.chernikovich.data.entity.transformToDomain
import andrey.chernikovich.data.entity.transformToRequest
import andrey.chernikovich.data.net.RestService
import andrey.chernikovich.domain.entity.Student
import andrey.chernikovich.domain.entity.StudentSearch
import andrey.chernikovich.domain.entity.transformToRequest
import andrey.chernikovich.domain.repository.StudentRepository
import io.reactivex.Observable

class StudentRepositoryImpl(val restService: RestService) : StudentRepository {
    override fun getStudents(): Observable<List<Student>> {
        return restService.getStudents().map { list ->
            list.map { student ->
                student.transformToDomain()
            }
        }
    }

    override fun getStudentById(id: String): Observable<Student> {
        return restService.getStudentById(id).map { student ->
            student.transformToDomain()
        }
    }

    override fun searchStudent(search: StudentSearch): Observable<List<Student>> {
        return restService.searchStudent(search.transformToRequest())
                .map { list ->
                    list.map { student ->
                        student.transformToDomain()
                    }
                }
    }

    override fun updateStudent(id: String, student: Student): Observable<Student> {
        return restService.updateStudent(id, student.transformToRequest())
                .map {
                    it.transformToDomain()
                }
    }

    override fun saveStudent(student: Student): Observable<Student> {
        return restService.saveStudent(student.transformToRequest())
                .map {
                    it.transformToDomain()
                }
    }

    override fun deleteStudent(id: String): Observable<String> {
        return restService.deleteStudent(id)
    }
}