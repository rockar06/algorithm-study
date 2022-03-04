package algorithms.easy

// https://leetcode.com/problems/long-pressed-name
class LongPressedNameSolution {
    fun isLongPressedName(name: String, typed: String): Boolean {
        if (name.length > typed.length) return false
        var typedCounter = 0
        var nameCounter = 0
        while (nameCounter < name.length && typedCounter < typed.length) {
            if (name[nameCounter] == typed[typedCounter]) {
                typedCounter++
                nameCounter++
            } else if (name.getOrNull(nameCounter - 1) == typed[typedCounter]) {
                typedCounter++
            } else {
                return false
            }
        }
        if (nameCounter != name.length) {
            return false
        }
        while (typedCounter < typed.length) {
            if (name.getOrNull(nameCounter - 1) != typed[typedCounter]) {
                return false
            }
            typedCounter++
        }
        return true
    }
}
