package com.example.backbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var backBtnTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {

        val curTime : Long = System.currentTimeMillis()
        val gapTime : Long = curTime - backBtnTime

        if(gapTime in 0..2000){
            super.onBackPressed()
        }
        else{
            backBtnTime = curTime
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
    }
}