package Lesson3.deq


/*
* Дек (deque) представляет собой двустороннюю очередь.
* И вставка, и удаление элементов могут производиться с обоих концов.
* Соответствующие методы могут называться insertLeft()/insertRight() и removeLeft()/removeRight().
* Если ограничиться только методами insertLeft() и removeLeft() (или их эквивалентами для правого конца),
*  дек работает как стек. Если же ограничиться методами insertLeft() и removeRight()
* (или противоположной парой), он работает как очередь. По гибкости деки превосходят и стеки, и очереди.
* */

class Deq(private var sizeArr:Int) {


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

    //добавление справа - с конца
    fun insertRight(element:Int){
        if(rear ==sizeArr -1){
            rear = -1
        }
        queue[++rear] = element
        items++
        println("insertRight() element = $element rear = $rear front = $front items = $items")
    }

    //удаление справа - с конца
    fun removeRight(): Int {
        val temp = queue[rear--]
        if(rear < 0){
            rear = sizeArr -1
        }
        items--
        println("removeRight() element = $temp  rear = $rear front = $front items = $items")
        return temp
    }

    //добавление слева - с начала
    fun insertLeft(element:Int){
        if(front == 0 ){
            front = sizeArr
        }
        queue[--front] = element
        items++
        println("insertRight() element = $element rear = $rear front = $front items = $items")
    }

    //удаление слева - с начала
    fun removeLeft(): Int {
        val temp = queue[front++]
        if (front == sizeArr){
            front = 0
        }
        items--
        println("removeLeft() element = $temp  rear = $rear front = $front items = $items")
        return temp
    }

    //получение без удаления
    fun peek():Int{
        return queue[front]
    }
}