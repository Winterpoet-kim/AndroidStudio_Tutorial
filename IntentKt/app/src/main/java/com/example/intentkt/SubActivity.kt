package com.example.intentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivityMainBinding
import com.example.intentkt.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private var mBinding: ActivitySubBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("msg")){
            // 서브 액티비티의 존재하는 텍스트뷰에 hello world가 넘겨짐.
            binding.tvGetMsg.text = intent.getStringExtra("msg")
        }

    }
}