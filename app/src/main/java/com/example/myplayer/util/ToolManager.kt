package com.example.myplayer.util

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.myplayer.R
import com.example.myplayer.ui.activity.SettingActivity

/**
 * 所有toolbar的接口
 */
interface ToolManager {
    val toolbar: Toolbar
    fun initToolBar() {
        toolbar.title = "MyPlayer"
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener { p0 ->
            when (p0?.itemId) {
                R.id.setting -> toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
            }
            true

        }
    }

    fun initSettingToolBar(){
        toolbar.title = "设置"
    }
}