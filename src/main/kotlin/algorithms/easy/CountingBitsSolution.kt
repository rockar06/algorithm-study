package algorithms.easy

// https://leetcode.com/problems/counting-bits
class CountingBitsSolution {

    fun countBits(n: Int): IntArray {
        // Create the result array with size of n + 1
        // Iterate from 0 to n
        // In each iteration, convert counter to bit representation string
        // Count number of 1's in the string
        // Add the counter result to the intarray
        // Return the array

        val arrayResult = IntArray(n + 1)
        for (counter in 0..n) {
            val numberOfOnes = counter.toString(2).count { it == '1' }
            arrayResult[counter + 1] = numberOfOnes
        }

        return arrayResult
    }
}