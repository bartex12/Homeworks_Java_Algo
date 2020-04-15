package Lesson5

fun main(){
    println("2 в степени 8")
    println(degreeRecourse(2, 8))
    println("3 в степени 3")
    println(degreeRecourse(3, 3))
    println("12 в степени 0")
    println(degreeRecourse(12, 0))
    println("0 в степени 15")
    println(degreeRecourse(0, 15))
    println("5 в степени -2")
    println(degreeRecourse(5, -2))
}

//возведение в целую неотрицательную степень неотрицательных чисел
fun degreeRecourse(number: Int, degree:Int):Int{
    if (degree == 1) {                                      //базовый случай
        return number
    }else if (degree == 0){                                 //базовый случай
            return 1
    } else if (number == 0){                                //базовый случай
        return 0
    } else if ((degree<0||number<0)){                        //исключение
        println("Число и степень должны быть >= 0")
        return -1
    }else                                                   //рекурсивный случай
        return if (degree%2 ==0) degreeRecourse(number*number, degree/2)
        else number*degreeRecourse(number*number, degree/2)
    }
