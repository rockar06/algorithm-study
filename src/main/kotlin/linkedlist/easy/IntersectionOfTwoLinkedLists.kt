package linkedlist.easy

import linkedlist.common.ListNode
import linkedlist.easy.SolutionInterjection.getIntersectionNode

fun main() {
    val result = getIntersectionNode(linkedListA, linkedListD)
    result
}

object SolutionInterjection {

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        // concatenar los nodos
        // headA + headB
        // 12345 + 678945 = 12345678945678945678945678945678945678945678945678945678945678945678945678945678945678945

        // 1-2-3-4-5
        // 1-6-7-8-4-5

        // abs(5 - 6)  = 1


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

private val linkedListC = ListNode(8).apply {
    next = ListNode(4).apply {
        next = ListNode(5)
    }
}

private val linkedListA = ListNode(4).apply {
    next = ListNode(1).apply {
        next = linkedListC
    }
}
// 4-1-[8-4-5]

private val linkedListB = ListNode(5).apply {
    next = ListNode(6).apply {
        next = ListNode(1).apply {
            next = linkedListC
        }
    }
}
// 5-6-1-[8-4-5]

private val linkedListD = ListNode(6).apply {
    next = ListNode(1).apply {
        next = linkedListC
    }
}