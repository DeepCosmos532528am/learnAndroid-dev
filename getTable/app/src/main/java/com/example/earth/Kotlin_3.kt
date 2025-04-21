package com.example.earth
// video no. Kotlin_7
//topics : for each loop , same with arr.indices , for each loop  to get index and value both,

fun main() {
    val arr = arrayOf(2, 3, 4, 5, 6, 7, 3, 2, 6, 24, 0)
var sum=4
    println(arr[2])

    // ways to access all tge array elements

    for (i in arr) {  // for loop can only be used at iterative methods
        println(i)

    //in it  println(i++ ) increment is not possible to do I observed till now...

    }// similarly in java
    /* for(int arya : arr_numbers) {
          System.out.println(arya++); //but  here increment in allowed in java at per array value
          System.out.println(arya);
      }
*/

    for (i in arr.indices) {  // this inbuilt arr.indices is not there in java so there traditional for loop is used to achieve same
        println(i)
    }


    for ((indices, value) in arr.withIndex()) {
        "lo bhai "
        print("index is $indices and the value is $value")
    }

    arr.forEach{  // for each loop is always applied on lists, like array in kotlin as well as in java's for each too for java
        println(it)
    }

    arr.forEachIndexed { index , value ->
        println("index is $index and the value is $value")
    }

    print(arr.size) // TO GET SIZE OF ARRAY\


    // fROM HERE LETS LOOK AT GIVING THE NULL VALUE MEANS PUTTING NULL IN OR VARIABLE DECLARING FIRST THEN INITIALIZING LATER IN JAVA TERMS ,ACTUALLY WHEN i DO declare only but not initialized it , then the value is by default get initialized with null value , but this thing do not happens in kotlin!
    // var means the value can be modify later after initialization
    //val means the value cannot be initialized later after declaration , it has now become constant

    //var a= null ,  not the valid way to do so
   var a:String? = null  // THIS LINE IS EQUIVALENT TO FIRST INITIALIZING THE VARIABLE IN JAVA ,
    println(a)

   a = sc.next()
   // var b = a.length // .length function is only to get the size of string value not the numeric or float pr boolean value ;) Understood h lekin haaye re meri aadat

    if( a == null)
println("No data fetched from the source!")
else println("Data fetched successfully, The size is : ${a.length} ! ")

    // other method other then if else using Elvis method below in this '?' means not null

    print( a?.length)  // this is saying , if the value of a  is not null then print it's length otherwise print null

    a?.let{
    println(a.length)


}

}
