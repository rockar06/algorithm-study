package algorithms.medium

import algorithms.common.TreeNode


// https://leetcode.com/problems/path-sum-ii/
class PathSumIISolution {

    // We need to check if the targetSum minus root.value then validate left and right
    // If left plus root is <= to target continue thorugh the left leaf
    // Apply the same for right leaf
    // We need to then go one step depth in the tree, with the new targetSum as the result of targetSum minus the root
    // If at the end, we have targetSum like 0, we found a sum path
    // We need to go in-order search backtracking all the items
    // We need to create a helper method to return a List<Int> and finally merge all the lists

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val pathList = mutableListOf<List<Int>>()
        val pathNodes = mutableListOf<Int>()
        helperSum(root, targetSum, pathNodes, pathList)
        return pathList
    }

    private fun helperSum(node: TreeNode?, remainingSum: Int, pathNodes: MutableList<Int>, pathList: MutableList<List<Int>>) {
        // Check if the node is null, if yes, stop the recursion
        if (node == null) return

        // Add the root path to the list
        pathNodes.add(node.`val`)

        // Check if the current value is equals to the target and is a leaf, if yes, add it to the final result
        if (remainingSum == node.`val` && node.left == null && node.right == null) {
            pathList.add(ArrayList(pathNodes))
        } else {
            // If not, iterate over left and right paths
            helperSum(node.left, remainingSum - node.`val`, pathNodes, pathList)
            helperSum(node.right, remainingSum - node.`val`, pathNodes, pathList)
        }

        // Remove last item of the list
        //pathNodes.removeLast()
        pathNodes.removeAt(pathNodes.lastIndex)
    }
}