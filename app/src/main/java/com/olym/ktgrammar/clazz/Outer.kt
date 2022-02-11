package com.olym.ktgrammar.clazz

/**
 * NAME：YONG_
 * Created at: 2022/2/9 17
 * Describe:
 */
class Outer {                  // 外部类
 private val bar: Int = 1
 class Nested {             // 嵌套类
  fun foo() = 2
 }

 var v = "成员属性"
 /**嵌套内部类**/
 inner class Inner {
  fun foo() = bar  // 访问外部类成员
  fun innerTest() {
   var o = this@Outer //获取外部类的成员变量
   println("内部类可以引用外部类的成员，例如：" + o.v)
  }
 }
}