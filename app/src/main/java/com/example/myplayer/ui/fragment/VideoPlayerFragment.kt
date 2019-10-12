package com.example.myplayer.ui.fragment

import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.base.BaseListFragment

class VideoPlayerFragment:BaseFragment() {

    var pos:String?=""
    override fun initView(): View? {
        val textView = TextView(context)
        textView.text="1111111+++$pos"
        return textView
    }

    override fun init() {
        super.init()
        pos = arguments?.getString("page")

    }


}