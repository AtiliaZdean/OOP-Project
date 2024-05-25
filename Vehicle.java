package studentVehicle;

abstract class Vehicle {
	//private Student matric;
	private String plateNo;
	private String model;
	private String color;
	
	public Vehicle (String plateNo, String model, String color) {
		this.plateNo = plateNo;
		this.model = model;
		this.color = color;
		
	}
	
	public String getPlateNo() {
		return plateNo;		
	}
	
	public void setPlateNo() {
		this.plateNo = plateNo;	
	}
	
	public String getModel() {
		return model;		
	}
	
	public void setModel() {
		this.model = model;	
	}
	
	public String getColor() {
		return color;		
	}
	
	public void setColor() {
		this.color = color;
	}

}
