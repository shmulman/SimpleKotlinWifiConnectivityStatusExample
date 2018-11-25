package com.google.www.simplekotlinwificonnectivitystatusexample

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener() {
            checkConnection()
        }
    }

    fun checkConnection(){
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        val isWiFi: Boolean = activeNetwork?.type == ConnectivityManager.TYPE_WIFI

        if (isConnected) {
            if (isWiFi) {
                OutputView.append("\n")
                OutputView.append("CONNECTED WIFI")
            } else {
                OutputView.append("\n")
                OutputView.append("CONNECTED MOBILE")
            }
        } else {
            OutputView.append("\n")
            OutputView.append("NOT CONNECTED")
        }
    }
}
