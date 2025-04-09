package com.example.earth

fun main(){
  // loop : hume yaar dekho for , while, do while, for each toh aata h lekin kucch loop h jo nahi aate h , jo ki kotlin specific h like repeat loop , indexed for loop , fast loops
    // for in nahi aata h
val a = 40
    val b = 28
     repeat( 10){number -> // hear after puting "->number" now "it" will not be used , as we have given the name "number" so instead of "it" "number" will be used , and this only is the purpose , behind putting this statement here
      //here  name could be anything  , after giving thsi statement "->number" it has now become invalid to use
         println(number)// it is used for current "repeat" scope like "this" is used for current class scope
         // and this starts from 0 by default and prints for upto n-1 value times the value is given
        // it is used to access given value : 10
          println("3 * ${number+1} = ${3 * (number+1)}")

     }

}