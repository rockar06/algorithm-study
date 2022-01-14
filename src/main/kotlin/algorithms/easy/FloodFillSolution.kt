package algorithms.easy

// https://leetcode.com/problems/flood-fill/submissions/
class FloodFillSolution {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val color = image[sr][sc]
        if (color != newColor) fillColor(image, sr, sc, newColor, color)
        return image
    }

    private fun fillColor(image: Array<IntArray>, pixelRow: Int, pixelColumn: Int, newColor: Int, color: Int) {
        if (image[pixelRow][pixelColumn] == color) {
            image[pixelRow][pixelColumn] = newColor
            if (pixelRow >= 1) fillColor(image, pixelRow - 1, pixelColumn, newColor, color)
            if (pixelColumn >= 1) fillColor(image, pixelRow, pixelColumn - 1, newColor, color)
            if (pixelRow + 1 < image.size) fillColor(image, pixelRow + 1, pixelColumn, newColor, color)
            if (pixelColumn + 1 < image[0].size) fillColor(image, pixelRow, pixelColumn + 1, newColor, color)
        }
    }
}