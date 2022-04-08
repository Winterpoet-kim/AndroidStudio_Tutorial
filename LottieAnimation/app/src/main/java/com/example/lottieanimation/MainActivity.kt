package com.example.lottieanimation

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lottieanimation.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    private lateinit var binding : ActivityMainBinding
    var isLiked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        isLiked = false

        val rootView = binding.root
        setContentView(rootView)
        val like_btn = rootView.like_btn

        like_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - onCreate() called")
            //like_btn.playAnimation()

            if (!isLiked){
                val animator = ValueAnimator.ofFloat(0f, 0.28f)
                animator.addUpdateListener { animation : ValueAnimator ->
                    like_btn.progress = animation.animatedValue as Float
                }
                animator.duration = 1000
                animator.start()
                isLiked = true
            }else{
                val animator = ValueAnimator.ofFloat(0.28f, 1f)
                animator.addUpdateListener { animation : ValueAnimator ->
                    like_btn.progress = animation.animatedValue as Float
                }
                animator.duration = 1000
                animator.start()
                isLiked = false
            }
        }
    }
}