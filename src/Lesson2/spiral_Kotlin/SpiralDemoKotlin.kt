package Lesson2.spiral_Kotlin

fun main() {

    // Всё работает для матрицы любого размера
println("  /////////////////////////////////////")
println(" /// Заполнение матрицы по спирали ///")
println("/////////////////////////////////////")

    val lines = 10          //количество строк
    val columns = 10        //количество столбцов

    var matrix: Array<IntArray> = Array(lines, {IntArray(columns)})
    matrix = spiral(matrix)
    showMatrix(matrix)
}

fun spiral(arr:Array<IntArray>):Array<IntArray>{

    //************* подготовка ****************
    var res = arr       //переписываем в изменяемую переменную
    var k = 1           // значение первого элемента
    val y = res.size   //количество строк
    var x = 0          //количество столбцов
    if (y > 0){         //если матрица не соответствует - сообщаем об этом
        x = res[0].size
        if (x < 1){
            showMessage()
            return res
        }
    }else {
        showMessage()
        return res
    }

    var aa: Array<IntArray> = Array(x,{IntArray(y)})   //матрица с размерами для обработки поворота
    var min = if(y <= x) y else x                       // определение меньшего размера матрицы
    if (min == 2){
        min = min-1
    }else if (min > 2){
        min = min-2
    }

    //************* вычисления ****************
    var ii = 0
    while (ii < min) {
        for (i in 0..3) {
            if (i % 2 == 0) {                  //еcли 0 или 2,
                k = fill(k, res[ii])         // то заполняем строку массива res
                aa = turnToLeft(res)         //поворот на 90 градусов
            } else {                         //еcли 1 или 3,
                k = fill(k, aa[ii])        //то заполняем строку массива aa
                res = turnToLeft(aa)         //поворот на 90 градусов
            }
        }
        ii++
    }
    return res
}

//заполнение строки матрицы
fun fill(k:Int, ints:IntArray):Int{
    var k = k                  //k- не изменяемая, перписываем её в var с тем же именем
    for (i in ints.indices){
        if (ints[i] == 0){
            ints[i] = k
            k++
        }
    }
    return k
}

//поворот влево на 90 градусов
fun turnToLeft(arr:Array<IntArray>):Array<IntArray>{
    val result = Array(arr[0].size,{IntArray(arr.size)})
    for (row in 0 until arr.size){
        for(cell in 0 until arr[row].size){
            result[arr[row].size-1-cell][row] = arr[row][cell]
        }
    }
    return result
}

//показать матрицу
private fun showMatrix(arr: Array<IntArray>) {
    for (row in arr) {
        for (cell in row) {
           print("$cell\t")
        }
        println()
    }
}

//показать сообщение
private fun showMessage() {
    println("Минимальный размер матрицы должен быть 1х1\n" +
            "Желательно - не меньше, чем 2х2")
}