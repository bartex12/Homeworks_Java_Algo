package Lesson4.my_linked_list

import java.util.*

class People(val name: String, val age: Int) {

    override fun hashCode(): Int {
        var hash = 5
        hash = 53 * hash + Objects.hashCode(this.name)
        hash = 53 * hash + this.age
        return hash
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) {
            return true
        }
        if (obj == null) {
            return false
        }
        if (javaClass != obj.javaClass) {
            return false
        }
        val other = obj as People?
        if (this.age != other!!.age) {
            return false
        }
        return if (this.name != other.name) {
            false
        } else true
    }

    override fun toString(): String {
        return "Name: " + this.name + ", line: " + this.age
    }
}