package algorithms.easy

// https://leetcode.com/problems/jewels-and-stones
class JewelsAndStonesSolution {

    fun numJewelsInStones(jewels: String, stones: String): Int {
        val charMapper = jewels.toSet()
        var result = 0

        stones.forEach {
            if (charMapper.contains(it)) {
                result++
            }
        }

        return result
    }
}