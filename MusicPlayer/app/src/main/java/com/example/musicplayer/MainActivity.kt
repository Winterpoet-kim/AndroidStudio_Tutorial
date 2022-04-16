package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnPlay.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.seasons)
            mediaPlayer.start()
        }

        binding.btnStop.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
                mediaPlayer.reset()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}