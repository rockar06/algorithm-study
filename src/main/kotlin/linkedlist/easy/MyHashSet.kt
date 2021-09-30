package linkedlist.easy

import linkedlist.common.ListNode

fun main() {
    val myHashSet = MyHashSet()
    myHashSet.add(58)
    myHashSet.contains(0)
    myHashSet.add(14)
    myHashSet.contains(58)
    myHashSet.remove(91)
    myHashSet.add(6)
    myHashSet.contains(58)
    myHashSet.add(66)
    myHashSet.add(51)
    myHashSet.add(16)
    myHashSet.add(40)
    myHashSet.add(52)
    myHashSet.add(48)
    myHashSet.contains(40)
    myHashSet.add(42)
    myHashSet.add(85)
    myHashSet.add(36)
    myHashSet.contains(16)
    myHashSet.remove(0)
    myHashSet.contains(43)
    myHashSet.contains(6)
    myHashSet.add(3)
    myHashSet.remove(25)
    myHashSet.add(99)
    myHashSet.remove(66)
    myHashSet.add(60)
    myHashSet.remove(58)
    myHashSet.add(97)
    myHashSet.contains(3)
}

class MyHashSet() {

    /** Initialize your data structure here. */
    private var rootNode: ListNode? = null

    fun add(key: Int) {
        rootNode?.let {
            insertNewNode(key, it)
        } ?: run {
            rootNode = ListNode(key)
        }
    }

    private fun insertNewNode(key: Int, head: ListNode) {
        when {
            head.value == key -> {
                return
            }
            head.next != null -> {
                insertNewNode(key, head.next!!)
            }
            else -> {
                head.next = ListNode(key)
            }
        }
    }

    fun remove(key: Int) {
        rootNode?.let {
            rootNode = removeExistingNode(key, it)
        }
    }

    private fun removeExistingNode(key: Int, head: ListNode?): ListNode? {
        return head?.let {
            when (head.value) {
                key -> {
                    head.next?.let {
                        return ListNode(it.value).apply {
                            next = it.next
                        }
                    }
                }
                else -> {
                    ListNode(head.value).apply {
                        next = removeExistingNode(key, head.next)
                    }
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int): Boolean {
        return rootNode?.let {
            searchForKey(key, it)
        } ?: false
    }

    private fun searchForKey(key: Int, head: ListNode): Boolean {
        return head.next?.let {
            when (head.value) {
                key -> true
                else -> searchForKey(key, head.next!!)
            }
        } ?: false
    }
}