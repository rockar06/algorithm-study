package algorithms.easy

class ReverseWordsInAStringIIISolution {

    fun reverseWords(s: String): String {
        val reverseString = reverseString(s)
        val listOfStrings = convertStringToList(reverseString)
        reverseList(listOfStrings)
        return generateString(listOfStrings)
    }

    private fun reverseString(stringToReverse: String): String {
        val stringBuilder = StringBuilder(stringToReverse)
        var leftIndex = 0
        var rightIndex = stringBuilder.length - 1
        while (leftIndex < rightIndex) {
            val temp = stringBuilder[rightIndex]
            stringBuilder[rightIndex--] = stringBuilder[leftIndex]
            stringBuilder[leftIndex++] = temp
        }
        return stringBuilder.toString()
    }

    private fun convertStringToList(stringToConvert: String): MutableList<String> {
        val stringBuilder = StringBuilder()
        val listOfStrings = mutableListOf<String>()
        stringToConvert.forEach {
            if (it != ' ') {
                stringBuilder.append(it)
            } else {
                listOfStrings.add(stringBuilder.toString())
                stringBuilder.clear()
            }
        }
        listOfStrings.add(stringBuilder.toString())
        return listOfStrings
    }

    private fun reverseList(listToReverse: MutableList<String>) {
        var leftIndex = 0
        var rightIndex = listToReverse.size - 1
        while (leftIndex < rightIndex) {
            val temp = listToReverse[rightIndex]
            listToReverse[rightIndex--] = listToReverse[leftIndex]
            listToReverse[leftIndex++] = temp
        }
    }

    private fun generateString(listOfStrings: List<String>): String {
        val resultString = StringBuilder()
        listOfStrings.forEachIndexed { index, item ->
            if (index != 0) {
                resultString.append(" ")
            }
            resultString.append(item)
        }
        return resultString.toString()
    }
}