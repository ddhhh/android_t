package com.dhh.audition.multprocess_messenger

import android.app.Service
import android.content.Intent
import android.os.*

class MultiProcessService : Service() {
   private val messenger = Messenger(MessengerHandler())
    override fun onBind(intent: Intent): IBinder? {
        return messenger.binder
    }

    class MessengerHandler: Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            print("服务端收到消息了--->")
            msg?.data?.classLoader = MultiBean::class.java.classLoader
            println(msg?.data?.getParcelable<MultiBean>("data")?.str)

            Thread.sleep(2000)
            val newMsg = Message()
            newMsg.what = 1111
            val bean = MultiBean("服务端的消息")
            val bundle = Bundle()
            bundle.putParcelable("data", bean)
            newMsg.data = bundle
            msg?.replyTo?.send(newMsg)

        }
    }
}
