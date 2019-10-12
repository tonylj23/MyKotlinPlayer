package com.example.myplayer.adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.myplayer.model.MvAreaBean
import com.example.myplayer.ui.fragment.MvPageFragment

class MvFragmentAdatper(val context: Context?, val list:List<MvAreaBean>?, fm:FragmentManager):FragmentPagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
//        val mvPageFragment = MvPageFragment()
        val bundle= Bundle()
        bundle.putString("args",list?.get(p0)?.code)
//        mvPageFragment.arguments=bundle
        val instantiate = Fragment.instantiate(context, MvPageFragment::class.java.name, bundle)
        return instantiate
    }

    override fun getCount(): Int {
        return list?.size?:0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list?.get(position)?.name?:""
    }
}