package algorithms.easy

// https://leetcode.com/problems/richest-customer-wealth
class RichestCustomerWealthSolution {

    fun maximumWealth(accounts: Array<IntArray>): Int {
        var result = 0

        for (element in accounts) {
            var wealth = 0
            for (bankWealth in element) {
                wealth += bankWealth
            }
            result = maxOf(result, wealth)
        }

        return result
    }
}