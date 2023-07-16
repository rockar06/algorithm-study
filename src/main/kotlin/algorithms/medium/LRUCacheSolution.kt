package algorithms.medium

class LRUCache(private val capacity: Int): LinkedHashMap<Int, Int>(5, 0.75f, true) {

    override fun get(key: Int): Int {
        return getOrDefault(key, -1)
    }

    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
        return size > capacity
    }
}

/*
class LRUCache(private val capacity: Int) {

    private val nodeMapper = hashMapOf<Int, DoubleIntListNode>()
    private val head = DoubleIntListNode(-1, -1)
    private val tail = DoubleIntListNode(-1, -1)

    init {
        head.next = tail
        tail.previous = head
    }

    fun get(key: Int): Int {
        val node = nodeMapper[key] ?: return -1

        remove(node)
        add(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        nodeMapper[key]?.let {
            remove(it)
        }

        val newNodeToInsert = DoubleIntListNode(key, value)
        nodeMapper[key] = newNodeToInsert
        add(newNodeToInsert)

        if (nodeMapper.size > capacity) {
            val nodeToDelete = head.next ?: return
            remove(nodeToDelete)
            nodeMapper.remove(nodeToDelete.key)
        }
    }

    private fun remove(nodeToRemove: DoubleIntListNode) {
        nodeToRemove.previous?.next = nodeToRemove.next
        nodeToRemove.next?.previous = nodeToRemove.previous
    }

    private fun add(nodeToAdd: DoubleIntListNode) {
        val previousEnd = tail.previous
        previousEnd?.next = nodeToAdd
        nodeToAdd.previous = previousEnd
        nodeToAdd.next = tail
        tail.previous = nodeToAdd
    }

    class DoubleIntListNode(val key: Int, var value: Int) {
        var next: DoubleIntListNode? = null
        var previous: DoubleIntListNode? = null
    }
}*/
