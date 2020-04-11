package Lesson4.generic_list

data class Link<T>(var link:T) {
    var next: Link<T>? = null
}