package com.example.earth

import java.util.Scanner;

val sc = Scanner(System.`in`)

fun main() {
    println("hello world!")
    PercentageGot()


}

fun EnterData(): Int {

    print("What's Your Name ?")
    val name = sc.next()

    println("hello $name , What's Up there!!,  Please enter your marks below")

    print("Tell me , how much you scored in English?")
    var English = sc.nextInt()

    print("how much you scored in Hindi?")
    var Hindi = sc.nextInt()

    print("how much you scored in Maths?")
    var Maths = sc.nextInt()

    print("how much you scored in SST?")
    var SST = sc.nextInt()

    print("how much you scored in Science?")
    var Science = sc.nextInt()

    val addedMarks = English + Hindi + Maths + SST + Science

    return addedMarks
}

fun TotalMarks(): Int {

    var totalMarks = EnterData()
    return totalMarks
}

fun PercentageGot(): Float {

    var datacame = EnterData()
    val percentage = datacame / 5f

    println("your total Marks are $datacame & you got $percentage % \n ThankYou! :) " )
    return percentage
}


