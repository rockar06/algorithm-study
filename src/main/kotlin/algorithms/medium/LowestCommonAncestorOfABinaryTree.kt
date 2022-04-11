package algorithms.medium

import algorithms.common.TreeNode

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
class LowestCommonAncestorOfABinaryTree {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null

        val rootIsMatch = root.`val` == p?.`val` || root.`val` == q?.`val`
        val leftValidation = getListOfMatchItems(root.left, p, q)
        val rightValidation = getListOfMatchItems(root.right, p, q)
        if (rootIsMatch && leftValidation == 1) return root
        if (rootIsMatch && rightValidation == 1) return root
        if (leftValidation == 1 && rightValidation == 1) return root

        return if (leftValidation == 2) {
            lowestCommonAncestor(root.left, p, q)
        } else {
            lowestCommonAncestor(root.right, p, q)
        }
    }

    private fun getListOfMatchItems(
        root: TreeNode?,
        p: TreeNode?,
        q: TreeNode?,
        numberOfCoincidences: Int = 0
    ): Int {
        if (root == null) return numberOfCoincidences
        val childNodesCoincidences = getListOfMatchItems(root.left, p, q, numberOfCoincidences) + getListOfMatchItems(
            root.right,
            p,
            q,
            numberOfCoincidences
        )
        return if (root.`val` == p?.`val` || root.`val` == q?.`val`) {
            childNodesCoincidences + 1
        } else childNodesCoincidences
    }
}
