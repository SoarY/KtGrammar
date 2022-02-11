package com.olym.ktgrammar.clazz

/**
 * NAME：YONG_
 * Created at: 2022/2/9 15
 * Describe:
 */
class Person(firstName: String){

 init {
  println("FirstName is $firstName")
 }

  var lastName: String = "zhang"
   get() = field.toUpperCase()   // 将变量赋值后转换为大写
   set

  var no: Int = 100
   get() = field                // 后端变量
   set(value) {
    if (value < 10) {       // 如果传入的值小于 10 返回该值
     field = value
    } else {
     field = -1         // 如果传入的值大于等于 10 返回 -1
    }
   }


  var heiht: Float = 145.4f
   private set


}