package org.example

open class Piece(val pieceTye: PieceType) {

    var value: Int = -1;

    init {

        value = when (pieceTye) {
            PieceType.Piece0 -> 0
            else -> 1
        }
    }
}