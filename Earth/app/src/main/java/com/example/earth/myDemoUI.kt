package com.example.myDemoUI
// dekho Sachiin ek cheez samjo ki, yha pe tumhe class anhi dikh rahi seedhe functions ( Main fun and other func dikh rahe h . )
// aese case me hum ye pretend kar rahe h ki saare functions class ke andar dale h , taaki hum isse java ki tarah se samjh sake .

fun  main (){
    add( 3 , 4) // calling of add func , which is returning the Int type value
}
fun add( a: Int , b: Int ):Int {
    return a+b
}
fun add(a : Float , b: Float  ) : Float  {  // Method overloading is happening here...
    return a+b
}