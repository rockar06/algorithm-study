package algorithms.medium

import algorithms.common.ListNode

class SolutionMergeInBetweenLinkedList {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var tempA = a
        var tempB = b - a
        var head1 = list1
        var head2 = list2
        var list2Tail: ListNode? = null

        // Find a-th node and keep reference for previous node (aka initReplace)
        while (tempA-- > 1) {
            head1 = head1?.next
        }
        val initReplace: ListNode? = head1
        // Find b-th node and keep reference for next node (aka finishReplace)
        while (tempB-- >= 0) {
            head1 = head1?.next
        }
        val finishReplace: ListNode? = head1?.next

        while (head2 != null) {
            list2Tail = head2
            head2 = head2.next
        }

        // Reference list2 as next node in initReplace
        initReplace?.next = list2

        // Reference remaining list1 nodes in the tail of list2
        list2Tail?.next = finishReplace
        return list1
    }
}