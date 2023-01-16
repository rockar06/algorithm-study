package algorithms.medium

// https://leetcode.com/problems/group-shifted-strings
class GroupShiftedStringsSolution {

    fun groupStrings(strings: Array<String>): List<List<String>> {
        val hashMapOfAnagrams = hashMapOf<String, MutableList<String>>()
        strings.forEach {
            val hashKey = getHash(it)
            if (hashMapOfAnagrams[hashKey] == null) {
                hashMapOfAnagrams[hashKey] = mutableListOf(it)
            } else {
                hashMapOfAnagrams[hashKey]?.add(it)
            }
        }

        return hashMapOfAnagrams.map {
            it.value
        }
    }

    private fun getHash(currentString: String): String {
        val chars = currentString.toCharArray()
        val hashKey = StringBuilder()

        for (index in 1 until currentString.length) {
            hashKey.append(((chars[index] - chars[index - 1] + 26) % 26 + 'a'.toInt()).toChar())
        }

        return hashKey.toString()
    }
}