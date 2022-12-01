package algorithms.easy

// Largest Number At Least Twice of Others
class LargestNumberAtLeastTwiceOfOthersSolution {
    fun dominantIndex(nums: IntArray): Int {
        var maxValue = 0
        var maxIndex = 0
        nums.forEachIndexed { index, item ->
            if (item > maxValue) {
                maxValue = item
                maxIndex = index
            }
        }

        nums.forEachIndexed { index, item ->
            if (index != maxIndex && item > (maxValue / 2)) {
                return -1
            }
        }

        return maxIndex
    }
}

fun main() {
    val result = LargestNumberAtLeastTwiceOfOthersSolution().dominantIndex(intArrayOf(3, 6, 1, 0))
}