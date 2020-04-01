package Lesson2.arraybig_Kotlin


fun main(){

        val arrBig = 1000000
        val arrMiddle = 100000
        val arrSmall = 20

        //Заполнение массива без сортировки, поиск, удаление
        initArrayWithoutSort(arrBig)
        //Заполнение массива  с сортировкой при вставке элемента
        // у меня 100 000 элементов заполняются примерно 3 сек
        initArrayWithSortByInsert(arrMiddle)
        println()

        //быстрая сортировка - (у меня 100 000 элементов за 0,02 сек)
        initArrayWith_QuickSort(arrMiddle)
        //сортировка выбором - (у меня 100 000 элементов за 7 сек)
        initArrayWith_SelectSort(arrMiddle)
        //пузырьковая сортировка - (у меня 100 000 элементов за 27 сек)
        initArrayWith_BubbleSort(arrMiddle)


}

private fun initArrayWith_BubbleSort(arrSize: Int) {
    val myArrSortBubble = MyArrBigKotlin(arrSize)
    myArrSortBubble.initArray()
    println()
    println("Пузырьковая сортировка  массива на 100 000 элементов. Ждите...")
    val timeRunSort = System.currentTimeMillis()
    myArrSortBubble.sortBubble()
    println("Время пузырьковой сортировки  массива на 100 000 элементов = " +
            (System.currentTimeMillis() - timeRunSort) + " mcek")
}

private fun initArrayWith_SelectSort(arrSize: Int) {
    println()
    val myArrSortSelect = MyArrBigKotlin(arrSize)
    myArrSortSelect.initArray()
    println("Сортировка выбором  массива на 100 000 элементов. Ждите...")
    val timeRunSortSel = System.currentTimeMillis()
    myArrSortSelect.sortSelect()
    println("Время  сортировки  массива выбором на 100 000 элементов = " +
            (System.currentTimeMillis() - timeRunSortSel) + " mcek")
}

private fun initArrayWith_QuickSort(arrSize: Int) {
    val myArrSortQuick = MyArrBigKotlin(arrSize)
    myArrSortQuick.initArray()
    println("Быстрая сортировка  массива на 100 000 элементов. Ждите...")
    val timeRunSortQuick = System.currentTimeMillis()
    myArrSortQuick.quickSort(myArrSortQuick.arr, 0, myArrSortQuick.sizeArr - 1)
    println("Время  быстрой сортировки  массива на 100 000 элементов = " +
            (System.currentTimeMillis() - timeRunSortQuick) + " mcek")
}

private fun initArrayWithoutSort(arrSize: Int) {

    val myArrBigKotlin = MyArrBigKotlin(arrSize)
    myArrBigKotlin.initArray()
    myArrBigKotlin.reportShort()
    //myArrBigKotlin.reportFull()

    println()
    println("Поиск элемента перебором в несортированном массиве")
    myArrBigKotlin.findSimple(15)

    println()
    println("Удаление элемента ")
    myArrBigKotlin.delete(12)
    myArrBigKotlin.delete(55555)
    myArrBigKotlin.reportShort()
    //myArrBigKotlin.reportFull()
}

private fun initArrayWithSortByInsert(arrSize: Int){
    println()
    val myArrSort = MyArrBigKotlin(arrSize)
    println("Заполнение массива  с сортировкой. Ждите...")
    val timeRun = System.currentTimeMillis()
    myArrSort.initArrayWithSorting()
    println("Время заполнения  массива  с сортировкой = " +
            (System.currentTimeMillis() - timeRun) + " mcek")
    myArrSort.reportShort()
    //myArrSort.reportFull()
    //если рядом стоят два одинаковых элемента, полученный индекс у методов findSimple и findBinary
    // может отличаться, поскольку получаем индекс первого найденного элемента
    myArrSort.findSimple(123)
    myArrSort.findBinary(123)
}
