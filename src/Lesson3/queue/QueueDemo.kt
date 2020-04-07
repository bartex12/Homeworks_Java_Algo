package Lesson3.queue


fun main(){

    val queue = Queue(10) //создаём очередь на 10 элементов

    queue.insert(1)
    queue.insert(2)
    queue.insert(3)
    queue.insert(4)
    queue.insert(5)
    queue.display()

    println()
    queue.remove()  // удалён элемент 1 - он был первым в очереди
    queue.remove()  // удалён элемент 2
    queue.display()

    println()
    //вставка элемента с проверкой
    var i = 10
    while (!queue.isFull()){
        queue.insert(i)
        i++
    }
    println("Очередь полна. Размер очереди = ${queue.size()} ")
    queue.display()

    println()
    //удаление из очереди с проверкой
    while (!queue.isEmpty()){
        queue.remove()
    }
    //очередь пуста, но массив заполнен - на пустоту очереди указывают маркеры начала и конца очереди
    // front и rear из класса Queue
    println("Очередь пуста")
    queue.display()
}