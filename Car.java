package studentVehicle;

public class Car extends Vehicle {

	private int capacity;
	
	public Car (String plateNo, String model, String color, int capacity) {
		super (plateNo, model, color);
		this.capacity = capacity;
	}
	
	
}
