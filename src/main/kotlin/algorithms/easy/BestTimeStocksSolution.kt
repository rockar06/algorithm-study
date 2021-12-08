package algorithms.easy

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class BestTimeStocksSolution {
    fun maxProfit(prices: IntArray): Int {
        var lowerPrice = prices.first()
        var maximumProfit = 0

        for (index in 1 until prices.size) {
            if (prices[index] <= lowerPrice && maximumProfit == 0) {
                lowerPrice = prices[index]
            } else {
                if (prices[index] - lowerPrice > maximumProfit) {
                    maximumProfit = prices[index] - lowerPrice
                }
            }
        }

        return maximumProfit
    }
}
