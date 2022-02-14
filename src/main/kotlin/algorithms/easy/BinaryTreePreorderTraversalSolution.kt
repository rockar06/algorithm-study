package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/binary-tree-preorder-traversal
class BinaryTreePreorderTraversalSolution {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        root?.let {
            result.add(it.`val`)
            result.addAll(preorderTraversal(it.left))
            result.addAll(preorderTraversal(it.right))
        }
        return result
    }
}