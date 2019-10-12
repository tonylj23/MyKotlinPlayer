package com.example.myplayer.net

import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.util.URLProviderUtils

class YueDanRequest(type:Int,offset:Int,handler: ResponseHandler<List<HomeItemBean>>): MRequest<List<HomeItemBean>>(0,type, URLProviderUtils.getHomeUrl(offset, 20),handler) {
}