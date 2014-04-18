import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Square{
	private String pieceOnSquare;
	private Color squareColor;
	private int px, py;	//Coordinates of upper right corner;

	public Square(){
	
	}
	
	public void setColor(Color c){
		squareColor = c;
	}
	public Color getColor(){
		return squareColor;
	}
	public void setCoordinates(int px, int py){
		this.px = px;
		this.py = py;
	}
	public int getX(){
		return px;
	}
	public int getY(){
		return py;
	}
	public void setPiece(String s){
		pieceOnSquare = s;
	}
	public String toString(){
		return pieceOnSquare;
	}




}