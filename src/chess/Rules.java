package chess;

/**
 * Created by test on 7/29/2015.
 */
public class Rules {

    private int [] knightXMove = {  2, 1, -1, -2, -2, -1,  1,  2 };
    private int [] knightYMove= {  1, 2,  2,  1, -1, -2, -2, -1 };

    public Position identifyPiece(String piece, Position candidate1, Position candidate2, Position newPosition) {

        switch(piece.trim()) {
            case "B":
                if(bishopMoveValid(candidate1, newPosition)) {
                    return candidate1;
                }
                return candidate2;

            case "R":
                if(rookMoveValid(candidate1, newPosition)) {
                    return candidate1;
                }
                return candidate2;

            case "N":
                if(knightMoveValid(candidate1, newPosition)) {
                    return candidate1;
                }
                return candidate2;

            default:
                return newPosition;
        }
    }

    private boolean bishopMoveValid(Position oldPosition, Position newPosition) {
        if (Math.abs(oldPosition.getX()-newPosition.getX()) == Math.abs(oldPosition.getY()-newPosition.getY())){
            return true;
        }
        return false;
    }

    private boolean rookMoveValid(Position oldPosition, Position newPosition) {
        if (oldPosition.getX() == newPosition.getX() || oldPosition.getY() == newPosition.getY()){
            return true;
        }
        return false;
    }

    private boolean knightMoveValid(Position oldPosition, Position newPosition) {
        for (int i=0; i<8; i++) {
            Position possiblePosition = new Position(oldPosition.getX()+knightXMove[i], oldPosition.getY()+knightYMove[i]);
            if(newPosition.equals(possiblePosition)) {
                return true;
            }
        }
        return false;
    }

}
