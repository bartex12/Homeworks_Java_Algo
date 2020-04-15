package Lesson5

import java.util.ArrayList

/*
* расчёт задачи о рюкзаке через рекурсию
* */
object BackPackDemo {

    private var arr = intArrayOf(3, 4, 5, 8, 12, 15)
    private var arr2 = intArrayOf(15, 12, 8, 5, 4, 3)

    @JvmStatic
    fun main(args: Array<String>) {

        displeyList(backpack(32, arr, 0))
        displeyList(backpack(32, arr2, 0))
        displeyList(backpack(12, arr, 0))
        displeyList(backpack(12, arr2, 0))

    }

    //метод расчёта задачи о рюкзаке через рекурсию
    private fun backpack(target: Int, array: IntArray, startItem: Int): ArrayList<Int> {

        for (i in startItem until array.size) {
            if (startItem == array.size - 1) {
                return ArrayList()
            } else if (array[i] > target) {
                continue
            } else if (array[i] == target) {
                val list = ArrayList<Int>()
                list.add(array[i])
                return list
            }
            //хитрость в том, что в рекурсию уходим внури цикла с target = target-array[i]
            //и элемента, следующего за array[i]
            val result = backpack(target - array[i], array, i + 1)
            if (!result.isEmpty()) {
                result.add(array[i])
                return result
            }
        }
        return ArrayList()
    }

    //вывод результата
    private fun displeyList(result: ArrayList<Int>) {
        for (res in result) {
            print("$res ")
        }
        println()
    }
}




