package Lesson3.deq

fun main(){
    val dequeue = Deq(10) //создаём очередь на 10 элементов

    //вставка справа как в очереди
    dequeue.insertRight(1)
    dequeue.insertRight(2)
    dequeue.insertRight(3)
    dequeue.insertRight(4)
    dequeue.insertRight(5)
    dequeue.insertRight(6)
    dequeue.display()

    //удаление слева - как в очереди
    println()
    dequeue.removeLeft()  // удалён элемент 1 - он был первым в очереди
    dequeue.removeLeft()  // удалён элемент 2
    dequeue.removeRight()// удалён элемент 6
    //удаление из очереди с проверкой
    if (!dequeue.isEmpty()){
        dequeue.removeRight()  // удалён элемент 5
    }else{
        println("Очередь пуста")
    }
    dequeue.display()  //массив тот же но указатели front и rear изменились

    println()
    dequeue.insertLeft(7)
    dequeue.insertLeft(8)
    dequeue.insertLeft(9)
    dequeue.display()

    println()
    //вставка элемента с проверкой
    var i = 10
    while (!dequeue.isFull()){
        dequeue.insertRight(i)
        i++
    }
    println("Очередь полна. Размер очереди = ${dequeue.size()} ")
    dequeue.display()

    println()
    //удаление из очереди с проверкой
    while (!dequeue.isEmpty()){
        dequeue.removeLeft()
    }
    //очередь пуста, но массив заполнен - на пустоту очереди указывают маркеры начала и конца очереди
    // front и rear из класса Queue
    println("Очередь пуста")
    dequeue.display()
}