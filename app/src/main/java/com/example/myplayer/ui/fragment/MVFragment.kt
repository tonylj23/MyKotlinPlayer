package com.example.myplayer.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.myplayer.R
import com.example.myplayer.adapter.MvFragmentAdatper
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.model.MvAreaBean
import com.example.myplayer.presenter.impl.MvPresenterImpl
import com.example.myplayer.view.MvView
import kotlinx.android.synthetic.main.fragment_mv.*
import org.jetbrains.anko.support.v4.toast

class MVFragment : BaseFragment(),MvView {
    override fun onError(msg: String) {
        toast("加载区域数据失败")
    }

    override fun onSuccess(result: List<MvAreaBean>) {
        val mvFragmentAdatper = MvFragmentAdatper(context,result, childFragmentManager)
        mv_viewpager.adapter=mvFragmentAdatper
        mv_toolbar.setupWithViewPager(mv_viewpager)
    }

    val presenter by lazy { MvPresenterImpl(this) }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_mv, null)
    }

    override fun initData() {
        super.initData()
        presenter.loadData()
    }
}