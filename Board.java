import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame implements ActionListener{
	private static Container background;
	private static BoardPanel bp;
	private static int height, length,squareLength;	//Height and length in squares

	public Board(int length, int height, int squareLength){
		this.height = height;
		this.length = length;
		this.squareLength = squareLength;

		super("Chess");
		setSize(height*squareLength, length*squareLength);
		setLocation(50,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);

		background = getContentPane();

		bp = new BoardPanel();
		background.add(bp);
		bp.repaint();
	}

	public void actionPerformed(ActionEvent e){

	}

	private class BoardPanel extends JPanel{
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
}