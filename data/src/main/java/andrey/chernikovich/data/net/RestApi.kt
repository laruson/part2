package andrey.chernikovich.data.net

import andrey.chernikovich.data.entity.StudentRequest
import andrey.chernikovich.data.entity.StudentResponse
import io.reactivex.Observable
import retrofit2.http.*

interface RestApi {

    @GET("Students?pageSize=100")
    fun getStudents(): Observable<List<StudentResponse>>

    @GET("Students/{id}")
    fun getStudentsById(@Path("id") id: String): Observable<StudentResponse>

    @Headers("Content-Type:application/json")
    @PUT("Students/{id}")
    fun updateStudent(@Path("id") id: String,
                      @Body student: StudentRequest): Observable<StudentResponse>

    @Headers("Content-Type:application/json")
    @PUT("Students")
    fun saveStudent(@Body student: StudentRequest): Observable<StudentResponse>

    @Headers("Content-Type:application/json")
    @DELETE("Students/{id}")
    fun deleteStudent(@Path("id") id: String): Observable<String>

    @GET("Students?pageSize=100")
    fun searchStudent(@Query("where") name: String): Observable<List<StudentResponse>>
}