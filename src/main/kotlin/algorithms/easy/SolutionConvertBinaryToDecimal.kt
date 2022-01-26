package algorithms.easy

import algorithms.common.ListNode

class SolutionConvertBinaryToDecimal {

    private val defaultValue = 0
    private var powNumber = 0

    fun getDecimalValue(head: ListNode?): Int {
        return head?.next?.let {
            val previousSum = getDecimalValue(it)
            (previousSum + timesValue(head.value))
        } ?: timesValue(head?.value ?: defaultValue)
    }

    private fun timesValue(value: Int): Int {
        return value.times(powerBaseNumber())
    }

    private fun powerBaseNumber(): Int {
        val result = powNumber * powNumber
        powNumber++
        return result
    }
}