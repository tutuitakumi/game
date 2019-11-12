import java.awt.*;
import javax.swing.*;

public class StartScreen extends JPanel {
	private static final String title = "Test text";
	private static final String subTitle = "Press Enter Key and Start the game";
	
	StartScreen(){
		setBounds(0,0,1000,1000);
		setBackground(Color.black);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("Selif",Font.PLAIN,100));
		FontMetrics fm = g.getFontMetrics();
		g.drawString(title, (1000-fm.stringWidth(title))/2, 400);
		g.setFont(new Font("Selif",Font.PLAIN,24));
		fm = g.getFontMetrics();
		g.drawString(subTitle, (1000 - fm.stringWidth(subTitle))/2, 500);
	}
	
}
