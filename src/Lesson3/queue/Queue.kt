package Lesson3.queue

/*
* в этой реализации есть косяк - когда размер очереди превышается, очередь начинает перезаписываться
* а front остаётся на старом месте и может так оказаться , что он будет указывать уже на вновь
* записанные значения, что будет неправильно, так как при последующем извлечении элемента из очереди
*  будет извлекаться не самый старый элемент
* поэтому обязательна при записи проверка - isFull
* */

class Queue(private var sizeArr:Int) {

    private val queue:IntArray        //массив целочисленный
    private var front:Int           // указатель начала очереди
    private var rear:Int            // указатель конца очереди
    private var items: Int          //текущий размер очереди

    init {
        queue = IntArray(sizeArr)
        front = 0
        rear = -1
        items = 0
    }

    fun display(){
        for (i in 0 until sizeArr ){
            print("${queue[i]} ")
        }
        println()
    }

    // очередь пустa?
    fun isEmpty():Boolean{
        return items == 0
    }

    //очередь полна?
    fun isFull():Boolean{
        return items == sizeArr
    }

    //размер очереди
    fun size(): Int {
        return items
    }

    //добавление
    fun insert(element:Int){
        if(rear ==sizeArr -1){
            rear = -1
        }
        queue[++rear] = element
        items++
        println("insert() element = $element rear = $rear front = $front")
    }

    //удаление
    fun remove(): Int {
        val temp = queue[front++]
        if (front == sizeArr){
            front = 0
        }
        items--
        println("remove() element = $temp  rear = $rear front = $front")
        return temp
    }

    //получение без удаления
    fun peek():Int{
        return queue[front]
    }
}