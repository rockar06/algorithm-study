package algorithms.easy

// https://leetcode.com/problems/can-place-flowers
class CanPlaceFlowersSolution {

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var places = 0

        flowerbed.forEachIndexed { index, value ->
            if (value == 0 && flowerbed.getOrElse(index - 1) { 0 } == 0 && flowerbed.getOrElse(index + 1) { 0 } == 0) {
                flowerbed[index] = 1
                places++
            }
        }

        return places >= n
    }
}