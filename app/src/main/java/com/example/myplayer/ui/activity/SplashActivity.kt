package com.example.myplayer.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.example.myplayer.R
import com.example.myplayer.base.BaseActivity
import kotlinx.android.synthetic.main.splash_activity.*

class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun onAnimationEnd(p0: View?) {
        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(p0: View?) {
    }

    override fun onAnimationStart(p0: View?) {
    }

    override fun getLayoutId(): Int {
       return R.layout.splash_activity
    }

    override fun initData() {
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setDuration(2000).setListener(this).start()

    }
}