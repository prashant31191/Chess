package chess;

import java.util.*;

public class Moves {
	
	private Position currentPosition;
	private Position candidatePosition1;
	private Position candidatePosition2;
	private String player;
	private String piece;
	private ChessBoard chessBoard;
	private Rules rules;
	
	Moves(){
		player = "W";
		piece = "P";
		rules = new Rules();
		chessBoard = new ChessBoard();
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
			chessBoard.updateBoard(player + "P" + currentPosition.getX(), currentPosition);
			System.out.println("Pawn");
		}
		else if(move.length() == 3){ //Play normal Move
			piece = "" + move.charAt(move.length()-3);
			
			if(piece.equals("Q") || piece.equals("K")){
				chessBoard.updateBoard(player + piece, currentPosition);
				//System.out.println("direct");
			}
			else if(piece.equals("R") || piece.equals("B") || piece.equals("N")){
				Position []candidates = chessBoard.getPositionOfPiece(player + piece);
				candidatePosition1 = candidates[0];
				candidatePosition2= candidates[1];
				
				candidates[0] = rules.identifyPiece(piece, candidatePosition1, candidatePosition2, currentPosition);
				System.out.println(""+ candidates[0]);
			}
		}
		
		else if(move.length() == 4){
			//chessBoard.pieces.get("");
		}
		//System.out.println(piece + " " + currentPosition.getX() + " " + currentPosition.getY());
	}
	

}
