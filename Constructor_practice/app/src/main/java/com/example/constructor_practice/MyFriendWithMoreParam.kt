package com.example.constructor_practice

// 추가 생성자로 되어있는 친구 클래스
class MyFriendWithMoreParam() {

    //멤버 변수
    var name:String? = null
    var age:Int? = null
    var isMarried:Boolean? = null
    var nickname:String? = null

    // 기보 생성자
    init{

    }
    // 추가 생성자
    constructor(name:String):this(){
        this.name = name
    }
    // 추가 생성자
    constructor(name:String, age:Int):this(){
        this.name = name
        this.age = age
    }
    // 추가 생성자
    constructor(name:String, age:Int, isMarried:Boolean):this(){
        this.name = name
        this.age = age
        this.isMarried = isMarried
    }
    // 추가 생성자
    constructor(name:String, age:Int, isMarried:Boolean, nickname:String):this(){
        this.name = name
        this.age = age
        this.isMarried = isMarried
        this.nickname = nickname
    }
    }
}