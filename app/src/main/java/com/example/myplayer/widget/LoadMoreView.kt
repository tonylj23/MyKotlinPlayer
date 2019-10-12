package com.example.myplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.myplayer.R

class LoadMoreView : RelativeLayout {
    constructor(context: Context?):super(context)
    constructor(context: Context?, attrs: AttributeSet?):super(context,attrs)
    constructor(context: Context?, attrs: AttributeSet?, def:Int):super(context,attrs,def)
    init {
        View.inflate(context, R.layout.load_more_layout,this)
    }


}
