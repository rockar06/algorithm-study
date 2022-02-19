package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/search-in-a-binary-search-tree
class SearchInABinarySearchTreeSolution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        root?.let {
            return if (it.`val` == `val`) {
                it
            } else {
                return searchBST(it.left, `val`) ?: searchBST(it.right, `val`)
            }
        }
        return null
    }
}