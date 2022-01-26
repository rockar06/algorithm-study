package algorithms.easy

import algorithms.common.ListNode

class SolutionInterjection {

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {

        if (headA == null || headB == null) return null
        var isIntersected = false
        var intersectedNode: ListNode? = null
        var tempHeadA = headA
        var tempHeadB = headB
        val lengthHeadA = getLengthHead(tempHeadA)
        val lengthHeadB = getLengthHead(tempHeadB)
        val difference = Math.abs(lengthHeadA - lengthHeadB)
        if (lengthHeadA > lengthHeadB) {
            tempHeadA = skipItemsInNode(tempHeadA, difference)
        } else {
            tempHeadB = skipItemsInNode(tempHeadB, difference)
        }
        while (tempHeadA != null && tempHeadB != null && isIntersected.not()) {
            if (tempHeadA == tempHeadB) {
                intersectedNode = tempHeadA
                isIntersected = true
            }
            tempHeadA = tempHeadA.next
            tempHeadB = tempHeadB.next
        }
        return intersectedNode
    }

    private fun getLengthHead(head: ListNode?): Int {
        var temporalHead = head
        var length = 0
        while (temporalHead != null) {
            length++
            temporalHead = temporalHead.next
        }
        return length
    }

    private fun skipItemsInNode(head: ListNode?, skips: Int): ListNode? {
        var counter = 0
        var tempHead = head
        while (counter < skips) {
            counter++
            tempHead = tempHead?.next
        }
        return tempHead
    }
}