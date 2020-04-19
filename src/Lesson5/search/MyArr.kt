package Lesson5.search

class MyArr(size: Int) {
    private val arr: IntArray
    private var size: Int = 0

    init {
        this.size = 0
        this.arr = IntArray(size)
    }

    private fun recBinaryFind(searchKey: Int, low: Int, high: Int): Int {
        val curIn: Int
        curIn = (low + high) / 2
        return if (arr[curIn] == searchKey)
            curIn
        else if (low > high)
            throw MyNoSearchException("Для $searchKey ничего не найдено")
        else {
            if (arr[curIn] < searchKey)
                recBinaryFind(searchKey, curIn + 1, high)
            else
                recBinaryFind(searchKey, low, curIn - 1)
        }
    }

    fun binaryFind(search: Int): Int {
        return recBinaryFind(search, 0, size - 1)
    }

    fun display() {
        for (i in 0 until this.size) {
            print(this.arr[i].toString() + " ")
        }
        println()
    }

    fun insert(value: Int) {
        var i: Int
        i = 0
        while (i < this.size) {
            if (this.arr[i] > value) {
                break
            }
            i++
        }
        for (j in this.size downTo i + 1) {
            this.arr[j] = this.arr[j - 1]
        }
        this.arr[i] = value
        this.size++
    }
}