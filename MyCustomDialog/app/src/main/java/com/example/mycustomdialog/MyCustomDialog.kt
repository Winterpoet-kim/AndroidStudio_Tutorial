package com.example.mycustomdialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.custom_dialog.*
import com.example.mycustomdialog.databinding.CustomDialogBinding


class MyCustomDialog(context:Context, myCustomDialogInterface: MyCustomDialogInterface)
    : Dialog(context), View.OnClickListener {

    val TAG: String = "로그"


    //private lateinit var binding : CustomDialogBinding


    private var myCustomDialogInterface:MyCustomDialogInterface? = null

    // 인터페이스 연결
    init {
        Log.d(TAG, "MyCustomDialog - init called")
        this.myCustomDialogInterface = myCustomDialogInterface
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.custom_dialog)
        Log.d(TAG, "MyCustomDialog - onCreate() called")

        // 배경 투명하게
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

//        val likeBtn = binding.likeBtn
//        val subscribeBtn = binding.subscribeBtn

        like_btn.setOnClickListener(this)
        subscribe_btn.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        Log.d(TAG, "MyCustomDialog - onClick() called")

        when(view){
            like_btn -> {
                Log.d(TAG, "MyCustomDialog - Like Button Clicked")
                this.myCustomDialogInterface?.onLikedBtnClicked()
            }
            subscribe_btn -> {
                Log.d(TAG, "MyCustomDialog - Subscribe Button Clicked")
                this.myCustomDialogInterface?.onSubscribeBtnClicked()
            }
        }
    }

}