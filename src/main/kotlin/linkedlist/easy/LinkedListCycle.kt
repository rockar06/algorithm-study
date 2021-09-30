package linkedlist.easy

import linkedlist.common.ListNode

object SolutionLinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        var hasCycle = false
        val hashNode = HashSet<ListNode>()
        var tempHead = head
        while (tempHead != null && hasCycle.not()) {
            if (hashNode.contains(tempHead).not()) {
                hashNode.add(tempHead)
            } else {
                hasCycle = true
            }
            tempHead = tempHead.next
        }
        return hasCycle
    }
}