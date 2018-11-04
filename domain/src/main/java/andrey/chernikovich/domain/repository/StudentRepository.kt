package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.Student
import andrey.chernikovich.domain.entity.StudentSearch
import io.reactivex.Observable

interface StudentRepository : BaseRepository {
    fun getStudents(): Observable<List<Student>>

    fun getStudentById(id: String): Observable<Student>

    fun searchStudent(search: StudentSearch): Observable<List<Student>>

    fun updateStudent(id: String, student: Student): Observable<Student>

    fun saveStudent(student: Student): Observable<Student>

    fun deleteStudent(id: String): Observable<String>
}