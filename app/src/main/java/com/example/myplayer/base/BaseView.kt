package com.example.myplayer.base

/**
 * 所有下拉刷新和上拉加载的fragment的item基类
 */
interface BaseView <RESPONSE>{
    fun onError(toString: String)
    fun loadMore(list: RESPONSE?)
    fun loadSuccess(list: RESPONSE?)
}