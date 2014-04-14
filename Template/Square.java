import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Square extends JLabel{
	private String pieceOnSquare;
	private Color squareColor;
	private int x0,y0,x1,y1;

	public Square(){
		super();
		setOpaque(true);
	}
	
	public void setColor(Color c){
		squareColor = c;
	}
	public Color getColor(){
		return squareColor;
	}
	public void setCoordinates(int x0,int y0,int x1,int y1){
		this.x0 = x0;
		this.x1 = x1;
		this.y0 = y0;
		this.y1 = y1;
	}
	public void setPiece(String s){
		pieceOnSquare = s;
	}

	public String toString(){
		return pieceOnSquare;
	}




}