package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
class MaximumDepthOfBinaryTreeSolution {

    fun maxDepth(root: TreeNode?, depthValue: Int? = null): Int {
        root?.let {
            return (depthValue ?: 1) + Math.max(maxDepth(it.left, 1), maxDepth(it.right, 1))
        }
        return 0
    }
}