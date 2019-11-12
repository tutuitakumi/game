import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame  {
	private static Long t = null;
	private static MyPanel p = new MyPanel();
	private static GameArea ga = new GameArea();
	private static PressedKey pk = new PressedKey();
	private static Player pl = new Player();
	private static MenuArea m = new MenuArea();
	private static StartScreen ss = new StartScreen();
	private static GameOver go = new GameOver();
	private static GameComplete gc = new GameComplete();
	private static boolean loop = true;
	private static ScreenType screenType =  ScreenType.START;
	private static EnemyPanel ep = new EnemyPanel();
	private static Enemy en = new Enemy1(50,"enemy1",ep);
	private static MessageWindow mw = new MessageWindow();
	
	MyFrame(){
		p.add(ga);
		p.add(m);
		p.add(mw);
		add(p);
		add(ss);
		add(go);
		add(gc);
		p.setVisible(false);
		ss.setVisible(true);
		ga.setVisible(true);
		m.setVisible(true);
		addKeyListener(pk);
		setSize(1000,1000);
	}
	
	public static void main(String[] args) {
        MyFrame mainFrame = new MyFrame();
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        while(loop) {
        	switch(screenType) {
        	case START:
        		if(pk.hasKeyCode(KeyEvent.VK_ENTER)) screenType = ScreenType.PLAY;
        		break;
			case PLAY:
				if(t == null) t = System.currentTimeMillis();
				if(System.currentTimeMillis() - t > 5000) {
					screenType = ScreenType.MESSAGE;
				}
				mw.setVisible(false);
				p.setVisible(true);
				ga.setVisible(true);
				m.setVisible(true);
				ss.setVisible(false);
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        	if(pk.hasKeyCode(KeyEvent.VK_LEFT)) pl.moveLeft();
	        	if(pk.hasKeyCode(KeyEvent.VK_RIGHT)) pl.moveRight();
	        	if(pk.hasKeyCode(KeyEvent.VK_UP)) pl.up();
	        	if(pk.hasKeyCode(KeyEvent.VK_DOWN)) pl.down();
	        	ga.repaint(pl.getX(), pl.getY());
	        	if(ep.getParent() == null) {
	        		ga.add(ep);
	        	}
        		en.attack();
	        	if(en.isAttackHit(pl.getX(), pl.getY(), pl.getPlayerSize())) {
	        		pl.decrementHealth();
	        		m.drawPlayerHealth(pl.getHealth());
	        		if(pl.isDead()) {
	        			screenType = ScreenType.GAMEOVER;
        			}
	        	}
	        	break;
			case MESSAGE:
				ga.setVisible(false);
				m.setVisible(false);
				mw.setVisible(true);
				mw.setText("playerのこうげき。");
				mw.repaint();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int damage = pl.getAttackPoint();
				mw.setText(damage+"のダメージをあたえた。");
				en.receiveDamage(damage);
				mw.repaint();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(en.isDead()) {
					screenType = ScreenType.GAMECOMPLETE;
				}else {
					screenType = ScreenType.PLAY;
				}
				en.incrementAttackCnt();
				t = null;
				en.resetBone();
				break;
			case GAMEOVER:
				p.setVisible(false);
				go.setVisible(true);
				loop = false;
				break;
			case GAMECOMPLETE:
				p.setVisible(false);
				gc.setVisible(true);
				break;
			default:
				break;
        	}
        }
    }
}
