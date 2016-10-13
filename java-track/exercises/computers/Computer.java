package computers;

public class Computer {
	//has-a
	private int memory;
	private double size;
	private double processor;
	private String brand;
	
	//behaviors
	
	//constructor (create a computer)
	public Computer(int memory, double size, double processor, String brand) {
		this.memory = memory;
		this.size = size;
		this.processor = processor;
		this.brand = brand;
	}
	
	//get the brand name
	public String getBrand() {
		return this.brand;
	}
	
	//get the size
	public double getSize() {
		return this.size;
	}
	
	//get the processor speed
	public double getProcessor() {
		return this.processor;
	}
	
	//get the memory
	public int getMemory() {
		return this.memory;
	}
	
	//add memory
	public void addMemory(int num) {
		if (this.memory + num <= 8) {
			this.memory += num;
		}
	}
	
	//swap out processor
	public void setProcessor(double newProcessor) {
		this.processor = newProcessor;
	}
	
	//display info as String
	public String toString() {
		return "Memory: " + memory + " Size: " + size + " Processor: " + processor + " Brand: " + brand;
	}
	
	public static void main(String[] args) {
		Computer c = new Computer(-4, 22.0, 100.5, "Unknown");
		System.out.println(c);
		c.addMemory(2);
		System.out.println(c);
		c.addMemory(4);
		System.out.println(c);
		c.setProcessor(1000.0);
		System.out.println(c);
		System.out.println(c.getBrand());
		System.out.println(c.brand);
		
	}
	
	
}
