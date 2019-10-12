package com.example.myplayer.ui.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.myplayer.R
import com.example.myplayer.base.BaseActivity
import com.example.myplayer.util.ToolManager
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(),ToolManager{

    override fun getLayoutId(): Int = R.layout.setting_activity

    override val toolbar: Toolbar by lazy{
        find<Toolbar>(R.id.toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSettingToolBar()
    }
}