package chess;

import java.util.*;

public class Moves {
	
	private Position currentPosition;
	private Position candidatePosition1;
	private Position candidatePosition2;
	private String player;
	private String piece;
	
	
	
	Moves(){
		player = "W";
		piece = "P";
		currentPosition = new Position(0, 0);
		candidatePosition1 = new Position(0, 0);
		candidatePosition2 =  new Position(0, 0);
	}
	
	//Put this in main or in wrapper
	public String[] separateMoves(String currentMoves){
		String[] moves = currentMoves.split(" ");
		return moves;
	}
	
	//Main function.
	public void playMove(String move){
		
		currentPosition.setY(move.charAt(move.length()-1) - '0');
		currentPosition.setX(move.charAt(move.length()-2) - 'a' + 1);
		
		if(move.length() == 2){ //Play pawn move.
			//updateBoard(player + "P" + currentPosition.getX(), currentPosition);
			System.out.println("Pawn");
		}
		else if(move.length() == 3){
			piece = "" + move.charAt(move.length()-3);
			
			if(piece.equals("Q") || piece.equals("K")){
				//updateBoard(player + piece, currentPosition);
				System.out.println("direct");
			}
			else if(piece.equals("R") || piece.equals("B") || piece.equals("N")){
				//getPositionOfPiece(player + piece);
				System.out.println("indirect");
			}
		}
		
		//System.out.println(piece + " " + currentPosition.getX() + " " + currentPosition.getY());
	}
	

}
