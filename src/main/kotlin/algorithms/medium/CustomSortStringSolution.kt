package algorithms.medium

// https://leetcode.com/problems/custom-sort-string/
class CustomSortStringSolution {

    fun customSortString(order: String, s: String): String {
        val characterMapper = hashMapOf<Char, Int>()
        val resultStringBuilder = StringBuilder(s.length)
        s.forEach {
            characterMapper[it] = characterMapper.getOrDefault(it, 0) + 1
        }
        order.forEach {
            if (characterMapper[it] != null) {
                for (index in 0 until characterMapper.getOrDefault(it, 0)) {
                    resultStringBuilder.append(it)
                }
                characterMapper.remove(it)
            }
        }

        characterMapper.entries.forEach {
            for (index in 0 until it.value) {
                resultStringBuilder.append(it.key)
            }
        }
        return resultStringBuilder.toString()
    }
}