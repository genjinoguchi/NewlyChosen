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
				    Chess.board[y][x].setBackground(Color.BLACK);
				}else{
				    Chess.board[y][x].setBackground(Color.WHITE);
				}
				isDark = !isDark;
		    }
		    oddLine = !oddLine;
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