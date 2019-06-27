package com.dhh.audition.multprocess_aidl

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import com.dhh.audition.IMyAidlInterface
import com.dhh.audition.R
import kotlinx.android.synthetic.main.activity_aidl_multi_main_process.*

class AidlMultiMainProcessActivity: AppCompatActivity() {
    var iMyAidlInterface : IMyAidlInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidl_multi_main_process)
        bindService(Intent(this, AidlService::class.java), serviceConnection, Context.BIND_AUTO_CREATE)
        button4.setOnClickListener {
            iMyAidlInterface?.sendMsgtoClient("sss")
        }
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service)
        }

    }
}
