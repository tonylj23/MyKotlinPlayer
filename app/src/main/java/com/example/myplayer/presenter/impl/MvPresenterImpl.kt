package com.example.myplayer.presenter.impl

import com.example.myplayer.model.MvAreaBean
import com.example.myplayer.net.MvAreaRequest
import com.example.myplayer.net.ResponseHandler
import com.example.myplayer.presenter.inter.MvBasePresenter
import com.example.myplayer.view.MvView

class MvPresenterImpl(var mvView: MvView):MvBasePresenter, ResponseHandler<List<MvAreaBean>> {
    override fun onError(msg: String) {
        mvView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<MvAreaBean>) {
        mvView.onSuccess(result)
    }

    override fun loadData() {
        MvAreaRequest(this).execute()
    }
}