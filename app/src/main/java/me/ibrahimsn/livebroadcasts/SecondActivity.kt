package me.ibrahimsn.livebroadcasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import me.ibrahimsn.lib.LiveBroadcasts

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        LiveBroadcasts.init().subscribe(this).observe(this, Observer {
            if (it != null)
                Log.d("SecondActivity", it.action)
        })
    }
}
