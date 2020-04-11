package Lesson4

class MyLinkedList<Item> {

    private var first: Node<*>? = null
    private var last: Node<*>? = null
    private var size = 0

    init {
        this.first = null
        this.last = null
    }

    fun isEmpty():Boolean{
        return first == null
    }

    fun size(): Int {
        return size
    }

    fun getFirst(): Item? {
        return if (isEmpty()) {
            null
        } else {
            first!!.value as Item?
        }
    }

    fun getLast(): Item? {
        return if (isEmpty()) {
            null
        } else last!!.value as Item?
    }

    fun insertFirst(item: Item) {
        val newNode = Node(item)
        newNode.next = first
        if (isEmpty()) {
            last = newNode
        } else {
            first!!.previous = newNode
        }
        first = newNode
        size++
    }

    fun insertLast(item: Item) {
        val newNode = Node(item)
        if (isEmpty()) {
            first = newNode
        } else {
            newNode.previous = last
            last!!.next = newNode
        }
        last = newNode
        size++
    }

    fun removeFirst(): Item? {
        if (isEmpty()) {
            return null
        }

        val oldFisrt = first
        first = first!!.next
        size--
        if (isEmpty()) {
            last = null
        } else {
            first!!.previous = null
        }
        return oldFisrt!!.value as Item?
    }

    fun removeLast(): Item? {
        if (isEmpty()) {
            return null
        }
        val oldLast = last
        if (last!!.previous != null) {
            last!!.previous!!.next = null
        } else {
            first = null
        }
        size--
        last = last!!.previous
        return oldLast!!.value as Item?
    }

    override fun toString(): String {
        var current: Node<*>? = first
        val sb = StringBuilder()
        while (current != null) {
            sb.append(current.value!!.toString() + ", ")
            current = current.next
        }
        return sb.toString()
    }

    fun indexOf(item: Item): Int {
        var current: Node<*>? = first
        var index = 0
        while (current != null) {
            if (current.value == item) {
                return index
            }
            current = current.next
            index++
        }
        return -1
    }

    fun insert(item: Item, index: Int) {
        var index = index
        if (index <= 0) {
            insertFirst(item)
            return
        }

        if (index > size) {
            index = size
        }

        var current: Node<*>? = first

        var i = 0
        while (i < index - 1) {
            current = current!!.next
            i++
        }

        val newNode = Node(item)
        newNode.next = current!!.next
        newNode.previous = current
        current.next = newNode
        newNode.next!!.previous = newNode
        size++
    }

    fun remove(item: Item): Boolean {
        if (isEmpty()) {
            return false
        }

        if (first!!.value == item) {
            removeFirst()
            return true
        }

        var current: Node<*>? = first
        while (current != null && current.value != item) {
            current = current.next
        }

        if (current == null) {
            return false
        }

        if (current === last) {
            removeLast()
            return true
        }

        current.next!!.previous = current.previous
        current.previous!!.next = current.next
        size--
        return true

    }

    operator fun contains(item: Item): Boolean {
        return indexOf(item) > -1
    }


//    internal inner class Node<Item> {
//        var value: Item? = null
//        var next: Node<*>? = null
//        var previous: Node<*>? = null
//
//        constructor(value: Item) {
//            this.value = value
//        }
//
//        constructor(value: Item, next: Node<*>) {
//            this.value = value
//            this.next = next
//        }
//    }

}
