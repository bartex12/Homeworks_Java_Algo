package Lesson4

fun main(){

    val list:LinkedList<String> = LinkedList()
    list.insert("Барсик1")
    list.insert("Барсик2")
    list.insert("Барсик3")

    println(list.find("Барсик3"))
    list.delete()  //удаляем Барсик3
    println(list.find("Барсик3"))

}