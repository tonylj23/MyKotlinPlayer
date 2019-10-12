package com.example.myplayer.base

interface BaseListPresenter {
    fun loadMoreData()
    fun loadData()
    fun destroyView()

    companion object{
        const val LOAD_OR_REFRESH=1
        const val LOAD_MORE=2
    }

}