package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/symmetric-tree/
class SymmetricTreeSolution {

    fun isSymmetric(root: TreeNode?): Boolean {
        return isSameValue(root?.left, root?.right)
    }

    private fun isSameValue(leftNode: TreeNode?, rightNode: TreeNode?): Boolean {
        return if (leftNode == null && rightNode == null) {
            true
        } else if (leftNode?.`val` != rightNode?.`val`) {
            false
        } else {
            isSameValue(leftNode?.left, rightNode?.right) && isSameValue(leftNode?.right, rightNode?.left)
        }
    }
}