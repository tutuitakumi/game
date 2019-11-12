import java.awt.event.*;
import java.util.ArrayList;

public class PressedKey implements KeyListener {
	private ArrayList<Integer> pressedKey = new ArrayList<Integer>();

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!pressedKey.contains(e.getKeyCode())) pressedKey.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(pressedKey.contains(e.getKeyCode())) pressedKey.remove((Integer)e.getKeyCode());
	}
	
	public boolean hasKeyCode(int key) {
		return pressedKey.contains(key);
	}

}
