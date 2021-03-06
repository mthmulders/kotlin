package com.infosupport.demos.h6.types

// Nullability:
// - safe cast,
// - unsafe not-null assertion,
// - let scope function,
// - nullability and
//      - extension functions
//      - generic type parameters

// TODO show and tell
fun main() {
    castPersonUnsafe(Person("Bram")) // OK
    // castPersonUnsafe("Bram")      // Exception

    castPersonSafe(Person("Bram"))   // OK
    castPersonSafe("Bram")           // OK

    printPersonNameUnsafe(person)    // OK
    // printPersonNameUnsafe(null)   // Exception

    // id 1 exists, id 2 not:
    letPrintPersonName(id = 1)
    letPrintPersonName(id = 2) // does nothing

    findPerson(1).printPersonNameSafeExtFn()
    findPerson(2).printPersonNameSafeExtFn() // no safe call needed, even though getPerson is of type Person?

    whatsTheTypeOfGenericTypeParam(person)
}

fun castPersonUnsafe(o: Any) {
    val p = o as Person  // if o !is Person: ClassCastException
    // now p is a `Person`
    println(p.name)
}

fun castPersonSafe(o: Any) {
    val p = o as? Person // if o !is Person p = null, else p is cast to Person
    // now p is smart cast to a `Person?`
    println(p?.name ?: "Unknown")
}

fun printPersonNameUnsafe(p: Person?) {
    // We tell the compiler we're sure that p is not null
    println(p!!.name) // !! is the not null assertion
}

fun findPerson(id: Int): Person? = if (id == 1) person else null // person or null, so Person?

fun letPrintPersonName(id: Int) {
    // when you want to execute a block of code if an object != null, use let:
    val p = findPerson(id)
    p?.let {
        // executes only if p != null
        println("Printing person name...")
        printPersonNameUnsafe(it)
    }
}

fun Person?.printPersonNameSafeExtFn() {
    println(this?.name ?: "Unknown")
}

fun <T> whatsTheTypeOfGenericTypeParam(t: T) {
    // T is nullable, since it can be anything
    println(t?.hashCode() ?: "Unknown") // safe call needed
}

