package com.dhh.audition

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import com.dhh.audition.base.BaseActivity
import com.dhh.audition.service.MyService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    var binder: MyService.MyBinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val serviceIntent = Intent(this, MyService::class.java)
       // startService(serviceIntent)
        btn.setOnClickListener {
            bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

        btn_unbind.setOnClickListener {
            unbindService(serviceConnection)
        }


    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            binder = service as  MyService.MyBinder
            binder?.test()
        }
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }

}
