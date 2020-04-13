package Lesson3.stack

class StackBracket(var sizeArr:Int) {
    val stack:CharArray
    var top:Int

    init {
        stack = CharArray(sizeArr)
        top = -1
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
    fun push(element:Char){
        stack[++top] = element
    }

    //извлечение
    fun pop():Char{
        return stack[top--]
    }

    //получение без удаления
    fun peek():Char{
        return stack[top]
    }

}