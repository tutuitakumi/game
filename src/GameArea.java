import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class GameArea extends JPanel{
	private Player player = new Player();
	private int charaX = player.getX();
	private int charaY = player.getY();
	private int charaSize = player.getPlayerSize();
	
	
	GameArea(){
		setBounds(300,150,400,400);
		setBackground(Color.black);
		setBorder(new LineBorder(Color.white,5));
		setLayout(null);
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
		g.fillRect(charaX, charaY, charaSize,charaSize);
    }
	
	public void repaint(int x, int y) {
		charaX = x;
		charaY = y;
		repaint();
	}
}
