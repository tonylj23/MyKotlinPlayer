package com.example.myplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.example.myplayer.R
import com.example.myplayer.model.HomeItemBean
import kotlinx.android.synthetic.main.item_home.view.*

class HomeItemView: RelativeLayout{
    constructor(context: Context?):super(context)
    constructor(context: Context?,attrs: AttributeSet?):super(context,attrs)
    constructor(context: Context?,attrs: AttributeSet?,def:Int):super(context,attrs,def)

    init{
        View.inflate(context, R.layout.item_home,this)
    }

    fun setData(data:HomeItemBean){
        title.text = data.title
        desc.setText(data.description)
        Glide.with(context).load(data.thumbnailPic).into(icon)
        Glide.with(context).load(data.posterPic).into(bg)

    }
}
