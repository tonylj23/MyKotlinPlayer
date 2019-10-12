package com.example.myplayer.base

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.myplayer.R
import com.example.myplayer.adapter.HomeAdapter
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.presenter.impl.HomePresenterImpl
import com.example.myplayer.view.HomeView
import kotlinx.android.synthetic.main.list_fragment_layout.*
import kotlinx.android.synthetic.main.list_fragment_layout.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * 所有下拉刷新和上拉加载的fragment的基类
 */
abstract class BaseListFragment<RESPONSE,ITEMBEAN,ITEMVIEW:View>:  BaseFragment(), BaseView<RESPONSE> {
    override fun onError(toString: String) {
        toast("加载数据失败")
    }

    override fun loadMore(list: RESPONSE?) {
        homeAdapter.addListData(getList(list))
        refreshLayout?.isRefreshing=false
    }



    override fun loadSuccess(list: RESPONSE?) {
        homeAdapter.updateListData(getList(list))
        refreshLayout?.isRefreshing=false
    }
    //    val urlResponse="{\"type\":\"VIDEO\",\"id\":3382095,\"title\":\"如果你说爱我 If You Say You Love Me 官方版\",\"description\":\"飞儿乐团\",\"posterPic\":\"http://img4.c.yinyuetai.com/others/mobile_front_page/190510/0/-M-d312567a94349f136899af35c4f54547_0x0.jpg\",\"thumbnailPic\":\"http://img4.c.yinyuetai.com/video/mv/190510/0/-M-65f137bae246845e161096769c2d9689_240x135.jpg\",\"url\":\"http://hc.yinyuetai.com/uploads/videos/common/AA9F016A9C19FF60E10C1A3E77B6344B.mp4?sc=b9a7c70497546ce1&br=778&rd=iOS\",\"hdUrl\":\"http://hc.yinyuetai.com/uploads/videos/common/AA9F016A9C19FF60E10C1A3E77B6344B.mp4?sc=b9a7c70497546ce1&br=778&rd=iOS\",\"uhdUrl\":\"http://hd.yinyuetai.com/uploads/videos/common/2405016A9C1D33E0571D3216A0C3D242.mp4?sc=d41e9e7f7d93f06a&br=1102&rd=iOS\",\"videoSize\":0,\"hdVideoSize\":0,\"uhdVideoSize\":0,\"status\":200,\"traceUrl\":\"http://www.yinyuetai.com/v?a=102437&un=53a621a9362eb7ed4e46425ac834f4b545fe1eff443acb1e2ba5fdc547da9314f66a78b03b640904a24e6f25376102b0c1dc16842b2b37e0d446aaffccd10a8cf69d2ebc6c2e79bfe31b925f005aee7e12ef159d573c37c97845c34d5e9dc329d8763c9a0e375997\",\"clickUrl\":\"http://mapi.yinyuetai.com/statistics/click.json?id=6558\"}"


    var list: List<HomeItemBean>? = null
    val homeAdapter by lazy { getAdapter() }

    val presenter by lazy { getSpecialPresenter() }
    override fun initView(): View? {
        presenter.loadData()
        val inflate = View.inflate(context, R.layout.list_fragment_layout, null)
        val linearLayoutManager = LinearLayoutManager(context)

        inflate.home_rv.layoutManager=linearLayoutManager
        inflate.home_rv.adapter=homeAdapter
        return inflate
    }

    override fun initListener() {
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GRAY)
        refreshLayout.setOnRefreshListener{
            presenter.loadData()
        }
        home_rv.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                when(newState){
                    RecyclerView.SCROLL_STATE_IDLE-> {
                        val layoutManager = home_rv.layoutManager
                        if(layoutManager is LinearLayoutManager){
                            val findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                            if(findLastVisibleItemPosition==homeAdapter.itemCount-1){
                                presenter.loadMoreData()
                            }
                        }
                    }
                }
            }
        })
    }

    abstract fun getList(list: RESPONSE?): List<ITEMBEAN>?
    abstract fun getSpecialPresenter(): BaseListPresenter

    abstract fun getAdapter():BaseListAdapter<ITEMBEAN,ITEMVIEW>

}
