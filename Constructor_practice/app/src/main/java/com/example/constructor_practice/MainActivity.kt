package com.example.constructor_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    
    val TAG: String = "로그"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        Log.d(TAG, "MainActivity - onCreate() called")

        var myFriend = MyFriend()

//        Log.d(TAG, "MainActivity - myFriend : ${myFriend.name}")
//        Log.d(TAG, "MainActivity - myFriend : ${myFriend.age}")
//        Log.d(TAG, "MainActivity - myFriend : ${myFriend.isMarried}")
//        Log.d(TAG, "MainActivity - myFriend : ${myFriend.nickname}")


        var myFriendWithParam1 = MyFriendWithParam("철수", 18, false, "땡칠이")
        //Log.d(TAG, "MyFriendWithParam : ${myFriendWithParam1.name}이고 별명은${myFriendWithParam1.nickName}")

        var myFriendWithParam2 = MyFriendWithParam("영희", 17, false, "모지리", "대전")
        //Log.d(TAG, "MyFriendWithParam : ${myFriendWithParam1.name}이고 별명은${myFriendWithParam1.nickName}, 주소는${myFriendWithParam2.addr}")

        // 추가 생성자로 되어있는 친구 객체
        var myFriendWithMoreParam1 = MyFriendWithMoreParam("제임스")
        Log.d(TAG, "MyFriendWithMoreParam : ${myFriendWithMoreParam1.name}")

        var myFriendWithMoreParam2 = MyFriendWithMoreParam("제임스", 20)
        Log.d(TAG, "MyFriendWithMoreParam : ${myFriendWithMoreParam2.name}, ${myFriendWithMoreParam2.age}")



    }
}