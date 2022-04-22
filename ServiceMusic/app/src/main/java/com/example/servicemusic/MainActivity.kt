package com.example.servicemusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.servicemusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding :ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MusicService::class.java)

        binding.btnStart.setOnClickListener {
            startService(intent)
        }
        binding.btnStop.setOnClickListener {
            stopService(intent)
        }

    }
}