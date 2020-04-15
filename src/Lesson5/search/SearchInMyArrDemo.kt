package Lesson5.search

    // делаем массив отсортированным при вставке элементов, ищем элементы с выводом индекса
    //если элемент не найден, выбрасываем исключение, в котором выводим сообщение

    fun main(){
        val arr:IntArray = intArrayOf(7,1,10,6,4,5,3,0,8,9,12,11,2)

        val myArr = MyArr(arr.size)
        for (item in arr.indices){
            myArr.insert(arr[item])
        }

        println("Выводим исходный массив")
        myArr.display()

        val search1 = 4
        val search2 = 44
        var search = 0
        try {
            search = search1
            println("$search имеет индекс = ${myArr.binaryFind(search)}")
            search = search2
            println("$search имеет индекс = ${myArr.binaryFind(search)}")
        }catch (e:MyNoSearchException){
            println(e.message)
        }

    }
