package me.ibrahimsn.lib

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.reactivex.subjects.PublishSubject

class LiveBroadcasts {

    private val publisher = PublishSubject.create<Intent>()

    companion object {
        private var liveBroadcasts: LiveBroadcasts? = null

        fun init(): LiveBroadcasts {
            if (liveBroadcasts == null)
                liveBroadcasts = LiveBroadcasts()

            return liveBroadcasts!!
        }
    }

    init {
        if (liveBroadcasts != null){
            throw RuntimeException("Use getInstance() method to get the single instance of this class.")
        }
    }

    private val receiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null)
                publisher.onNext(intent)
        }
    }

    fun subscribe(context: Context): LiveBroadcast {
        return LiveBroadcast(receiver, context, publisher)
    }
}