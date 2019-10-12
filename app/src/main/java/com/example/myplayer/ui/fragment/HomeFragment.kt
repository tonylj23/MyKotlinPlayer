package com.example.myplayer.ui.fragment

import com.example.myplayer.adapter.HomeAdapter
import com.example.myplayer.base.BaseListAdapter
import com.example.myplayer.base.BaseListFragment
import com.example.myplayer.base.BaseListPresenter
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.presenter.impl.HomePresenterImpl
import com.example.myplayer.widget.HomeItemView


class HomeFragment : BaseListFragment<List<HomeItemBean>,HomeItemBean,HomeItemView>(){
    override fun getList(list: List<HomeItemBean>?): List<HomeItemBean>? {
        return list
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)
    }

    override fun getAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroyView()
    }
}
