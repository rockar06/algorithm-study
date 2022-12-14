package algorithms.medium

import algorithms.common.ListNode

// https://leetcode.com/problems/add-two-numbers/
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int = 0): ListNode? {
        if (l1 == null && l2 == null && carry > 0) return ListNode(carry)
        if (l1 == null && l2 == null) return null
        val result = (l1?.value ?: 0) + (l2?.value ?: 0) + carry
        return ListNode(result % 10).apply {
            next = addTwoNumbers(l1?.next, l2?.next, result / 10)
        }
    }

    /*fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var firstNumber = l1
        var secondNumber = l2
        var headResult: ListNode? = null
        var result: ListNode? = null
        var carry = 0


        while (firstNumber != null || secondNumber != null) {
            val sumOfNodes = (firstNumber?.value ?: 0) + (secondNumber?.value ?: 0) + carry
            carry = sumOfNodes / 10
            if (headResult == null) {
                headResult = ListNode(sumOfNodes % 10)
                result = headResult
            } else {
                val nextNode = ListNode(sumOfNodes % 10)
                headResult.next = nextNode
                headResult = nextNode
            }
            firstNumber = firstNumber?.next
            secondNumber = secondNumber?.next
        }

        if (carry > 0) {
            val carryValue = ListNode(carry)
            headResult?.next = carryValue
        }

        return result
    }*/
}