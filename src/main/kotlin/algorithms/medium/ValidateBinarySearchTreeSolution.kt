package algorithms.medium

import algorithms.common.TreeNode
import kotlin.math.max

class ValidateBinarySearchTreeSolution {

    fun isValidBST(root: TreeNode?, minimumValue: Int? = null, maximumValue: Int? = null): Boolean {
        root?.let {
            if (it.left == null && it.right == null) {
                return true
            }
            it.left?.let { leftItem ->
                if (leftItem.`val` >= it.`val`) {
                    return false
                }
                minimumValue?.let {
                    if (leftItem.`val` < minimumValue) {
                        return false
                    }
                }
            }
            it.right?.let { rightItem ->
                if (rightItem.`val` <= it.`val`) {
                    return false
                }
                maximumValue?.let {
                    if (rightItem.`val` > maximumValue) {
                        return false
                    }
                }
            }
            return isValidBST(it.left, maximumValue = maximumValue ?: it.`val`) &&
                    isValidBST(it.right, minimumValue = minimumValue ?: it.`val`)
        }
        return true
    }

    /*
        fun isValidBST(root: TreeNode?, rootTreeValue: Int? = null): Boolean {
        root?.let {
            if (it.left == null && it.right == null) {
                return true
            }
            it.left?.let { leftItem ->
                if (leftItem.`val` >= it.`val`) {
                    return false
                }
                rootTreeValue?.let {
                    if (leftItem.`val` < rootTreeValue) {
                        return false
                    }
                }
            }
            it.right?.let { rightItem ->
                if (rightItem.`val` <= it.`val`) {
                    return false
                }
                rootTreeValue?.let {
                    if (rightItem.`val` > rootTreeValue) {
                        return false
                    }
                }
            }
            val rootValue = rootTreeValue ?: it.`val`
            return isValidBST(it.left, rootTreeValue = rootValue) && isValidBST(it.right, rootTreeValue = rootValue)
        }
        return true
    }
     */
}

// [3,1,5,0,2,4,6]
fun main() {
    /*val tree = TreeNode(5).apply {
        left = TreeNode(4)
        right = TreeNode(6).apply {
            left = TreeNode(3)
            right = TreeNode(7)
        }
    }*/
    val tree = TreeNode(3).apply {
        left = TreeNode(1).apply {
            left = TreeNode(0)
            right = TreeNode(2)
        }
        right = TreeNode(5).apply {
            left = TreeNode(4)
            right = TreeNode(6)
        }
    }
    val result = ValidateBinarySearchTreeSolution().isValidBST(tree)
    result
}