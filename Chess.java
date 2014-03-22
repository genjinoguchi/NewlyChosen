import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Chess{

	public final static int numRanks=30, numFiles=30;
	public final static int squareLength = 50;
	public static Square[][] board;

	public static Image blackBishop, blackKnight, blackPawn, blackQueen, blackRook, blackKing;
	public static Image whiteBishop, whiteKing, whiteKnight, whitePawn, whiteQueen, whiteRook;



	public static void main(String[] args) {
		
		URL imageURL1 = Chess.class.getResource("Pieces.blackBishop.png");
		Chess.blackBishop = new ImageIcon(imageURL1);
		URL imageURL2 = Chess.class.getResource("Pieces.blackKing.png");
		Chess.blackKing = new ImageIcon(imageURL2);
		URL imageURL3 = Chess.class.getResource("Pieces.blackKnight.png");
		Chess.blackKnight = new ImageIcon(imageURL3);
		URL imageURL4 = Chess.class.getResource("Pieces.blackPawn.png");
		Chess.blackPawn = new ImageIcon(imageURL4);
		URL imageURL5 = Chess.class.getResource("Pieces.blackQueen.png");
		Chess.blackQueen = new ImageIcon(imageURL5);
		URL imageURL6 = Chess.class.getResource("Pieces.blackRook.png");
		Chess.blackRook = new ImageIcon(imageURL6);
		URL imageURL7 = Chess.class.getResource("Pieces.whiteBishop.png");
		Chess.whiteBishop = new ImageIcon(imageURL7);
		URL imageURL8 = Chess.class.getResource("Pieces.whiteKing.png");
		Chess.whiteKing = new ImageIcon(imageURL8);
		URL imageURL9 = Chess.class.getResource("Pieces.whiteKnight.png");
		Chess.whiteKnight = new ImageIcon(imageURL9);
		URL imageURL10 = Chess.class.getResource("Pieces.whitePawn.png");
		Chess.whitePawn = new ImageIcon(imageURL10);
		URL imageURL11 = Chess.class.getResource("Pieces.whiteQueen.png");
		Chess.whiteQueen = new ImageIcon(imageURL11);
		URL imageURL12 = Chess.class.getResource("Pieces.whiteRook.png");
		Chess.whiteRook = new ImageIcon(imageURL12);


		ArrayChess ac = new ArrayChess();
		ChessGui cg = new ChessGui(20,20);

	}


}