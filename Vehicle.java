package studentVehicle;

//interface Type
interface Type {
	String isType();
}

//superclass vehicle
public class Vehicle {
	//private Student owner;
	private String plateNo, model, color, vehicleType;

	public Vehicle() {}
	
	public Vehicle (String plateNo, String model, String color, String vehicleType) {
		this.plateNo = plateNo;
		this.model = model;
		this.color = color;
		this.vehicleType = vehicleType;
	}
	
	public String getPlateNo () {
		return plateNo;		
	}
	
	public void setPlateNo (String plateNo) {
		this.plateNo = plateNo;	
	}
	
	public String getModel () {
		return model;		
	}
	
	public void setModel (String model) {
		this.model = model;	
	}
	
	public String getColor () {
		return color;		
	}
	
	public void setColor (String color) {
		this.color = color;
	}
	
	public String getVehicleType () {
		return vehicleType;		
	}
	
	public void setVehicleType (String vehicleType) {
		this.vehicleType = vehicleType;
	}
}

//subclass car from vehicle
class Car extends Vehicle implements Type {
	public Car () {}
	
	public Car (String plateNo, String model, String color, String vehicleType) {
		//inherit attributes from superclass vehicle
		super(plateNo, model, color, vehicleType);
	}
	
	@Override //interface method implementation
	public String isTyre () {
		return "Car";
	}
}

//subclass motorcycle from vehicle
class Motorcycle extends Vehicle implements Type {
	public Motorcycle () {}
	
	public Motorcycle (String plateNo, String model, String color, String vehicleType) {
		//inherit attributes from superclass vehicle
		super (plateNo, model, color, vehicleType);
	}
	
	@Override //interface method implementation
	public String isType () {
		return "Motorcycle";
	}
}
