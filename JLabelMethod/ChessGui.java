import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame implements ActionListener{
	private static Container background;
	private static BoardPanel b;

	public Board(int L, int h){
		frame = new JFrame("Chess");
		height = h;
		width = L;
		frame.setSize(height*Chess.squareLength, width*Chess.squareLength);
		frame.setLocation(50,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);

		background = frame.getContentPane();

		b = new BoardPanel();
		background.add(b);
		b.repaint();
	}
}