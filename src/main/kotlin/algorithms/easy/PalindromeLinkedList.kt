package algorithms.easy

import algorithms.common.ListNode
import algorithms.easy.SolutionPalindromeLinkedList.isPalindrome

fun main() {
    val result = isPalindrome(notPalindromeListA)
    println("Is Palindrome?: $result")
}

private val palindromeListA = ListNode(1).apply {
    next = ListNode(2).apply {
        next = ListNode(3).apply {
            next = ListNode(3).apply {
                next = ListNode(2).apply {
                    next = ListNode(1)
                }
            }
        }
    }
}

private val notPalindromeListA = ListNode(1).apply {
    next = ListNode(2).apply {
        next = ListNode(3).apply {
            next = ListNode(4).apply {
                next = ListNode(2).apply {
                    next = ListNode(1)
                }
            }
        }
    }
}

object SolutionPalindromeLinkedList {
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
