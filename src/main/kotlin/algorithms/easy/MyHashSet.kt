package algorithms.easy

import java.util.*

// https://leetcode.com/problems/design-hashset
class MyHashSet() {

    private val keyRange = 769
    private val bucketArray = Array(keyRange) {
        BucketSet()
    }

    private fun hash(key: Int) : Int {
        return key % keyRange
    }

    fun add(key: Int) {
        val bucketIndex = hash(key)
        bucketArray[bucketIndex].insert(key)
    }

    fun remove(key: Int) {
        val bucketIndex = hash(key)
        bucketArray[bucketIndex].delete(key)
    }

    fun contains(key: Int): Boolean {
        val bucketIndex = hash(key)
        return bucketArray[bucketIndex].exists(key)
    }
}

class BucketSet {

    private val container = LinkedList<Int>()

    fun insert(key: Int) {
        val index = container.indexOf(key)
        if (index == -1) {
            container.addFirst(key)
        }
    }

    fun delete(key: Int) {
        container.remove(key)
    }

    fun exists(key: Int): Boolean {
        return container.indexOf(key) != -1
    }
}