package algorithms.easy

import java.util.*

// https://leetcode.com/problems/implement-queue-using-stacks
class ImplementQueueUsingStacksSolution {

    private var hardStack = Stack<Int>()
    private var reverseStack = Stack<Int>()

    fun push(x: Int) {
        hardStack.push(x)
        reverseHardStack()
    }

    private fun reverseHardStack() {
        reverseStack.clear()
        val tempStack = Stack<Int>().apply {
            addAll(hardStack)
        }
        while (tempStack.size != 0) {
            reverseStack.push(tempStack.pop())
        }
    }

    fun pop(): Int {
        return reverseStack.pop().also {
            updateHardStack()
        }
    }

    private fun updateHardStack() {
        hardStack.clear()
        val tempStack = Stack<Int>().apply {
            addAll(reverseStack)
        }
        while (tempStack.size != 0) {
            hardStack.push(tempStack.pop())
        }
    }

    fun peek(): Int {
        reverseStack.forEach {
            it
        }
        return reverseStack.peek()
    }

    fun empty(): Boolean {
        return reverseStack.isEmpty()
    }
}