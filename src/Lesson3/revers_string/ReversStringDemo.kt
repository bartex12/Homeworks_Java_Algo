package Lesson3.revers_string

import Lesson3.stack.StackBracket


fun main(){

    var input = "На дворе трава, на траве - дрова"
    println(input)
    reverseString(input)

    println()
    input = "А роза упала на лапу Азора"
    println(input)
    reverseString(input)

}

fun reverseString(input:String){
    val size = input.length
    val st = StackBracket(size)

    for (i in input.indices){
        val ch = input[i]
        st.push(ch)
    }

    var res = ""
    for (i in input){
      val cha:Char =  st.pop()
        res +=cha
    }

    println(res)
}