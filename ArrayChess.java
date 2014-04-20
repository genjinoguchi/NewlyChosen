import java.util.*;
import java.awt.Color;

public class ArrayChess{

	public ArrayChess(){
		Chess.board = new Square[Chess.numRanks][Chess.numFiles];
		resetBoard();
		setBoardColors();

	}

	public static void resetBoard(){
		for(int y=0;y<Chess.numFiles;y++){
			for(int x=0;x<Chess.numRanks;x++){
				Chess.board[y][x]=new Square();
				Chess.board[y][x].setPieceOnSquare("_");
				Chess.board[y][x].setRankFile(y, x);
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

    public static void highlightCoveredSquares(Color C){
    	//setBoardColors();

		//for each in the board:
		for(int y = 0; y < Chess.numRanks; y++){
			for(int x = 0; x < Chess.numFiles; x++){

				//check for each piece type and highlight appropriately:
				if(!Chess.board[y][x].isEmpty() && Chess.board[y][x].getPieceColor().equals(C)){
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
						highlightLinears(y,x,C);
						highlightDiagnals(y,x,C);
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Rook")){
						highlightLinears(y,x,C);
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Bishop")){
 						highlightDiagnals(y,x,C);
					}
					else if(Chess.board[y][x].getPieceOnSquare().equals("Knight")){
						try{	
							Chess.board[y+1][x+2].setColor(C);	
						}catch(Exception e){}
						try{	
							Chess.board[y+1][x-2].setColor(C);	
						}catch(Exception e){}
						try{	
							Chess.board[y-1][x+2].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y-1][x-2].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y+2][x+1].setColor(C);	
						}catch(Exception e){}
						try{		
							Chess.board[y+2][x-1].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y-2][x+1].setColor(C);
						}catch(Exception e){}
						try{		
							Chess.board[y-2][x-1].setColor(C);
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

	public static void highlightLinears(int y, int x, Color C){
		Square tempUp = Chess.board[y][x];
 		Square tempRight = Chess.board[y][x];
 		Square tempLeft = Chess.board[y][x];
 		Square tempDown = Chess.board[y][x];
 		boolean upDone = false;
 		boolean leftDone = false;
 		boolean rightDone = false;
 		boolean downDone = false;
 		while(!(upDone && downDone && rightDone && leftDone)){
 			try{
				tempUp = Chess.board[tempUp.getRank() - 1][tempUp.getFile()];
				tempUp.setColor(C);
			}catch(Exception e){
				upDone = true;
			}
			try{
				tempDown = Chess.board[tempDown.getRank() + 1][tempDown.getFile()];
				tempDown.setColor(C);
			}catch(Exception e){
				rightDone = true;
			}
			try{
				tempRight = Chess.board[tempRight.getRank()][tempRight.getFile() + 1];
				tempRight.setColor(C);
			}catch(Exception e){
				leftDone = true;
			}
			try{
				tempLeft = Chess.board[tempLeft.getRank()][tempLeft.getFile() - 1];
				tempLeft.setColor(C);
			}catch(Exception e){
				downDone = true;
			}
 		}
	}

	public static void highlightDiagnals(int y, int x, Color C){
 		Square tempUpRight = Chess.board[y][x];
 		Square tempUpLeft = Chess.board[y][x];
 		Square tempDownRight = Chess.board[y][x];
 		Square tempDownLeft = Chess.board[y][x];
 		boolean upRightDone = false;
 		boolean upLeftDone = false;
 		boolean downRightDone = false;
 		boolean downLeftDone = false;

 		while(!(upRightDone && upLeftDone && downLeftDone && downRightDone)){
			try{
				tempUpRight = Chess.board[tempUpRight.getRank() - 1][tempUpRight.getFile() + 1];
				tempUpRight.setColor(C);
			}catch(Exception e){
				upRightDone = true;
			}
			try{
				tempUpLeft = Chess.board[tempUpLeft.getRank() - 1][tempUpLeft.getFile() - 1];
				tempUpLeft.setColor(C);
			}catch(Exception e){
				upLeftDone = true;
			}
			try{
				tempDownRight = Chess.board[tempDownRight.getRank() + 1][tempDownRight.getFile() + 1];
				tempDownRight.setColor(C);
			}catch(Exception e){
				downRightDone = true;
			}
			try{
				tempDownLeft = Chess.board[tempDownLeft.getRank() + 1][tempDownLeft.getFile() - 1];
				tempDownLeft.setColor(C);
			}catch(Exception e){
				downLeftDone = true;
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