package studentVehicle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class StudentVehicle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField icField;
	private JTextField phoneField;
	private JTextField matricField;
	private JTextField modelField;
	private JTextField plateField;
	private JTextField colorField;
	private JTextField facultyField;
	//private JTextField textField_8;
	private JTextField addressField;
	private Student student;
	private Vehicle vehicle;
	private DatabaseQuery registration;
	private JTextField insertField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentVehicle frame = new StudentVehicle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentVehicle() {
		setTitle("Student Vehicle Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		/*JLabel lblNewLabel_2_1_1_1_2 = new JLabel("License Validity:");
		lblNewLabel_2_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_2.setBounds(0, 52, 88, 14);
		panel.add(lblNewLabel_2_1_1_1_2);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_8.setColumns(10);
		textField_8.setBounds(92, 49, 137, 20);
		panel.add(textField_8);*/

		//to group the radio buttons so that user can only select one
		ButtonGroup bg = new ButtonGroup();
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 474, 466);
		contentPane.add(tabbedPane);
		
		JPanel MainPage = new JPanel();
		tabbedPane.addTab("Main", null, MainPage, null);
		MainPage.setLayout(null);
		
		JLabel tLabel = new JLabel("WELCOME TO");
		tLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tLabel.setBounds(163, 102, 141, 14);
		MainPage.add(tLabel);
		
		JLabel tLabel_1 = new JLabel("UTeM Student Vehicle Registration System");
		tLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tLabel_1.setBounds(50, 133, 367, 14);
		MainPage.add(tLabel_1);
		
		insertField = new JTextField();
		insertField.setBounds(116, 185, 235, 20);
		MainPage.add(insertField);
		insertField.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = insertField.getText();
				try {
					if (input.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please input student matric number.","Error", JOptionPane.ERROR_MESSAGE);
					} 
					else {
						int response = JOptionPane.showConfirmDialog(null, "Student " + input + " not registered. Do you want to register?", "Register?", JOptionPane.YES_NO_OPTION);
						if (response == JOptionPane.YES_OPTION) {
							tabbedPane.setSelectedIndex(1);
							matricField.setText(input);
							}
						}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		searchButton.setBounds(126, 216, 89, 23);
		MainPage.add(searchButton);
		
		JButton listButton = new JButton("List");
		listButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Listing Registered Students","Message",JOptionPane.INFORMATION_MESSAGE);
				tabbedPane.setSelectedIndex(2);
			}
		});
		listButton.setBounds(252, 216, 89, 23);
		MainPage.add(listButton);
												
		JPanel RegistrationPage = new JPanel();
		tabbedPane.addTab("Register", null, RegistrationPage, null);
		RegistrationPage.setLayout(null);
												
		JLabel registerLabel = new JLabel("UTeM Student Vehicle Registration System");
		registerLabel.setBounds(48, 11, 337, 21);
		RegistrationPage.add(registerLabel);
		registerLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
														
		JLabel studentLabel = new JLabel("Student Credentials");
		studentLabel.setBounds(10, 43, 135, 14);
		RegistrationPage.add(studentLabel);
		studentLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
														
		JPanel panel = new JPanel();
		panel.setBounds(10, 68, 449, 156);
		RegistrationPage.add(panel);
		panel.setLayout(null);
														
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameField.setBounds(92, 0, 357, 20);
		panel.add(nameField);
		nameField.setColumns(10);
														
		icField = new JTextField();
		icField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		icField.setColumns(10);
		icField.setBounds(92, 25, 137, 20);
		panel.add(icField);
														
		JLabel icLabel = new JLabel("IC Number:");
		icLabel.setForeground(Color.BLACK);
		icLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		icLabel.setBounds(0, 27, 67, 14);
		panel.add(icLabel);
														
		JLabel phoneLabel = new JLabel("Phone Number:");
		phoneLabel.setForeground(Color.BLACK);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phoneLabel.setBounds(248, 27, 88, 14);
		panel.add(phoneLabel);
														
		phoneField = new JTextField();
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phoneField.setColumns(10);
		phoneField.setBounds(340, 24, 109, 20);
		panel.add(phoneField);
														
		JLabel matricLabel = new JLabel("Matric Number:");
		matricLabel.setForeground(Color.BLACK);
		matricLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		matricLabel.setBounds(0, 76, 88, 14);
		panel.add(matricLabel);
														
		matricField = new JTextField();
		matricField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		matricField.setColumns(10);
		matricField.setBounds(92, 73, 137, 20);
		panel.add(matricField);
																
		JLabel yearLabel = new JLabel("Year of Study:");
		yearLabel.setForeground(Color.BLACK);
		yearLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		yearLabel.setBounds(248, 75, 88, 14);
		panel.add(yearLabel);
																
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner.setBounds(340, 73, 41, 20);
		panel.add(spinner);
		spinner.setModel(new SpinnerNumberModel(1, 1, 4, 1));
																
		JLabel facultyLabel = new JLabel("Faculty:");
		facultyLabel.setForeground(Color.BLACK);													
		facultyLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));														
		facultyLabel.setBounds(0, 101, 88, 14);																
		panel.add(facultyLabel);																
																
		facultyField = new JTextField();
		facultyField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		facultyField.setColumns(10);
		facultyField.setBounds(92, 98, 137, 20);
		panel.add(facultyField);
																
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setForeground(Color.BLACK);
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addressLabel.setBounds(0, 128, 88, 14);
		panel.add(addressLabel);
																
		addressField = new JTextField();
		addressField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addressField.setColumns(10);
		addressField.setBounds(92, 125, 357, 20);
		panel.add(addressField);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(0, 3, 34, 14);
		panel.add(nameLabel);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setForeground(new Color(0, 0, 0));
		
		JLabel vehicleLabel = new JLabel("Vehicle Details");
		vehicleLabel.setBounds(10, 235, 135, 14);
		RegistrationPage.add(vehicleLabel);
		vehicleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
																				
		JPanel vtypePanel = new JPanel();
		vtypePanel.setBounds(10, 260, 213, 88);
		RegistrationPage.add(vtypePanel);
		vtypePanel.setLayout(null);
		
		JLabel vtypeLabel = new JLabel("Vehicle Type:");
		vtypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		vtypeLabel.setBounds(0, 1, 85, 14);
		vtypePanel.add(vtypeLabel);
		
		JRadioButton CarRadioButton = new JRadioButton("Car");
		CarRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CarRadioButton.setBounds(0, 18, 111, 23);
		vtypePanel.add(CarRadioButton);
		
		JRadioButton MotorRadioButton = new JRadioButton("Motorcycle");
		MotorRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MotorRadioButton.setBounds(0, 42, 111, 23);
		vtypePanel.add(MotorRadioButton);
		bg.add(CarRadioButton);
		bg.add(MotorRadioButton);
																						
		JPanel vPanel = new JPanel();
		vPanel.setBounds(231, 260, 228, 88);
		RegistrationPage.add(vPanel);
		vPanel.setLayout(null);
		
		JLabel modelLabel = new JLabel("Model Name:");
		modelLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modelLabel.setBounds(0, 4, 85, 14);
		vPanel.add(modelLabel);
																						
		modelField = new JTextField();
		modelField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modelField.setBounds(100, 1, 129, 20);
		vPanel.add(modelField);
		modelField.setColumns(10);
																						
		plateField = new JTextField();
		plateField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		plateField.setColumns(10);
		plateField.setBounds(100, 29, 129, 20);
		vPanel.add(plateField);
																						
		JLabel plateLabel = new JLabel("Plate Number:");
		plateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		plateLabel.setBounds(0, 32, 85, 14);
		vPanel.add(plateLabel);
																						
		colorField = new JTextField();
		colorField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorField.setColumns(10);
		colorField.setBounds(100, 57, 129, 20);
		vPanel.add(colorField);
																						
		JLabel colorLabel = new JLabel("Color:");
		colorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorLabel.setBounds(0, 60, 85, 14);
		vPanel.add(colorLabel);
																						
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(22, 380, 204, 34);
		RegistrationPage.add(registerButton);
		registerButton.setBackground(new Color(255, 255, 255));
		registerButton.setForeground(new Color(0, 0, 0));
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//empty the fields
				nameField.setText("");
				icField.setText("");
				phoneField.setText("");
				matricField.setText("");
				facultyField.setText("");
				addressField.setText("");
				modelField.setText("");
				plateField.setText("");
				colorField.setText("");
				
				JOptionPane.showMessageDialog(null,"Registration Cancelled","Message",JOptionPane.INFORMATION_MESSAGE);
				tabbedPane.setSelectedIndex(0); //Go back to main page
				insertField.setText("");
			}
		});
		cancelButton.setForeground(Color.BLACK);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setBounds(243, 380, 204, 34);
		RegistrationPage.add(cancelButton);
																						
		JPanel ListPage = new JPanel();
		tabbedPane.addTab("List", null, ListPage, null);
		ListPage.setLayout(null);
		
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				registration = new DatabaseQuery();
				
				String name = nameField.getText();			
				String icNo = icField.getText();
				String phoneNo = phoneField.getText();
				String matricNo = matricField.getText();
				int yearStudy = (Integer) spinner.getValue();
				String faculty = facultyField.getText();
				String address = addressField.getText();
				String vehicleType = null;
				
				
				if (CarRadioButton.isSelected()) {
					vehicleType = "Car";
					} else if (MotorRadioButton.isSelected()) {
						vehicleType = "Motorcycle";
						}
				String model = modelField.getText();
				String plateNo = plateField.getText();
				String color = colorField.getText();
				
				//exception
				try {
					if (name.isEmpty()) {
						throw new Exception("Name cannot be empty.");
					}
					if (icNo.isEmpty()) {
						throw new Exception("IC number cannot be empty");
					}
					if (phoneNo.isEmpty()) {
						throw new Exception("Phone Number cannot be empty.");
					}
					if (matricNo.isEmpty()) {
						throw new Exception("Matric number cannot be empty");
					}
					if (faculty.isEmpty()) {
						throw new Exception("Faculty cannot be empty.");
					}
					if (address.isEmpty()) {
						throw new Exception("Address number cannot be empty.");
					}
					if (vehicleType == null) {
						throw new Exception("Please select a vehicle.");
					}
					if (model.isEmpty()) {
						throw new Exception("Vehicle model cannot be empty.");
					}
					if (plateNo.isEmpty()) {
						throw new Exception("Plate number cannot be empty.");
					}
					if (color.isEmpty()) {
						throw new Exception("Vehicle color cannot be empty.");
					}
					
					
					if (!registration.existStudent(matricNo)) {
						//invoke information into class
						if (address == null || address.trim().isEmpty() ) {
							student = new Student(icNo, name, matricNo, phoneNo, yearStudy, faculty);
							} else {
								student = new Student(icNo, name, matricNo, phoneNo, yearStudy, address, faculty);
								}
						
						vehicle = new Vehicle(plateNo, model, color, vehicleType);
															
						//invoke into information into database
						registration.addStudent(student);
						registration.addVehicle(student, vehicle);
						JOptionPane.showMessageDialog(null, "Student registered successfully!"); 
						//use vehicle or car&motorcycle?
						} else {
							JOptionPane.showMessageDialog(null, "Student already registered"); 
							}
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,  "Year invalid", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				}
			});
	}
}
