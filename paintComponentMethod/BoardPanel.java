import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class BoardPanel extends JPanel{
	boolean isDark = true;
	boolean oddLine = false;

	public BoardPanel(){
		super();
		setLayout(new GridLayout(Chess.numRanks, Chess.numFiles));
	}
	
	public void layoutSquares(){
		for(int y= 0;y<Chess.numRanks;y++){
			for(int x=0;x<Chess.numFiles;x++){
				
			}
		}
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		
		for(int y=0;y<Chess.numFiles;y++){
			for(int x=0;x<Chess.numRanks;x++){
				g2.setColor(Chess.board[y][x].getColor());
				g2.fillRect(x*Chess.squareLength,y*Chess.squareLength,Chess.squareLength,Chess.squareLength);
				
			}
		}		
	}
}