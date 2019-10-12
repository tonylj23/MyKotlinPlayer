package com.example.myplayer.ui.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.media.MediaPlayer
import android.os.IBinder
import android.view.View
import com.example.myplayer.R
import com.example.myplayer.base.BaseActivity
import com.example.myplayer.model.VBanBean
import com.example.myplayer.service.AudioService
import com.example.myplayer.service.IService
import kotlinx.android.synthetic.main.activity_music_player_bottom.*

class AudioPlayerActivity:BaseActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.state->{
                iService?.updatePlayState()
                updateStateView()
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_audio_player
    }

    override fun initListener() {
        super.initListener()
        state.setOnClickListener(this)


    }

    private fun updateStateView() {
        val playing = iService?.isPlaying()
        playing?.let {
            if(it){
                state.setImageResource(R.mipmap.btn_audio_play_normal)
            }else{
                state.setImageResource(R.mipmap.btn_audio_pause_normal)
            }
        }
    }

    override fun initData() {
        super.initData()



        val intent = intent
        intent.setClass(this,AudioService::class.java)
        bindService(intent,conn,Context.BIND_AUTO_CREATE)
        startService(intent)
    }
    var iService: IService?=null
    private val conn by lazy { AudioConnection() }
    inner class AudioConnection:ServiceConnection{
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            iService=service as IService
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(conn)
    }


}