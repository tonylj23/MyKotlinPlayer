package com.example.myplayer.view

import android.content.Context
import android.text.format.Formatter
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.myplayer.R
import com.example.myplayer.model.VBanBean
import kotlinx.android.synthetic.main.v_ban_item.view.*
import java.text.Format

class VBanItemView:RelativeLayout {
    fun setData(vBanBean: VBanBean) {
        textView.text=vBanBean.displayname
        textView2.text=vBanBean.artist
        time.text=Formatter.formatFileSize(context,vBanBean.size)
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.v_ban_item,this)
    }
}