package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/path-sum/
class PathSumSolution {

    fun hasPathSum(root: TreeNode?, targetSum: Int, currentTotal: Int = 0): Boolean {
        root?.let {
            return if ((it.`val` + currentTotal) == targetSum && it.left == null && it.right == null) {
                true
            } else {
                hasPathSum(root.left, targetSum, currentTotal + it.`val`) ||
                        hasPathSum(root.right, targetSum, currentTotal + it.`val`)
            }
        }
        return false
    }
}