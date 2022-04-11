package com.example.intentkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA.setOnClickListener{
            // 다음 화면으로 이동하기 위한 인텐트 객체 생성
            val intent = Intent(this, SubActivity::class.java)
            // hello world 라는 텍스트를 msg 라는 키로 잠금.
            intent.putExtra("msg", binding.tvSendMsg.text.toString())

            // intent에 저장되어 있는 액티비티로 이동
            startActivity(intent)

            // 자기 자신의 액티비티를 파괴한다.
            //finish()
        }
    }
}