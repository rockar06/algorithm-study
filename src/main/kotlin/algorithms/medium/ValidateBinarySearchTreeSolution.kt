package algorithms.medium

import algorithms.common.TreeNode

class ValidateBinarySearchTreeSolution {

    fun isValidBST(root: TreeNode?, parentNode: TreeNode? = null): Boolean {
        root?.let {
            if (it.left == null && it.right == null) {
                return true
            }
            it.left?.let { leftItem ->
                if (leftItem.`val` >= it.`val`) {
                    return false
                }
                parentNode?.let { parentItem ->
                    if (leftItem.`val` < parentItem.`val`) {
                        return false
                    }
                }
            }
            it.right?.let { rightItem ->
                if (rightItem.`val` <= it.`val`) {
                    return false
                }
                parentNode?.let { parentItem ->
                    if (rightItem.`val` > parentItem.`val`) {
                        return false
                    }
                }
            }
            return isValidBST(it.left, it) && isValidBST(it.right, it)
        }
        return true
    }
}

// [3,1,5,0,2,4,6]
fun main() {
    val tree = TreeNode(5).apply {
        left = TreeNode(4)
        right = TreeNode(6).apply {
            left = TreeNode(3)
            right = TreeNode(7)
        }
    }
    /*val tree = TreeNode(3).apply {
        left = TreeNode(1).apply {
            left = TreeNode(0)
            right = TreeNode(2)
        }
        right = TreeNode(5).apply {
            left = TreeNode(4)
            right = TreeNode(6)
        }
    }*/
    val result = ValidateBinarySearchTreeSolution().isValidBST(tree)
    result
}