package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/invert-binary-tree
class InvertBinaryTreeSolution {

    fun invertTree(root: TreeNode?): TreeNode? {
        return root?.apply {
            val tempLeft = left
            left = invertTree(this.right)
            right = invertTree(tempLeft)
        }
    }
}