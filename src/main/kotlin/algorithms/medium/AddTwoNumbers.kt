package algorithms.medium

import algorithms.common.ListNode

// https://leetcode.com/problems/add-two-numbers/
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int = 0): ListNode? {
        if (l1 == null && l2 == null && carry != 0) return ListNode(1)
        if (l1 == null && l2 == null) return null
        val result = (l1?.value ?: 0) + (l2?.value ?: 0) + carry
        return if (result / 10 != 0) {
            ListNode(result % 10).apply {
                next = addTwoNumbers(l1?.next, l2?.next, 1)
            }
        } else {
            ListNode(result).apply {
                next = addTwoNumbers(l1?.next, l2?.next)
            }
        }
    }
}