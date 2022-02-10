package algorithms.easy

import algorithms.common.ListNode

// https://leetcode.com/problems/merge-two-sorted-lists/
class MergeTwoSortedLists {

    /*fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        return if (l1 != null && l2 == null) {
            l1
        } else if (l1 == null && l2 != null) {
            l2
        } else if ((l1?.value ?: -1) < (l2?.value ?: -1)) {
            l1?.next = mergeTwoLists(l1?.next, l2)
            l1
        } else {
            l2?.next = mergeTwoLists(l1, l2?.next)
            l2
        }
    }*/

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 != null && l2 == null) {
            return l1
        } else if (l1 == null && l2 != null) {
            return l2
        }
        var result: ListNode? = null
        var resultHead = result
        var headL1 = l1
        var headL2 = l2
        while (headL1 != null && headL2 != null) {
            if (headL1.value < headL2.value) {
                if (result == null) {
                    result = ListNode(headL1.value)
                    resultHead = result
                } else {
                    resultHead?.next = ListNode(headL1.value)
                    resultHead = resultHead?.next
                }
                headL1 = headL1.next
            } else {
                if (result == null) {
                    result = ListNode(headL2.value)
                    resultHead = result
                } else {
                    resultHead?.next = ListNode(headL2.value)
                    resultHead = resultHead?.next
                }
                headL2 = headL2.next
            }
        }
        resultHead?.next = headL1 ?: headL2
        return result
    }
}