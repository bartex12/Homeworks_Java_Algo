package Lesson6

import java.util.*


fun main(){

    val numberOfTrees = 20
    val heightLeft = IntArray(numberOfTrees)
    val heightRight = IntArray(numberOfTrees)

    val random = Random()
    for (n in 0 until numberOfTrees) {
        val myMap = MyTreeMap<Int, Int>()
        println()
        println("Дерево № ${n + 1}")
        println("--------------------------")
        println("Порядок получения ключей")
        for (i in 1..63) {
            var key: Int
            val value: Int
            key = random.nextInt(100)
            if (random.nextInt(2) % 2 == 0) {
                key = -key
            }
            value = i
            myMap.put(key, value)
            print("$key->$value ")
            if (myMap.getHeight() == 6) {
                break
            }
        }
        println()
        println("Обход дерева")
        System.out.println(myMap)
        System.out.println("Количество элементов = ${myMap.size()} ")
        System.out.println("Всего уровней = ${myMap.getHeight()}")
        heightLeft[n] = myMap.heightLeft()
        println("Всего уровней слева от корня = ${heightLeft[n]}")
        heightRight[n] = myMap.heightRight()
        println("Всего уровней справа от корня = ${heightRight[n]}")
    }

    var noBalance = 0
    for (i in 0 until numberOfTrees) {
        if (heightLeft[i] - heightRight[i] > 1 || heightLeft[i] - heightRight[i] < -1) {
            noBalance++
        }
    }
    val part = noBalance.toDouble() / numberOfTrees.toDouble()
    println()
    println("****************************************")
    println("Несбалансированных деревьев построено ${(part*100).toInt()} %")
    }
