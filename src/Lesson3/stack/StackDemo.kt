package Lesson3.stack


fun main(){
    val stack = Stack(5)
    if (!stack.isFull()){
        stack.push(1)
        stack.push(2)
        stack.push(3)
    }else{
        println(" Стэк переполнен ")
    }

    //смотрим верхний элемент
        if (!stack.isEmpty()){
            println(" Верхний элемент ${stack.peek()} ")
        }else{
            println(" Стэк пуст ")
        }


    stack.push(40)
    stack.push(50)
    if (!stack.isFull()){
        stack.push(60)
    }else{
        println(" Стэк переполнен ")
    }
    println(" Верхний элемент ${stack.peek()} ")
}