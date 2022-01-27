package algorithms.medium

// https://leetcode.com/problems/permutations/
class PermutationsSolution {

    private val output: MutableList<List<Int>> = mutableListOf()
    private lateinit var originalArray: IntArray

    fun permute(nums: IntArray): List<List<Int>> {
        originalArray = nums
        permutations(0)
        return output
    }

    private fun permutations(first: Int) {
        if (first == originalArray.size) {
            val permutation = arrayListOf<Int>()
            for (element in originalArray) {
                permutation.add(element)
            }
            output.add(permutation)
        } else {
            for (index in first until originalArray.size) {
                if (index != first) {
                    swap(index, first)
                    permutations(first + 1)
                    swap(index, first)
                } else {
                    permutations(first + 1)
                }
            }
        }
    }

    private fun swap(index: Int, first: Int) {
        val temp = originalArray[index]
        originalArray[index] = originalArray[first]
        originalArray[first] = temp
    }
}