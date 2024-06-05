package studentVehicle;

//class student
public class Student {
	private String icNo, name, phoneNo, address, faculty;
	public String matricNo;
	private int yearStudy;

	public Student () {}
	
	//constructor
	public Student (String icNo, String name, String matricNo, String phoneNo, int yearStudy, String address, String faculty) {
		this.icNo = icNo;
		this.name = name;
		this.matricNo = matricNo;
		this.phoneNo = phoneNo;
		this.yearStudy = yearStudy;
		this.address = address;
		this.faculty = faculty;
	}
	
	//constructor overloading to set default value
	public Student (String icNo, String name, String matricNo, String phoneNo, int yearStudy, String faculty) {
		this.icNo = icNo;
		this.name = name;
		this.matricNo = matricNo;
		this.phoneNo = phoneNo;
		this.yearStudy = yearStudy;
		this.address = "not filled in";
		this.faculty = faculty;
	}
	
	public void setIcNo (String icNo) {
		this.icNo = icNo;
	}
	
	public String getIcNo () {
		return icNo;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return name;
	}
	
	public void setPhoneNo (String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getPhoneNo () {
		return phoneNo;
	}
	
	public void setYearStudy (int yearStudy) {
		this.yearStudy = yearStudy;
	}
	
	public int getYearStudy () {
		return yearStudy;
	}
	
	public void setAddress (String address) {
		this.address = address;
	}
	
	public String getAddress () {
		return address;
	}
	
	public void setFaculty (String faculty) {
		this.faculty = faculty;
	}
	
	public String getFaculty () {
		return faculty;
	}
}
