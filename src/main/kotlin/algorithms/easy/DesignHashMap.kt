package algorithms.easy

import java.util.*

// https://leetcode.com/problems/design-hashmap
class MyHashMap() {

    private val keySpace = 2048
    private val hashTable = Array(keySpace) { Bucket() }

    fun put(key: Int, value: Int) {
        val hashIndex = key % keySpace
        hashTable[hashIndex].put(key, value)
    }

    fun get(key: Int): Int {
        val hashIndex = key % keySpace
        return hashTable[hashIndex].get(key)
    }

    fun remove(key: Int) {
        val hashIndex = key % keySpace
        hashTable[hashIndex].remove(key)
    }
}

class Bucket {

    private val bucket = LinkedList<Pair<Int, Int>>()

    fun get(key: Int): Int {
        bucket.forEach { pair ->
            if (pair.first == key) {
                return pair.second
            }
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        var keyFound = false
        bucket.forEachIndexed { index, pair ->
            if (pair.first == key) {
                bucket[index] = pair.copy(second = value)
                keyFound = true
            }
        }
        if (!keyFound) {
            bucket.add(Pair(key, value))
        }
    }

    fun remove(key: Int) {
        for (pair in bucket) {
            if (pair.first == key) {
                bucket.remove(pair)
                break
            }
        }
    }
}