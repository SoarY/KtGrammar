package com.olym.ktgrammar.clazz2

import kotlin.reflect.KProperty

/**
 * NAME：YONG_
 * Created at: 2022/2/10 12
 * Describe:
 */
class Delegate {
 operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
  return "$thisRef, 这里委托了 ${property.name} 属性"
 }

 operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
  println("$thisRef 的 ${property.name} 属性赋值为 $value")
 }
}