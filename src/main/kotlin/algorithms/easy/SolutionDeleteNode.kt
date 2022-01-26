package algorithms.easy

import algorithms.common.ListNode

class SolutionDeleteNode {

    fun deleteNode(node: ListNode?) {
        node!!.value = node.next!!.value
        node.next = node.next!!.next
    }
}