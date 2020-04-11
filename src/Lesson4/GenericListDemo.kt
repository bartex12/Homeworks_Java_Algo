package Lesson4

fun main(){

    val list:LinkedList<String> = LinkedList()
    list.insert("Барсик1")
    list.insert("Барсик2")
    list.insert("Барсик3")

    println(list.find("Барсик3"))// возвращаемый тип не T, а Link<T>
    list.delete()                           //удаляем Барсик3
    println(list.find("Барсик3"))//ищем то, чего уже нет

    //***********

    println()
    val list2:LinkedList<Int> = LinkedList()
    list2.insert(1)
    list2.insert(2)
    list2.insert(3)

    println(list2.find(3)) // возвращаемый тип не T, а Link<T>
    list2.delete()                   //удаляем 3
    println(list2.find(3)) //ищем то, чего уже нет

}