package algorithms.medium

import kotlin.math.max

// https://leetcode.com/problems/max-area-of-island
class MaxAreaOfIslandSolution {

    private var maxCounter = 0
    private var islandCounter = 0

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        for (rowIndex in grid.indices) {
            for (columnIndex in 0 until grid[0].size) {
                islandCounter = 0
                foundArea(grid, rowIndex, columnIndex)
                maxCounter = max(maxCounter, islandCounter)
            }
        }
        return maxCounter
    }

    private fun foundArea(grid: Array<IntArray>, row: Int, column: Int) {
        if (grid[row][column] == 1) {
            grid[row][column] = 0
            islandCounter++
            if (row >= 1) foundArea(grid, row - 1, column)
            if (column >= 1) foundArea(grid, row, column - 1)
            if (row + 1 < grid.size) foundArea(grid, row + 1, column)
            if (column + 1 < grid[0].size) foundArea(grid, row, column + 1)
        }
    }
}