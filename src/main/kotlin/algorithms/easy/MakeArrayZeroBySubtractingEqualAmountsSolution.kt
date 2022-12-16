package algorithms.easy

// https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts
class MakeArrayZeroBySubtractingEqualAmountsSolution {

    fun minimumOperations(nums: IntArray): Int {
        var counterResult = 0
        nums.sort()
        nums.forEachIndexed { index, value ->
            if (value != 0 && nums.getOrNull(index + 1) != value) {
                counterResult++
            }
        }
        return counterResult
    }
}

fun main() {
    MakeArrayZeroBySubtractingEqualAmountsSolution().minimumOperations(intArrayOf(1,5,0,3,5))
}