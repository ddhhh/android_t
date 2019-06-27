package com.dhh.audition.multprocess_aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.dhh.audition.IMyAidlInterface

class AidlService: Service(){
    override fun onBind(intent: Intent?): IBinder? {
        return AidlBinder()
    }
    class AidlBinder: IMyAidlInterface.Stub() {
        override fun basicTypes(a: Int) {

        }
    }
}
