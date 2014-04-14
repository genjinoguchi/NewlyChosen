import java.awt.*;
import java.awt.event.*;
import java.swing.*;

public class Piece extends JLabel{
	Image pieceImage;
	Color squareColor;

	public Piece(Image i, Color color){
		super(new new ImageIcon(i));
		pieceIcon = i;
		squareColor = color;
	}

	public Piece(Color color){
		squareColor = color;
	}






}