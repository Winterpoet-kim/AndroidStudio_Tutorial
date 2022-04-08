package com.example.kotlin_practice

////////////////////////////////////////////////////////////////////////////////////

//fun doWhen(a:Any){
//    when(a){
//        1 -> println("정수 1입니다.")
//        "DiMo" -> println("디모의 코틀린 강좌입니다.")
//        is Long -> println("Long 타입입니다.")
//        !is String -> println("String 타입이 아닙니다.")
//        else -> println("어떤 조건도 만족하지 않습니다.")
//    }
//}

//    << 클래스 기본 및 기본/보조 생성자>>
//class Person (var name:String, val birthYear:Int){
//    // 기본 생성자
//    init {
//        println("[init] 안녕하세요, ${this.birthYear}년생 ${this.name}입니다.")
//    }
//
//    // 보조 생성자 : 반드시 기본 생성자를 통해 속성을 초기화!(보조 생성자가 기본 생성자를 호출)
//    constructor(name: String) : this(name, 1997){
//        println("보조 생성자가 사용되었습니다.")
//    }
//
//    fun introduce(){
//        println("안녕하세요, ${birthYear}년생 ${name}입니다.")
//    }
//}

//    <<클래스 상속>>
// 클래스를 상속시키려면 open 상태로 만들어주어야 함.
//// 상속 규칙1. 수퍼 클래스에 존재하는 속성과 같은 이름의 속성을 가질 수 없음.
//// 상속 규칙2. 서브 클래스가 생성될때는 반드시 수퍼 클래스의 생성자까지 호출되어야함.
//open class Animal(var name:String, var age:Int, var type:String)
//{
//    fun introduce(){
//        println("저는 ${type} ${name}이고, ${age}살 입니다.")
//    }
//}
//// var, val 을 붙이면 자체 속성으로 만들어지므로 붙이지 않고 일만 패러미터로 받고
//// 뒤에 : 을 붙인뒤, 수퍼 클래스의 생성자를 호출
//class Dog(name:String, age:Int) : Animal (name, age, "개")
//{
//    fun bark(){
//        println("멍멍")
//    }
//}
//class Cat(name:String, age:Int) : Animal (name, age, "고양이")
//{
//    fun meow(){
//        println("야옹")
//    }
//}

//    <<overriding>>
// 추상화 = 선언부만 있고 기능이 구현되지 않은 추상함수, 추상 클래스 사용
//open class Animal{
//    open fun eat(){
//        println("음식을 먹습니다.")
//    }
//}
//
//class Tiger : Animal(){
//    override fun eat(){
//        println("고기를 먹습니다.")
//    }
//}

//    <<abstraction 1.>>
// 추상화 = 선언부만 있고 기능이 구현되지 않은 추상함수, 추상 클래스 사용
// abstract 클래스는 단독으로는 인스턴스를 만들수 없다.
// 반드시 상속 받아 abstract 가 표시된 함수들을 구현해야 함.
//abstract class Animal{
//    abstract fun eat()
//    fun sniff(){
//        println("킁킁")
//    }
//}
//class Rabbit : Animal(){
//    override fun eat(){
//        println("당근을 먹습니다.")
//    }
//}

//    <<abstraction 2. - interface>>
// interface 는 일반 속성, 추상함수, 일반함수 모두 가질수있다.
// 다만 추상함수는 생성자를 가질 수 있는 반면
// interface 는  생성자를 가질 수 없고
// 별도의 키워드가 필요없다
// (구현부 있는 함수 -> open 함수로 간주)
// (구현부가 없는 함수 -> abstract 함수로 간주)
// 장점 : 한번에 여러 interface 를 상속받을 수 있으므로 유연하게 구현 가능
//interface Runner{
//    fun run()
//}
//interface Eater{
//    fun eat(){
//        println("음식을 먹습니다.")
//    }
//}
//class Dog : Runner, Eater{
//    override fun run(){
//        println("우다다 뜁니다.")
//    }
//    override fun eat(){
//        println("고기를 먹습니다.")
//    }
//}

