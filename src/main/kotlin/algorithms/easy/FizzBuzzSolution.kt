package algorithms.easy

// https://leetcode.com/problems/fizz-buzz/
class FizzBuzzSolution {

    fun fizzBuzz(n: Int): List<String> {
        val result = arrayListOf<String>()
        for (index in 1..n) {
            if (index % 3 == 0 && index % 5 == 0) {
                result.add("FizzBuzz")
            } else if (index % 3 == 0) {
                result.add("Fizz")
            } else if (index % 5 == 0) {
                result.add("Buzz")
            } else {
                result.add(index.toString())
            }
        }
        return result
    }
}