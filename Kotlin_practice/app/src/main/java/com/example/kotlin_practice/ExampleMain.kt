//package com.example.kotlin_practice
//
//fun main(){
//    helloWorld()
//    var a:Int = 123
//    println(a)
//    var intValue = 1234
//    var longValue:Long = 1234L
//    var intValueByHex:Int = 0x1af
//    var doubleValue:Double = 123.5
//    var doubleValueWithExp:Double = 123.5e10
//    var floatValue:Float = 123f

//    var intArr = arrayOf(1,2,3,4,5)
//    var nullArr = arrayOfNulls<Int>(5)

//    doWhen(1)
//    doWhen("DiMo")
//    doWhen(12L)
//    doWhen(3.14159)
//    doWhen("Kotlin")

//    loop@for (i in 1..10) {
//        for (j in 1..10) {
//            if(i == 1 && j == 2) break@loop
//            print("i : $i, j : $j")
//        }
//    }

//    << 클래스 기본 및 기본/보조 생성자>>
//    var p1 = Person("박보영", 1990)
//    var p2 = Person("전정국")
//    var p3 = Person("장원영", 2004)
//    println("안녕하세요, ${p1.birthYear}년생 ${p1.name}입니다.")
//    p2.introduce()

//    <<클래스 상속>>
//    var a = Animal("별이", 5, "개")
//    var b = Dog("별이", 5)
//
//    a.introduce()
//    b.introduce()
//    b.bark()
//
//    var c = Cat("루이", 1)
//    c.introduce()
//    c.meow()

//    <<overriding>>
//    var t = Tiger()
//    t.eat()

//    <<abstraction 1.>>
//    var r = Rabbit()
//    r.eat()
//    r.sniff()

//    <<abstraction 2. - interface>>
//    var d = Dog()
//    d.eat()
//    d.run()

//    <<고차 함수(higher-order function)>>
//    b(::a)

//    <<람다 함수(lambda function)>>
//    var c = {str:String -> println("$str 람다함수")}
//    b(c)

//    ex) 람다 함수 내에서 여러 구문 사용
//    var calculate:(Int, Int)->Int = {a, b ->
//        println(a)
//        println(b)
//        a + b   // 마지막은 return 값
//    }

//    ex) 패러미터가 1개일 경우 it 사용
//    var c : (String) -> Unit = {println("$it 람다함수")}

//    <<스코프 함수(Scope function)>>
//    ex) apply
//    var a = Book("디모의 코틀린", 10000).apply{
//        name = "[초특가]" + name
//        discount()
//    }
//    println("${a.name}의 가격은 ${a.price}입니다.")
//
////    ex) run
//    var b = a.run{
//        println(a.price)
//        a.name   // 마지막 구문이 결과 값으로 return
//    }
//    println(b)


//    <<오브젝트 (Object)>>
//    println(Counter.count)
//    Counter.countUp()
//    Counter.countUp()
//    println(Counter.count)
//    Counter.clear()
//    println(Counter.count)

//    <<컴페니언 오브젝트 (Companion Object)>>
//    var a = FoodPoll("짜장")
//    var b = FoodPoll("짬뽕")
//
//    a.vote()
//    a.vote()
//    b.vote()
//    b.vote()
//    b.vote()
//
//    println("${a.name} 투표수 = ${a.count}")
//    println("${b.name} 투표수 = ${b.count}")
//    println("총 투표수 = ${FoodPoll.total}")

//    <<옵저버 패턴 : 이벤트 감시>>
//    EventPrinter().start()


//    <<클래스 다형성 (Polymorphysm)>>
//    var a = Drink()
//    a.drink()
//    var b : Drink = Cola()
//    b.drink()
//    if(b is Cola){  // 조건문 안에서만 잠시 down-casing 된다.
//        b.washDishes()
//    }
//    var c = b as Cola
//    c.washDishes()
//    b.washDishes()  // 반환값 뿐만아니라 변수 자체도 down-casing 됨을 알수있다.

//    <<generic>>
//    UsingGeneric(A()).doShouting()
//    UsingGeneric(B()).doShouting()
//    UsingGeneric(C()).doShouting()
//    doShouting(A())
//    doShouting(B())
//    doShouting(C())


//    <<List>>
//    var a = listOf("사과", "딸기", "배")
//    println(a)
//    println(a[1])
//    for (fruit in a){
//        println("${fruit}")
//    }
//    var b = mutableListOf(6,3,1)
//    println(b)
//    b.add(4)
//    println(b)
//    b.add(2,8)
//    println(b)
//    b.removeAt(1)
//    println(b)
//    b.shuffle()
//    println(b)
//    b.sort()
//    println(b)

//    <<문자열 : String>>
//    var test1 = "Test.Kotlin.String"
//    println(test1.length)
//    println(test1.lowercase())
//    println(test1.uppercase())
//
//    var test2 = test1.split(".")
//    println(test2)
//    println(test2.joinToString())
//    println(test2.joinToString("-"))
//
//    println(test1.substring(5..10))

//    val nullString:String? = null
//    val emptyString = ""
//    val blankString = " "
//    val normalString = "A"
//
//    println(nullString.isNullOrEmpty()) // null 이거나 empty 이면 ture
//    println(emptyString.isNullOrEmpty())
//    println(blankString.isNullOrEmpty())
//    println(normalString.isNullOrEmpty())
//    println()
//    println(nullString.isNullOrBlank()) // null 이거나 blank 이면 ture
//    println(emptyString.isNullOrBlank())
//    println(blankString.isNullOrBlank())
//    println(normalString.isNullOrBlank())
//    // 공백 문자의 차이 : space, Tab, Line Feed, Carrige Return

