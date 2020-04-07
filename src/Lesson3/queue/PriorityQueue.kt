package Lesson3.queue

/*
* Данные, которые находятся в приоритетной очереди, упорядочены по ключу.
* В начале очереди находится элемент, у которого ключ имеет минимальное значение —
*  иначе говоря, наивысший приоритет. Когда происходит вставка нового элемента,
* он занимает позицию согласно своему ключу, чтобы не нарушить сортировку.
* Массив элементов Int сортируется по убыванию !!!
* */

class PriorityQueue (i: Int){

    private var maxSize: Int
    private var queueArray: IntArray
    private var items: Int = 0

    init {
        maxSize = i
        queueArray = IntArray(maxSize)
        items = 0
    }

    fun insert(item: Int) {
        var i: Int
        if (items == 0)
            queueArray[items++] = item
        else {
            i = items - 1
            while (i >= 0) {
                if (item > queueArray[i])
                    queueArray[i + 1] = queueArray[i]
                else
                    break
                i--
            }
            queueArray[i + 1] = item // Вставка элемента
            items++
        }
        println("insert() element = $item items = $items")
    }

    //удаление слева - то есть начиная с самого маленького числа
    fun remove(): Int {
        return queueArray[--items]
    }

    fun peek(): Long {
        return queueArray[items - 1].toLong()
    }

    fun isEmpty(): Boolean {
        return items == 0
    }

    fun isFull(): Boolean {
        return items == maxSize
    }
}

