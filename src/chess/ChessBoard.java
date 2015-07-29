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
    
    void updateBoard(String piece, Position position){
        pieces.put(piece, position);
    }
    
    void updateReversedPieces(){
        for (Map.Entry<String, Position> piece : pieces.entrySet()) {
            reversed_pieces.put(piece.getValue(), piece.getKey());
        }
    }
    
    void printReversedPieces(){
        for (Map.Entry<Position, String> item : reversed_pieces.entrySet()) {
            System.out.println("Position: " + item.getKey().printPosition() + " Piece: " + item.getValue());
        }
    }

    void printPieces(){
        for (Map.Entry<String, Position> item : pieces.entrySet()) {
            System.out.println("Piece: " + item.getKey() + " Position: " + item.getValue().printPosition());
        }
    }    
    
    void displayBoard(){
        updateReversedPieces();
        for(int i=8; i>=1; i--){
            for(int j=1; j<=8; j++){
                Position key = new Position(i,j);
                String value = reversed_pieces.get(key);
                System.out.print(value + " ");
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