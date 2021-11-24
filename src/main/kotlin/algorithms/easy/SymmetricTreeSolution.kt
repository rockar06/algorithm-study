package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/symmetric-tree/
class SymmetricTreeSolution {

    fun isSymmetric(root: TreeNode?): Boolean {
        return isSameValue(root?.left, root?.right)
    }

    private fun isSameValue(leftNode: TreeNode?, rightNode: TreeNode?): Boolean {
        if (leftNode == null && rightNode == null) {
            return true
        }
        if (leftNode == null || rightNode == null || leftNode.`val` != rightNode.`val`) {
            return false
        }
        return isSameValue(leftNode.left, rightNode.right) && isSameValue(leftNode.right, rightNode.left)
    }
}