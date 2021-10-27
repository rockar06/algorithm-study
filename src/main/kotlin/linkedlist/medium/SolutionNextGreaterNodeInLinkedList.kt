package linkedlist.medium

import linkedlist.common.ListNode

// https://leetcode.com/problems/next-greater-node-in-linked-list/
object SolutionNextGreaterNodeInLinkedList {
    fun nextLargerNodes(head: ListNode?): IntArray {
        var counter = 0
        var temp = head
        while (temp != null) {
            counter++
            temp = temp.next
        }
        return IntArray(0)
    }

    private fun getSizeOfNode(head: ListNode?): Int {
        var counter = 0
        var temp = head
        while (temp != null) {
            counter++
            temp = temp.next
        }
        return counter
    }
}