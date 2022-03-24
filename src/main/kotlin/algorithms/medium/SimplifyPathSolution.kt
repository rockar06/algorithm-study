package algorithms.medium

import java.util.*

// https://leetcode.com/problems/simplify-path
class SimplifyPathSolution {
    fun simplifyPath(path: String): String {
        val helperStack = Stack<String>()
        val splitPaths = path.split("/")
        splitPaths.forEach {
            if (it.isNotEmpty() && it != ".") {
                if (it == "..") {
                    if (helperStack.isNotEmpty()) {
                        helperStack.pop()
                    }
                } else {
                    helperStack.push(it)
                }
            }
        }
        return "/${helperStack.joinToString("/")}"
    }
}