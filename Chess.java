import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chess{

	public final static int numRanks=30, numFiles=30;
	public final static int squareLength = 50;
	public static Square[][] board;

	public static void main(String[] args) {
		ArrayChess ac = new ArrayChess();
		ChessGui cg = new ChessGui(20,20);

	}


}