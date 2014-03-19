import java.util.*;
import java.awt.Color;

public class ArrayChess{

	public ArrayChess(){
		Chess.board = new Square[Chess.numRanks][Chess.numFiles];
		resetBoard();
		setBoardColors();

	}

	public void resetBoard(){
		for(int y=0;y<Chess.board.length;y++){
			for(int x=0;x<Chess.board[0].length;x++){
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
				    Chess.board[x][y].setColor(Color.BLACK);
				}else{
				    Chess.board[x][y].setColor(Color.WHITE);
				}
				isDark = !isDark;
		    }
		    oddLine = !oddLine;
		}
    }

	public String toString(){
		String total = "";
		for(int y=0;y<Chess.board.length;y++){
			for(int x=0;x<Chess.board[0].length;x++){
				total+=Chess.board[y][x] + " ";
			}
			total+="\n";
		}
		return total;
	}

}