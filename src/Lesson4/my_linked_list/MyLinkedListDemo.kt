package Lesson4.my_linked_list

fun main(){
        //пишем 5 человек
        println()
        val mll2: MyLinkedList<People> = MyLinkedList()
        mll2.insertFirst(People("Bob1", 21))
        mll2.insertFirst(People("Bob2", 22))
        mll2.insertFirst(People("Bob3", 23))
        mll2.insertFirst(People("Bob4", 24))
        mll2.insertFirst(People("Bob5", 25))
        System.out.println(mll2)

        //удаляем первого и последнего
        println()
        println(mll2.removeFirst())
        println(mll2)
        println()
        println(mll2.removeLast())
        println(mll2)

        //удаляем объект, если есть
        println()
        println(mll2.remove(People("Bob3", 23))) //такой есть
        println(mll2)
        println()
        println(mll2.remove(People("Bob33", 23))) //такого уже нет
        println(mll2)
    }
