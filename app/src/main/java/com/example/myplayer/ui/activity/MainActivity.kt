package com.example.myplayer.ui.activity

import android.graphics.Color
import android.support.v7.widget.Toolbar
import com.example.myplayer.R
import com.example.myplayer.base.BaseActivity
import com.example.myplayer.util.FragmentUtils
import com.example.myplayer.util.ToolManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(),ToolManager {
    override val toolbar: Toolbar by lazy {
        find<Toolbar>(R.id.toolbar)

    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {

        initToolBar()
        toolbar.setTitleTextColor(Color.WHITE)
        bottom_bar.setOnTabSelectListener {
            val beginTransaction = supportFragmentManager.beginTransaction()
            FragmentUtils.fragmentUtils.getFragment(it)?.let { item -> beginTransaction.replace(R.id.container, item,it.toString()) }
            beginTransaction.commit()
        }
    }



}


