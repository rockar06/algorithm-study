package algorithms.easy

// https://leetcode.com/problems/n-th-tribonacci-number
class NthTribonacciNumberSolution {

    fun tribonacci(n: Int): Int {
        // If mn is equals to 0 or 1 return 0 -> Base case
        // if n is equals to 2 return 1
        // If n > 3 calculate the sequence as follows resultArray(index - 3) + resultArray(index - 2) + resultArray(index - 1)
        // Return the last item of the array
        if (n == 0) return 0
        if (n == 1) return 1
        val resultArray = IntArray(n + 2)
        resultArray[0] = 0
        resultArray[1] = 0
        resultArray[2] = 1
        for (index in 3..n + 1) {
            resultArray[index] = resultArray[index - 3] + resultArray[index - 2] + resultArray[index - 1]
        }
        return resultArray.last()
    }
}