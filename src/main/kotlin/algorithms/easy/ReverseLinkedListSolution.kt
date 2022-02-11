package algorithms.easy

import algorithms.common.ListNode

// https://leetcode.com/problems/reverse-linked-list/
class ReverseLinkedListSolution {

    fun reverseList(head: ListNode?): ListNode? {
        var result: ListNode? = null
        var temp = head
        while (temp != null) {
            if (result == null) {
                result = ListNode(temp.value)
            } else {
                ListNode(temp.value).apply {
                    next = result
                    result = this
                }
            }
            temp = temp.next
        }
        return result
    }
}