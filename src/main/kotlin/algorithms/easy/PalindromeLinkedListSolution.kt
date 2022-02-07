package algorithms.easy

import algorithms.common.ListNode

class PalindromeLinkedListSolution {

    fun isPalindrome(head: ListNode?): Boolean {
        var differenceDetected = false
        var editableHead = head
        var reverseHead = reverseLinkedList(head)
        while (editableHead != null && reverseHead != null && differenceDetected.not()) {
            differenceDetected = editableHead.value != reverseHead.value
            editableHead = editableHead.next
            reverseHead = reverseHead.next
        }
        return differenceDetected.not()
    }

    private fun reverseLinkedList(head: ListNode?): ListNode? {
        var tempHead = head
        var reverseHead: ListNode? = null
        while (tempHead != null) {
            reverseHead = ListNode(tempHead.value).apply {
                next = reverseHead
            }
            tempHead = tempHead.next
        }
        return reverseHead
    }
}