//    var test3 = "kotlin.kt"
//    var test4 = "java.java"
//
//    println(test3.startsWith("java"))
//    println(test4.startsWith("java"))
//
//    println(test3.endsWith(".kt"))
//    println(test4.endsWith(".kt"))
//
//    println(test3.contains("lin"))
//    println(test4.contains("lin"))


//    <<null 처리>>

//    var a:String? = null
//    println(a?.uppercase())
//    println(a?:"default".uppercase())
//    println(a!!.uppercase())
//    a?.run{
//        println(uppercase())
//        println(lowercase())
//    }

//    <<변수의 동일성 확인>>
//    var a = Product("콜라", 1000)
//    var b = Product("콜라", 1000)
//    var c= a
//    var d = Product("사이다", 1000)
//
//    println(a == b)  // true
//    println(a === b)  // false
//
//    println(a == c)  // true
//    println(a === c)  // ture
//
//    println(a == d)  // false
//    println(a === d)  // false
//

//    <overloading>>
//    read(7)
//    read("감사합니다.")

//    <<default argument>>
//    deliveryItem("짬뽕")
//    deliveryItem("노트북", 30, "학교" )
//    // 패러미터 중간값을 기본값으로 사용하고 싶을때 : named argument
//    deliveryItem("선물", destination = "친구집")

//    <<variable number of arguments (vararg)>>
//    같은 자료형을 개수에 상관없이 패러미터로 받고 싶을때 사용
//    sum(1,2,3,4)

//    <<infix function>>
//    좌측에 붙은 6이 infix 함수가 적용되는 객체 자신 (=this)
//    우측에 붙은 4가 패러미터인 x에 해당
//    println(6 multiply 4)
//    println(6 multiply(4))

//    <<중첩 클래스 : Nested Class>>
//    Outer.Nested().introduce()
//
//    val outer = Outer()
//    val inner = outer.Inner()
//
//    inner.introduceInner()
//    inner.introduceOuter()
//
//    outer.text = "Changed Outer Class"
//    inner.introduceOuter()

//    <<Data class>>
//    val a = General("보영", 212)
//    println(a == General("보영", 212))
//    println(a.hashCode())
//    println(a)
//
//    val b = Data("루다", 306)
//    println(b == Data("루다", 306))
//    println(b.hashCode())
//    println(b)
//
//    println(b.copy())
//    println(b.copy("아린"))
//    println(b.copy(id=618))
//
//    val list = listOf(Data("보영", 212),
//        Data("루다", 306),
//        Data("아린", 618))
//    for ((a, b) in list){   // a 값은 component1(), b 값은 component2()로 가져온다
//        println("${a}, ${b}")
//    }

//    <<Enum class>>
//    var state = State.SING
//    println(state)
//    state = State.SLEEP
//    println(state.isSleep())
//    state = State.EAT
//    println(state.message)

//    <<컬렉션 클래스 : Set / Map>>
//    val a = mutableSetOf("귤", "바나나", "키위")
//    for(i in a){
//        println(i)
//    }
//    a.add("자몽")
//    println(a)
//    a.remove("바나나")
//    println(a.contains("귤"))

//    val a = mutableMapOf("레드벨벳" to "음파음파",
//        "트와이스" to "FANCY",
//        "ITZY" to "ICY")
//    for(entry in a){
//        println("${entry.key} : ${entry.value}")
//    }
//    a.put("오마이걸","번지")
//    println(a)
//    a.remove("트와이스")
//    println(a)
//    println(a["레드벨벳"])

//    <<컬렉션 함수>>
//    val nameList = listOf("박수영","김지수","김다현","신유나","김지우")
//    nameList.forEach{print(it + " ")}
//    println()
//    println(nameList.filter{it.startsWith("김")})
//    println(nameList.map{"이름: " + it})
//    println(nameList.any{it == "김지연"})
//    println(nameList.all{it.length == 3})
//    println(nameList.none{it.startsWith("이")})

//    data class Person(val name:String, val birthYear:Int)
//    val personList = listOf(Person("유나", 1992),
//        Person("조이", 1996),
//        Person("츄", 1999),
//        Person("유나", 2003))
//    println(personList.associateBy{ it.birthYear })
//    println(personList.groupBy{it.name})
//    var (a_list, b_list) = personList.partition { it.birthYear < 1999}
//    println(a_list)
//    println(b_list)

//    val numbers = listOf(-3, 7, 2, -10, 1)
//    println(numbers.flatMap{
//        listOf(it*3, it+3)
//    })
//    println(numbers.getOrElse(2){100})
//    println(numbers.getOrElse(10){100})
//    val numbers_small = listOf(-3, 7, 2, -10, 1)
//    println(numbers zip numbers_small)


//    <<변수의 고급기술>>
//    val foodCourt = FoodCourt()
//    foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)
//    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
//    foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)

//    var late =  LateInitSample()
//    println(late.getLateInitText())
//    late.text = "초기화"
//    println(late.getLateInitText())

//    val number:Int by lazy{
//      println("초기화를 합니다.")
//      7
//    }
//    println("코드를 시작합니다.")
//    println(number)
//    println(number)


//    <<비트 연산>>
//    var bitData:Int = 0b10000  // 지정되지 않은 상위 비트들은 0으로 채워진다.
//    // 세번째 비트에 1을 set 하기
//    bitData = bitData or(1 shl 2)
//    println(bitData.toString(2))
//
//    var result = bitData and(1 shl 4)
//    println(result.toString(2))
//    println(result shr 4)
//    bitData = bitData and((1 shl 4).inv())
//    println(bitData.toString(2))
//
//    println((bitData xor (0b10100)).toString(2))


//}




