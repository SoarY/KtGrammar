package com.olym.ktgrammar.clazz

/**
 * NAME：YONG_
 * Created at: 2022/2/9 15
 * Describe:
 */
class Runoob  constructor(name: String) {  // 类名为 Runoob
 // 大括号内是类体构成
 var url: String = "http://www.runoob.com"
 var country: String = "CN"
 var siteName = name

 init {
  println("初始化网站名: ${name}")
 }
 // 次构造函数
 constructor (name: String, alexa: Int) : this(name) {
  println("Alexa 排名 $alexa")
 }

 fun printTest() {
  println("我是类的函数")
 }
}