package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class ConvertSortedArrayToBinarySearchTreeSolution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return TreeNode(nums[nums.size / 2]).apply {
            left = if (nums.size > 1) sortedArrayToBST(nums.copyOfRange(0, nums.size / 2)) else null
            right = if (nums.size > 2) sortedArrayToBST(nums.copyOfRange((nums.size / 2) + 1, nums.size)) else null
        }
    }
}