//    <<접근 제한자>>
// [패키지 스코프]
// 1. public(기본값) : 어떤 패키지에서도 접근 가능
// 2. internal : 같은 모듈 내에서만 접근 가능
// 3. private : 같은 파일 내에서만 접근 가능
// 4. protected : 사용하지 않음
// [클래스 스코프]
// 1. public(기본값) : 클래스 외부에서 접근 가능
// 2. internal : 사용하지 않음
// 3. private : 클래스 내부에서만 접근 가능
// 4. protected : 클래스 자신과 상속받은 클래스에서만 접근 가능

//    <<고차 함수(higher-order function>>
// 함수를 마치 클래스에서 만든 인스턴스처럼 취급하는 방법
// 함수를 패러미터로 넘겨줄수도 있고
// 결과값으로 반환 맏을 수도 있는 방법
//// 모든 함수를 고차함수로 사용 가능
//fun a(str:String){
//    println("$str 함수 a")
//}
//fun b(function:(String)->Unit ){
//    function("b가 호출한")
//}

//    <<람다 함수(lambda function)>>
// 람다 함수는 그 자체가 고차함수이기 때문에
// 별도의 연산자 없이도 변수에 담을 수 있다.
// 여러 구문의 사용이 가능

//    <<스코프 함수(Scope function)>>
// 클래스 내의 인스턴스를 Scope 함수에 전달하면
// 인스턴스의 속성이나 함수를 좀 더 깔금하게 불러 쓸수 있음.
// 1. apply : 인스턴스를 생성한 후, 변수에 담기전에 초기화 과정 수행할때 쓰임
// 2. run : apply 와 같이 run scope 안에서 참조 연산자를 사용하지 않는것은 같지만 마지막 구문을 return 한다는것이 다름
// 3. with : run과 비교해 인스턴스를 패러미터로 받는다는 차이점 제외하면 똑같음.
//       ex) a.run{..}  with(a){..}
// 4. also(apply 대용) : main 에 있는 같은 이름의 변수를 우선시하므로, it을 사용하여 구분, 처리가 끝나면 인스턴스를 반환
// 5. let(run 대용): main 에 있는 같은 이름의 변수를 우선시하므로, it을 사용하여 구분, 처리가 끝나면 최종값을 반환

//ex) apply
//class Book(var name:String, var price:Int)
//{
//    fun discount()
//    {
//        price -= 2000
//    }
//}


//    <<오브젝트 (Object)>>
// 그 자체로 객체이기 때문에 생성자는 사용하지 않는다.
// 최초 생성시 자동으로 생성되며, 이후, 코드 전체에서 공용으로 사용
// Singleton Pattern
// 클래스의 인스턴스를 단 하나만 만들어 사용하도록 하는 코딩 아키텍쳐 패턴
//object Counter{
//    var count = 0
//    fun countUp(){
//        count++
//    }
//    fun clear(){
//        count = 0
//    }
//}

//    <<컴페니언 오브젝트 (Companion Object)>>
// 클래스 내에서 오브젝트 생성
// 클래스 인스턴스들은 그대로 사용하면서, 공용 속성 및 함수를 별도로 만드는 기능
// 다른 언어의 Static 멤버와 같음.
// Static 멤버 : 클래스 내부에서 별도의 영역에 고정적으로 존재, 인스턴스를 생성하지 않아도
//              공용으로 사용가능한 속성이나 함수.
//class FoodPoll (val name:String){
//    companion object{
//        var total = 0
//    }
//    var count = 0
//    fun vote(){
//        total++
//        count++
//    }
//}

//    <<옵저버 패턴 : 이벤트 감시>>
// 2개의 클래스 필요
// 1. 이벤트를 수신, 기능 수행
// ------- 인터페이스  --------
// 2. 이벤트의 발생 및 전달
// 두 클래스 사이의 인터페이스 =  옵저버
// 이를 listener 라고 부르며 이벤트를 넘겨주는 행위를 callback 이라 한다.

//interface EventListener{
//    fun onEvent(count:Int)
//}
//
//class Counter(var listener: EventListener){
//    fun count(){
//        for(i in 1..100){
//            if(i%5==0) listener.onEvent((i))
//        }
//    }
//}
//
//class EventPrinter:EventListener{
//    override fun onEvent(count: Int) {
//        print("${count}-")
//    }
//    fun start(){
//        val counter = Counter(this)
//        counter.count()
//    }
//}

