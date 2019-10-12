package com.example.myplayer.net

import com.example.myplayer.model.HomeItemBean
import com.example.myplayer.util.URLProviderUtils

class MvListRequest(requestType:Int,type:Int,offset:Int,handler: ResponseHandler<List<HomeItemBean>>):MRequest<List<HomeItemBean>>(requestType,type, URLProviderUtils.getHomeUrl(offset, 20),handler) {
}