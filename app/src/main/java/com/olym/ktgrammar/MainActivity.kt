package com.olym.ktgrammar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olym.ktgrammar.R
import com.olym.ktgrammar.clazz.*
import com.olym.ktgrammar.clazz2.BaseImpl
import com.olym.ktgrammar.clazz2.Derived2
import com.olym.ktgrammar.clazz2.Example
import com.olym.ktgrammar.imp.TestInterFace
import java.lang.Integer.parseInt
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sum = sum(1, 2)
        println("sum:$sum")

        printSum(1,3)

        vararg(1,2,3)

        val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
        println(sumLambda(1,2))  // 输出 3

        val b=1
        val v:Int

        var x=5
        x+=1
        println(x)

        var a = 2

        val s1 = "a is $a"
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        println(s2)


        //类型后面加?表示可为空
//        var age: String? = "23"
        var age: String? = null
//        //抛出空指针异常
//        val ages = age!!.toInt()
        //不做处理返回 null
        val ages1 = age?.toInt()
//age为空返回-1
        val ages2 = age?.toInt() ?: -1

        var ages3=age?.toInt()

        println("ages1$ages1 ages2$ages2")


        val x1 = parseInt("1")
        val y = parseInt("2")
        // 直接使用 `x * y` 会导致错误, 因为它们可能为 null.
        if (x1 != null && y != null) {
            // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
            print(x * y)
        }

        print("循环输出：")
        for (i in 1..4) print(i) // 输出“1234”
        println("\n----------------")
        print("设置步长：")
        for (i in 1..4 step 2) print(i) // 输出“13”
        println("\n----------------")
        print("使用 downTo：")
        for (i in 4 downTo 1 step 2) print(i) // 输出“42”
        println("\n----------------")
        print("使用 until：")
        // 使用 until 函数排除结束元素
        for (i in 1 until 4) {   // i in [1, 4) 排除了 4
            print(i)
        }
        println("\n----------------")


        test2()

        test3()

        test4()

        test5()

        test6()

        test7()

        test8()

        test9()

        test10()

        test11()

        test12()

        test13()

        test14()

        test15()
    }

    private fun test15() {
        val user = TestUser()
        user.name = "第一次赋值"
        user.name = "第二次赋值"

        var map:MutableMap<String, Any?> = mutableMapOf(
            "name" to "教",
            "url" to "www.runoob.com"
        )

        val site2 = Site2(map)
        println(site2.name)
        println(site2.url)

        println("--------------")
        map.put("name", "Google")
        map.put("url", "www.google.com")
        println(site2.name)
        println(site2.url)

        val foo2 = Foo2()
        foo2.notNullBar = "bar"
        println(foo2.notNullBar)
    }

    class Foo2 {
        var notNullBar: String by Delegates.notNull<String>()
    }

    class Site2(val map: MutableMap<String, Any?>) {
        val name: String by map
        val url: String  by map
    }

    class TestUser {
        var name: String by Delegates.observable("初始值") {
                prop, old, new ->
            println("旧值：$old -> 新值：$new")
        }
    }

    private fun test14() {
        println(lazyValue)   // 第一次执行，执行两次输出表达式
        println(lazyValue)   // 第二次执行，只输出返回值
    }

    val lazyValue: String by lazy {
        println("computed!")     // 第一次调用输出，第二次调用不执行
        "Hello"
    }

    val testlazy:Int by lazy{
        println("testlazy")
        1
    }

    private fun test13() {
        val b = BaseImpl(10)
        Derived2(b).print() // 输出 10


        val e = Example()
        println(e.p)     // 访问该属性，调用 getValue() 函数

        e.p = "Runoob"   // 调用 setValue() 函数
        println(e.p)
    }

    private fun test12() {
        val site = object {
            var name: String = "程"
            var url: String = "www.runoob.com"
        }
        println(site.name)
        println(site.url)


        var s1 =  Site
        var s2 = Site
        s1.url = "www.runoob.com"
        println(s1.url)
        println(s2.url)

        val create = MyClass.create()
    }

    class MyClass {
        companion object Factory {
            fun create(): MyClass = MyClass()
        }
    }

    object Site {
        var url:String = ""
        val name: String = "程"
    }

    private fun test11() {
        var color:Color=Color.BLUE

        println(Color.values())
        println(Color.valueOf("RED"))
        println(color.name)
        println(color.ordinal)
    }

    inline fun <reified T : Enum<T>> printAllValues() {
        print(enumValues<T>().joinToString { it.name })
    }

    private fun test10() {
//        var strCo: Runoob<String> = Runoob("a")
//        var anyCo: Runoob<Any> = Runoob<Any>("b")
//        anyCo = strCo
//        println(anyCo.foo())   // 输出 a

        var strDCo = Runoob("a")
        var anyDCo = Runoob<Any>("b")
        strDCo = anyDCo
    }

    // 定义一个支持逆变的类
    class Runoob<in A>(a: A) {
        fun foo(a: A) {
        }
    }

