package algorithms.medium

import algorithms.common.TreeNode

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/
class FindLargestValueInEachTreeRowSolution {

    private val mapHelper = hashMapOf<Int, Int>()

    fun largestValues(root: TreeNode?): List<Int> {
        traverseTree(root)
        return mapHelper.map {
            it.value
        }
    }

    private fun traverseTree(root: TreeNode?, level: Int = 0) {
        root?.let { node ->
            mapHelper[level]?.let {
                mapHelper[level] = Math.max(it, node.`val`)
            } ?: run {
                mapHelper[level] = node.`val`
            }
            traverseTree(root.left, level + 1)
            traverseTree(root.right, level + 1)
        }
    }
}

fun main() {
    val tree = TreeNode(1).apply {
        left = TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(6)
        }
        right = TreeNode(2).apply {
            right = TreeNode(9)
        }
    }/*
    val tree = TreeNode(1).apply {
        left = TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(3)
        }
        right = TreeNode(2).apply {
            right = TreeNode(9)
        }
    }*/
    val result = FindLargestValueInEachTreeRowSolution().largestValues(tree)
    result
}