package com.chernikovichandreygmail.lesson5

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.chernikovichandreygmail.R

class Wifi : Activity() {
    private lateinit var wifiImage: ImageView
    private lateinit var watch: Watch

    private val wifiStatus = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val net = connMgr.activeNetworkInfo
            val wifi = net != null && net.type == ConnectivityManager.TYPE_WIFI
            setWiFi(wifi)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_lesson5)
        wifiImage = findViewById(R.id.wifi)
        watch = findViewById(R.id.watch)

        registerReceiver(wifiStatus, IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wifiStatus)
    }

    private fun setWiFi(wifi: Boolean) {
        if (wifi)
            wifiImage.setImageResource(R.drawable.ic_wifi_on_24dp)
        else
            wifiImage.setImageResource(R.drawable.ic_wifi_off_24dp)
    }
}