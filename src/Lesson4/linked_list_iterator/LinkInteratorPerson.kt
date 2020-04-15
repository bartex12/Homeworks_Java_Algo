package Lesson4.linked_list_iterator

class LinkInteratorPerson(private val list: LinkedListPerson) {
    var current: LinkPerson? = null
        private set
    private var previous: LinkPerson? = null

    init {
        this.reset()
    }

    fun reset() {
        current = list.first
        previous = null
    }

    fun atEnd(): Boolean {
        return current!!.next == null
    }

    fun nextLink() {
        previous = current
        current = current!!.next
    }

    fun insertAfter(name: String, line: Int) {
        val newLink = LinkPerson(name, line)
        if (list.isEmpty) {
            list.first = newLink
            current = newLink
        } else {
            newLink.next = current!!.next
            current!!.next = newLink
            nextLink()
        }
    }

    fun insertBefore(name: String, line: Int) {
        val newLink = LinkPerson(name, line)
        if (previous == null) {
            newLink.next = list.first
            list.first =newLink
            reset()
        } else {
            newLink.next = previous!!.next
            previous!!.next = newLink
            current = newLink
        }
    }

    fun deleteCurrent(): String {
        val name = current!!.name
        if (previous == null) {
            list.first =current!!.next
            reset()
        } else {
            previous!!.next = current!!.next
            if (atEnd()) {
                reset()
            } else {
                current = current!!.next
            }
        }
        return name
    }

}