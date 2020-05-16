package me.ibrahimsn.lib

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.lifecycle.LiveData

class LiveBroadcast(
    private val context: Context,
    private val filters: Array<String>
) : LiveData<Intent>() {

    private val intentFilter = IntentFilter().apply {
        for (filter in filters) addAction(filter)
    }

    override fun onActive() {
        super.onActive()
        context.registerReceiver(broadcastReceiver, intentFilter)
    }

    private val broadcastReceiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            postValue(intent)
        }
    }

    override fun onInactive() {
        super.onInactive()
        try {
            context.unregisterReceiver(broadcastReceiver)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }
}
