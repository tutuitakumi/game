import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MessageWindow extends JPanel {
	private static String text;
	
	MessageWindow(){
		setBounds(150,600, 700,160);
		setBackground(Color.black);
		setBorder(new LineBorder(Color.white,5));
		setVisible(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Selif",Font.PLAIN,30));
		FontMetrics fm = g.getFontMetrics();
		g.setColor(Color.white);
		drawText(g, 20, 0, text);
	}
	
	public void setText(String text) {this.text = text;}
	
	public void drawText(Graphics g , int x, int y, String text) {
		for (String line : text.split("\n"))
	        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}
}
