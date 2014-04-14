import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Chess{

	public final static int numRanks=16, numFiles=16;
	public final static int squareLength = 30;
	public static Square[][] board;

	public static Image blackBishop, blackKnight, blackPawn, blackQueen, blackRook, blackKing;
	public static Image whiteBishop, whiteKing, whiteKnight, whitePawn, whiteQueen, whiteRook;

	public Chess(){
		Toolkit tkit = Toolkit.getDefaultToolkit();

		URL imageURL1 = Chess.class.getResource("Pieces.blackBishop.png");
		Chess.blackBishop = tkit.getImage(imageURL1);
		URL imageURL2 = Chess.class.getResource("Pieces.blackKing.png");
		Chess.blackKing = tkit.getImage(imageURL2);
		URL imageURL3 = Chess.class.getResource("Pieces.blackKnight.png");
		Chess.blackKnight = tkit.getImage(imageURL3);
		URL imageURL4 = Chess.class.getResource("Pieces.blackPawn.png");
		Chess.blackPawn = tkit.getImage(imageURL4);
		URL imageURL5 = Chess.class.getResource("Pieces.blackQueen.png");
		Chess.blackQueen = tkit.getImage(imageURL5);
		URL imageURL6 = Chess.class.getResource("Pieces.blackRook.png");
		Chess.blackRook = tkit.getImage(imageURL6);
		URL imageURL7 = Chess.class.getResource("Pieces.whiteBishop.png");
		Chess.whiteBishop = tkit.getImage(imageURL7);
		URL imageURL8 = Chess.class.getResource("Pieces.whiteKing.png");
		Chess.whiteKing = tkit.getImage(imageURL8);
		URL imageURL9 = Chess.class.getResource("Pieces.whiteKnight.png");
		Chess.whiteKnight = tkit.getImage(imageURL9);
		URL imageURL10 = Chess.class.getResource("Pieces.whitePawn.png");
		Chess.whitePawn = tkit.getImage(imageURL10);
		URL imageURL11 = Chess.class.getResource("Pieces.whiteQueen.png");
		Chess.whiteQueen = tkit.getImage(imageURL11);
		URL imageURL12 = Chess.class.getResource("Pieces.whiteRook.png");
		Chess.whiteRook = tkit.getImage(imageURL12);
	}

	public static void main(String[] args) {
		ArrayChess ac = new ArrayChess();
		Board b = new Board();
		System.out.println(ac);

	}


}