package com.example.myplayer.util

import com.example.myplayer.R
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.ui.fragment.HomeFragment
import com.example.myplayer.ui.fragment.MVFragment
import com.example.myplayer.ui.fragment.VBanFragment
import com.example.myplayer.ui.fragment.YueDanFragment

class FragmentUtils private constructor(){

    val mvFragment by lazy { MVFragment() }
    val vBanFragment by lazy { VBanFragment() }
    val yueDanFragment by lazy { YueDanFragment() }
    val homeFragment by lazy { HomeFragment() }
    companion object{
        val fragmentUtils by lazy {
            FragmentUtils()
        }
    }

    fun getFragment(id:Int): BaseFragment? {
        when(id){
            R.id.tab1->return homeFragment
            R.id.tab2->return mvFragment
            R.id.tab3->return vBanFragment
            R.id.tab4->return yueDanFragment
        }
        return null

    }
}