package Lesson4.my_linked_list

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