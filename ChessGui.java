import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessGui{
	private JFrame frame;
	private static Container background;
	private static int height, width;
	private static BoardPanel b;

	public ChessGui(int L, int h){
		frame = new JFrame("Chess");
		height = h;
		width = L;
		frame.setSize(height*Chess.squareLength, width*Chess.squareLength);
		frame.setLocation(50,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		background = frame.getContentPane();
		frame.setLayout(new GridLayout());

		b = new BoardPanel();
		background.add(b);
		b.repaint();

		addIcon("blackQueen.png", 3, 3);
	}

	public void addIcon(String filename, int x, int y){
		try{
			Chess.board[y][x].setIcon(new ImageIcon(filename));
		}catch(Exception e){}
	}


	private class BoardPanel extends JPanel{
		boolean isDark = true;
		boolean oddLine = false;

		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			
			for(int y=0;y<Chess.numFiles;y++){
				for(int x=0;x<Chess.numRanks;x++){
					System.out.println(Chess.board[y][x].getColor());
					g2.setColor(Chess.board[y][x].getColor());
					g2.fillRect(x*Chess.squareLength,y*Chess.squareLength,(x+1)*Chess.squareLength,(y+1)*Chess.squareLength);

				}
			}		
			
		}
	}
}