package com.example.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.imageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            binding.ivProfile.setImageResource(R.drawable.android_black)
            Toast.makeText(this@MainActivity,"버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show()
        }

    }
}