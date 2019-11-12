public class Enemy{
	private String enemyName;
	public String getEnemyName() {return enemyName;}
	public void setEnemyName(String enemyName) {this.enemyName = enemyName;}

	private int health;
	public int getHealth() {return health;}
	public void setHealth(int health) {this.health = health;}
	
	private int attackCnt = 0;
	public int getAttackCnt() {return attackCnt;}
	public void setAttackCnt(int attackCnt) {this.attackCnt = attackCnt;};

	private static EnemyPanel ep;
	
	Enemy(int health, String name, EnemyPanel ep){
		this.health = health;
		this.enemyName = name;
		this.setEp(ep);
	}
	
	public void attack() {};
	
	public void receiveDamage(int damage) {
		setHealth(getHealth() - damage);
	}
	
	public boolean isDead() {
		return health <= 0;
	}
	
	public void incrementAttackCnt() {attackCnt++;}
	
	public boolean isAttackHit(int px, int py, int pSize) {return true;}
	
	public EnemyPanel getEp() {
		return ep;
	}
	public void setEp(EnemyPanel ep) {
		this.ep = ep;
	}
	public void resetBone() {}
	

}
