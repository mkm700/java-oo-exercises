package blogz;

public abstract class Entity {
	private static int counter = 999;
	private final int uid;
	
	public Entity() {
		counter++;
		this.uid = counter;
	}
	
	public int getUid() {
		return this.uid;
	}
}
