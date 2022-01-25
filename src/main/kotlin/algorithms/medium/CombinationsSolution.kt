package algorithms.medium

import java.util.*


class CombinationsSolution {

    private val output: MutableList<List<Int>> = mutableListOf()
    private var range = 0
    private var combinations = 0

    fun combine(n: Int, k: Int): List<List<Int>> {
        range = n
        combinations = k
        backtrack(1, LinkedList())
        return output
    }

    private fun backtrack(first: Int, current: LinkedList<Int>) {
        if (current.size == combinations) {
            output.add(LinkedList(current))
        }
        for (index in first..range) {
            current.add(index)
            backtrack(index + 1, current)
            current.removeLast()
        }
    }
}

fun main() {
    val result = CombinationsSolution().combine(4, 2)
    result
}