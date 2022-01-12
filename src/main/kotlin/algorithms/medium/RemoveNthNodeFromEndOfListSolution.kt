package algorithms.medium

import algorithms.common.ListNode

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class RemoveNthNodeFromEndOfListSolution {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var nodePosition = 0
        var tempHead = head
        while (tempHead != null) {
            tempHead = tempHead.next
            nodePosition++
        }
        if (nodePosition == 1) return null
        nodePosition -= n
        var counter = 1
        tempHead = head
        if (nodePosition == 0) {
            tempHead = tempHead?.next
            return tempHead
        } else {
            while (counter < nodePosition) {
                tempHead = tempHead?.next
                counter++
            }
            tempHead?.next = tempHead?.next?.next
        }
        return head
    }
}