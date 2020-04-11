package Lesson4

class LinkedList<T>() {

    var first:Link<T>?

   init {
       first = null
   }

    fun isEmpty():Boolean{
        return first==null
    }

    //сначала создаём объект со значением link, который будет вставлен в начало списка
    //затем передаём  созданному  объекту ссылку на предыдущий, эта ссылка сохранялась в first
    //после чего запоминаем ссылку на созданный объект в поле first
    fun insert(link:T){
        val l = Link(link)  //создаём новый элемент - объект типа T со значением link
        l.next = first      //для нового элемента пишем ссылку на предыдущий- она ранее записана в first
        first = l           //переписываем first: теперь Link<T> l - первый элемент списка
    }

    //метод должен вернуть удалённый объект, удаляем с начала списка
    // поэтому мы первый (последний вставленный) объект списка  сначала запоминаем в temp
    //а затем переписываем ссылку first удалённого объекта на first следующего
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

    fun find(searchNode:T):Link<T>?{
    var findNode = Link(searchNode)
        var current = first
        while (current!=null){
            if (current.link!!.equals(findNode.link)){
                return findNode
            }
            current = current.next
        }
        return null
    }

}