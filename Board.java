import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Board extends JFrame{
	private static Container background;
	private static BoardPanel bp;

	public Board(){
		super("Chess");
		setSize(Chess.numFiles*Chess.squareLength, Chess.numRanks*Chess.squareLength+29);
		setLocation(50,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		background = getContentPane();

		bp = new BoardPanel();
		background.add(bp);
		bp.repaint();

	}

	public void actionPerformed(ActionEvent e){

	}

	private class BoardPanel extends JPanel implements MouseListener, MouseMotionListener{
		boolean isDark = true;
		boolean oddLine = false;
		private int mouseX, mouseY;

		public BoardPanel(){
			super();
			setLayout(new GridLayout(Chess.numRanks, Chess.numFiles));
			addMouseMotionListener(this);
			addMouseListener(this);
		}

		public void placePiece(Image i){

		}

		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			
			g2.setColor(Color.white);
			
			g2.fillRect(0,0,Chess.squareLength*Chess.numFiles,Chess.squareLength*Chess.numRanks);
			for(int y=0;y<Chess.numFiles;y++){
				for(int x=0;x<Chess.numRanks;x++){
					if(Chess.board[y][x].getColor()==Color.black){
						g2.setColor(Color.black);
						g2.fillRect(x*Chess.squareLength,y*Chess.squareLength,Chess.squareLength,Chess.squareLength);
						g2.drawString(Chess.board.toString(),x*Chess.squareLength,y*Chess.squareLength);
					}
				}
			}
			/*
			for(int y=0;y<Chess.numFiles;y++){
				for(int x=0;x<Chess.numRanks;x++){
					g2.setColor(Chess.board[y][x].getColor());
					g2.fillRect(Chess.board[y][x].getX(),Chess.board[y][x].getY(),Chess.squareLength,Chess.squareLength);
				}
			}
			*/
			
			g2.drawImage(Chess.blackKing,mouseX-25, mouseY-25, this);	
		}

		public void mousePressed(MouseEvent e){

		}
		public void mouseReleased(MouseEvent e){

		}
		public void mouseEntered(MouseEvent e){

		}
		public void mouseExited(MouseEvent e){

		}
		public void mouseClicked(MouseEvent e){

		}
		public void mouseMoved(MouseEvent e){
			mouseX = e.getX();
			mouseY = e.getY();
			System.out.println(mouseX + " " + mouseY);
			this.repaint();
		}
		public void mouseDragged(MouseEvent e){
			
		}



	}

}