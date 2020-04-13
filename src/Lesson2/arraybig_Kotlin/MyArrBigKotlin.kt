package Lesson2.arraybig_Kotlin

import java.util.*


class MyArrBigKotlin(var sizeArr:Int) {

    var arr:IntArray

    init {
        arr = IntArray(sizeArr)
        this.sizeArr = 0
    }

    //заполнение массива случайными числами без сортировки
    fun initArray(){
        val length = arr.size
        for (i in 0 until length ){
            insertElement(Random().nextInt(length))
        }
    }

    //вставка элемента  в конец массива
    fun insertElement(value:Int){
        arr[sizeArr] = value
        sizeArr++
    }

    //заполнение массива случайными числами с сортировкой
    fun initArrayWithSorting(){
        val length = arr.size
        for (i in 0 until length ){
            insertElementWithSortingUp(Random().nextInt(length))
        }
    }

    //вставка элемента  с сортировкой от меньшего к большему
    private fun insertElementWithSortingUp(value: Int) {
        var i = 0
        while (i < sizeArr){
            if (arr[i] > value){
                break
            }
            i++
        }
        for (n in sizeArr downTo i + 1) {
            arr[n] = arr[n - 1]
        }
        arr[i] = value
        sizeArr++
    }

    fun reportShort(){
        println("Элементов в массиве: $sizeArr")
    }

    //вывод данных для небольшого массива
    fun reportFull(){
        println("Элементов в массиве: $sizeArr")
        for (i in 0 until sizeArr){
            print("${arr[i]} ")
        }
        println()
    }

    //поиск перебором элементов массива
    fun findSimple(value:Int){
        var i = 0
        while (i<sizeArr){
            if (arr[i] == value){
                break
            }
            i++
        }

        if (i == sizeArr){
            println("Поиск выбором. Элемент $value не обнаружен.")
        }else{
            println("Поиск выбором. Элемент = $value находится по индексу = $i")
        }
    }

    //удаление элемента массива
    fun delete(value: Int) {
        var i = 0
        while (i < sizeArr) {
            if (arr[i] == value) {
                break
            }
            i++
        }
        if (i == sizeArr) {
            println("Элемент $value не обнаружен. Удаление невозможно")
        } else {
            for (n in i until sizeArr - 1) {
                arr[n] = arr[n + 1]
            }
            sizeArr--
            println("Удалён элемент = $value индекс = $i")
        }

    }

    // Бинарный поиск  элемента  в отсортированном  массиве
    fun findBinary(value: Int): Boolean {
        var low = 0
        var high = sizeArr - 1
        var middle: Int

        while (low <= high) {
            middle = (low + high) / 2
            if (arr[middle] == value) {
                println("Бинарный поиск. Элемент = $value находится по индексу = $middle")
                return true
            } else if (arr[middle] < value) {
                low = middle + 1
            } else {
                high = middle - 1
            }
        }
        println("Бинарный поиск. Элемент $value не обнаружен.")
        return false
    }

    fun quickSort(array: IntArray, low: Int, high: Int) {
        if (array.size == 0)
            return //завершить выполнение если длина массива равна 0
        if (low >= high)
            return //завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        val middle = low + (high - low) / 2
        val opora = array[middle]


        // разделить на подмассивы, который больше и меньше опорного элемента
        var i = low
        var j = high
        while (i <= j) {
            while (array[i] < opora) {
                i++
            }
            while (array[j] > opora) {
                j--
            }
            if (i <= j) {//меняем местами
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
                i++
                j--
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j)
        if (high > i)
            quickSort(array, i, high)
    }

    //сортировка выбором
    fun sortSelect() {
        var low: Int
        var high: Int
        var mark: Int
        high = 0
        while (high < sizeArr) {
            mark = high
            low = high + 1
            while (low < sizeArr) {
                if (arr[low] < arr[mark]) {
                    mark = low
                }
                low++
            }
            exchange(high, mark)
            high++
        }
    }

    //обмен элементами
    private fun exchange(a: Int, b: Int) {
        val c = arr[a]
        arr[a] = arr[b]
        arr[b] = c
    }

    //пузырьковая сортировка
    fun sortBubble() {
        var low: Int
        var high: Int
        high = sizeArr - 1
        while (high >= 1) {
            low = 0
            while (low < high) {
                if (arr[low] > arr[low + 1]) {
                    exchange(low, low + 1)
                }
                low++
            }
            high--
        }
    }
}

