import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Piece extends JLabel{

	public Piece(String filepath){
		super();
		BufferedImage icon = ImageIO.read(new File(filepath));
		this = new JLabel(new ImageIcon(icon));

	}






}