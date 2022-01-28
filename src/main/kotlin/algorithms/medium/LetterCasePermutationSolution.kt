package algorithms.medium

// https://leetcode.com/problems/letter-case-permutation/
class LetterCasePermutationSolution {

    private val output: MutableList<String> = mutableListOf()
    private lateinit var charArray: CharArray

    fun letterCasePermutation(s: String): List<String> {
        charArray = s.toCharArray()
        permutations(0)
        return output
    }

    private fun permutations(start: Int) {
        if (start == charArray.size) {
            val permutation = StringBuilder()
            for (element in charArray) {
                permutation.append(element)
            }
            output.add(permutation.toString())
        } else {
            permutations(start + 1)
            if (Character.isLetter(charArray[start])) {
                convertCharacter(start)
                permutations(start + 1)
                convertCharacter(start)
            }
        }
    }

    private fun convertCharacter(index: Int) {
        if (Character.isUpperCase(charArray[index])) {
            charArray[index] = Character.toLowerCase(charArray[index])
        } else {
            charArray[index] = Character.toUpperCase(charArray[index])
        }
    }
}

fun main() {
    val result = LetterCasePermutationSolution().letterCasePermutation("3z4")
}