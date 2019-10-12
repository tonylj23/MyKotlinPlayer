package com.example.myplayer.view

import com.example.myplayer.model.MvAreaBean

interface MvView {
    fun onError(msg: String)
    fun onSuccess(result: List<MvAreaBean>)
}