package com.example.threadexam


import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.threadexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    // Thread 핸들러 생성
    private lateinit var handlerThread:HandlerThread
    private var toastAlarmThread:ToastAlarmThread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handlerThread = HandlerThread("toastAlarmThread")
        handlerThread.start()

        binding.btnStart.setOnClickListener {
            toastAlarmThread = ToastAlarmThread()
            toastAlarmThread?.start()
        }
        binding.btnStop.setOnClickListener {
            //Thread 종료
            toastAlarmThread?.stopThread()
        }
    }
    inner class ToastAlarmThread:Thread(){

        private var time = 0

        override fun run() {
            while(handlerThread.isAlive){
                Handler(handlerThread.looper).post{
                    Toast.makeText(this@MainActivity, "시작 Tread : ${handlerThread.name}", Toast.LENGTH_SHORT).show()
                    binding.tvSec.text = "$time 초"
                    time += 5
                }
                sleep(5000)
            }
        }
        fun stopThread(){
            Handler(handlerThread.looper).post{
                Toast.makeText(this@MainActivity, "종료 Tread : ${handlerThread.name}", Toast.LENGTH_SHORT).show()
                binding.tvSec.text = "준비중"
                handlerThread.quitSafely()
            }
            toastAlarmThread = null
        }
    }
}



