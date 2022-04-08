package com.example.kotlin_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlin_practice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"


    // 액티비티가 생성되었을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃을 설정
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        // 로그인 버튼 뷰에 클릭 리스너를 설정
        login_btn.setOnClickListener(View.OnClickListener {
            onLoginButtonClicked()
        })


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()

        // [Main][Activity] -> [Activity][Main] + binding 클래스를 자동으로 생성해줌
//        val bindingTextView : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(bindingTextView.root)
//        bindingTextView.textView.visibility = View.VISIBLE
//        bindingTextView.textView.text = "onPause()"

        Log.d(TAG, "MainActivity - onPause() called")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity - onDestroy() called")
    }

    fun onLoginButtonClicked(){
        Log.d(TAG, "MainActivity - onLoginButtonClicked() called")

        val intent = Intent(this, RelativeLayout::class.java)
        startActivity(intent)

    }
}