package com.chernikovichandreygmail.lesson5

import android.os.AsyncTask
import java.util.concurrent.TimeUnit

class Timer(watch: Watch): AsyncTask<String, Int, Unit>() {
    var watch : Watch = watch

    override fun doInBackground(vararg params: String?) {
        while (true){
            watch.runWatch()
            TimeUnit.SECONDS.sleep(1)
        }
    }
}