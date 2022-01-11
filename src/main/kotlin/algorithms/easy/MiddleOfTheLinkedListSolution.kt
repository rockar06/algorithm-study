package algorithms.easy

import algorithms.common.ListNode

class MiddleOfTheLinkedListSolution {
    fun middleNode(head: ListNode?): ListNode? {
        var nodeCounter = 0
        var tempHead = head
        var resultNode = head
        while (tempHead != null) {
            tempHead = tempHead.next
            nodeCounter++
        }
        nodeCounter /= 2
        for (index in 0 until nodeCounter) {
            resultNode = resultNode?.next
        }
        return resultNode
    }
}