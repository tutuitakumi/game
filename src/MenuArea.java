import java.awt.*;
import javax.swing.*;

public class MenuArea extends JPanel {
	private static int playerHealth = new Player().getHealth();
	
	MenuArea(){
		setBounds(0,600, 1000,160);
		setBackground(Color.black);
		setLayout(null);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		FontMetrics fm = g.getFontMetrics();
		String stHealth = Integer.toString(playerHealth);
		String viewWord = "HEALTH：" + stHealth + " / 30";
		g.setColor(Color.white);
		g.drawString(viewWord,(1000-fm.stringWidth(viewWord))/2, 100); //くそ重くなるのはなんでだろう
		g.drawRect(400, 20, 200, 50);
		g.fillRect(400, 20, 200*playerHealth/30, 50);
	}
	
	public void drawPlayerHealth(int health) {
		playerHealth = health;
		repaint();
	}
}
