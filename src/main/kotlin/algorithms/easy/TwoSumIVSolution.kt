package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
class TwoSumIVSolution {

    private val mappedItems = hashMapOf<Int, Int>()

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        root?.let {
            val complement = k - it.`val`
            return if (mappedItems[complement] == null) {
                mappedItems[it.`val`] = complement
                findTarget(it.left, k) || findTarget(it.right, k)
            } else {
                true
            }
        }
        return false
    }
}