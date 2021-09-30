package linkedlist.easy

import linkedlist.common.ListNode

object SolutionMiddleLinkedList {

    private var currentNodeCounter = 0
    private var middleNumber = 0
    private var middleCounter = 0
    private var nodeHelper: ListNode? = null

    fun middleNode(head: ListNode?): ListNode? {
        checkNodeCounter()
        checkValueNumber(head!!.value)
        if (currentNodeCounter == 0) {
            nodeHelper = head
        }
        currentNodeCounter++
        if (head.next != null) {
            middleNode(head.next)
        }
        middleNumber = currentNodeCounter / 2

        while (middleCounter < middleNumber) {
         middleCounter++
         nodeHelper = nodeHelper!!.next
        }
        return nodeHelper
    }

    private fun checkValueNumber(value: Int) {
        if (value !in 0..100) throw RuntimeException()
    }

    private fun checkNodeCounter() {
        if (currentNodeCounter > 100) throw IndexOutOfBoundsException()
    }
}