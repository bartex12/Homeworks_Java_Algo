package Lesson4.linked_list_iterator

class LinkedListPerson {

    var first: LinkPerson? = null

    val iterator: LinkInteratorPerson
        get() = LinkInteratorPerson(this)

    val isEmpty: Boolean
        get() = first == null

    init {
        first = null

    }

    fun display() {
        var current = first
        while (current != null) {
            current.display()
            current = current.next
        }
    }

}