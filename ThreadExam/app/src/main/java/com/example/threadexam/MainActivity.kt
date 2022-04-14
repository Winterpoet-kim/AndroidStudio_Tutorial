package com.example.threadexam


import android.os.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.threadexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    // 쓰레드 flag 값
    private var isThread : Boolean = false
    // 쓰레스 핸들러 생성
    private lateinit var handler:Handler
    private lateinit var ready:TextView
    private var toastAlarmThread:ToastAlarmThread? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler()
        ready = binding.tvSec




        binding.btnStart.setOnClickListener {
            // 쓰레드 시작
            toastAlarmThread = ToastAlarmThread()
            toastAlarmThread?.start()
        }

        binding.btnStop.setOnClickListener {
            // 쓰레드 종료
            toastAlarmThread?.stopThread()


        }
    }
    inner class ToastAlarmThread : Thread(){

        private var isRunning = true
        private var time = 0

        override fun run() {
            super.run()
            while(isRunning){
                sleep(5000)

                handler.post{
                    Toast.makeText(this@MainActivity, "쓰레드 시작", Toast.LENGTH_SHORT).show()
                    ready.text = "${time}초"
                    time += 5
                }
            }

            handler.post{
                Toast.makeText(this@MainActivity, "쓰레드 종료", Toast.LENGTH_SHORT).show()
                ready.text = "준비중"
            }
        }
        fun stopThread(){
            isRunning = false
            toastAlarmThread = null
        }
    }
}



