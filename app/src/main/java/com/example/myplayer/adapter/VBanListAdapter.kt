package com.example.myplayer.adapter

import android.content.Context
import android.database.Cursor
import android.support.v4.widget.CursorAdapter
import android.view.View
import android.view.ViewGroup
import com.example.myplayer.model.VBanBean
import com.example.myplayer.view.VBanItemView

class VBanListAdapter(context: Context?, c: Cursor?) : CursorAdapter(context, c) {

    override fun newView(p0: Context?, p1: Cursor?, p2: ViewGroup?): View {
        return VBanItemView(p0)
    }

    override fun bindView(p0: View?, p1: Context?, p2: Cursor?) {

        val vBanItemView = p0 as VBanItemView
        p2?.let {
            val vBanBean = VBanBean.getVBanBean(it)
            vBanItemView.setData(vBanBean)
        }
    }
}