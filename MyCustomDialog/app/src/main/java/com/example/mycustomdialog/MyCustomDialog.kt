package com.example.mycustomdialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.mycustomdialog.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.custom_dialog.*
import com.example.mycustomdialog.databinding.CustomDialogBinding


class MyCustomDialog(context:Context, myCustomDialogInterface: MyCustomDialogInterface) : Dialog(context) {

    private var mBinding : CustomDialogBinding? = null
    private val binding get() = mBinding!!


    private var myCustomDialogInterface:MyCustomDialogInterface? = null

    // 인터페이스 연결
    init {
        this.myCustomDialogInterface = myCustomDialogInterface
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = CustomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 배경 투명하게
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.subscribeBtn.setOnClickListener {
            this.myCustomDialogInterface?.onSubscribeBtnClicked()
        }
        binding.likeBtn.setOnClickListener {
            this.myCustomDialogInterface?.onLikedBtnClicked()
        }
    }
}