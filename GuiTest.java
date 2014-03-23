import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.net.*;

public class GuiTest{

	private JFrame frame;
	private static Container background;
	private static MyPanel p;
	private Image img;

	private static MyLabel l1, l2, l3, l4;
	

	public void go(){
		frame = new JFrame("Gui test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50,50);
		frame.setSize(500,300);
		frame.setVisible(true);

		URL imageurl = GuiTest.class.getResource("Pieces.blackBishop.png");
		img = Toolkit.getDefaultToolkit().getImage(imageurl);

		background = frame.getContentPane();
		p = new MyPanel();
		background.add(p);

		l1 = new MyLabel(new ImageIcon("Pieces/blackBishop.png"));
		l2 = new MyLabel(new ImageIcon("Pieces/whiteBishop.png"));
		l3 = new MyLabel(new ImageIcon("Pieces/blackKing.png"));
		l4 = new MyLabel(new ImageIcon("Pieces/whiteKing.png"));
		l1.randomInt = 1;
		l2.randomInt = 2;
		l3.randomInt = 3;
		l4.randomInt = 4;
		
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		
	}

	private class MyPanel extends JPanel implements MouseMotionListener{
		private boolean mouseIn;
		private BufferedImage img;
		private int mouseX, mouseY;

		public MyPanel(){
			super();
			//setLayout(new GridLayout(2,2)); //Causes a lot of bugs.
			addMouseMotionListener(this);
			/*
			img = Toolkit.getDefaultToolkit().getImage(GuiTest.class.getResource("Pieces/blackBishop.png"));
			try{
				img = ImageIO.read(new File("Pieces/blackBishop.png"));
			}catch(Exception e){}
			*/
		}
		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.blue);
			g2.drawImage(img,mouseX, mouseY,null);
		}
		
		public void mouseMoved(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			System.out.println(mouseX + " " + mouseY);
			frame.repaint();
		}
		public void mouseDragged(MouseEvent e) {}
		
	}
	private class MyLabel extends JLabel implements MouseMotionListener{
		private Color color;
		private int randomInt;
		public MyLabel(String s){
			super(s);
			setOpaque(false);
			addMouseMotionListener(this);
		}
		public MyLabel(ImageIcon i){
			super(i);
			setOpaque(false);
			addMouseMotionListener(this);
		}
		public void setColor(Color color){
			this.color = color;
		}
		public Color getColor(){
			return color;
		}
		public void mouseMoved(MouseEvent e) {
			p.mouseX = e.getX();
			p.mouseY = e.getY();
			System.out.println(p.mouseX + " " + p.mouseY);
			frame.repaint();
		}
		public void mouseDragged(MouseEvent e) {}
	}

	public static void main(String[] args) {
		GuiTest g = new GuiTest();
		g.go();
	}

}
