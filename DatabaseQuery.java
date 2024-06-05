package studentVehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//database connection implementation
public class DatabaseQuery {
	private final String URL = "jdbc:mysql://localhost:3306/studentvehicle_registration";
	private final String USER = "root";
	private final String PASSWORD = "";

	public DatabaseQuery() {}
	
	//add Student
	public void addStudent (Student student){
		try (Connection conn = DriverManager.getConnection( URL, USER, PASSWORD)) {
			String query = "INSERT INTO student (matricNo, icNo, name, phoneNo, yearStudy, address, faculty) VALUES (?,?,?,?,?,?,?)";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, student.matricNo);
				pstmt.setString(2, student.getIcNo());
				pstmt.setString(3, student.getName());
				pstmt.setString(4, student.getPhoneNo());
				pstmt.setInt(5, student.getYearStudy());
				pstmt.setString(6, student.getAddress());
				pstmt.setString(7, student.getFaculty());
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//check if matricNo exist
	public boolean existStudent (String inputId) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String query = "SELECT COUNT(*) FROM student WHERE matricNo = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, inputId);

				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						return rs.getInt(1) > 0;
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
			
		return false;
	}
	
	//update Student
	public void updateStudent (Student student) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String query = "UPDATE student SET icNo = ?, name = ?, phoneNo = ?, yearStudy = ?, address = ?, faculty = ? WHERE matricNo = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, student.getIcNo());
				pstmt.setString(2, student.getName());
				pstmt.setString(3, student.getPhoneNo());
				pstmt.setInt(4, student.getYearStudy());
				pstmt.setString(5, student.getAddress());
				pstmt.setString(6, student.getFaculty());
				pstmt.setString(7, student.matricNo);
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//delete student
	public void deleteStudent (Student student) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String query = "DELETE FROM student WHERE matricNo = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, student.matricNo);
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//register vehicle
	public void addVehicle (Student student, Vehicle vehicle){
		try (Connection conn = DriverManager.getConnection( URL, USER, PASSWORD)) {
			String query = "INSERT INTO vehicle (matricNo, plateNo, model, color, vehicle_type) VALUES (?,?,?,?,?)";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, student.matricNo);
				pstmt.setString(2, vehicle.getPlateNo());
				pstmt.setString(3, vehicle.getModel());
				pstmt.setString(4, vehicle.getColor());
				pstmt.setString(5, vehicle.getVehicleType());
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//update vehicle
	public void updateVehicle (Student student, Vehicle vehicle) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String query = "UPDATE vehicle SET plateNo = ?, model = ?, color = ?, vehicle_type = ? WHERE matricNo = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, vehicle.getPlateNo());
				pstmt.setString(2, vehicle.getModel());
				pstmt.setString(3, vehicle.getColor());
				pstmt.setString(4, vehicle.getVehicleType());
				pstmt.setString(5, student.matricNo);
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//delete vehicle
	public void deleteVehicle (Student student) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String query = "DELETE FROM vehicle WHERE matricNo = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, student.matricNo);
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//retrieve data from student table
	public void retrieveStudent (Student student) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String query = "SELECT * FROM student WHERE matricNo = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, student.matricNo);
				try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    student.setIcNo(rs.getString("icNo"));
	                    student.setName(rs.getString("name"));
	                    student.setPhoneNo(rs.getString("phoneNo"));
	                    student.setYearStudy(rs.getInt("yearStudy"));
	                    student.setAddress(rs.getString("address"));
	                    student.setFaculty(rs.getString("faculty"));
	                }
				}
			} catch (SQLException ex) {
			ex.printStackTrace();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//retrieve data from vehicle table
	public void retrieveVehicle (Student student, Vehicle vehicle) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String query = "SELECT * FROM vehicle WHERE matricNo = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, student.matricNo);
				try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    vehicle.setPlateNo(rs.getString("plateNo"));
	                    vehicle.setModel(rs.getString("model"));
	                    vehicle.setColor(rs.getString("color"));
	                    vehicle.setVehicleType(rs.getString("vehicle_type"));
	                }
				}
			} catch (SQLException ex) {
			ex.printStackTrace();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
