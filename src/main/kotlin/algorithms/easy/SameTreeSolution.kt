package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/same-tree/
class SameTreeSolution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return if (p?.`val` == q?.`val`) {
            if (p?.left != null || q?.left != null) {
                if (!isSameTree(p?.left, q?.left)) {
                    return false
                }
            }
            if (p?.right != null || q?.right != null) {
                if (!isSameTree(p?.right, q?.right)) {
                    return false
                }
            }
            true
        } else {
            false
        }
    }
}