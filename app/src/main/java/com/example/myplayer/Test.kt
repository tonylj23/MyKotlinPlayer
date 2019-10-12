package com.example.myplayer

import java.util.concurrent.ThreadPoolExecutor

data class Test(val id: Int, val name: String)

fun main() {


    println(phoneBook)
    println(cityBook)
    println(peopleCities)

}

data class Person(val name: String, val city: String, val phone: String) // 1

val people = listOf(                                                     // 2
        Person("John", "Boston", "+1-888-123456"),
        Person("Sarah", "Munich", "+49-777-789123"),
        Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))

val phoneBook = people.associateBy { it.phone }                          // 3
val cityBook = people.associateBy(Person::phone, Person::city)           // 4
val peopleCities = people.groupBy(Person::city, Person::name)

fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"

fun square() {
    println(25.toString())
}



val systemUsers: MutableList<Int> =mutableListOf(1, 2, 3)        // 1
val sudoers: List<Int> = systemUsers

fun addSys(newUser:Int){
    systemUsers.add(newUser)
}

fun getSud():List<Int>{
    return sudoers
}


val a:MutableMap<Int,Int> = mutableMapOf(1 to 200,2 to 100)


val numbers= listOf(1,2,4,-1)
val pos= numbers.filter { x->x>0 }
val m= numbers.map { it*3 }
