import java.util.Random;

public class Player{
	private int x = 180;  //380が右端,0が左端
	private int y = 180;  //380が下端,0が上端
	private int size = 20;
	private int health = 30;
	
	Player(){}
	
	Player(int x, int y, int size, int health){
		this.x = x;
		this.y = y;
		this.size = size;
		this.health = health;
	}
	
	public int getX() { return x;}
	public void setX( int x ) { this.x = x;}
	public int getY() { return y;}
	public void setY( int y ) { this.y = y;}
	public int getPlayerSize() { return size;}
	public void setPlayerSize( int size ) { this.size = size;}
	public int getHealth() { return health;}
	public void setHealth( int health ) { this.health = health;}
	
	public void up() {
		if(y >= 5) {y-=7;}
	}
	public void down() {
		if(y <= 375) {y+=7;}
	}
	public void moveLeft() {
		if(x >= 5) {x-=7;}
	}
	public void moveRight() {
		if(x <= 375) {x+=7;}
	}
	
	public void decrementHealth() {
		if(health > 0) health--;
	}
	
	public boolean isDead() {
		return health == 0;
	}
	
	public int getAttackPoint() {
		return new Random().nextInt(50);
	}
	
}
