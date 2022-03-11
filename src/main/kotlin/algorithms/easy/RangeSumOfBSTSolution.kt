package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/range-sum-of-bst
class RangeSumOfBSTSolution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        return if (root.`val` in low..high) {
            root.`val` + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
        } else {
            0 + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
        }
    }
}