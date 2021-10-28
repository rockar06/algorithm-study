package algorithms.easy

import algorithms.common.ListNode
import algorithms.easy.SolutionRemoveLinkedListItems.removeElements

fun main() {
    val result = removeElements(linkedList, 6)
    result
}

object SolutionRemoveLinkedListItems {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var tempHead = head
        var filteredList: ListNode? = null
        var tail: ListNode? = null
        while (tempHead != null) {
            if (tempHead.value != `val`) {
                if (filteredList == null) {
                    filteredList = ListNode(tempHead.value)
                    tail = filteredList
                } else {
                    tail?.next = ListNode(tempHead.value)
                    tail = tail?.next
                }
            }
            tempHead = tempHead.next
        }
        return filteredList
    }
}

private val linkedList = ListNode(1).apply {
    next = ListNode(2).apply {
        next = ListNode(6).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(6)
                    }
                }
            }
        }
    }
}