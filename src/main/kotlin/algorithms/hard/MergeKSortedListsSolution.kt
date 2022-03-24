package algorithms.hard

import algorithms.common.ListNode

// https://leetcode.com/problems/merge-k-sorted-lists
class MergeKSortedListsSolution {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val firstList = if (lists.size <= 2) {
            lists.firstOrNull()
        } else {
            mergeKLists(lists.copyOfRange(0, lists.size / 2))
        }

        val secondList = if (lists.size <= 2) {
            lists.getOrNull(1)
        } else {
            mergeKLists(lists.copyOfRange(lists.size / 2, lists.size))
        }
        return mergeTwoLists(firstList, secondList)
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
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
