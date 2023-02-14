package algorithms.medium

// https://leetcode.com/problems/design-circular-queue
class MyCircularQueue(private val k: Int) {

    private var headPointer = -1
    private var tailPointer = -1
    private val queueArray = IntArray(k)

    fun enQueue(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            if (isEmpty()) {
                headPointer = 0
            }
            tailPointer = (tailPointer + 1) % k
            queueArray[tailPointer] = value
            true
        }
    }

    fun deQueue(): Boolean {
        return if (isEmpty()) {
            false
        } else if (headPointer == tailPointer) {
            headPointer = -1
            tailPointer = -1
            true
        } else {
            headPointer = (headPointer + 1) % k
            true
        }
    }

    fun Front(): Int {
        return if (isEmpty()) {
            -1
        } else {
            queueArray[headPointer]
        }
    }

    fun Rear(): Int {
        return if (isEmpty()) {
            -1
        } else {
            queueArray[tailPointer]
        }
    }

    fun isEmpty(): Boolean {
        return headPointer == -1
    }

    fun isFull(): Boolean {
        return ((tailPointer + 1) % k) == headPointer
    }
}