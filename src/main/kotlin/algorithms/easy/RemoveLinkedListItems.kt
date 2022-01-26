package algorithms.easy

import algorithms.common.ListNode

class SolutionRemoveLinkedListItems {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var tempHead = head
        var filteredList: ListNode? = null
        var tail: ListNode? = null
        while (tempHead != null) {
            if (tempHead.value != `val`) {
                if (filteredList == null) {
                    filteredList = ListNode(tempHead.value)
                    tail = filteredList
                } else {
                    tail?.next = ListNode(tempHead.value)
                    tail = tail?.next
                }
            }
            tempHead = tempHead.next
        }
        return filteredList
    }
}