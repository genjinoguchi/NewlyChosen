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
						try{	
							Chess.board[y][x+1].setColor(C);	
						}catch(Exception e){}
						try{	
							Chess.board[y][x-1].setColor(C);	
						}catch(Exception e){}
						try{	
							Chess.board[y-1][x].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y+1][x].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y+1][x+1].setColor(C);	
						}catch(Exception e){}
						try{		
							Chess.board[y-1][x+1].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y+1][x-1].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y-1][x-1].setColor(C);
						}catch(Exception e){}
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Queen")){
 						highlightLinears(y,x);
 						highlightDiagnals(y,x);
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Rook")){
						highlightLinears(y,x);
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Bishop")){
 						highlightDiagnals(y,x);
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Knight")){
						try{	
							Chess.board[y][x+1].setColor(C);	
						}catch(Exception e){}
						try{	
							Chess.board[y][x-1].setColor(C);	
						}catch(Exception e){}
						try{	
							Chess.board[y-1][x].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y+1][x].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y+1][x+1].setColor(C);	
						}catch(Exception e){}
						try{		
							Chess.board[y-1][x+1].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y+1][x-1].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y-1][x-1].setColor(C);
						}catch(Exception e){}
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Pawn")){
						try{		
							Chess.board[y+1][x+1].setColor(C);	
						}catch(Exception e){}
						try{		
							Chess.board[y-1][x+1].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y+1][x-1].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y-1][x-1].setColor(C);
						}catch(Exception e){}
					}

				}
			}
		}
	}

	public void highlightLinears(int y, int x){
		Square tempUp = Chess.board[y][x];
 		Square tempRight = Chess.board[y][x];
 		Square tempLeft = Chess.board[y][x];
 		Square tempDown = Chess.board[y][x];
 		while(true){
 			try{
				tempUp = Chess.board[tempUp.getRank() - 1][tempUp.getFile()];
				tempUp.setColor(C);
			}catch(Exception e){}
			try{
				tempDown = Chess.board[tempDown.getRank() + 1][tempDown.getFile()];
				tempDown.setColor(C);
			}catch(Exception e){}
			try{
				tempRight = Chess.board[tempRight.getRank()][tempRight.getFile() + 1];
				tempRight.setColor(C);
			}catch(Exception e){}
			try{
				tempLeft = Chess.board[tempLeft.getRank()][tempLeft.getFile() - 1];
				tempLeft.setColor(C);
			}catch(Exception e){}
 		}
	}

	public void highlightDiagnals(int y, int x){
 		Square tempUpRight = Chess.board[y][x];
 		Square tempUpLeft = Chess.board[y][x];
 		Square tempDownRight = Chess.board[y][x];
 		Square tempDownLeft = Chess.board[y][x];
 		while(true){
			try{
				tempUpRight = Chess.board[tempUpRight.getRank() - 1][tempUpRight.getFile() + 1];
				tempUpRight.setColor(C);
			}catch(Exception e){}
			try{
				tempUpLeft = Chess.board[tempUpLeft.getRank() - 1][tempUpLeft.getFile() - 1];
				tempUpLeft.setColor(C);
			}catch(Exception e){}
			try{
				tempDownRight = Chess.board[tempDownRight.getRank() + 1][tempDownRight.getFile() + 1];
				tempDownRight.setColor(C);
			}catch(Exception e){}
			try{
				tempDownLeft = Chess.board[tempDownLeft.getRank() + 1][tempDownLeft.getFile() - 1];
				tempDownLeft.setColor(C);
			}catch(Exception e){}
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