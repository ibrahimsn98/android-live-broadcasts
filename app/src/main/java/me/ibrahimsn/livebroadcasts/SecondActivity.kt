package me.ibrahimsn.livebroadcasts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import me.ibrahimsn.lib.LiveBroadcast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        LiveBroadcast(this, arrayOf(Intent.ACTION_TIME_TICK)).observe(this, Observer {
            Log.d("SecondActivity", it.action)
        })
    }
}
