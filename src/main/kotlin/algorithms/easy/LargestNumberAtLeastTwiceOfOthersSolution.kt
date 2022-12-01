package algorithms.easy

// Largest Number At Least Twice of Others
class LargestNumberAtLeastTwiceOfOthersSolution {
    /*fun dominantIndex(nums: IntArray): Int {
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
    }*/

    fun dominantIndex(nums: IntArray): Int {
        var maxValue = 0
        var secondMaxValue = 0
        var maxValueIndex = 0

        nums.forEachIndexed { index, item ->
            if (item > maxValue) {
                secondMaxValue = maxValue
                maxValue = item
                maxValueIndex = index
            } else {
                secondMaxValue = Math.max(secondMaxValue, item)
            }
        }

        return if (maxValue >= (secondMaxValue * 2)) {
            maxValueIndex
        } else -1
    }
}