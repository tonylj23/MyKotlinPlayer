package com.example.myplayer.util

import android.database.Cursor

class CursorUtil {
    fun loadCursor(cursor:Cursor?){
        cursor?.let {
            it.moveToPosition(-1)
            while (it.moveToNext()){
                for(index in 0 until it.columnCount){
                    println("cursor---${it.getColumnName(index)},value=${it.getString(index)}")
                }
            }
        }

    }
}