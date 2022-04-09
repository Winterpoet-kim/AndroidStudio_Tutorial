package com.example.kotlin_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_relative_layout.*

class RelativeLayout : AppCompatActivity() {

    val TAG: String = "로그"

    var number:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        add_number_btn.setOnClickListener {
            number++
            number_text.text = number.toString()
        }
    }

    fun onBackButtonClicked(view: View){
        Log.d(TAG, "RelativeLayout - onBackButtonClicked() called")
        finish()
    }
}