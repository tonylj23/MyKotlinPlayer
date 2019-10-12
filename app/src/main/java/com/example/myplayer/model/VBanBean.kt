package com.example.myplayer.model

import android.database.Cursor
import android.os.Parcel
import android.os.Parcelable
import android.provider.MediaStore

class VBanBean(var data:String,var size:Long,var displayname:String,var artist:String) :Parcelable{

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString()) {
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(data)
        parcel.writeLong(size)
        parcel.writeString(displayname)
        parcel.writeString(artist)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VBanBean> {
        override fun createFromParcel(parcel: Parcel): VBanBean {
            return VBanBean(parcel)
        }

        override fun newArray(size: Int): Array<VBanBean?> {
            return arrayOfNulls(size)
        }

        fun getVBanBean(cursor:Cursor):VBanBean{
            val vBanBean = VBanBean("", 0, "", "")
            vBanBean.data=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
            vBanBean.size=cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE))
            vBanBean.displayname=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME))
            vBanBean.displayname=vBanBean.displayname.substring(0,vBanBean.displayname.lastIndexOf("."))
            vBanBean.artist=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
            return vBanBean
        }
        fun getVBanBeans(cursor: Cursor):ArrayList<VBanBean>{
            val list=ArrayList<VBanBean>()
            cursor.moveToPosition(-1)
            while (cursor.moveToNext()){
                val vBanBean = getVBanBean(cursor)
                list.add(vBanBean)
            }
            return list

        }
    }
}