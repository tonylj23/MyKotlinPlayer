package com.example.myplayer.ui.fragment

import com.example.myplayer.adapter.MvPageAdatper
import com.example.myplayer.base.BaseListAdapter
import com.example.myplayer.base.BaseListFragment
import com.example.myplayer.base.BaseListPresenter
import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.model.VideoPlayerBean
import com.example.myplayer.presenter.impl.MvListPresenterImpl
import com.example.myplayer.ui.activity.TextureVideoPlayerActivity
import com.example.myplayer.ui.activity.VideoPlayerActivity
import com.example.myplayer.widget.MvItemView
import org.jetbrains.anko.support.v4.startActivity

class MvPageFragment:BaseListFragment<List<HomeItemBean>,HomeItemBean,MvItemView>() {
    override fun getList(list: List<HomeItemBean>?): List<HomeItemBean>? {
        return list
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return MvListPresenterImpl(code!!,this)
    }

    override fun getAdapter(): BaseListAdapter<HomeItemBean, MvItemView> {
        return MvPageAdatper()
    }


    var code:String?=null
    override fun init() {
        super.init()
        code = arguments?.getString("args")
    }

    override fun initListener() {
        super.initListener()

        homeAdapter.setMyListener {
            val videoBean=VideoPlayerBean(it.id.toString(),it.title,"http://v.yinyuetai.com/video/3393281")
            startActivity<TextureVideoPlayerActivity>("item" to videoBean)
        }
    }
}