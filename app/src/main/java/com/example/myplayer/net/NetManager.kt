package com.example.myplayer.net

import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.util.ThreadUtil
import com.example.myplayer.util.URLProviderUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException


class NetManager private constructor(){
    private val okHttpClient by lazy {
        OkHttpClient()
    }
    companion object {
        val manager by lazy { NetManager() }
    }

    fun <RESPONSE> sendRequest(type:Int,request: MRequest<RESPONSE>){
        val req = Request.Builder().url(request.url).get().build()

        okHttpClient.newCall(req).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                request.handler.onError(e.toString())

            }

            override fun onResponse(call: Call, response: Response) {
                val toString = response?.body?.string()
                val parseResult = request.parseResult(toString)
//                android.util.Log.i("response---::",response.toString())

                ThreadUtil.runOnMainThread(Runnable {
                    request.handler.onSuccess(type,parseResult)
                })
////                onUiThread {
//
//                    homeAdapter.setItem(list as ArrayList<HomeItemBean>)
//
//                    homeAdapter.notifyDataSetChanged()
//                }

            }
        })
    }
}