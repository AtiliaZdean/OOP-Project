package studentVehicle;

public class Motorcycle extends Vehicle {

	private int capacity1;
	
	public Motorcycle (String plateNo, String model, String color, int capacity1) {
		super (plateNo, model, color);
		this.capacity1 = capacity1;
	}
	
	
}