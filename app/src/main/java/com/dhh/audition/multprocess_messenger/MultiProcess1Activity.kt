package com.dhh.audition.multprocess_messenger

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.support.v7.app.AppCompatActivity
import com.dhh.audition.R
import kotlinx.android.synthetic.main.activity_multi_process_1.*

class MultiProcess1Activity : AppCompatActivity() {
    val messenger = Messenger(InnerHandler())
    var sendMessenger: Messenger? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_process_1)
        button2.setOnClickListener {
            sendMsg()
        }
        val intent = Intent(this, MultiProcessService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
             sendMessenger = Messenger(service)
            sendMsg()
        }
    }

    private fun sendMsg() {
        val msg = Message()
        msg.what = 0
        val bean = MultiBean("我是客户端的消息")
        val bundle = Bundle()
        bundle.putParcelable("data", bean)
        msg.data = bundle
        msg.replyTo = messenger
        sendMessenger?.send(msg)
    }

    class InnerHandler: Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            msg?.data?.classLoader = MultiBean::class.java.classLoader
            val multiBean = msg?.data?.getParcelable<MultiBean>("data")
            print("客户端收到消息了--->")
            println(multiBean?.str)
        }
    }
}
