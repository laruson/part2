package com.chernikovichandreygmail.presenter.screen.lesson6

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Binder
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager

class ServiceWifi : Service() {
    companion object {
        const val STATUS_WIFI = "STATUS_WIFI"
    }

    private lateinit var wifiManager : WifiManager
    private val binder = LocalBinder()
    var status = false
    private lateinit var intent: Intent
    private val instance: LocalBroadcastManager = LocalBroadcastManager.getInstance(this)

    private val wifiReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, int: Intent) {
            val connect = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network = connect.activeNetworkInfo
            status = network != null && network.type == ConnectivityManager.TYPE_WIFI
            intent = Intent("Wifi")
            intent.putExtra(STATUS_WIFI, status)
            instance.sendBroadcast(intent)
        }

    }

    override fun onBind(intent: Intent?): IBinder {
        return this.binder
    }

    override fun onCreate() {
        super.onCreate()
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        registerReceiver(wifiReceiver, IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))
    }

    fun controlWifi() {
        wifiManager.isWifiEnabled = !status
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wifiReceiver)
    }

    inner class LocalBinder : Binder() {
        val binder: ServiceWifi = this@ServiceWifi
    }
}