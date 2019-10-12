package com.example.myplayer.ui.activity

import com.example.myplayer.R
import com.example.myplayer.base.BaseActivity
import com.example.myplayer.model.VideoPlayerBean
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity:BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_video_player
    }

    override fun initData() {
        super.initData()

        val parcelableExtra = intent.getParcelableExtra<VideoPlayerBean>("item")
        video.setVideoPath(parcelableExtra.url)
        video.setOnPreparedListener{
            it.start()
        }

    }
}