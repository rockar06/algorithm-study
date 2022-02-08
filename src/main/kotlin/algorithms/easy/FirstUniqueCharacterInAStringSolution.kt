package algorithms.easy

// https://leetcode.com/problems/first-unique-character-in-a-string/
class FirstUniqueCharacterInAStringSolution {

    fun firstUniqChar(s: String): Int {
        val charMapper = hashMapOf<Char, Int>()
        s.forEach {
            charMapper[it] = charMapper.getOrDefault(it, 0) + 1
        }
        s.forEachIndexed { index, item ->
            if (charMapper[item] == 1) return index
        }
        return -1
    }
}