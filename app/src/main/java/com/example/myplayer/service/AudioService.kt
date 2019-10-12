package com.example.myplayer.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.example.myplayer.model.VBanBean

class AudioService:Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
    }
    var position:Int=0
    var list:List<VBanBean>?=null
    var mediaPlayer:MediaPlayer?=null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         list = intent?.getParcelableArrayListExtra<VBanBean>("itemdata")
         position = intent?.getStringExtra("position")?.toInt()?:0

        binder.play()

        return START_NOT_STICKY
    }


    inner class AudioBind:Binder(), MediaPlayer.OnPreparedListener,IService {
        override fun isPlaying(): Boolean? {
            return mediaPlayer?.isPlaying
        }

        override fun updatePlayState() {
            val playing = isPlaying()
            playing?.let {
                if(it){
                    mediaPlayer?.pause()
                }else{
                    mediaPlayer?.start()
                }
            }
        }

        override fun onPrepared(mp: MediaPlayer?) {
            mediaPlayer?.start()
        }

        fun play(){
            mediaPlayer = MediaPlayer()
            mediaPlayer?.let {
                it.setDataSource(list?.get(position)?.data)
                it.prepareAsync()
                it.setOnPreparedListener(this)
            }

        }
    }

    val binder by lazy { AudioBind() }
}