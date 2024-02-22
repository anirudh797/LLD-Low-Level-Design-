package org.example

import java.util.*

fun main() {
    // Creates an instance which takes input from standard input (keyboard)
    val reader = Scanner(System.`in`)
    print("Enter the boardSize: ")

    // nextInt() reads the next integer from the keyboard
    val boardSize: Int = reader.nextInt()
    var board = MutableList(boardSize) { MutableList(boardSize) { -1 } }
    val players: Deque<Player> = LinkedList();
    val player1 = Player(Piece0(), "Anirudh")
    val player2 = Player(PieceX(), "Sparsh")

    players.addAll(listOf(player1,player2))
    var isGameWon = false
    while(true){
        if(isGameWon){
            break;
        }
        val currPlayer = players.pop()
        players.addLast(currPlayer)
        printBoard(board,currPlayer)
        val reader = Scanner(System.`in`)
        println("${currPlayer?.name } Please enter row to insertPiece")
        val row = reader.nextInt()
        println("${currPlayer?.name } Please enter col to insertPiece")
        val col = reader.nextInt()
        val placePiece = placePiece(board,row,col,currPlayer)
        if(placePiece == true){
           isGameWon = checkIfWinner(board,currPlayer)
            if(isGameWon){
                println("${currPlayer.name} won the game")
            }
        }
        else{
            continue;
        }
    }

}

fun checkIfWinner(board: MutableList<MutableList<Int>>, currPlayer: Player?): Boolean {
    var horizontal = true
    var vertical = true
    var diagonal = true
    //check if horizontal matches
    for (row in 0..board.size - 1) {
        for (col in 0..board.size - 1) {
            if (board[row][col] != currPlayer?.piece?.value) {
                horizontal = false
            }
        }
    }

    //check if vertical matches
    for (row in 0..<board.size) {
        for (col in 0..<board.size) {
            if (board[col][row] != currPlayer?.piece?.value) {
                vertical = false
            }
        }
    }

    //check if diagonal 1 matches
    for (row in 0..<board.size) {
        for (col in 0..<board.size) {
            if ((row == col) && board[row][col] != currPlayer?.piece?.value) {
                diagonal = false
            }
        }
    }

    //check if diagonal 2 matches
    for (row in 0..<board.size) {
        for (col in 0..<board.size) {
            if ((row + col == board.size - 1) && board[row][col] != currPlayer?.piece?.value) {
                diagonal = false
            }
        }
    }

    return (horizontal||diagonal||vertical)
}

fun placePiece(board: MutableList<MutableList<Int>>, row: Int, col: Int,player: Player): Any {
    if(board[row][col] !=-1){
        println("Invalid input . Please try again")
        return false
    }
    board[row][col] =  player.piece.value
    return true
}

fun printBoard(board: MutableList<MutableList<Int>>, currPlayer: Player?) {

    for(row in board){
        for(piece in row){
            print("| $piece ")
        }
        println()
    }


}
