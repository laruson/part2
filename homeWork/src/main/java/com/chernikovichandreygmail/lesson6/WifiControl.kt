package com.chernikovichandreygmail.lesson6

import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.chernikovichandreygmail.R

class WifiControl : AppCompatActivity() {
    private lateinit var instance: LocalBroadcastManager
    private lateinit var wifiImage: ImageView
    private lateinit var wifiService : ServiceWifi
    private var status = false


    private val wifiReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            status = intent.getBooleanExtra(ServiceWifi.STATUS_WIFI, false)
            setImage(status)
        }

    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            var binder = service as ServiceWifi.LocalBinder
            wifiService = service.binder
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi_lesson6)

        wifiImage = findViewById(R.id.wifi_service)
        instance = LocalBroadcastManager.getInstance(this)
    }

    override fun onResume() {
        super.onResume()
        instance.registerReceiver(wifiReceiver, IntentFilter("Wifi"))
        bindService(Intent(this, ServiceWifi::class.java),serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onPause() {
        super.onPause()
        unbindService(serviceConnection)
        instance.unregisterReceiver(wifiReceiver)
    }

    fun changeWifi(view : View){
        wifiService.controlWifi()
    }

    private fun setImage(status: Boolean) {
        Log.e("AAAAA", status.toString())

        if (status)
            wifiImage.setImageResource(R.drawable.ic_wifi_on_24dp)
        else
            wifiImage.setImageResource(R.drawable.ic_wifi_off_24dp)
    }
}