//    <<클래스 다형성 (Polymorphysm)>>
// Up-Casting : ex) var b : Drink = Cola()
// Down-Casting 의 종류 캐스팅 연산자 (2가지)
// 1. as : 호환되는 자료형으로 변환 + 반환
// 2. is : 호환되는 자료형인지 체크 후, 호환되면 조건문 내{..}에서만 down-casting 된다.
//open class Drink{
//    var name = "음료"
//    open fun drink(){
//        println("${name}을 마십니다.")
//    }
//}
//
//class Cola : Drink(){
//    var type = "콜라"
//    override fun drink(){
//        println("${name}중에 ${type}을 마십니다.")
//    }
//    fun washDishes(){
//        print("${type}로 설거지를 합니다.")
//    }
//}


//    <<generic>>
// 클래스나 함수에서 사용하는 자료형을 외부에서 지정할 수 있는 기능
// 캐스팅 연산을 거치는 것은 프로그램의 속도 저하시킬 수 있음.
// = 함수나 클래스를 선언할때 고정적인 자료형 대신, 실제 자료형으로 대체되는
//   타입 패러미터를 받아 사용하는 방법
//open class A{
//    open fun shout(){
//        println("A가 소리칩니다.")
//    }
//}
//class B : A(){
//    override fun shout(){
//        println("B가 소리칩니다.")
//    }
//}
//class C : A(){
//    override fun shout(){
//        println("C가 소리칩니다.")
//    }
//}
//class UsingGeneric<T:A> (var t:T){
//    fun doShouting(){
//        t.shout()
//    }
//}
//fun <T:A> doShouting(t:T){
//    t.shout()
//}

//    <<List>>
// 1. List<out T> : 생성시에 넣은 객체를 대체, 추가, 삭제 할수 없음
// 2. MutableList<T> : 생성시에 넣은 객체를 대체, 추가, 삭제 할수 있음
// 함수 : listOf(데이터)
// 함수 : mutableListOf(데이터), add(데이터), add(인덱스, 데이터), remove(데이터), removeAt(인덱스)
//      shuffle(), sort()


//    <<문자열 : String>>

//    <<null 처리>>
// [null] 체크 방법
// 1. null safe 연산자 = ?.
//  (참조 연산자를 사용하기 전에 null 인지 확인하고 null 이면 이후 구문을 실행하지 않음)
// 2. elvis 연산자 = ?:
//  (객체가 null 이 아니라면 그대로 사용, null 이면 연산자 우측의 객체로 대체됨)
// 3. non-null assertion 연산자 = !!.
//  (참조 연산자를 사용할때 null 여부를 컴파일시 확인하지 않도록 하여
//    의도적으로 null pointer exception 이 발생하도록 함.)


//    <<변수의 동일성 확인>>
//1. 내용의 동일성 : 메모리 상에 서로 다른곳에 할당되었어도 내용이 동일 ( == )
// ('Any'라는 최상위 클래스의 equals() 함수가 반환하는 Boolean 값으로 판단)
// 커스텀 클래스를 만들때는 open fun equals(other:Any?):Boolean 을 구현해주어야 함.

//2. 객체의 동일성 : 서로 다른 변수가 메모리상에 같은 객체를 가리키고 있음. ( === )

//class Product(val name:String, val price:Int){
//    override fun equals(other:Any?):Boolean {
//        if(other is Product){
//            return other.name == name && other.price == price
//        }else{
//            return false
//        }
//    }
//}


//    <<overloading>>
// 같은 scope 안에서 같은 이름의 함수를 여러개 만드드것. (패러미터는 각각 다름)
//fun read(x:Int){
//    println("숫자 ${x}입니다.")
//}
//fun read(x:String){
//    println(x)
//}

//    <<default argument>>
//fun deliveryItem(name:String, count:Int=1, destination:String="집"){
//    println("${name}, ${count}개를 ${destination}에 배달하였습니다.")
//}


//    <<variable number of arguments (vararg)>>
// vararg 는 갯수가 지정되지 않아 다른 패러미터와 같이 쓸때는 제일 마지막에 써야함.
//fun sum(vararg numbers:Int){
//    var sum = 0
//    for (n in numbers){
//        sum += n
//    }
//    print(sum)
//}


