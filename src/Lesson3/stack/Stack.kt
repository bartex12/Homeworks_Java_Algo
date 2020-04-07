package Lesson3.stack

class Stack(var sizeArr:Int) {

    val stack:IntArray
    var top:Int

    init {
        stack = IntArray(sizeArr)
        top = -1
    }

    fun display(){
        for (i in stack.indices ){
            print("${stack[i]} ")
        }
        println()
    }

    //стэк пуст?
    fun isEmpty():Boolean{
        return top == -1
    }

    //стэк полон?
    fun isFull():Boolean{
        return top == sizeArr-1
    }

    //добавление
    fun push(element:Int){
        stack[++top] = element
        display()
    }

    //извлечение
    fun pop():Int{
        val tmp = stack[top--]
        display()
        return tmp
    }

    //получение без удаления
    fun peek():Int{
        return stack[top]
    }
}