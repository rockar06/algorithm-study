package algorithms.easy

// https://leetcode.com/problems/island-perimeter/
class IslandPerimeterSolution {

    fun islandPerimeter(grid: Array<IntArray>): Int {
        // Iterate each row
        // Iterate each column
        // By each item, we will validate the neighborhoods, if vertical/horizontal neighborhoods are zeros or nulls, 
        // increase the counter, otherwise not
        // Return the counter

        var perimeterCounter = 0

        grid.forEachIndexed { indexColumns, columns ->
            columns.forEachIndexed { index, item ->
                if (item == 1) {
                    if (grid.getOrNull(indexColumns)?.getOrNull(index - 1).isValidArea()) {
                        perimeterCounter++
                    }
                    if (grid.getOrNull(indexColumns)?.getOrNull(index + 1).isValidArea()) {
                        perimeterCounter++
                    }
                    if (grid.getOrNull(indexColumns - 1)?.getOrNull(index).isValidArea()) {
                        perimeterCounter++
                    }
                    if (grid.getOrNull(indexColumns + 1)?.getOrNull(index).isValidArea()) {
                        perimeterCounter++
                    }
                }
            }
        }

        return perimeterCounter
    }

    private fun Int?.isValidArea(): Boolean {
        return this == null || this == 0
    }
}