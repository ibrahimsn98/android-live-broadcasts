package me.ibrahimsn.lib

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LiveBroadcast(private val receiver: BroadcastReceiver,
                    private val context: Context,
                    private val updates: Observable<Intent>) : MutableLiveData<Intent>() {

    private var disposable: Disposable? = null

    override fun onActive() {
        super.onActive()

        disposable = updates.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object: DisposableObserver<Intent>() {
                override fun onComplete() {

                }

                override fun onNext(t: Intent) {
                    postValue(t)
                }

                override fun onError(e: Throwable) {

                }
            })

        context.registerReceiver(receiver, IntentFilter().apply {
            this.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)
        })
    }

    override fun onInactive() {
        super.onInactive()

        try {
            context.unregisterReceiver(receiver)
        } catch (e: IllegalArgumentException) {}

        disposable?.dispose()
    }
}