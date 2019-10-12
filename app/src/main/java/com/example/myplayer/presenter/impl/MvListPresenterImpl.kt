package com.example.myplayer.presenter.impl

import com.example.myplayer.base.BaseListPresenter
import com.example.myplayer.base.BaseListPresenter.Companion.LOAD_MORE
import com.example.myplayer.base.BaseListPresenter.Companion.LOAD_OR_REFRESH
import com.example.myplayer.base.BaseView
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.net.MvListRequest
import com.example.myplayer.net.ResponseHandler
import com.example.myplayer.util.ThreadUtil

class MvListPresenterImpl(var code:String,var itemView: BaseView<List<HomeItemBean>>?):BaseListPresenter, ResponseHandler<List<HomeItemBean>> {
    override fun onError(msg: String) {
        itemView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {
        when(type){
            LOAD_OR_REFRESH->itemView?.loadSuccess(result)
            LOAD_MORE->itemView?.loadMore(result)
        }
    }

    override fun loadMoreData() {
        MvListRequest(0,LOAD_MORE,0,this).execute()
    }

    override fun loadData() {
        MvListRequest(0,LOAD_OR_REFRESH,0,this).execute()
    }

    override fun destroyView() {
        if(itemView!=null){
            itemView=null
        }
    }
}