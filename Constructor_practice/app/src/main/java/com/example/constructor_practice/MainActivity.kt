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

        Log.d(TAG, "MainActivity - myFriend : ${myFriend.name}")
        Log.d(TAG, "MainActivity - myFriend : ${myFriend.age}")
        Log.d(TAG, "MainActivity - myFriend : ${myFriend.isMarried}")
        Log.d(TAG, "MainActivity - myFriend : ${myFriend.nickname}")


//        var myFriendWithParam = MyFriendWithParam("철수", 18, false, "땡칠이")
//
//        println("${myFriendWithParam.name}의 나이는 ${myFriendWithParam.age}이고 별명은${myFriendWithParam.nickName}입니다.")
//        Log.d(TAG, "${myFriendWithParam.name}의 나이는 ${myFriendWithParam.age}이고 별명은${myFriendWithParam.nickName}입니다.")

    }
}