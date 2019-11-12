import java.util.ArrayList;
import java.util.Random;

public class Enemy1 extends Enemy {
	Enemy1(int health, String name, EnemyPanel ep) {
		super(health, name, ep);
	}

	private ArrayList<Bone> bones = new ArrayList<Bone>();
	private boolean addBone = false;

	@Override
	public void attack() {
		switch(getAttackCnt() % 2) {
		case 1:
			attack1();
			break;
		case 0:
			attack2();
			break;
		}
	}
	
	public void attack1() {
		if(bones.isEmpty()) {
			int height = new Random().nextInt(360);
			bones.add(new Bone(380,0,20, height));
			bones.add(new Bone(380,height + 40,20, 360 - height ));
		}else {
			for(int i = 0; i < bones.size(); i++) {
				Bone bone = bones.get(i);
				bone.moveLeft();
				if(bone.getX() <= 0) {
					bones.remove(i);
				}
			}
		}
		getEp().drawBone(bones);
	}
	
	public void attack2() {
		if(bones.isEmpty() || addBone == true) {
			bones.add(new Bone(0,0,200, 20));
			bones.add(new Bone(200,380,200,20));
			addBone = false;
		}else {
			for(int i = 0; i < bones.size(); i++) {
				Bone bone = bones.get(i);
				if(i % 2 == 0) {
					bone.down();
					if(bone.getY() > 200 && addBone == false && bones.size() == 2) {
						addBone = true;
					}
				}else {
					bone.up();
				}
				if(bone.getY() <= 0 || bone.getY() >= 400 ) {
					bones.remove(i);
				}
			}
		}
		getEp().drawBone(bones);
	}
	
	@Override
	public boolean isAttackHit(int px, int py, int pSize) {
		for(Bone bone: bones) {
			if( bone.getX() + bone.getWidth() > px && px > bone.getX() ||
				bone.getX() + bone.getWidth() > px + pSize && px + pSize > bone.getX() ) {
				if(bone.getY() + bone.getHeight() > py && py > bone.getY() || 
				   bone.getY() + bone.getHeight() > py + pSize && py + pSize > bone.getY()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void resetBone() {
		bones.clear();
	}

}
