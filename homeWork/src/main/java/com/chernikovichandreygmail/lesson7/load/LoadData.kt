package com.chernikovichandreygmail.lesson7.load

import com.chernikovichandreygmail.lesson7.dao.StudentDao
import com.chernikovichandreygmail.lesson7.domain.Student
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class LoadData {
    private var st = Students()
    fun load() {
        val url = URL("https://raw.githubusercontent.com/laruson/part2/master/students.json")
        val connect = url.openConnection() as HttpURLConnection
        try {
            connect.requestMethod = "GET";
            connect.connect()
            val reader = BufferedReader(InputStreamReader(connect.inputStream))
            val gson = GsonBuilder().create()
            st = gson.fromJson(reader, Students::class.java)
            StudentDao.students = st.students
            reader.close()
        } finally {
            connect.disconnect()
        }
    }

    private class Students {
        var students = ArrayList<Student>()
    }
}