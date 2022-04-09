package com.example.constructor_practice

import android.util.Log

class MyFriendWithParam (var name:String?, var age:Int?, var isMarried:Boolean?, var nickName:String?){

    val TAG: String = "로그"
    var addr:String? = null

    // 기본 생성자
    init {
        Log.d(TAG, "MyFriendWithParam - init() called")
        this.name = name
        this.age = age
        this.isMarried = isMarried
        this.nickName = nickName
    }

    // 추가 생성자
    constructor(name: String?, age: Int?, isMarried: Boolean?, nickName: String?, addr:String?):this(name, age, isMarried, nickName){
        Log.d(TAG, "MyFriendWithParam - constructor() called")
        this.addr = addr
    }

}