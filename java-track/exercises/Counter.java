
public class Counter {
	private static int staticCounter = 0;
	private int instanceCounter = 0;
	
	public static void incrementStatic() {
		staticCounter++;
	}
	
	public void incrementInstance() {
		instanceCounter++;
	}
	
	public static int getStatic() {
		return staticCounter;
	}
	
	public int getInstance() {
		return instanceCounter;
	}
	
	public static void main(String[] args) {

		Counter counterAll = new Counter();
		Counter counterEvens = new Counter();
		
		int max1 = (int)(Math.random() * 100);
		int max2 = (int)(Math.random() * 100);
		
		for (int i = 0; i < max1; i++) {
			counterAll.incrementInstance();
			//Counter.incrementStatic();
			if (i%2 == 0) {
				counterEvens.incrementInstance();
			}
		}
		
//		for (int i=0; i<max2; i++) {
//			Counter.incrementStatic();
//		}
		
		System.out.println("counterAll: " + counterAll.getInstance());
		System.out.println("counterEvens: " + counterEvens.getInstance());
		System.out.println("counterStatic: " + Counter.getStatic());
	}
	
}
