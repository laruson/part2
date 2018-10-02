package com.chernikovichandreygmail

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class ExampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}