package com.example.myplayer.presenter.impl

import com.example.myplayer.base.BaseListPresenter.Companion.LOAD_MORE
import com.example.myplayer.base.BaseListPresenter.Companion.LOAD_OR_REFRESH
import com.example.myplayer.base.BaseView
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.net.HomeRequest
import com.example.myplayer.net.ResponseHandler
import com.example.myplayer.presenter.inter.HomeBasePresenter

class HomePresenterImpl(var homeView: BaseView<List<HomeItemBean>>?) :HomeBasePresenter, ResponseHandler<List<HomeItemBean>> {

    override fun onError(msg: String) {
        homeView?.onError(msg)
    }

    override fun onSuccess(type:Int,result: List<HomeItemBean>) {
        when(type){
            LOAD_OR_REFRESH->homeView?.loadSuccess(result)
            LOAD_MORE->homeView?.loadMore(result)
        }
    }

    override fun loadMoreData() {
         HomeRequest(0,LOAD_MORE,0, this).execute()
    }

    override fun loadData() {
        HomeRequest(0,LOAD_OR_REFRESH,0, this).execute()

//        val homeUrl = URLProviderUtils.getHomeUrl(0, 20)
//        val request = Request.Builder().url(homeUrl).get().build()
//        val okHttpClient = OkHttpClient()
//        okHttpClient.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
////                ThreadUtil.runOnMainThread (Runnable{refreshLayout.isRefreshing=false})
//                ThreadUtil.runOnMainThread(Runnable { homeView.onError(e.toString()) })
//            }
//
//            override fun onResponse(call: Call, response: Response) {
////                android.util.Log.i("response---::",response.toString())
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(urlResponse, object : TypeToken<List<HomeItemBean>>(){}.type)
//                ThreadUtil.runOnMainThread(Runnable { homeView.loadMore(list) })
////                onUiThread {
////
////                    homeAdapter.setItem(list as ArrayList<HomeItemBean>)
////
////                    homeAdapter.notifyDataSetChanged()
////                }
//
//            }
//        })
    }

    override fun destroyView() {
        if(homeView!=null){
            homeView=null
        }
    }

}