package algorithms.easy

import java.util.*

// https://leetcode.com/problems/implement-stack-using-queues
class MyStackSolution {

    private val mainStack: Queue<Int> = LinkedList()
    private val helperStack: Queue<Int> = LinkedList()

    fun push(x: Int) {
        mainStack.add(x)
    }

    fun pop(): Int {
        var topValue = 0
        var reverseCounter = 0

        while (mainStack.isNotEmpty()) {
            reverseCounter++
            topValue = mainStack.poll()
            helperStack.add(topValue)
        }

        var removeCounter = 0
        while (helperStack.isNotEmpty()) {
            if (removeCounter < reverseCounter - 1) {
                mainStack.add(helperStack.peek())
            }
            helperStack.poll()
            removeCounter++
        }

        return topValue
    }

    fun top(): Int {
        var topValue = 0

        while (mainStack.isNotEmpty()) {
            topValue = mainStack.poll()
            helperStack.add(topValue)
        }

        while (helperStack.isNotEmpty()) {
            mainStack.add(helperStack.poll())
        }

        return topValue
    }

    fun empty(): Boolean {
        return mainStack.isEmpty()
    }
}