package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class ConvertSortedArrayToBinarySearchTreeSolution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? = when(nums.size) {
        1 -> TreeNode(nums[0])
        2 -> TreeNode(nums[1]).apply {
            left = TreeNode(nums[0])
        }
        else -> TreeNode(nums[nums.size / 2]).apply {
            left = sortedArrayToBST(nums.copyOfRange(0, nums.size / 2))
            right = sortedArrayToBST(nums.copyOfRange((nums.size / 2) + 1, nums.size))
        }
    }
}
