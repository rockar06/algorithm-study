package algorithms.medium

import algorithms.common.DoubleListNode

fun main() {
    val browserHistory = BrowserHistory("google")
    browserHistory.visit("facebook")
    browserHistory.visit("amazon")
    browserHistory.visit("walmart")
    browserHistory.visit("stackoverflow")
    browserHistory.back(5)
    browserHistory.forward(5)
}

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
class BrowserHistory(homepage: String) {

    private val stackHistory: DoubleListNode<String> = DoubleListNode(homepage)
    private var stackTail: DoubleListNode<String>? = stackHistory

    fun visit(url: String) {
        stackTail?.next = DoubleListNode(url).apply {
            previous = stackTail
        }
        stackTail = stackTail?.next
    }

    fun back(steps: Int): String {
        var countDownSteps = steps
        while (countDownSteps-- > 0 && stackTail?.previous != null) {
            stackTail = stackTail?.previous
        }
        return stackTail?.value ?: ""
    }

    fun forward(steps: Int): String {
        var countUpSteps = steps
        while (countUpSteps-- > 0 && stackTail?.next != null) {
            stackTail = stackTail?.next
        }
        return stackTail?.value ?: ""
    }
}