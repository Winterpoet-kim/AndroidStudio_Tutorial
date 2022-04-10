package com.example.mycustomdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), MyCustomDialogInterface {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDialogBtnClicked(view: View){
        Log.d(TAG, "MainActivity - onDialogBtnClicked() called")

        val myCustomDialog = MyCustomDialog(this, this)
        myCustomDialog.show()
    }

    // Subscribe Button Clicked
    override fun onSubscribeBtnClicked() {
        Log.d(TAG, "MainActivity - onSubscribeBtnClicked() called")
        Toast.makeText(this, "구독버튼 클릭", Toast.LENGTH_SHORT).show()
    }

    // Like Button Clicked
    override fun onLikedBtnClicked() {
        Log.d(TAG, "MainActivity - onLikedBtnClicked() called")
        Toast.makeText(this, "좋아요버튼 클릭", Toast.LENGTH_SHORT).show()
    }
}