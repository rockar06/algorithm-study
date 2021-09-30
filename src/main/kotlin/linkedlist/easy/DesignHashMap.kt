package linkedlist.easy

fun main() {
    val myHashMap = MyHashMap()
    myHashMap.put(1, 1)
    myHashMap.put(2, 2)
    myHashMap.put(3, 3)
    myHashMap.put(4, 4)
    myHashMap.put(5, 5)
    myHashMap.put(6, 6)
    myHashMap.get(1)
    myHashMap.get(7)
    myHashMap.remove(1)
    myHashMap.get(1)
}

private const val NO_KEY_FOUND = -1

class MyHashMap() {

    /** Initialize your data structure here. */
    private var rootNode: HashNode? = null

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        rootNode?.let {
            insertNewNode(it, key, value)
        } ?: run {
            rootNode = HashNode(key, value)
        }
    }

    private fun insertNewNode(head: HashNode, key: Int, value: Int) {
        when {
            head.key == key -> {
                // Replace the value
                head.value = value
            }
            head.next != null -> {
                insertNewNode(head.next!!, key, value)
            }
            else -> {
                head.next = HashNode(key, value)
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        return rootNode?.let {
            searchForKey(it, key)
        } ?: NO_KEY_FOUND
    }

    private fun searchForKey(head: HashNode, key: Int): Int {
        return when {
            head.key == key -> head.value
            head.next == null -> NO_KEY_FOUND
            else -> searchForKey(head.next!!, key)
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        rootNode?.let {
            rootNode = removeExistingKey(it, key)
        }
    }

    private fun removeExistingKey(head: HashNode?, key: Int): HashNode? {
        return head?.let {
            when (head.key) {
                key ->
                    head.next?.let {
                        return HashNode(it.key, it.value).apply {
                            next = it.next
                        }
                    }
                else -> {
                    HashNode(head.key, head.value).apply {
                        next = removeExistingKey(head.next, key)
                    }
                }
            }
        }
    }
}

data class HashNode(
    val key: Int,
    var value: Int
) {
    var next: HashNode? = null
}