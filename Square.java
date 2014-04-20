import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square{
	private String pieceOnSquare;
	private boolean pieceHere, mouseHere;
	private Color squareColor, pieceColor;
	private Image face;
	private int px, py;	//Coordinates of upper right corner;
	private int rank, file; //array indices

	public Square(){
		pieceHere = false;
	}

	//Mouse sensitivity:
	public boolean getMouseHere(){
		boolean temp = mouseHere;
		mouseHere = false;
		return temp;
	}
	public void setMouseHere(){
		mouseHere = true;
	}
	
	//Empty or with piece:
	public boolean isEmpty(){
		return !pieceHere;
	}
	public void setPieceHere(boolean b){
		pieceHere = b;
	}


	//squareColor	
	public void setColor(Color c){
		if(squareColor==null){
			squareColor = c;
		}
		else{ 
			if(squareColor.equals(Color.black) || squareColor.equals(Color.white) || squareColor.equals(c)){
				squareColor = c;
			}else{
				squareColor = Chess.Middle;
			}
		}
	}

	public void absoluteSetColor(Color c){
		squareColor = c;
	}

	public Color getColor(){
		return squareColor;
	}

	//pieceColor
	public Color getPieceColor(){
		return pieceColor;
	}
	public void setPieceColor(Color C){
		pieceColor = C;
	}

	//Images
	public void setFace(Image i){
		face = i;
	}
	public Image getFace(){
		return face;
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
	public void setPieceOnSquare(String s){
		pieceOnSquare = s;
	}
	
	public String toString(){
		if(isEmpty()){
			return "E";
		}else{
			return pieceOnSquare;
		}
	}




}