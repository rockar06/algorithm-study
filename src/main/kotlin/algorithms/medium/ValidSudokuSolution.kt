package algorithms.medium

// https://leetcode.com/problems/valid-sudoku/
class ValidSudokuSolution {

    /*fun isValidSudoku(board: Array<CharArray>): Boolean {
        board.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { index, char ->
                if (char != '.') {
                    if (validateRowRepetition(char, index + 1, row) ||
                        validateColumnRepetition(char, index, board, rowIndex + 1)
                    ) {
                        return false
                    }
                }
            }
        }

        for (rowIndex in 0 until 9 step 3) {
            for (columnIndex in 0 until 9 step 3) {
                val charMapper = HashMap<Char, Boolean>()
                for (nestedRowIndex in rowIndex until (rowIndex + 3)) {
                    for (nestedColumnIndex in columnIndex until (columnIndex + 3)) {
                        if (board[nestedRowIndex][nestedColumnIndex] != '.') {
                            if (charMapper.getOrDefault(board[nestedRowIndex][nestedColumnIndex], false)) {
                                return false
                            } else {
                                charMapper[board[nestedRowIndex][nestedColumnIndex]] = true
                            }
                        }
                    }
                }
            }
        }
        return true
    }

    private fun validateRowRepetition(char: Char, index: Int, row: CharArray): Boolean {
        for (currentIndex in index until row.size) {
            if (char == row[currentIndex]) return true
        }
        return false
    }

    private fun validateColumnRepetition(char: Char, itemIndex: Int, board: Array<CharArray>, rowIndex: Int): Boolean {
        for (currentIndex in rowIndex until board.size) {
            if (char == board[currentIndex][itemIndex]) return true
        }
        return false
    }*/

    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rows = Array(9) {
            HashSet<Char>()
        }
        val columns = Array(9) {
            HashSet<Char>()
        }
        val boxes = Array(9) {
            HashSet<Char>()
        }

        for (rowIndex in 0 until 9) {
            for (columnIndex in 0 until 9) {
                val currentValue = board[rowIndex][columnIndex]

                if (currentValue == '.') {
                    continue
                }

                if (rows[rowIndex].contains(currentValue)) {
                    return false
                }
                rows[rowIndex].add(currentValue)

                if (columns[columnIndex].contains(currentValue)) {
                    return false
                }
                columns[columnIndex].add(currentValue)

                val boxIndex = (rowIndex / 3) * 3 + columnIndex / 3
                if (boxes[boxIndex].contains(currentValue)) {
                    return false
                }
                boxes[boxIndex].add(currentValue)
            }
        }

        return true
    }
}