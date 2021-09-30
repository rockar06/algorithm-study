package linkedlist.medium

import linkedlist.common.ListNode

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
object Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val arrayOfNodes = convertListNodeIntoArray(head)
        swapItemsInArray(arrayOfNodes, k)
        return convertArrayIntoListNode(arrayOfNodes)
    }

    private fun convertListNodeIntoArray(head: ListNode?): ArrayList<Int> {
        var tempHead = head
        val nodeArray = ArrayList<Int>()
        while (tempHead != null) {
            nodeArray.add(tempHead.value)
            tempHead = tempHead.next
        }
        return nodeArray
    }

    private fun swapItemsInArray(arrayOfNodes: ArrayList<Int>, index: Int) {
        val arraySize = arrayOfNodes.size
        arrayOfNodes[index - 1] = arrayOfNodes.set(arraySize - index, arrayOfNodes[index - 1])
    }

    private fun convertArrayIntoListNode(arrayOfNodes: List<Int>): ListNode? {
        var convertedNode: ListNode? = null
        var tail: ListNode? = null
        arrayOfNodes.forEach { value ->
            convertedNode?.let {
                tail?.next = ListNode(value)
                tail = tail?.next
            } ?: run {
                convertedNode = ListNode(value)
                tail = convertedNode
            }
        }
        return convertedNode
    }
}