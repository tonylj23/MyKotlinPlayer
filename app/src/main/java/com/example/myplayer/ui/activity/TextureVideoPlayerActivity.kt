package com.example.myplayer.ui.activity

import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.support.v4.view.ViewPager
import android.view.Surface
import android.view.TextureView
import android.widget.RadioGroup
import com.example.myplayer.R
import com.example.myplayer.adapter.VideoPlayerAdapter
import com.example.myplayer.base.BaseActivity
import com.example.myplayer.model.VideoPlayerBean
import kotlinx.android.synthetic.main.activity_texture_player.*
import kotlinx.android.synthetic.main.activity_video_player.*

class TextureVideoPlayerActivity:BaseActivity(), TextureView.SurfaceTextureListener {
    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {

    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
        return true
    }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
        bean?.let {
            val mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(it.url)
            mediaPlayer.setSurface(Surface(surface))
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener {
                it.start()
            }
        }

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_texture_player
    }

    val adapter by lazy {
        VideoPlayerAdapter(supportFragmentManager)
    }
    var bean:VideoPlayerBean?=null
    override fun initData() {
        super.initData()

        player_vp.adapter=adapter
        bean = intent.getParcelableExtra<VideoPlayerBean>("item")
        texture.surfaceTextureListener=this
    }

    override fun initListener() {
        super.initListener()
        player_rg.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.player_rb1-> player_vp.setCurrentItem(0)
                    R.id.player_rb2-> player_vp.setCurrentItem(1)
                    R.id.player_rb3-> player_vp.setCurrentItem(2)
                }
            }

        })

        player_vp.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                when(p0){
                    0->{
                        player_rg.check(R.id.player_rb1)
                    }
                    1->{
                        player_rg.check(R.id.player_rb2)
                    }
                    2->{
                        player_rg.check(R.id.player_rb3)
                    }

                }
            }

        })

    }

}