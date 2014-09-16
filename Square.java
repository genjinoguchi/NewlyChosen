import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Square{
	private String pieceOnSquare;
	private boolean pieceHere, mouseHere;
	private Color squareColor, pieceColor;
	private int px, py;	//Coordinates of upper right corner;
	private int rank, file; //array indices

	public Square(){

	}

	//Mouse sensitivity:
	public boolean getMouseHere(){
		return mouseHere;
	}
	public void changeMouseHere(){
		mouseHere = !mouseHere;
	}
	
	//Empty or with piece:
	public boolean isEmpty(){
		return !pieceHere;
	}
	public void changePieceHere(){
		pieceHere = !pieceHere;
	}


	//squareColor	
	public void setColor(Color c){
		squareColor = c;
	}
	public Color getColor(){
		return squareColor;
	}

	//pieceColor
	public String getPieceColor(){
		return pieceColor;
	}
	public void setPieceColor(String s){
		pieceColor = s;
	}

	//topCoords
	public void setTopCoordinates(int px, int py){
		this.px = px;
		this.py = py;
	}
	public int getPX(){
		return px;
	}
	public int getPY(){
		return py;
	}

	//Ranks n' files:
	public void setRankFile(int rank, int file){
		this.rank = rank;
		this.file = file;
	}
	public int getRank(){
		return rank;
	}
	public int getFile(){
		return file;
	}


	//Piecetypes:
	public String getPieceOnSquare(){
		return pieceOnSquare;
	}
	public void setPiece(String s){
		pieceOnSquare = s;
	}
	
	public String toString(){
		return pieceOnSquare;
	}




}