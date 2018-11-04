package andrey.chernikovich.data.net

import andrey.chernikovich.data.entity.StudentRequest
import andrey.chernikovich.data.entity.StudentResponse
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestService(apiUrl: String) {
    private val restApi: RestApi
    private val gson = Gson()

    init {
        val okHttpBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpBuilder.build())
                .build()
        restApi = retrofit.create(RestApi::class.java)
    }

    fun getStudents(): Observable<List<StudentResponse>> {
        return restApi.getStudents()
    }

    fun getStudentById(id: String): Observable<StudentResponse> {
        return restApi.getStudentsById(id)
    }

    fun searchStudent(name:String):Observable<List<StudentResponse>>{
        return restApi.searchStudent(name)
    }

    fun updateStudent(id: String, student: StudentRequest): Observable<StudentResponse> {
        return restApi.updateStudent(id, student)
    }

    fun saveStudent(student: StudentRequest): Observable<StudentResponse> {
        return restApi.saveStudent(student)
    }

    fun deleteStudent(id:String): Observable<String>{
        return restApi.deleteStudent(id)
    }

}