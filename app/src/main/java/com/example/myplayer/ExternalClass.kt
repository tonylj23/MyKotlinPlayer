package com.example.myplayer

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

class ExternalClass() :Parcelable{


    var diaryId:Int=0
    var praiseTotal:Int=0
    var commentTotal:Int=0
    var pirctureUrlList:ArrayList<String>?=null

    constructor(parcel: Parcel) : this() {
        diaryId = parcel.readInt()
        praiseTotal = parcel.readInt()
        commentTotal = parcel.readInt()
        pirctureUrlList=parcel.createStringArrayList()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(diaryId)
        parcel.writeInt(praiseTotal)
        parcel.writeInt(commentTotal)
        parcel.writeStringList(pirctureUrlList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExternalClass> {
        override fun createFromParcel(parcel: Parcel): ExternalClass {
            return ExternalClass(parcel)
        }

        override fun newArray(size: Int): Array<ExternalClass?> {
            return arrayOfNulls(size)
        }
    }


}
