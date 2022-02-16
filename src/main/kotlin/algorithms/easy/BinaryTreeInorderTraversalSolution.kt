package algorithms.easy

import algorithms.common.TreeNode


// https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
class BinaryTreeInorderTraversalSolution {

    private val result = arrayListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        root?.let {
            inorderTraversal(it.left)
            result.add(it.`val`)
            inorderTraversal(it.right)
        }
        return result
    }
}
