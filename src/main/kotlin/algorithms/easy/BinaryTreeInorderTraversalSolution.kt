package algorithms.easy

import algorithms.common.TreeNode


// https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
class BinaryTreeInorderTraversalSolution {

    private val result = arrayListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        root?.let {
            addItemToList(it)
        }
        return result
    }

    private fun addItemToList(node: TreeNode) {
        node.left?.let {
            addItemToList(it)
        }
        result.add(node.`val`)
        node.right?.let {
            addItemToList(it)
        }
    }
}
