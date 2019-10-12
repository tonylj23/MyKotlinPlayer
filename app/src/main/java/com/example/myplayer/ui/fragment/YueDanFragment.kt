package com.example.myplayer.ui.fragment

import com.example.myplayer.adapter.YueDanAdapter
import com.example.myplayer.base.BaseListAdapter
import com.example.myplayer.base.BaseListFragment
import com.example.myplayer.base.BaseListPresenter
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.presenter.impl.YueDanPresenterImpl
import com.example.myplayer.widget.YueDanItemView

class YueDanFragment :BaseListFragment<List<HomeItemBean>,HomeItemBean,YueDanItemView>(){
    override fun getList(list: List<HomeItemBean>?): List<HomeItemBean>? {
        return list
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return YueDanPresenterImpl(this)
    }

    override fun getAdapter(): BaseListAdapter<HomeItemBean, YueDanItemView> {
        return YueDanAdapter()
    }
}