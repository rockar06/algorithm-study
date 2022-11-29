package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
class MaximumDepthOfBinaryTreeSolution {

    fun maxDepth(root: TreeNode?, depthValue: Int? = null): Int {
        return root?.let {
            1 + Math.max(maxDepth(it.left), maxDepth(it.right))
        } ?: 0
    }
}