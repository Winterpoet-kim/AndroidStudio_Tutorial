package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 자바 스크립트 허용
        binding.webView.settings.javaScriptEnabled = true

        /* 웹뷰에서 새 창이 뜨지 않도록 방지하는 구문 */
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()

        /* 링크 주소를 로드 */
        binding.webView.loadUrl("https://www.naver.com")

    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()){
            // 웹싸이트에서 뒤로 갈 페이지가 존재 할 경우
            binding.webView.goBack()
        }
        else {
            super.onBackPressed()
        }
    }
}