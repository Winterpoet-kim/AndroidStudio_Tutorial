package com.example.threadexam


import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.threadexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    // 쓰레드 flag 값
    private var isThread : Boolean = false
    // 쓰레스 핸들러 생성
    private val handler = HandlerThread("handlerThread")


    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //setContentView(R.layout.activity_main)
    mBinding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.btnStart.setOnClickListener {
        isThread = true
        // 쓰레드 시작 : 핸들러를 통한 분기 (while 구문을 통해 5초마다 메시지 표시)
        Toast.makeText(this@MainActivity, "쓰레드 시작", Toast.LENGTH_SHORT).show()

    }

    binding.btnStop.setOnClickListener {
        // 쓰레드 종료
        isThread = false
        Toast.makeText(this@MainActivity, "쓰레드 종료", Toast.LENGTH_SHORT).show()
    }
        
    }
}



