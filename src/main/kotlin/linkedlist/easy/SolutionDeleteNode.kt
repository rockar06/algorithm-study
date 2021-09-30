package linkedlist.easy

import linkedlist.common.ListNode

object SolutionDeleteNode {

    fun deleteNode(node: ListNode?) {
        node!!.value = node.next!!.value
        node.next = node.next!!.next
    }
}