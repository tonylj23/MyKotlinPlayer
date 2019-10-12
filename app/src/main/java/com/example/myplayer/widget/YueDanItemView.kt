package com.example.myplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.myplayer.R
import com.example.myplayer.model.HomeItemBean
import kotlinx.android.synthetic.main.item_yuedan.view.*

class YueDanItemView: RelativeLayout {
    constructor(context: Context?):super(context)
    constructor(context: Context?, attrs: AttributeSet?):super(context,attrs)
    constructor(context: Context?, attrs: AttributeSet?, def:Int):super(context,attrs,def)

    init{
        View.inflate(context, R.layout.item_yuedan,this)
    }

    fun setData(homeItemBean: HomeItemBean) {
        title.text=homeItemBean.title
        desc.text=homeItemBean.description
        Glide.with(context).load(homeItemBean.thumbnailPic).apply(RequestOptions.bitmapTransform(CircleCrop())).into(icon)
        Glide.with(context).load(homeItemBean.posterPic).into(bg)
    }

}