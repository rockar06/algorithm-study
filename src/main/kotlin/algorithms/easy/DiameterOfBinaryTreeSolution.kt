package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/diameter-of-binary-tree
class DiameterOfBinaryTreeSolution {

    private var diameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        root?.let {
            calculateLongestPath(it)
        }
        return diameter
    }

    private fun calculateLongestPath(root: TreeNode?): Int {
        if (root == null) return 0
        val leftPath = calculateLongestPath(root.left)
        val rightPath = calculateLongestPath(root.right)

        diameter = Math.max(diameter, leftPath + rightPath)
        return Math.max(leftPath, rightPath) + 1
    }
}