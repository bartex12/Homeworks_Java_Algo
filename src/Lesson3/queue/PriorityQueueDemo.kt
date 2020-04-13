package Lesson3.queue


fun  main(){
    //Массив элементов Int сортируется по убыванию !!!
    val q = PriorityQueue(5)
    q.insert(30)
    q.insert(50)
    q.insert(10)
    q.insert(40)
    q.insert(20)

    println()
    while (!q.isEmpty()) {
        val item = q.remove()   //удаление идёт слева - то есть начиная с самого маленького числа
        print("$item ")
    }
    println("")
}