package com.example.myplayer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.myplayer.base.BaseListAdapter
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.view.HomeView
import com.example.myplayer.widget.HomeItemView
import com.example.myplayer.widget.LoadMoreView

class HomeAdapter :BaseListAdapter<HomeItemBean,HomeItemView>(){
    override fun refreshItemView(homeItemView: HomeItemView, data: HomeItemBean?) {
        data?.let { homeItemView.setData(it) }
    }



    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }


}