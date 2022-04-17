package algorithms.easy

import java.util.*

// https://leetcode.com/problems/moving-average-from-data-stream
class MovingAverageFromDataStreamSolution(private val size: Int) {

    private var currentSum = 0
    private val numbersQueue: Queue<Int> = LinkedList()

    fun next(`val`: Int): Double {
        if (numbersQueue.size >= size) {
            currentSum -= numbersQueue.poll()
        }
        numbersQueue.add(`val`)
        currentSum += `val`
        return currentSum.toDouble() / numbersQueue.size.toDouble()
    }
}