package Lesson4.linked_list_iterator

class LinkPerson(var name: String, var line: Int) {

    var next: LinkPerson? = null

    fun display() {
        println("Name: " + this.name + ", line: " + this.line)
    }

}