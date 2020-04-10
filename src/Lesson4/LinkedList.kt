package Lesson4

class LinkedList<T>() {

    var first:Link<T>?

   init {
       first = null
   }

    fun isEmpty():Boolean{
        return first==null
    }

    fun insert(link:T){
        val l = Link(link)
        l.next = first
        first = l
    }

    fun delete():Link<T>?{
        val tmp:Link<T>? = first
        first = first?.next
        return tmp
    }

    fun display(){
        var current:Link<T>? = first
        while (current!=null){
            System.out.println(current.link)
            current = current.next
        }
    }

//    fun display() {
//        var current: Link<T>? = first
//        while (current != null) {
//            System.out.println(current.link)
//            current = current.next
//        }
//    }

    fun find(searchNode:T):T?{
    var findNode = Link(searchNode)
        var current = first
        while (current!=null){
            if (current.link!!.equals(findNode.link)){
                return findNode.link
            }
            current = current.next
        }
        return null
    }

}