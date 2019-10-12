package com.example.myplayer.net

import com.example.myplayer.model.MvAreaBean
import com.example.myplayer.util.URLProviderUtils

class MvAreaRequest(handler: ResponseHandler<List<MvAreaBean>>) :
        MRequest<List<MvAreaBean>>(1,0, URLProviderUtils.getMVareaUrl(), handler) {
}