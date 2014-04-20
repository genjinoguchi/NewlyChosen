import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class Board extends JFrame{
	private static Container background;
	private static BoardPanel bp;
	int timeStart = (int)System.currentTimeMillis();
	int counter = 0;

	public Board(){
		super("Chess");
		setSize(Chess.numFiles*Chess.squareLength, Chess.numRanks*Chess.squareLength+0);
		setLocation(50,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		background = getContentPane();

		bp = new BoardPanel();
		background.add(bp);
		bp.repaint();

	}

	public void placePiece(int x, int y, String type, Color C, Image i){
		if(Chess.board[y][x].isEmpty()){
			Chess.board[y][x].setPieceOnSquare(type);
			Chess.board[y][x].setPieceColor(C);
			Chess.board[y][x].setFace(i);
			Chess.board[y][x].setPieceHere(true);
		}
	}	

	private class BoardPanel extends JPanel implements MouseListener,MouseMotionListener{
		private boolean isDark = true;
		private boolean oddLine = false;
		private int mouseX, mouseY;
		private int squareX, squareY;
		private int counter;

		public BoardPanel(){
			super();
			setLayout(new GridLayout(Chess.numRanks, Chess.numFiles));
			addMouseMotionListener(this);
			addMouseListener(this);
		}

		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			
			g2.setColor(Color.white);
			
			g2.fillRect(0,0,Chess.squareLength*Chess.numFiles,Chess.squareLength*Chess.numRanks);
			for(int y=0;y<Chess.numFiles;y++){
				for(int x=0;x<Chess.numRanks;x++){
					if(Chess.board[y][x].getMouseHere()){
						g2.setColor(Color.blue);
						g2.fillRect(x*Chess.squareLength,y*Chess.squareLength,Chess.squareLength,Chess.squareLength);
						g2.drawImage(Chess.whiteQueen,x*Chess.squareLength-Chess.squareLength/2+3,y*Chess.squareLength-Chess.squareLength/2+5,this);
					}else{
						g2.setColor(Chess.board[y][x].getColor());
						g2.fillRect(x*Chess.squareLength,y*Chess.squareLength,Chess.squareLength,Chess.squareLength);

					}

					if(!Chess.board[y][x].isEmpty()){
						g2.drawImage(Chess.board[y][x].getFace(),x*Chess.squareLength-Chess.squareLength/2+5,y*Chess.squareLength-Chess.squareLength/2+5,this);
					}
				}
			}
			squareY = (int)mouseY / Chess.squareLength;
			squareX = (int)mouseX / Chess.squareLength;
			Chess.board[squareY][squareX].setMouseHere();

		}

		public void mousePressed(MouseEvent e){

		}
		public void mouseReleased(MouseEvent e){
			switch(counter%12){
				case 1:
				placePiece(squareX, squareY, "King", Color.red, Chess.blackKing);
				break;
				case 2:
				placePiece(squareX, squareY, "Queen", Color.red, Chess.blackQueen);
				break;
				case 3:
				placePiece(squareX, squareY, "Rook", Color.red, Chess.blackRook);
				break;
				case 4:
				placePiece(squareX, squareY, "Knight", Color.red, Chess.blackKnight);
				break;
				case 5:
				placePiece(squareX, squareY, "Bishop", Color.red, Chess.blackBishop);
				break;
				case 6:
				placePiece(squareX, squareY, "Pawn", Color.red, Chess.blackPawn);
				break;
				case 7:
				placePiece(squareX, squareY, "King", Color.blue, Chess.whiteKing);
				break;
				case 8:
				placePiece(squareX, squareY, "Queen", Color.blue, Chess.whiteQueen);
				break;
				case 9:
				placePiece(squareX, squareY, "Rook", Color.blue, Chess.whiteRook);
				break;
				case 10:
				placePiece(squareX, squareY, "Knight", Color.blue, Chess.whiteKnight);
				break;
				case 11:
				placePiece(squareX, squareY, "Bishop", Color.blue, Chess.whiteBishop);
				break;
				case 12:
				placePiece(squareX, squareY, "Pawn", Color.blue, Chess.whitePawn);
				break;
				default:
				ArrayChess.highlightCoveredSquares(Color.red);
				ArrayChess.highlightCoveredSquares(Color.blue);
			}
			counter++;

			

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
		}
		public void mouseDragged(MouseEvent e){
			
		}
	}

	public void go(){
		timeStart = (int)System.currentTimeMillis();
		int timeDifference = 1;
		while(timeDifference<16){
			timeDifference = (int)System.currentTimeMillis() - timeStart; 
		}
		repaint();
		go();
	}

}