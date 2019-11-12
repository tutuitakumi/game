public class Bone {
	private int x;
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	
	private int y;
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}

	private int width;
	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}

	private int height;
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}	
	
	Bone(int bx, int by, int bWidth, int bHeight){
		this.setX(bx);
		this.y = by;
		this.width = bWidth;
		this.height = bHeight;
	}
	
	public void moveLeft() { setX(getX() - 8);}
	public void moveRight() { setX(getX() + 8);}
	public void up() { y -= 8;}
	public void down() { y += 8;}
	
}