//    <<infix function>>
// 마치 연산자 처럼 사용
// 함수 이름을 infix 함수가 적용될 자료형.이름 으로 지정
// 클래스 안에서 infix 함수를 선언할때에는
// 적용할 클래스가 자기 자신이므로 클래스 이름은 쓰지 않음.
//infix fun Int.multiply(x:Int):Int = this * x


//    <<중첩 클래스 : Nested Class / 내부 클래스 : Inner Class>>
// 중첩: 하나의 클래스가 다른 클래스의 기능과 강하게 연관되어 있다는 의미를 전달하기위해 만들어진 형식
// (형태만 내부에 존재할 뿐, 외부 클래스의 내용을 공유할 수 없음)
// 내부 클래스 : 중첩 클래스에 inner 키워드를 붙임
// (혼자서는 객체를 만들수 없고, 외부 클래스의 객체가 있어야만 생성과 사용이 가능
//  그리고, 외부 클래스의 속성과 함수의 사용이 가능)

//class Outer{
//    var text = "Outer Class"
//
//    class Nested{
//        fun introduce(){
//            println("Nested Class")
//        }
//    }
//    inner class Inner{
//        var text = "Inner Class"
//        fun introduceInner(){
//            println(text)
//        }
//        fun introduceOuter(){
//            println(this@Outer.text)
//        }
//    }
//}


//    <<Data class>>
// 1. equals() 자동구현 : 내용의 동일성 판단
// 2. hashcode() 자동구현 : 객체의 내용에서 고유한 코드를 생성
// 3. toString() 자동구현 : 포함된 속성을 나타내줌
// 4. copy() 자동구현 : 객체를 복사, 또는 패러미터로 데이터의 내용 수정
// 5. componentX() 자동구현 : 속성을 순서대로 반환
//class General(val name:String, val id:Int)
//data class Data(val name:String, val id:Int)


//    <<Enum class>>
// enum 클래스 안의 객체들은 관행적으로 대문자로 기술
// 선언시에 만든 객체를 이름으로 참조하여 그대로 사용
// 고유한 속성을 가질수 있음 : 생성자를 만들어 속성을 받도록하면 객체를 선언할때 속성도 설정가능
// 일반 클래스 처럼 함수도 추가 가능
//  (객체의 선언이 끝나는 부분에 ; 을 표시이후, 함수 선언)
//enum class State(val message:String){
//    SING("노래를 부릅니다."),
//    EAT("밥을 먹습니다."),
//    SLEEP("잠을 잡니다.");
//    fun isSleep() = this == State.SLEEP
//}


//    <<컬렉션 클래스 : Set / Map>>
// 1. Set : list 와 달리 중복이 허용되지 않고, 정렬되지 않음.
//         인덱스로 지정하여 객체를 참조할 수 없음.
//         .contains()를 통해 객체가 존재하는지만 확인가능
//  Set<out T> / MutableSet<T> : add(), remove()
// 2. Map : key와 객체의 쌍으로 데이터를 저장
//  Map<K, out V> / MutableMap<K, V> : put(key, value), remove(key)


//    <<컬렉션 함수>>
// 1. collection.forEach{
//      println(it)
// }
// 2. collection.filter{
//      it < 4   // 조건문 : 조건에 맞는 객체만 filtering 해서 반환
// }
// 3. collection.map{
//      it * 2   // 구문 : 구문을 적용한 후, 객체들을 반환
// }
// 4. collection.any{it == 0}  //조건문 : 하나라도 조건에 맞으면 true
// 5. collection.all{it == 0}  //조건문 : 모두 조건에 맞으면 true
// 6. collection.none{it == 0}  //조건문 : 하나도 조건에 맞지 않으면 true
// 7. collection.first{it > 3}  //조건문 : 조건에 맞는 첫번째 객체를 반환
//   ( = collection.find{it > 3} )
// 8. collection.last{it > 3}  //조건문 : 조건에 맞는 마지막 객체를 반환
//   ( = collection.findLast{it > 3} )
// 9. collection.count{it > 3}  //조건문 : 조건에 맞는 객체의 개수를 반환

