package com.example.myplayer.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.myplayer.ui.fragment.VideoPlayerFragment

class VideoPlayerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {

        val videoPlayerFragment = VideoPlayerFragment()
        val bundle = Bundle()
        when(p0){

            0->{

                bundle.putString("page","0")
                videoPlayerFragment.arguments=bundle
            }
            1->{

                bundle.putString("page","1")
                videoPlayerFragment.arguments=bundle
            }
            2->{

                bundle.putString("page","2")
                videoPlayerFragment.arguments=bundle
            }
        }
        return videoPlayerFragment
    }

    override fun getCount(): Int {
        return 3
    }
}