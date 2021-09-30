package linkedlist.medium

import linkedlist.common.ListNode
import linkedlist.medium.SolutionMergeInBetweenLinkedList.mergeInBetween

fun main() {
    val result = mergeInBetween(linkedListA, 3, 4, linkedListC)
    result
}

object SolutionMergeInBetweenLinkedList {
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

private val linkedListA = ListNode(0).apply {
    next = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
}

private val linkedListB = ListNode(1000000).apply {
    next = ListNode(1000001).apply {
        next = ListNode(1000002).apply {
            next = ListNode(1000003).apply {
                next = ListNode(1000004)
            }
        }
    }
}

private val linkedListC = ListNode(1000000).apply {
    next = ListNode(1000001).apply {
        next = ListNode(1000002)
    }
}