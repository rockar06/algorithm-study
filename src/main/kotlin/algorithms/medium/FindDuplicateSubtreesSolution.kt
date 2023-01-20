package algorithms.medium

import algorithms.common.TreeNode

// https://leetcode.com/problems/find-duplicate-subtrees
class FindDuplicateSubtreesSolution {

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val nodeTable = hashMapOf<String, Pair<TreeNode, Int>>()

        preOrderTraversal(root, nodeTable)

        val resultList = mutableListOf<TreeNode?>()
        nodeTable.forEach { (_, value) ->
            if (value.second > 1) {
                resultList.add(value.first)
            }
        }
        return resultList
    }

    private fun preOrderTraversal(root: TreeNode?, nodeTable: HashMap<String, Pair<TreeNode, Int>>): String {
        if (root == null) return "-"

        val key = with(StringBuilder()) {
            append(root.`val`).append("-")
            append(preOrderTraversal(root.left, nodeTable)).append("-")
            append(preOrderTraversal(root.right, nodeTable)).append("-")
            toString()
        }

        if (nodeTable[key] != null) {
            val pair = nodeTable[key]
            pair?.let {
                nodeTable[key] = it.copy(second = it.second + 1)
            }
        } else {
            nodeTable[key] = Pair(root, 1)
        }

        return key
    }
}