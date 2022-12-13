package algorithms.medium

// https://leetcode.com/problems/house-robber
class HouseRobberSolution {

    // Bottom to top solution
    /*private val housesMoneyMapper = hashMapOf<Int, Int>()
    private lateinit var housesArray: IntArray

    fun rob(nums: IntArray): Int {
        // If we decide to not rob the house, we should get the max amount of money until previous house nums[i - 1]
        // If we decide to rob the house, we should sum two houses ago plus the value of the current house nums[i - 2] + nums[i]
        // Keep track of the base case scenario i == 0 or i == 1
        // return the max quantity from the last item
        housesArray = nums
        val result = robSolution(housesArray.lastIndex)
        return result
    }

    private fun robSolution(numberOfHouse: Int): Int {
        if (numberOfHouse == 0) return housesArray[0]
        if (numberOfHouse == 1) return Math.max(housesArray[0], housesArray[1])
        if (housesMoneyMapper[numberOfHouse] == null) {
            housesMoneyMapper[numberOfHouse] = Math.max(
                robSolution(numberOfHouse - 1),
                robSolution(numberOfHouse - 2) + housesArray[numberOfHouse]
            )
        }
        return housesMoneyMapper.getOrDefault(numberOfHouse, 0)
    }*/

    fun rob(nums: IntArray): Int {
        // Keep track of default cases nums.size == 1 or nums.size == 2
        // Create the array which contains all the possible values
        // Add default cases to the array
        // Iterate for remaining items in the array
        // Add to the result array the max between the last houses (if we don't rob the current one) or two houses ago
        // plus the current value
        // Return as result the last value added to the resultArray
        if (nums.size == 1) return nums.first()
        val resultArray = IntArray(nums.size)
        resultArray[0] = nums.first()
        resultArray[1] = Math.max(nums[0], nums[1])
        for (index in 2 until nums.size) {
            resultArray[index] = Math.max(resultArray[index - 1], resultArray[index - 2] + nums[index])
        }
        return resultArray.last()
    }
}

fun main() {
    val result = HouseRobberSolution().rob(intArrayOf(2, 7, 9, 3, 1))
    result
}