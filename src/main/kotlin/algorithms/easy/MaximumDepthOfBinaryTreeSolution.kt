package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
class MaximumDepthOfBinaryTreeSolution {

    fun maxDepth(root: TreeNode?, depthValue: Int? = null): Int {
        return root?.let {
            1 + Math.max(algorithms.maxDepth(it.left), algorithms.maxDepth(it.right))
        } ?: 0
    }
}