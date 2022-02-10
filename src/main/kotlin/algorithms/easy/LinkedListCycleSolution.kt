package algorithms.easy

import algorithms.common.ListNode

// https://leetcode.com/problems/linked-list-cycle/
class LinkedListCycleSolution {
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