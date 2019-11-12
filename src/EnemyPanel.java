import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class EnemyPanel extends JPanel {
	private ArrayList<Bone> bones = new ArrayList<Bone>();
	
	EnemyPanel(){
		setBounds(0,0,400,400);
		setBackground(Color.red);
		setOpaque(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		for(Bone bone : bones) {
			g.fillRect(bone.getX(), bone.getY(), bone.getWidth(), bone.getHeight());
		}
	}
	
	public void drawBone(ArrayList<Bone> bones){
		this.bones = bones;
		repaint();
	}

}
