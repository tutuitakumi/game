import java.awt.*;
import javax.swing.*;

public class GameOver extends JPanel {
	private static final String text = "Game Over";
	
	GameOver(){
		setBounds(0,0,1000,1000);
		setBackground(Color.black);
		setVisible(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("Selif",Font.PLAIN,100));
		FontMetrics fm = g.getFontMetrics();
		g.drawString(text, (1000-fm.stringWidth(text))/2, 400);
	}
	
}
