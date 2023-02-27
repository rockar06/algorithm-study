package algorithms.medium

import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/walls-and-gates/
class WallsAndGatesSolution {

    fun wallsAndGates(rooms: Array<IntArray>) {
        val nodesQueue: Queue<Pair<Int, Int>> = LinkedList()

        rooms.forEachIndexed { indexRow, row ->
            row.forEachIndexed { indexColumn, item ->
                if (item == 0) {
                    val node = Pair(indexRow, indexColumn)
                    nodesQueue.add(node)
                }
            }
        }

        while (nodesQueue.isNotEmpty()) {
            val currentNode = nodesQueue.poll()
            val valueToUpdate = rooms[currentNode.first][currentNode.second] + 1

            // Up
            rooms.getOrNull(currentNode.first - 1)?.get(currentNode.second)?.let {
                if (it == Int.MAX_VALUE) {
                    rooms[currentNode.first - 1][currentNode.second] = valueToUpdate
                    nodesQueue.add(Pair(currentNode.first - 1, currentNode.second))
                }
            }

            // Left
            rooms[currentNode.first].getOrNull(currentNode.second - 1).let {
                if (it == Int.MAX_VALUE) {
                    rooms[currentNode.first][currentNode.second - 1] = valueToUpdate
                    nodesQueue.add(Pair(currentNode.first, currentNode.second - 1))
                }
            }

            // Down
            rooms.getOrNull(currentNode.first + 1)?.get(currentNode.second)?.let {
                if (it == Int.MAX_VALUE) {
                    rooms[currentNode.first + 1][currentNode.second] = valueToUpdate
                    nodesQueue.add(Pair(currentNode.first + 1, currentNode.second))
                }
            }

            // Right
            rooms[currentNode.first].getOrNull(currentNode.second + 1).let {
                if (it == Int.MAX_VALUE) {
                    rooms[currentNode.first][currentNode.second + 1] = valueToUpdate
                    nodesQueue.add(Pair(currentNode.first, currentNode.second + 1))
                }
            }
        }
    }
}