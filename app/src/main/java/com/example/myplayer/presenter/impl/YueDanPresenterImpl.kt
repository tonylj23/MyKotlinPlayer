package com.example.myplayer.presenter.impl

import com.example.myplayer.base.BaseListPresenter.Companion.LOAD_MORE
import com.example.myplayer.base.BaseListPresenter.Companion.LOAD_OR_REFRESH
import com.example.myplayer.base.BaseView
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.net.ResponseHandler
import com.example.myplayer.net.YueDanRequest
import com.example.myplayer.presenter.inter.HomeBasePresenter
import com.example.myplayer.presenter.inter.YueDanBasePresenter
import com.example.myplayer.view.YueDanView

class YueDanPresenterImpl(var itemView: BaseView<List<HomeItemBean>>?) : YueDanBasePresenter, ResponseHandler<List<HomeItemBean>> {
    override fun onError(msg: String) {
        itemView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {
        when(type){
            LOAD_MORE->itemView?.loadMore(result)
            LOAD_OR_REFRESH->itemView?.loadSuccess(result)
        }
    }


    override fun loadMoreData() {
        YueDanRequest(LOAD_MORE,0,this).execute()
    }

    override fun loadData() {
        YueDanRequest(LOAD_OR_REFRESH,0,this).execute()
    }

    override fun destroyView() {
        if(itemView!=null){
            itemView=null
        }
    }
}