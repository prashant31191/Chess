# Chess

<h2> Problem Statement </h2>
Given a list of chess moves in PGN notation, display the final status of the chess board.

<h2> Approach </h2>
1. Pawn: The pawn on the given column moved. If a pawn is killing, the pawn on the previous column has moved. <br>
2. Rook: The rook on the given column moved. Logic doesn't change for a rook killing something else. <br>
3. Knight: Determine all the possible position the knight could have been and identify the correct knight. <br>
4. Bishop: Move diagonally in all directions to find the previous position of the bishop that moved. <br>
5. Queen: There is only one queen, no identification required. <br>
6. King: There is only one king, no identification required. <br>

API's Exposed:
1. Chessboard           - Jaipradha
    updateBoard()
    displayBoaard()
2. Moves                - Mohanish
    makeMove()
    identifyUpdatePosition()
3. Rules                - Mayank
    identifyPiece()
4. Wrapper Main method
