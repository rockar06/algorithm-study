package algorithms.easy

import algorithms.common.TreeNode
import java.util.*


// https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
class BinaryTreeInorderTraversalSolution {

    /*private val result = arrayListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        root?.let {
            inorderTraversal(it.left)
            result.add(it.`val`)
            inorderTraversal(it.right)
        }
        return result
    }*/

    fun inorderTraversal(root: TreeNode?): List<Int> {

        if (root == null) return emptyList()

        val stackOfItems = Stack<TreeNode>()
        val result = arrayListOf<Int>()
        var currentNode = root

        while (currentNode != null || stackOfItems.size > 0) {

            while (currentNode != null) {
                stackOfItems.push(currentNode)
                currentNode = currentNode.left
            }

            currentNode = stackOfItems.pop()

            result.add(currentNode.`val`)

            currentNode = currentNode.right
        }

        return result
    }
}
