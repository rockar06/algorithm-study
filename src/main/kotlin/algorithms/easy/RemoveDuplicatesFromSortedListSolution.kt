package algorithms.easy

import algorithms.common.ListNode

class RemoveDuplicatesFromSortedListSolution {
    fun deleteDuplicatesRecursive(head: ListNode?): ListNode? {
        return head?.let { currentNode ->
            currentNode.next?.let { nextNode ->
                if (currentNode.value != nextNode.value) {
                    ListNode(currentNode.value).apply {
                        next = deleteDuplicatesRecursive(nextNode)
                    }
                } else {
                    deleteDuplicatesRecursive(nextNode)
                }
            } ?: run {
                ListNode(currentNode.value)
            }
        }
    }

    fun deleteDuplicatesIterative(head: ListNode?): ListNode? {
        var current = head
        var filteredList: ListNode? = null
        var tail: ListNode? = null
        while (current != null) {
            if (filteredList == null) {
                filteredList = ListNode(current.value)
                tail = filteredList
            } else {
                if (tail!!.value != current.value) {
                    tail.next = ListNode(current.value)
                    tail = tail.next
                }
            }
            current = current.next
        }
        return filteredList
    }
}
