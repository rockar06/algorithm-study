package algorithms.medium

// https://leetcode.com/problems/custom-sort-string/
class CustomSortStringSolution {

    fun customSortString(order: String, s: String): String {
        val orderMapper = hashMapOf<Char, Int>()
        val result = StringBuilder(s.length)

        s.forEach {
            orderMapper[it] = orderMapper.getOrDefault(it, 0) + 1
        }

        order.forEach {
            val repetitions = orderMapper[it] ?: 0
            for (index in 1 .. repetitions) {
                result.append(it)
            }
            orderMapper.remove(it)
        }

        s.forEach {
            if (orderMapper[it] != null) {
                result.append(it)
            }
        }

        return result.toString()
    }
}