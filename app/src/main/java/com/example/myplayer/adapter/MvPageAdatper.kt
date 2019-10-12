package com.example.myplayer.adapter

import android.content.Context
import com.example.myplayer.base.BaseListAdapter
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.widget.MvItemView

class MvPageAdatper: BaseListAdapter<HomeItemBean, MvItemView>() {
    override fun refreshItemView(homeItemView: MvItemView, data: HomeItemBean?) {
        data?.let { homeItemView.setData(it) }
    }

    override fun getItemView(context: Context?): MvItemView {
        return MvItemView(context)
    }
}