package algorithms.medium

import java.util.*

// https://leetcode.com/problems/my-calendar-i
class MyCalendarISolution {

    private val meetingMap = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        val floorKey = meetingMap.floorKey(start)
        val ceilingKey = meetingMap.ceilingKey(start)
        if ((floorKey == null || meetingMap.getOrDefault(floorKey, -1) <= start) &&
            (ceilingKey == null || end <= ceilingKey)
        ) {
            meetingMap[start] = end
            return true
        }
        return false
    }
}