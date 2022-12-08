package algorithms.easy

import algorithms.common.TreeNode

// https://leetcode.com/problems/leaf-similar-trees/
class LeafSimilarTreesSolution {

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        // Depth-First Search in order traversal to reach the all the leafs
        // Add all the leafs in order traversal to a list
        // Compare both arrays, return false if any difference is found, otherwise true
        // Use a separated method to get the arrays
        val arrayFirstRoot = arrayListOf<Int>()
        val arraySecondRoot = arrayListOf<Int>()

        getArrayFromTree(root1, arrayFirstRoot)
        getArrayFromTree(root2, arraySecondRoot)

        if (arrayFirstRoot.size != arraySecondRoot.size) return false

        var counter = 0

        while (counter < arrayFirstRoot.size) {
            if (arrayFirstRoot[counter] != arraySecondRoot[counter]) return false
            counter++
        }

        return true
    }

    private fun getArrayFromTree(root: TreeNode?, listValues: ArrayList<Int>) {
        // Validate if the root doesn't have left and right nodes, if true, we can add the value to the array
        // Otherwise we need to iterate first to the left then to the right
        // Validate default value when root == null, then just return

        if (root == null) return

        if (root.left == null && root.right == null) {
            listValues.add(root.`val`)
        } else {
            getArrayFromTree(root.left, listValues)
            getArrayFromTree(root.right, listValues)
        }
    }
}