// 10. associateBy : 객체에서 key를 추출하여 map으로 변환하는 함수
// collection.associateBy{it.name} : 객체의 name을 key, 객체를 value로하는 map을 반환
// 11. groupBy : key가 같은 아이템끼리 배열로 묶어 map으로 반환
// collection.groupBy{it.birthYear} : 같은 key값을 가진 객체끼리 묶어 배열을 만들고 map을 반환
// 12. partition : 객체에 조건을 걸어 두개의 컬렉션으로 나눔.
//                (두 객체를 담을 수있는 Pair 클래스로 반환 -> first, second로 참조가능)
// collection.partition{it.birthYear>2002}

// 13. flatMap : 객체마다 컬렉션을 추가로 만들고 추가된 객체까지 합쳐서 하나의 collection으로 반환
// collection.flatMap{
//    listOf(it*3, it+3)
// }
// 14. getOrElse(index){default} : 인덱스 위치에 객체가 있으면 반환, 아닌경우 지저한 기본값 반환
// collection.getOrElse(1){50}
// 15. zip : 컬렉션 2개의 객체를 1:1로 매칭 Pair 클래스의 객체로 만들고
//          리스트로 만들어 새 컬렉션으로 반환 (리스트의 개수는 더 작은 컬렉션이 맞춰진다)


//    <<변수의 고급기술>>
// val : 한번 할당된 객체를 바꿀수 없지만, 내부의 속성을 변경할 수는 있다.
// 절대 변경될수 없는 것 =  constants : 컴파일 시점에 결정되어 변경 불가
//   ex) const val CONST_A = 1234
// 상수로 선언될수 있는 것 : 기본 자료형 (String 자료형 포함)
// 런타임에 생성될 수 있는 일반적인 다른 클래스의 객체들은 담을 수 없다.
// 상수 사용 불가 = class의 속성, 지역 변수로는 쓸수 없음.
// 반드시 companion objet 안에 선언, 객체의 생성과 상관없이 클래스와 관계된 고정값으로 활용
// 상수를 사용하는 이유
// : 변수의 경우, 런타임시 객체를 생성하는데 시간이 더 소요되어 성능 하락
//class FoodCourt{
//    fun searchPrice(foodName : String){
//        val price = when(foodName){
//            FOOD_CREAM_PASTA -> 13000
//            FOOD_STEAK -> 25000
//            FOOD_PIZZA -> 15000
//            else -> 0
//        }
//        println("${foodName}의 가격은 ${price}입니다.")
//    }
//    companion object{
//        const val FOOD_CREAM_PASTA = "크림파스타"
//        const val FOOD_STEAK = "스테이크"
//        const val FOOD_PIZZA = "피자"
//    }
//}
// lateinit : 변수 앞에 선언
// 일단 변수만 선언하고 초기값 할당은 나중에 할 수 있도록 함.
// lateinit var 변수의 제한사항
// = 초기값 할당 전까지 변수를 사용할 수 없음(에러)
// 기본 자료형에는 사용할 수 없음 (단, String 클래스 에서는 사용가능)
// lateinit var a  변수의 초기화를 하였는지 확인 방법
// = ::a.isInitialized
//class LateInitSample{
//    lateinit var text:String
//    fun getLateInitText():String{
//        if(::text.isInitialized){
//            return text
//        }else{
//            return "기본값"
//        }
//    }
//}
// lazy delegate properties
// 변수를 사용하는 시점까지 초기화를 자동으로 늦춰준다.
// ex) val a:Int by lazy{7}


//    <<비트 연산>>
// 주 사용처 : 플래그 값, 네트워크(프로토콜 데이터 양 줄이기 위해)
// 코틀린에서는 모든 정수형이 부호를 포함하므로
// 최상위 비트 0 = 양수, 1 = 음수
// 1. bitwise shift 연산자
// shl : 부호비트를 제외한 모든 비트를 좌측으로 밀어주는 기능
// shr : 부호비트를 제외한 모든 비트를 우측으로 밀어주는 기능
// ushl : 부호비트를 포함한 모든 비트를 좌측으로 밀어주는 기능
// ushr : 부호비트를 포함한 모든 비트를 우측으로 밀어주는 기능
// 2. bitwise 연산자 : and, or, xor(같으면 0, 다르면 1)
// 3. inv() : 비트를 모두 반전시킴.


//    <<코루틴을 통한 비동기 처리>>






