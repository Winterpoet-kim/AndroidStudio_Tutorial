package com.example.kotlin_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class RelativeLayout : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)
    }

    fun onBackButtonClicked(view: View){
        Log.d(TAG, "RelativeLayout - onBackButtonClicked() called")
        finish()
    }
}