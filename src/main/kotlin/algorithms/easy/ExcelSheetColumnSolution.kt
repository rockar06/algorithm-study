package algorithms.easy

// https://leetcode.com/problems/excel-sheet-column-title/submissions/
class ExcelSheetColumnSolution {

    private val alphabetMap: HashMap<Int, Char> = hashMapOf(
        1 to 'A',
        2 to 'B',
        3 to 'C',
        4 to 'D',
        5 to 'E',
        6 to 'F',
        7 to 'G',
        8 to 'H',
        9 to 'I',
        10 to 'J',
        11 to 'K',
        12 to 'L',
        13 to 'M',
        14 to 'N',
        15 to 'O',
        16 to 'P',
        17 to 'Q',
        18 to 'R',
        19 to 'S',
        20 to 'T',
        21 to 'U',
        22 to 'V',
        23 to 'W',
        24 to 'X',
        25 to 'Y',
        26 to 'Z'
    )

    fun convertToTitle(columnNumber: Int): String {
        if (columnNumber in 1..26) {
            return alphabetMap[columnNumber].toString()
        }
        var tempNumberA = 0
        var tempNumberB = 0
        if (columnNumber % 26 == 0) {
            tempNumberA = (columnNumber / 26) - 1
            tempNumberB = 26
        } else {
            tempNumberA = columnNumber / 26
            tempNumberB = columnNumber % 26
        }
        return convertToTitle(tempNumberA) + convertToTitle(tempNumberB)
    }
}