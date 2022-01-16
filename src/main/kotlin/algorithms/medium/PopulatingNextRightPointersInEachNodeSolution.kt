package algorithms.medium

import algorithms.common.Node

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
class PopulatingNextRightPointersInEachNodeSolution {

    fun connect(root: Node?): Node? {
        if (root == null) return null

        var leftMost = root

        while (leftMost?.left != null) {
            var head = leftMost

            while (head != null) {
                head.left?.next = head.right
                head.right?.next = head.next?.left
                head = head.next
            }
            leftMost = leftMost.left
        }

        return root
    }
}