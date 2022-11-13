package algorithms.medium

import java.util.*

// https://leetcode.com/problems/meeting-rooms-ii
class MeetingRoomsIISolution {

    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        intervals.sortBy { it.first() }
        val meetingPriorityQueue = PriorityQueue<IntArray> { valueA, valueB ->
            valueA.last() - valueB.last()
        }
        intervals.forEachIndexed { index, value ->
            if (index > 0 && meetingPriorityQueue.peek().last() < value.first()) {
                meetingPriorityQueue.poll()
            }
            meetingPriorityQueue.add(value)
        }
        return meetingPriorityQueue.size
    }
}
