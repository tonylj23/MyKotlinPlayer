package com.example.myplayer.ui.fragment

import android.os.Bundle
import android.preference.PreferenceFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myplayer.R
import com.example.myplayer.base.BaseFragment

class SettingFragment :PreferenceFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addPreferencesFromResource(R.xml.setting_pref)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}