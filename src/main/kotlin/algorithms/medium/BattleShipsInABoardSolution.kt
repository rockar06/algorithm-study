package algorithms.medium

// https://leetcode.com/problems/battleships-in-a-board/
class BattleShipsInABoardSolution {

    fun countBattleships(board: Array<CharArray>): Int {
        var battleShipsCounter = 0

        board.forEachIndexed { verticalIndex, boardRows ->
            boardRows.forEachIndexed { horizontalIndex, ship ->
                if (ship == 'X' && boardRows.getOrElse(horizontalIndex - 1) { '.' } != 'X' &&
                            board.getOrElse(verticalIndex - 1) { CharArray(boardRows.size) { '.' } }[horizontalIndex] != 'X') {
                    battleShipsCounter++
                }
            }
        }
        return battleShipsCounter
    }
}