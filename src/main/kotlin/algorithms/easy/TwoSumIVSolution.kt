package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
class TwoSumIVSolution {

    fun findTarget(root: TreeNode?, k: Int, mappedItems: HashMap<Int, Int> = hashMapOf()): Boolean {
        root?.let {
            val complement = k - it.`val`
            return if (mappedItems[complement] == null) {
                mappedItems[it.`val`] = complement
                findTarget(it.left, k, mappedItems) || findTarget(it.right, k, mappedItems)
            } else {
                true
            }
        }
        return false
    }
}