//    // 定义一个支持协变的类
//    class Runoob<out A>(val a: A) {
//        fun foo(): A {
//            return a
//        }
//    }

    private fun test9() {
        val box = Box(1)
        val box1: Box<Int> = Box<Int>(2)

        val box2 = Box("test")

        // 以下都是合法语句
        val box4 = boxIn<Int>(1)
        val box5 = boxIn(1)     // 编译器会进行类型推断

        val age = 23
        val name = "runoob"
        val bool = true

        doPrintln(age)    // 整型
        doPrintln(name)   // 字符串
        doPrintln(bool)   // 布尔型

        sort(listOf(1, 2, 3)) // OK。Int 是 Comparable<Int> 的子类型
    }

    fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String> where T : CharSequence, T : Comparable<T> {
        return list.filter { it > threshold }.map { it.toString() }
    }

    fun <T : Comparable<T>> sort(list: List<T>) {
        // ……
    }

    fun <T> doPrintln(content: T) {
        when (content) {
            is Int -> println("整型数字为 $content")
            is String -> println("字符串转换为大写：${content.toUpperCase()}")
            else -> println("T 不是整型，也不是字符串")
        }
    }

    fun <T> boxIn(value: T):Box<T>{
        return Box(value)
    }

    fun <T> boxInA(value: T)=Box(value)

    private fun test8() {
        val user2 = User2("soar", 1)
        val copy = user2.copy(age = 2)
        println(user2)
        println(copy)


        val jane = User2("Jane", 35)
        val (name, age) = jane
        println("$name, $age years of age") // prints "Jane, 35 years of age"
    }

    private fun test7() {
        val user = User("a")
        user.printA()

        val mutableListOf = mutableListOf(1, 2, 3)
        mutableListOf.swap(0,2)
        println(mutableListOf.toString())
    }

    fun User.printA(){
        println("扩展$name")
    }

    fun MutableList<Int>.swap(index1:Int,index2:Int){
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2]=tmp
    }

    private fun test6() {
        val test = Test()

        test.setInterFace(object :TestInterFace{
            override fun test() {
                println("对象表达式创建匿名内部类的实例")
            }
        })
    }

    private fun test5() {
        var person: Person = Person("a")

        person.lastName = "wang"

        println("lastName:${person.lastName}")

        person.no = 9
        println("no:${person.no}")

        person.no = 20
        println("no:${person.no}")

        val nested = Outer.Nested()
        val foo = nested.foo()
    }

    private fun test4() {
        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println(item)
        }

        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

        for ((index, value) in items.withIndex()) {
            println("the element at $index is $value")
        }

        println("----while 使用-----")
        var x = 5
        while (x > 0) {
            println( x--)
        }
        println("----do...while 使用-----")
        var y = 5
        do {
            println(y--)
        } while(y>0)


        loop@ for (i in 1..100) {
            for (j in 1..100) {
                if (j==5) break@loop
            }
        }
    }


    private fun test3() {
        var a:Int=1
        var b:Int=2

//        // 传统用法
//        var max = a
//        if (a < b) max = b

//// 使用 else
//        var max: Int
//        if (a > b) {
//            max = a
//        } else {
//            max = b
//        }
//

// 作为表达式
        val max = if (a > b) a else b

//        val max = if (a > b) {
//            print("Choose a")
//            a
//        } else {
//            print("Choose b")
//            b
//        }


        val x = 5
        val y = 9
        if (x in 1..8) {
            println("x 在区间内")
        }

        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> { // 注意这个块
                print("x 不是 1 ，也不是 2")
            }
        }

        when (x) {
            0, 1 -> print("x == 0 or x == 1")
            else -> print("otherwise")
        }

        when (x) {
            in 1..10 -> print("x is in the range")
            !in 10..20 -> print("x is outside the range")
            else -> print("none of the above")
        }

        fun hasPrefix(x: Any) = when(x) {
            is String -> x.startsWith("prefix")
            else -> false
        }

        val items = setOf("apple", "banana", "kiwi")
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }
    }

    private fun test2() {
        val a: Int = 10000
        println(a === a) // true，值相等，对象地址相等

        //经过了装箱，创建了两个不同的对象
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        //虽然经过了装箱，但是值是相等的，都是10000
        println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
        println(boxedA == anotherBoxedA) // true，值相等


        val b: Byte = 1 // OK, 字面值是静态检测的
        val i: Int = b.toInt() // OK

        val l = 1L + 3 // Long + Int => Long

        val shl = 1.shl(1)

        //[1,2,3]
        val a1 = arrayOf(1, 2, 3)
        //[0,2,4]
        val b1 = Array(3, { i -> (i * 2) })

        //读取数组内容
        println(a1[0])    // 输出结果：1
        println(b1[1])    // 输出结果：2

        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]

        for (c in "abc") {
            println(c)
        }

        val text = """
            多行字符串
            多行字符串
            """.trimMargin()
        println(text)   // 输出有一些前置空格

        val i1 = 10
        val s = "i = $i1" // 求值结果为 "i = 10"
        println(s)

        val s1 = "runoob"
        val str = "$s1.length is ${s1.length}" // 求值结果为 "runoob.length is 6"
        println(str)

        val price = """
    ${'$'}9.99
    """
        println(price)  // 求值结果为 $9.99

    }

    fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt() // 显式转换为数字
    }

    public fun sum (a: Int,b: Int): Int=a+b

    fun printSum(a:Int,b:Int){
        println("printSum"+(a+b))
    }

    fun vararg(vararg v:Int){
        for (i in v) {
            println("vararg i$i")
        }
    }

    fun getStringL(obj: Any): Int?{
        if (obj is String ){
            return obj.length
        }
        return null
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // 做过类型判断以后，obj会被系统自动转换为String类型
            return obj.length
        }

        //在这里还有一种方法，与Java中instanceof不同，使用!is
        // if (obj !is String){
        //   // XXX
        // }

        // 这里的obj仍然是Any类型的引用
        return null
    }
}