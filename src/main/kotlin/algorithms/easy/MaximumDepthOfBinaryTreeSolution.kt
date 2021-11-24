package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
class MaximumDepthOfBinaryTreeSolution {

    fun maxDepth(root: TreeNode?): Int {
        var maxDepth = 0
        root?.let {
            maxDepth++
        } ?: run {
            return 0
        }
        val leftCounter = root.left?.let {
            maxDepth(root.left)
        } ?: 0
        val rightCounter = root.right?.let {
            maxDepth(root.right)
        } ?: 0

        maxDepth += if (leftCounter > rightCounter) leftCounter else rightCounter
        return maxDepth
    }
}