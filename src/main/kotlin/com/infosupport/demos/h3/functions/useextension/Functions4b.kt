// Using an extension function

// TODO tell: package and dir name do not have to match like in Java
package com.infosupport.demos.h3.functions.use

// TODO tell: you have to import extension function in order to use it
import com.infosupport.demos.h3.functions.lastChar /* as myLast */

// TODO show
fun main() {
    val s = "Kotlin"
    println(s.lastChar())

    println(s.last()) // In Kotlin API! And a lot more...
}