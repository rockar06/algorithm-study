package algorithms.medium

// https://leetcode.com/problems/group-anagrams
class GroupAnagramsSolution {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val mapResult = hashMapOf<String, MutableList<String>>()
        strs.forEach { currentString ->
            val stringAnagramHash = mapStringToIntArray(currentString)
            if (mapResult[stringAnagramHash] == null) {
                mapResult[stringAnagramHash] = mutableListOf(currentString)
            } else {
                mapResult[stringAnagramHash]?.add(currentString)
            }
        }
        val result = mutableListOf<MutableList<String>>()

        mapResult.forEach {
            result.add(it.value)
        }

        return result
    }

    private fun mapStringToIntArray(stringToMap: String): String {
        val result = IntArray(26)
        stringToMap.forEach {
            result[it - 'a']++
        }
        return result.contentToString()
    }
}
