package com.olym.ktgrammar.imp

/**
 * NAME：YONG_
 * Created at: 2022/2/9 18
 * Describe:
 */
interface MyInterface {
 var name:String //name 属性, 抽象的
 fun bar()
 fun foo() {
  // 可选的方法体
  println("foo")
 }
}