package algorithms.easy

import algorithms.common.ListNode

object SolutionReverseLinkedList {

    private var nodeHelper: ListNode? = null

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        nodeHelper = ListNode(head.value).apply {
            next = nodeHelper
        }

        return if (head.next != null) {
            reverseList(head.next)
        } else {
            nodeHelper
        }
    }

    fun reverseListIteration(head: ListNode?): ListNode? {
        var currentHead = head
        var tempNode: ListNode? = null
        while (currentHead != null) {
            tempNode = ListNode(currentHead.value).apply {
                next = tempNode
            }
            currentHead = currentHead.next
        }
        return tempNode
    }
}