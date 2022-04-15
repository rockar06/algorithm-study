package algorithms.medium

import java.util.*

// https://leetcode.com/problems/top-k-frequent-elements/
class TopKFrequentElementsSolution {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numberFrequentMap = hashMapOf<Int, Int>()
        val queueTopFrequent = PriorityQueue<Pair<Int, Int>> { itemA, itemB ->
            itemA.second - itemB.second
        }
        nums.forEach {
            numberFrequentMap[it] = numberFrequentMap.getOrDefault(it, 0) + 1
        }
        numberFrequentMap.entries.forEach {
            queueTopFrequent.add(Pair(it.key, it.value))
            if (queueTopFrequent.size > k) {
                queueTopFrequent.poll()
            }
        }
        return queueTopFrequent.map {
            it.first
        }.toIntArray()
    }
}