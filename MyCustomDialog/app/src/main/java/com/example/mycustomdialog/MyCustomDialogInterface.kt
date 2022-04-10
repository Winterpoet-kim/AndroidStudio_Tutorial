package com.example.mycustomdialog

import android.util.Log

// MyCustomDialog 에서의 이벤트를 MainActivity에 알려주기 위한 역할
interface MyCustomDialogInterface {

    fun onLikedBtnClicked()
    fun onSubscribeBtnClicked()

}