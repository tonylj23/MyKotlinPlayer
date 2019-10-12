package com.example.myplayer.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.myplayer.widget.LoadMoreView

abstract class BaseListAdapter<BASEITEMBEAN,ITEMVIEW:View> : RecyclerView.Adapter<BaseListAdapter.BaseListAdapterHolder>(){
    private var list=ArrayList<BASEITEMBEAN>()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseListAdapterHolder {
        if(p1==1){
            return BaseListAdapterHolder(LoadMoreView(p0?.context))
        }
        return BaseListAdapterHolder(getItemView(p0?.context))
    }

    fun updateListData(list: List<BASEITEMBEAN>?){

        list?.let {
            this.list.clear()
            this.list.addAll(it)
            notifyDataSetChanged()
        }


    }

    fun addListData(list: List<BASEITEMBEAN>?){
        list?.let {
            this.list.addAll(it)
            notifyDataSetChanged()
        }


    }

    override fun getItemViewType(position: Int): Int {
        if (position==list.size){
            return 1
        }
        return 0
    }


    override fun getItemCount(): Int {
        return list.size+1
    }

    override fun onBindViewHolder(p0: BaseListAdapterHolder, p1: Int) {
        if(p1==list.size){
            return
        }
        val data = list[p1]
        val homeItemView = p0.itemView as ITEMVIEW
        refreshItemView(homeItemView,data)
        homeItemView.setOnClickListener {
            listener?.invoke(data)
        }

    }

    var listener:((itemBean:BASEITEMBEAN)->Unit)?=null
    fun setMyListener(listener:((itemBean:BASEITEMBEAN)->Unit)){
        this.listener=listener
    }

    abstract fun refreshItemView(homeItemView: ITEMVIEW, data: BASEITEMBEAN?)

    abstract fun getItemView(context: Context?): ITEMVIEW

    class BaseListAdapterHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}