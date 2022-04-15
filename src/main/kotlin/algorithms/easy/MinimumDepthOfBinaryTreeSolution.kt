package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/minimum-depth-of-binary-tree
class MinimumDepthOfBinaryTreeSolution {
    fun minDepth(root: TreeNode?): Int {
        return root?.let {
            val childNodesValue = if (it.left != null && it.right != null) {
                Math.min(minDepth(it.left), minDepth(it.right))
            } else if (it.left != null) {
                minDepth(it.left)
            } else {
                minDepth(it.right)
            }
            1 + childNodesValue
        } ?: 0
    }
}