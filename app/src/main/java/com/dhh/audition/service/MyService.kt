package com.dhh.audition.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        println("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        println("onRebind")
    }
    override fun onBind(intent: Intent): IBinder {
        println("onBind")
        return MyBinder()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        println("onUnbind")
        return true
    }

    public inner class MyBinder: Binder() {
        fun test() {
            println("my test")
        }
    }
}
