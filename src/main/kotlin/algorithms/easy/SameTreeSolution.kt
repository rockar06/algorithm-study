package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/same-tree/
class SameTreeSolution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return if (p == null && q == null) {
            true
        } else if (p?.`val` != q?.`val`) {
            false
        } else {
            isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        }
    }
}