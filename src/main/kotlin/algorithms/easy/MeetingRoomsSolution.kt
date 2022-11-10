package algorithms.easy

// https://leetcode.com/problems/meeting-rooms/
class MeetingRoomsSolution {

    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        intervals.sortBy {
            it.first()
        }
        intervals.forEachIndexed { index, array ->
            if (index > 0 && array.last() > intervals[index - 1].first() ) {
                return false
            }
        }
        return true
    }
}