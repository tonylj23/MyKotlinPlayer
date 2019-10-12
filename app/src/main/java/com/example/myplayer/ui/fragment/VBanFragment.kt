package com.example.myplayer.ui.fragment

import android.Manifest
import android.app.AlertDialog
import android.content.AsyncQueryHandler
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Color
import android.os.Handler
import android.os.Message
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import com.example.myplayer.R
import com.example.myplayer.adapter.VBanListAdapter
import com.example.myplayer.base.BaseFragment
import com.example.myplayer.model.VBanBean
import com.example.myplayer.ui.activity.AudioPlayerActivity
import com.example.myplayer.util.CursorUtil
import kotlinx.android.synthetic.main.fragment_vb.*
import org.jetbrains.anko.noButton
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.yesButton
import java.security.Permission

class VBanFragment : BaseFragment() {
    val handler=object :Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            msg?.let {
                val cursor = msg.obj as Cursor

            }
        }
    }
    override fun initView(): View? {
       return View.inflate(context, R.layout.fragment_vb,null)
    }

    var vbAdapter:VBanListAdapter?=null

    override fun initListener() {
        super.initListener()
        this.vbAdapter=VBanListAdapter(context,null)
        vb_lv.adapter=vbAdapter
        vb_lv.setOnItemClickListener { parent, view, position, id ->
            val cursor = vbAdapter?.getItem(position) as Cursor
            val vBanBeans = VBanBean.getVBanBeans(cursor)
            startActivity<AudioPlayerActivity>("itemdata" to vBanBeans,"position" to position)
        }

    }

    override fun initData() {
        super.initData()

        handlePermission()
        loadData()


    }

    private fun handlePermission() {
        val readExternalStorage = Manifest.permission.READ_EXTERNAL_STORAGE
         context?.let {
             val checkSelfPermission =ActivityCompat.checkSelfPermission(it, readExternalStorage)
             if(checkSelfPermission==PackageManager.PERMISSION_GRANTED){
                 loadData()
             }else{
                 activity?.let { it1 ->
                     if(ActivityCompat.shouldShowRequestPermissionRationale(it1,readExternalStorage)){
                         alert("我们只会访问音乐文件,不会访问隐私照片", "温馨提示") {
                             yesButton { myRequestPermission() }
                             noButton {}
                         }.show()
                    }else{
                         myRequestPermission()
                     }
                 }
             }
         }

    }

    private fun myRequestPermission() {
        val arrayOf = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        requestPermissions(arrayOf,1)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
            loadData()
        }
    }

    private fun loadData() {
        val resolver = context?.contentResolver
        val asyncQueryHandler = object : AsyncQueryHandler(resolver) {
            override fun onQueryComplete(token: Int, cookie: Any?, cursor: Cursor?) {
                super.onQueryComplete(token, cookie, cursor)
                (cookie as VBanListAdapter).swapCursor(cursor)


            }

        }
        asyncQueryHandler.startQuery(0, vbAdapter, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.SIZE,
                        MediaStore.Audio.Media.DISPLAY_NAME,
                        MediaStore.Audio.Media.ARTIST
                ), null, null, null)
    }

    override fun onDestroy() {
        super.onDestroy()

        vbAdapter?.changeCursor(null)
    }
}