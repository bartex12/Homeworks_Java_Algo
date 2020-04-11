package Lesson4

class Node<Item> {
    var value: Item
    var next: Node<*>? = null
    var previous: Node<*>? = null

    constructor(value: Item) {
        this.value = value
    }

    constructor(value: Item, next: Node<*>) {
        this.value = value
        this.next = next
    }
}