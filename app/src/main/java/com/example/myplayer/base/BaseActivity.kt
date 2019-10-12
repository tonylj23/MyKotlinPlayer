package com.example.myplayer.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myplayer.ui.activity.MainActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 所有activity的基类
 */
abstract class BaseActivity : AppCompatActivity(),AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    open protected fun initData() {

    }

    open protected fun initListener(){

    }

    abstract fun getLayoutId(): Int

    protected fun myToast(msg:String){
        runOnUiThread { toast(msg) }
    }

    inline fun <reified T:BaseActivity> startActivityAndFinish(){
        startActivity<T>()
        finish()
    }
}