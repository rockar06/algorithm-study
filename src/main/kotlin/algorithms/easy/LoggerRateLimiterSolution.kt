package algorithms.easy

// https://leetcode.com/problems/logger-rate-limiter/
class Logger() {

    private val loggerMap = hashMapOf<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (timestamp >= loggerMap.getOrDefault(message, 0)) {
            loggerMap[message] = timestamp + 10
            return true
        }
        return false
    }
}