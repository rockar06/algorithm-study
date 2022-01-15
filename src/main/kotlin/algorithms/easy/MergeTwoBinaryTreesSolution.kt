package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/merge-two-binary-trees
class MergeTwoBinaryTreesSolution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return if (root1 != null || root2 != null) {
            TreeNode((root1?.`val` ?: 0) + (root2?.`val` ?: 0)).apply {
                left = mergeTrees(root1?.left, root2?.left)
                right = mergeTrees(root1?.right, root2?.right)
            }
        } else null
    }
}