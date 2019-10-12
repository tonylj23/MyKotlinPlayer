package com.example.myplayer.net

interface ResponseHandler<RESPONSE> {

    fun onError(msg:String)
    fun onSuccess(type:Int,result:RESPONSE)
}