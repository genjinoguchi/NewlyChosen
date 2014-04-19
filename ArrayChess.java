import java.util.*;
import java.awt.Color;

public class ArrayChess{

	public ArrayChess(){
		Chess.board = new Square[Chess.numRanks][Chess.numFiles];
		resetBoard();
		setBoardColors();

	}

	public void resetBoard(){
		for(int y=0;y<Chess.numFiles;y++){
			for(int x=0;x<Chess.numRanks;x++){
				Chess.board[y][x]=new Square();
				Chess.board[y][x].setPiece("_");
			}
		}
	}

    public static void setBoardColors(){
        boolean isDark = true;
		boolean oddLine = true;
	    for(int y = 0; y < Chess.numRanks; y++){
			for(int x = 0; x < Chess.numFiles; x++){
				if(isDark==oddLine){
				    Chess.board[y][x].setColor(Color.BLACK);
				}else{
				    Chess.board[y][x].setColor(Color.WHITE);
				}
				isDark = !isDark;
		    }
		    oddLine = !oddLine;
		}
    }

    public void highlightCoveredSquares(String color){
		//Establish highlight color	
    	if(color.equals("Red")){
	    	Color C = COLOR.Red;
    	}else{
	    	Color C = COLOR.Blue;
	   	}

		//for each in the board:
		for(int y = 0; y < Chess.numRanks; y++){
			for(int x = 0; x < Chess.numFiles; x++){

				//check for each piece type and highlight appropriately:
				if(!Chess.board[y][x].isEmpty() && Chess.board[y][x].getPieceColor().equals(color)){
					if(Chess.board[y][x].getPieceOnSquare().equals("King")){
						Chess.board[y][x].setColor(C);	
						Chess.board[y][x].setColor(C);	
						Chess.board[y][x].setColor(C);
						Chess.board[y][x].setColor(C);
						Chess.board[y][x].setColor(C);	
						Chess.board[y][x].setColor(C);																
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Queen")){
 
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Rook")){

					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Bishop")){

					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Knight")){

					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Pawn")){

					}

				}
			}
		}
	}

	public String toString(){
		String total = "";
		for(int y=0;y<Chess.numFiles;y++){
			for(int x=0;x<Chess.numRanks;x++){
				total+=Chess.board[y][x] + " ";
			}
			total+="\n";
		}
		return total;
	}

}