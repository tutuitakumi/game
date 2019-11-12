import java.awt.*;
import javax.swing.*;

public class GameComplete extends JPanel {
	private static final String text = "Congratulations";

	GameComplete(){
		setBounds(0,0,1000,1000);
		setBackground(Color.black);
		setVisible(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("Selif",Font.PLAIN,50));
		FontMetrics fm = g.getFontMetrics();
		g.drawString(text, (1000-fm.stringWidth(text))/2, 400);
	}
	
}
