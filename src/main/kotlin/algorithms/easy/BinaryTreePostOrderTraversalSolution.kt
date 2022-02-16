package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/binary-tree-postorder-traversal
class BinaryTreePostOrderTraversalSolution {

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        root?.let {
            result.addAll(postorderTraversal(it.left))
            result.addAll(postorderTraversal(it.right))
            result.add(it.`val`)
        }
        return result
    }
}