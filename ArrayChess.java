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
				Chess.board[y][x].setRankFile(y,x);
			}
		}
	}

    public static void setBoardColors(){
        boolean isDark = true;
		boolean oddLine = true;
	    for(int y = 0; y < Chess.numRanks; y++){
			for(int x = 0; x < Chess.numFiles; x++){
				if(isDark==oddLine){
				    Chess.board[y][x].absoluteSetColor(Color.BLACK);
				}else{
				    Chess.board[y][x].absoluteSetColor(Color.WHITE);
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
 		while(!upDone){
 			try{
				tempUp = Chess.board[tempUp.getRank() - 1][tempUp.getFile()];
				tempUp.setColor(C);
				if(!tempUp.isEmpty()){
					upDone = true;
				}
			}catch(Exception e){
				upDone = true;
			}
		}
 		while(!downDone){
			try{
				tempDown = Chess.board[tempDown.getRank() + 1][tempDown.getFile()];
				tempDown.setColor(C);
				if(!tempDown.isEmpty()){
					downDone = true;
				}
			}catch(Exception e){
				downDone = true;
			}
		}
 		while(!rightDone){
 			try{
				tempRight = Chess.board[tempRight.getRank()][tempRight.getFile() + 1];
				tempRight.setColor(C);
				if(!tempRight.isEmpty()){
					rightDone = true;
				}
			}catch(Exception e){
				rightDone = true;
			}
		}
 		while(!leftDone){
			try{
				tempLeft = Chess.board[tempLeft.getRank()][tempLeft.getFile() - 1];
				tempLeft.setColor(C);
				if(!tempLeft.isEmpty()){
					leftDone = true;
				}
			}catch(Exception e){
				leftDone = true;
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

 		while(!upRightDone){
			try{
				tempUpRight = Chess.board[tempUpRight.getRank() - 1][tempUpRight.getFile() + 1];
				tempUpRight.setColor(C);
				if(!tempUpRight.isEmpty()){
					upRightDone = true;
				}
			}catch(Exception e){
				upRightDone = true;
				//e.printStackTrace();
			}
		}
		while(!upLeftDone){
			try{
				tempUpLeft = Chess.board[tempUpLeft.getRank() - 1][tempUpLeft.getFile() - 1];
				tempUpLeft.setColor(C);
				if(!tempUpLeft.isEmpty()){
					upLeftDone = true;
				}
			}catch(Exception e){
				upLeftDone = true;
				//e.printStackTrace();
			}
		}
		while(!downRightDone){
			try{
				tempDownRight = Chess.board[tempDownRight.getRank() + 1][tempDownRight.getFile() + 1];
				tempDownRight.setColor(C);
				if(!tempDownRight.isEmpty()){
					downRightDone = true;
				}
			}catch(Exception e){
				downRightDone = true;
				//e.printStackTrace();

			}
		}
		while(!downLeftDone){
			try{
				tempDownLeft = Chess.board[tempDownLeft.getRank() + 1][tempDownLeft.getFile() - 1];
				tempDownLeft.setColor(C);
				if(!tempDownLeft.isEmpty()){
					downLeftDone = true;
				}
			}catch(Exception e){
				downLeftDone = true;
				//e.printStackTrace();
			}
		}
	}

	public static String printString(){
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