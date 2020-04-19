package Lesson6

class MyTreeMap<Key : Comparable<Key>, Value> {
    // ссылка на корневой элемент
    var root: Node? = null

    inner class Node(internal var key: Key, internal var value: Value) {
        internal var left: Node? = null
        internal var right: Node? = null

        internal var size: Int = 0

        init {
            size = 1
        }
    }
    fun isEmpty(): Boolean {
        return root == null
    }

    fun size(): Int {
        return size(root)
    }

    private fun size(node: Node?): Int {
        return node?.size ?: 0
    }

    private fun isKeyNotNull(key: Key?): Boolean {
        if (key == null) {
            throw IllegalArgumentException("key не должен быть null")
        }
        return true
    }

    operator fun get(key: Key): Value? {
        //
        return get(root, key)
    }

    private operator fun get(node: Node?, key: Key): Value? {
        isKeyNotNull(key)
        if (node == null) {
            return null
        }
        // если наш ключ совпал
        val cmp = key.compareTo(node.key)

        return if (cmp == 0) {
            node.value
        } else if (cmp < 0) {
            // идем на лево
            get(node.left, key)
        } else {
            // идем на право
            get(node.right, key)
        }
    }

    operator fun contains(key: Key): Boolean {
        //
        return get(root, key) != null
    }

    fun put(key: Key, value: Value?) {
        isKeyNotNull(key)
        if (value == null) {
            // delete(key);
            return
        }
        root = put(root, key, value)
    }

    private fun put(node: Node?, key: Key, value: Value): Node {
        // новый узел
        if (node == null) {
            return Node(key, value)
        }

        val cmp = key.compareTo(node.key)
        if (cmp == 0) {
            node.value = value
        } else if (cmp < 0) {
            node.left = put(node.left, key, value)
        } else {
            node.right = put(node.right, key, value)
        }

        // пересчитать размер узла
        node.size = size(node.left) + size(node.right) + 1
        //        System.out.println("node.key = "+ node.key+" node.value = "+ node.value+
        //                " node.size = "+ size(node.left) + size(node.right) + 1 +" node.size = " + node.size);
        return node
    }

    //**************************
    override fun toString(): String {
        return toString(root)
    }

    private fun toString(node: Node?): String {
        return if (node == null) {
            ""
        } else toString(node.left) + " " + node.key.toString() + " = " +
                node.value.toString() + " " + toString(node.right)

    }

    //***********************************
    fun getHeight(): Int {
        return getHeight(root)
    }

    fun heightLeft(): Int{
        return getHeight(root!!.left)
    }

    fun heightRight(): Int{
        return getHeight(root!!.right)
    }

    private fun getHeight(node: Node?): Int {
        if (node == null)
            return 0

        val h_l = getHeight(node.left)
        val h_r = getHeight(node.right)

        val res = if (h_l > h_r) h_l else h_r
        return res + 1

    }

    fun goInOrder() {
        inOrder(root)
    }

    private fun inOrder(localRoot: Node?) {
        if (localRoot != null) {
            inOrder(localRoot.left)
            print("${localRoot.key}")
            inOrder(localRoot.right)
        }
    }

    //**********************************

    fun minKey(): Key {
        //
        return min(root!!).key
    }

    // мы ищем наименьший узел в наборе узлов, больших исходного узла node
    private fun min(node: Node): Node {
        return if (node.left == null) {
            node
        } else min(node.left!!)
    }

    fun maxKey(): Key {
        return max(root!!).key
    }

    private fun max(node: Node): Node {
        return if (node.right == null) {
            node
        } else max(node.right!!)
    }

    private fun deleteMin(node: Node): Node? {
        if (node.left == null) {
            return node.right
        }
        node.left = deleteMin(node.left!!)
        node.size = size(node.left) + size(node.right) + 1
        return node
    }

    fun delete(key: Key) {
        isKeyNotNull(key)
        delete(root, key)
    }

    private fun delete(node: Node?, key: Key): Node? {
        var node: Node? = node
                ?: // если в узле ничего нет, возвращаем null
                return null
        val cmp = key.compareTo(node!!.key)       //cравниваем ключи
        if (cmp < 0) {
            node.left = delete(node.left, key)   //если ключ меньше ключа узла, вызываем рекурсивное
        } else if (cmp > 0) {                       //удаление левого узла
            node.right = delete(node.right, key)  //если ключ больше ключа узла, вызываем рекурсивное
        } else {                                    //удаление правого узла
            if (node.left == null) {    //а если равен, смотрим - есть ли потомки
                return node.right     // если нет левого потомка, возвращаем ссылку правого потомка
            }
            if (node.right == null) {// если нет правого потомка, возвращаем ссылку левого потомка
                return node.left
            }

            val temp = node       //если еть оба потомка, то запоминаем узел во временной переменной
            node = min(node.right!!) //мы ищем наименьший узел в наборе узлов, больших исходного узла node

            node.right = deleteMin(temp.right!!)
            node.left = temp.left
        }

        node.size = size(node.left) + size(node.right) + 1
        return node
    }

}