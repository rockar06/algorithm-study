package algorithms.easy

import algorithms.common.ListNode

object SolutionConvertBinaryToDecimal {

    private const val DEFAULT_VALUE = 0
    private const val BASE_TWO = 2.toFloat()

    private var powNumber = 0

    fun getDecimalValue(head: ListNode?): Int {
        return head?.next?.let {
            val previousSum = getDecimalValue(it)
            (previousSum + timesValue(head.value))
        } ?: timesValue(head?.value ?: DEFAULT_VALUE)
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