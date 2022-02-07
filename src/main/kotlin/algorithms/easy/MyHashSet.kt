package algorithms.easy

import algorithms.common.ListNode

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