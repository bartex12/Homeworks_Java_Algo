package Lesson4.linked_list_iterator


    fun  main(){
        val list = LinkedListPerson()
        val itr = LinkInteratorPerson(list)

        itr.insertAfter("Короновирус, однако", 1)
        itr.insertBefore("Тут и сказке конец", 2)
        itr.insertBefore("Сказка", 3)
        itr.insertAfter("Жили-были", 4)
        itr.insertAfter("Иван да Марья", 5)
        list.display()
    }