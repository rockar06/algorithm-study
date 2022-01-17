package algorithms.easy

import algorithms.common.ListNode

// https://leetcode.com/problems/merge-two-sorted-lists/
class MergeTwoSortedLists {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        return if (l1 != null && l2 == null) {
            l1.apply {
                next = mergeTwoLists(l1.next, null)
            }
        } else if (l1 == null && l2 != null) {
            l2.apply {
                next = mergeTwoLists(null, l2.next)
            }
        } else if ((l1?.value ?: -1) < (l2?.value ?: -1)) {
            l1?.apply {
                next = mergeTwoLists(l1.next, l2)
            }
        } else {
            l2?.apply {
                next = mergeTwoLists(l1, l2.next)
            }
        }
    }
}