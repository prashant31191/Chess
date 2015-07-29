package chess;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChessBoard {

    Map<String,Position> pieces = new LinkedHashMap<String,Position>();
    Map<Position,String> reversed_pieces = new LinkedHashMap<Position,String>();
    
    ChessBoard(){
        pieces.put("WP1", new Position(1,2));
        pieces.put("WP2", new Position(2,2));
        pieces.put("WP3", new Position(3,2));
        pieces.put("WP4", new Position(4,2));
        pieces.put("WP5", new Position(5,2));
        pieces.put("WP6", new Position(6,2));
        pieces.put("WP7", new Position(7,2));
        pieces.put("WP8", new Position(8,2));
        pieces.put("WR1", new Position(1,1));
        pieces.put("WN1", new Position(2,1));
        pieces.put("WB1", new Position(3,1));
        pieces.put("WQ", new Position(4,1));
        pieces.put("WK", new Position(5,1));
        pieces.put("WB2", new Position(6,1));
        pieces.put("WN2", new Position(7,1));
        pieces.put("WR2", new Position(8,1));
        
        pieces.put("BP1", new Position(1,7));
        pieces.put("BP2", new Position(2,7));
        pieces.put("BP3", new Position(3,7));
        pieces.put("BP4", new Position(4,7));
        pieces.put("BP5", new Position(5,7));
        pieces.put("BP6", new Position(6,7));
        pieces.put("BP7", new Position(7,7));
        pieces.put("BP8", new Position(8,7));
        pieces.put("BR1", new Position(1,8));
        pieces.put("BN1", new Position(2,8));
        pieces.put("BB1", new Position(3,8));
        pieces.put("BQ", new Position(4,8));
        pieces.put("BK", new Position(5,8));
        pieces.put("BB2", new Position(6,8));
        pieces.put("BN2", new Position(7,8));
        pieces.put("BR2", new Position(8,8));
        
        updateReversedPieces();
    }
    
    void updatePositionOfPawn( String piece, Position oldPosition, Position newPosition){
        String[] pawns = new String[9];
        Position[] pawn_positions = new Position[9];
        for(int i=1; i<=8; i++){
            pawns[i] = piece + i;
            pawn_positions[i] = pieces.get(pawns[i]);
        }
        for(int i=1; i<=8; i++){
            if(oldPosition.equals(pawn_positions[i])){
                updateBoard(pawns[i], newPosition);
                break;
            }
        }
        
    }
    
    void updatePositionOfOthers(String piece, Position oldPosition, Position newPosition){
        String piece1 = piece + "1";
        String piece2 = piece + "2";
        Position pos1 = pieces.get(piece1);
        Position pos2 = pieces.get(piece2);
        if(pos1.equals(oldPosition)){
            updateBoard(piece1,newPosition);
        }
        else if(pos2.equals(oldPosition)){
            updateBoard(piece2, newPosition);
        }
    }
    void updateBoard(String piece, Position position){
        pieces.remove(piece);
        pieces.put(piece, position);
    }
    
    void updateBoard(String piece, Position oldPosition, Position newPosition){
        if(piece.charAt(1)== 'P'){
            updatePositionOfPawn(piece, oldPosition, newPosition);
        }
        else{
            updatePositionOfOthers(piece, oldPosition, newPosition);
        }
    }
    
    void updateReversedPieces(){
        for (Map.Entry<String, Position> piece : pieces.entrySet()) {
            reversed_pieces.put(piece.getValue(), piece.getKey());
        }
    }   
    
    void displayBoard(){
        updateReversedPieces();
        for(int i=8; i>=1; i--){
            for(int j=1; j<=8; j++){
                Position key = new Position(j,i);
                String value = reversed_pieces.get(key);
                if(value == null) value = "_";
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
    
    Position[] getPositionOfPiece(String piece){
        Position[] positions = new Position[2];
        String piece1 = piece + "1";
        String piece2 = piece + "2";
        positions[0] = pieces.get(piece1);
        positions[1] = pieces.get(piece2);
        return positions;
    }
    
}
