package com.example.startactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.startactivityforresult.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private var mBinding : ActivitySubBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener {
            val intent = Intent()
            intent.putExtra("comeback", binding.etComback.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}