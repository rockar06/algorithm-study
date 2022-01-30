package algorithms.easy

// https://leetcode.com/problems/consecutive-characters/
class ConsecutiveCharactersSolution {

    fun maxPower(s: String): Int {
        var maxCounter = 0
        var currentCounter = 0
        var previousChar = ' '
        s.forEach {
            if (it == previousChar) {
                currentCounter++
            } else {
               maxCounter = Math.max(maxCounter, currentCounter)
               currentCounter = 1
               previousChar = it
            }
        }
        return Math.max(maxCounter, currentCounter)
    }
}