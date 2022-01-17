package algorithms.easy

import algorithms.common.ListNode

// https://leetcode.com/problems/merge-two-sorted-lists/
class MergeTwoSortedLists {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
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
    }
}