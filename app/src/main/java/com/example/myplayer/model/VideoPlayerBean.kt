package com.example.myplayer.model

import android.os.Parcel
import android.os.Parcelable

data class VideoPlayerBean(val id:String,val title:String,val url:String):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VideoPlayerBean> {
        override fun createFromParcel(parcel: Parcel): VideoPlayerBean {
            return VideoPlayerBean(parcel)
        }

        override fun newArray(size: Int): Array<VideoPlayerBean?> {
            return arrayOfNulls(size)
        }
    }
}