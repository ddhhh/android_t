package com.dhh.audition.multprocess_aidl

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.dhh.audition.IMyAidlInterface

class AidlService: Service(){
    var mContext: Context? = null
    override fun onCreate() {
        super.onCreate()
        mContext = baseContext
    }

    override fun onBind(intent: Intent?): IBinder? {
        return AidlBinder()
    }
    class AidlBinder: IMyAidlInterface.Stub() {
        override fun basicTypes(aInt: Int): String {
            println("服务端收到消息了")
            Thread.sleep(5000)
            return "ssssss"
        }

    }
}
