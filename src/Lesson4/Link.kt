package Lesson4

data class Link<T>(var link:T) {
    var next:Link<T>? = null
}