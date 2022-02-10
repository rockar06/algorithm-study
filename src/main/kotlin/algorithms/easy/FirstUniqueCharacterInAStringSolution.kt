package algorithms.easy

// https://leetcode.com/problems/first-unique-character-in-a-string/
class FirstUniqueCharacterInAStringSolution {

    /*fun firstUniqChar(s: String): Int {
        val charMapper = hashMapOf<Char, Int>()
        s.forEach {
            charMapper[it] = charMapper.getOrDefault(it, 0) + 1
        }
        s.forEachIndexed { index, item ->
            if (charMapper[item] == 1) return index
        }
        return -1
    }*/

    fun firstUniqChar(s: String): Int {
        val charMapper = IntArray(26)
        s.forEach {
            charMapper[it - 'a']++
        }
        s.forEachIndexed { index, item ->
            if (charMapper[item - 'a'] == 1) return index
        }
        return -1
    }
}