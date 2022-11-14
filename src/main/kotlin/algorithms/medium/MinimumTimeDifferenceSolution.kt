package algorithms.medium

import java.util.*

// https://leetcode.com/problems/minimum-time-difference/
class MinimumTimeDifferenceSolution {

    fun findMinDifference(timePoints: List<String>): Int {
        Collections.sort(timePoints)
        val lastIndex = timePoints.size - 1
        var counter = 1
        var minimumDifference: Int = Int.MAX_VALUE
        while (counter < timePoints.size) {
            val result =
                Math.abs(convertStringToMinutes(timePoints[counter]) - convertStringToMinutes(timePoints[counter - 1]))
            minimumDifference = Math.min(minimumDifference, result)
            counter++
        }
        val result =
            Math.abs(convertStringToMinutes(timePoints[counter - 1]) - convertStringToMinutes(timePoints.first(), true))
        minimumDifference = Math.min(minimumDifference, result)
        return minimumDifference
    }

    private fun convertStringToMinutes(valueToConvert: String, shouldAddTime: Boolean = false): Int {
        val (stringHours, stringMinutes) = valueToConvert.split(":")
        val hours = (if (shouldAddTime) (24 + stringHours.toInt()) else stringHours.toInt()) * 60
        val minutes = stringMinutes.toInt()
        return hours + minutes
    }
}