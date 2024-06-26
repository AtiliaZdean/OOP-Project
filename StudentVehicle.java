package studentVehicle;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.Vector;

public class StudentVehicle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/*Register page fields line 18-27
	setSelectedIndex(1)*/
	private JTextField nameField;
	private JTextField icField;
	private JTextField phoneField;
	private JTextField matricField;
	private JTextField modelField;
	private JTextField plateField;
	private JTextField colorField;
	private JTextField facultyField;
	private JTextField addressField;
	private JTextField insertField;
	
	//Table for List Page line 30-31
	private DefaultTableModel tableModel;
	private JTable table;
	
	/*Display page fields line 35-43
	setSelectedIndex(3)*/
	private JTextField nameField_1;
	private JTextField icField_1;
	private JTextField phoneField_1;
	private JTextField matricField_1;
	private JTextField facultyField_1;
	private JTextField addressField_1;
	private JTextField modelField_1;
	private JTextField plateField_1;
	private JTextField colorField_1;
	
	//class declaration
	private Student student = new Student();
	private Vehicle vehicle = new Vehicle();
	private Car car = new Car();
	private Motorcycle motor = new Motorcycle();
	private DatabaseQuery query = new DatabaseQuery();

	//Launch the application.
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

	//Create the frame.
	public StudentVehicle() {
		setTitle("Student Vehicle Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 514);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Tab pane declaration
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, -29, 474, 506);
		contentPane.add(tabbedPane);
		
		//Main page tab
		JPanel MainPage = new JPanel();
		tabbedPane.addTab("Main", null, MainPage, null);
		MainPage.setLayout(null);
		
		//Title1 Main
		JLabel tLabel = new JLabel("WELCOME TO");
		tLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tLabel.setBounds(163, 102, 141, 14);
		MainPage.add(tLabel);
		
		//Title2 Main
		JLabel tLabel_1 = new JLabel("UTeM Student Vehicle Registration System");
		tLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tLabel_1.setBounds(50, 133, 367, 14);
		MainPage.add(tLabel_1);
		
		//Register Page tab
		JPanel RegistrationPage = new JPanel();
		tabbedPane.addTab("Register", null, RegistrationPage, null);
		RegistrationPage.setLayout(null);
				
		//Register Page fields & labels line 105-280
		//Title Register
		JLabel registerLabel = new JLabel("UTeM Student Vehicle Registration System");
		registerLabel.setBounds(48, 11, 337, 21);
		RegistrationPage.add(registerLabel);
		registerLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		//Student Register
		JLabel studentLabel = new JLabel("Student Credentials");
		studentLabel.setBounds(10, 43, 135, 14);
		RegistrationPage.add(studentLabel);
		studentLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
															
		JPanel panel = new JPanel();
		panel.setBounds(10, 68, 449, 156);
		RegistrationPage.add(panel);
		panel.setLayout(null);
		
		//Student Details Section -- Update table student
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
		nameLabel.setBounds(0, 3, 51, 14);
		panel.add(nameLabel);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setForeground(new Color(0, 0, 0));
				
		//Vehicle Details Section -- Update table vehicle
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
		//to group the radio buttons so that user can only select one
		ButtonGroup bg = new ButtonGroup();
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
				
		//List Page Tab
		JPanel ListPage = new JPanel();
		tabbedPane.addTab("List", null, ListPage, null);
		ListPage.setLayout(null);
				
		//Details Page Tab
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Details", null, panel_1, null);
		panel_1.setLayout(null);
		
		//Details Page fields & labels line 293-462
		JPanel RegistrationPage_1 = new JPanel();
		RegistrationPage_1.setLayout(null);
		RegistrationPage_1.setBounds(0, 0, 469, 438);
		panel_1.add(RegistrationPage_1);
				
		JLabel registerLabel_1 = new JLabel("UTeM Student Vehicle Registration System");
		registerLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		registerLabel_1.setBounds(48, 11, 337, 21);
		RegistrationPage_1.add(registerLabel_1);
				
		JLabel studentLabel_1 = new JLabel("Student Credentials");
		studentLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		studentLabel_1.setBounds(10, 43, 135, 14);
		RegistrationPage_1.add(studentLabel_1);
				
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 68, 449, 156);
		RegistrationPage_1.add(panel_2);
				
		nameField_1 = new JTextField();
		nameField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameField_1.setColumns(10);
		nameField_1.setBounds(92, 0, 357, 20);
		panel_2.add(nameField_1);
				
		icField_1 = new JTextField();
		icField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		icField_1.setColumns(10);
		icField_1.setBounds(92, 25, 137, 20);
		panel_2.add(icField_1);
				
		JLabel icLabel_1 = new JLabel("IC Number:");
		icLabel_1.setForeground(Color.BLACK);
		icLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		icLabel_1.setBounds(0, 27, 67, 14);
		panel_2.add(icLabel_1);
				
		JLabel phoneLabel_1 = new JLabel("Phone Number:");
		phoneLabel_1.setForeground(Color.BLACK);
		phoneLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phoneLabel_1.setBounds(248, 27, 88, 14);
		panel_2.add(phoneLabel_1);
				
		phoneField_1 = new JTextField();
		phoneField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phoneField_1.setColumns(10);
		phoneField_1.setBounds(340, 24, 109, 20);
		panel_2.add(phoneField_1);
				
		JLabel matricLabel_1 = new JLabel("Matric Number:");
		matricLabel_1.setForeground(Color.BLACK);
		matricLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		matricLabel_1.setBounds(0, 76, 88, 14);
		panel_2.add(matricLabel_1);
				
		matricField_1 = new JTextField();
		matricField_1.setEditable(false);
		matricField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		matricField_1.setColumns(10);
		matricField_1.setBounds(92, 73, 137, 20);
		panel_2.add(matricField_1);
				
		JLabel yearLabel_1 = new JLabel("Year of Study:");
		yearLabel_1.setForeground(Color.BLACK);
		yearLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		yearLabel_1.setBounds(248, 75, 88, 14);
		panel_2.add(yearLabel_1);
				
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_1.setBounds(340, 73, 41, 20);
		panel_2.add(spinner_1);
				
		JLabel facultyLabel_1 = new JLabel("Faculty:");
		facultyLabel_1.setForeground(Color.BLACK);
		facultyLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		facultyLabel_1.setBounds(0, 101, 88, 14);
		panel_2.add(facultyLabel_1);
				
		facultyField_1 = new JTextField();
		facultyField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		facultyField_1.setColumns(10);
		facultyField_1.setBounds(92, 98, 137, 20);
		panel_2.add(facultyField_1);
				
		JLabel addressLabel_1 = new JLabel("Address:");
		addressLabel_1.setForeground(Color.BLACK);
		addressLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addressLabel_1.setBounds(0, 128, 88, 14);
		panel_2.add(addressLabel_1);
				
		addressField_1 = new JTextField();
		addressField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addressField_1.setColumns(10);
		addressField_1.setBounds(92, 125, 357, 20);
		panel_2.add(addressField_1);
				
		JLabel nameLabel_1 = new JLabel("Name:");
		nameLabel_1.setForeground(Color.BLACK);
		nameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel_1.setBounds(0, 3, 51, 14);
		panel_2.add(nameLabel_1);
				
		JLabel vehicleLabel_1 = new JLabel("Vehicle Details");
		vehicleLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		vehicleLabel_1.setBounds(10, 235, 135, 14);
		RegistrationPage_1.add(vehicleLabel_1);
				
		JPanel vtypePanel_1 = new JPanel();
		vtypePanel_1.setLayout(null);
		vtypePanel_1.setBounds(10, 260, 213, 88);
		RegistrationPage_1.add(vtypePanel_1);
				
		JLabel vtypeLabel_1 = new JLabel("Vehicle Type:");
		vtypeLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		vtypeLabel_1.setBounds(0, 1, 85, 14);
		vtypePanel_1.add(vtypeLabel_1);
				
		JRadioButton CarRadioButton_1 = new JRadioButton("Car");
		CarRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CarRadioButton_1.setBounds(0, 18, 111, 23);
		vtypePanel_1.add(CarRadioButton_1);
				
		JRadioButton MotorRadioButton_1 = new JRadioButton("Motorcycle");
		MotorRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MotorRadioButton_1.setBounds(0, 42, 111, 23);
		vtypePanel_1.add(MotorRadioButton_1);
		ButtonGroup bg_1 = new ButtonGroup();
		bg_1.add(CarRadioButton_1);
		bg_1.add(MotorRadioButton_1);
			
		JPanel vPanel_1 = new JPanel();
		vPanel_1.setLayout(null);
		vPanel_1.setBounds(231, 260, 228, 88);
		RegistrationPage_1.add(vPanel_1);
				
		JLabel modelLabel_1 = new JLabel("Model Name:");
		modelLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modelLabel_1.setBounds(0, 4, 85, 14);
		vPanel_1.add(modelLabel_1);
				
		modelField_1 = new JTextField();
		modelField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modelField_1.setColumns(10);
		modelField_1.setBounds(100, 1, 129, 20);
		vPanel_1.add(modelField_1);
				
		plateField_1 = new JTextField();
		plateField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		plateField_1.setColumns(10);
		plateField_1.setBounds(100, 29, 129, 20);
		vPanel_1.add(plateField_1);
				
		JLabel plateLabel_1 = new JLabel("Plate Number:");
		plateLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				plateLabel_1.setBounds(0, 32, 85, 14);
		vPanel_1.add(plateLabel_1);
				
		colorField_1 = new JTextField();
		colorField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorField_1.setColumns(10);
		colorField_1.setBounds(100, 57, 129, 20);
		vPanel_1.add(colorField_1);
				
		JLabel colorLabel_1 = new JLabel("Color:");
		colorLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorLabel_1.setBounds(0, 60, 85, 14);
		vPanel_1.add(colorLabel_1);
				
		//User input matric number to search/register
		insertField = new JTextField();
		insertField.setBounds(116, 185, 235, 20);
		MainPage.add(insertField);
		insertField.setColumns(10);
		
		JButton backButton_1 = new JButton("Back");
        backButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0); //Go back to main page
			}
		});
				
		//List button bring to list page. Will list out registered users
		//Will list: matricNo, VehicleType, model and plateNo
		JButton listButton = new JButton("List");
		listButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Listing Registered Students","Message",JOptionPane.INFORMATION_MESSAGE);
				
				tabbedPane.setSelectedIndex(2);
				
				//dalam listPage, ada tablepanel, dalam tablepanel ada dua, scrollpane(table listing), dengan buttonpanel(bahagian buttons)
				JPanel tablePanel = new JPanel();
				tablePanel.setLayout(new BorderLayout());
			
				//design the table display
		        tableModel = new DefaultTableModel();
		        tableModel.addColumn("Matric No");
		        tableModel.addColumn("Plate No");
		        tableModel.addColumn("Model");
		        tableModel.addColumn("Type");
		        table = new JTable(tableModel);
		        JScrollPane scrollPane = new JScrollPane(table);
		        tablePanel.add(scrollPane, BorderLayout.CENTER);
		        
		        //adding back button
		        JPanel buttonPanel = new JPanel();
		        buttonPanel.add(backButton_1);
		        tablePanel.add(buttonPanel, BorderLayout.SOUTH);
		        
		        //below this adalah untuk tujuan refresh table
		        // Clear existing components in ListPage
		        ListPage.removeAll();
		        
		        //sebab dah remove, letak balik component
		        ListPage.setLayout(new BorderLayout());
		        ListPage.add(tablePanel, BorderLayout.CENTER);
		        
		        //Repaint the ListPage to reflect changes
		        ListPage.revalidate();
		        ListPage.repaint();
		        
		        // Retrieve student data to fill in the table
		        Vector<Vector<Object>> vehicleData = query.retrieveVehicleList();
		        for (Vector<Object> vehicle : vehicleData) {
		            tableModel.addRow(vehicle);
		        }
			}
		});
		listButton.setBounds(252, 216, 89, 23);
		MainPage.add(listButton);
		
		//Cancel button will reset all input and return to main page
		//Go back setSelectedIndex(0)
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
		
		//Button Back will bring user back to Main Page
		//setSelectedIndex(0)
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0); //Go back to main page
				insertField.setText("");
			}
		});
		backButton.setForeground(Color.BLACK);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(20, 348, 204, 34);
		RegistrationPage_1.add(backButton);
		
		//Will delete user information from database
		//Have confirmation message
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//message YES NO
				int responses = JOptionPane.showConfirmDialog(null, "Do you want to delete student " + student.matricNo + "?", "Delete?", JOptionPane.YES_NO_OPTION);
				if (responses == JOptionPane.YES_OPTION) {
					//delete vehicle then student
					query = new DatabaseQuery();
					query.deleteVehicle(student);
					query.deleteStudent(student);
					//Message student been deleted
					JOptionPane.showMessageDialog(null, "Student data has been deleted", "Deleted", JOptionPane.INFORMATION_MESSAGE);
				}
				
				//Go back main page
				tabbedPane.setSelectedIndex(3);
				insertField.setText("");
			}
		});
		deleteButton.setForeground(new Color(204, 0, 0));
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setBounds(241, 348, 204, 34);
		RegistrationPage_1.add(deleteButton);
		
		//Will Update user information to database
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//allow update
				String name = nameField_1.getText();			
				String icNo = icField_1.getText();
				String matricNo = student.matricNo;
				String phoneNo = phoneField_1.getText();
				int yearStudy = (Integer) spinner_1.getValue();
				String faculty = facultyField_1.getText();
				String address = addressField_1.getText();
				String vehicleType = null;	
				if (CarRadioButton_1.isSelected()) {
					vehicleType = car.isType();
				} else if (MotorRadioButton_1.isSelected()) {
					vehicleType = motor.isType();
				}
				String model = modelField_1.getText();
				String plateNo = plateField_1.getText();
				String color = colorField_1.getText();
				
				//exception
				try {
					if (name.isEmpty()) {
						throw new Exception("Name cannot be empty.");
					}
					if (icNo.isEmpty()) {
						throw new Exception("IC number cannot be empty.");
					}
					if (icNo.length()>14) {
						throw new Exception("IC number exceeds 14 characters.");
					}
					if (phoneNo.isEmpty()) {
						throw new Exception("Phone Number cannot be empty.");
					}
					if (phoneNo.length() >11) {
						throw new Exception("Phone Number exceeds 11 characters.");
					}
					if (faculty.isEmpty()) {
						throw new Exception("Faculty cannot be empty.");
					}
					if (faculty.length() > 10 ) {
						throw new Exception("Faculty name exceeds 10 characters.");
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
					if (plateNo.length() > 12) {
						throw new Exception("Plate number exceeds 12 characters.");
					}
					if (color.isEmpty()) {
						throw new Exception("Vehicle color cannot be empty.");
					}
					
					//invoke information into class
					if (address == null || address.trim().isEmpty() ) {
						student = new Student(icNo, name, matricNo, phoneNo, yearStudy, faculty);
					} else {
						student = new Student(icNo, name, matricNo, phoneNo, yearStudy, address, faculty);
					}	
					vehicle = new Vehicle(plateNo, model, color, vehicleType);	
					
					//invoke into information into database
					query.updateStudent(student);
					query.updateVehicle(student, vehicle);
					
					JOptionPane.showMessageDialog(null, "Student updated successfully!");	
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		saveButton.setForeground(new Color(51, 204, 0));
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveButton.setBackground(Color.WHITE);
		saveButton.setBounds(132, 393, 204, 34);
		RegistrationPage_1.add(saveButton);
		
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String name = nameField.getText();			
				String icNo = icField.getText();
				String phoneNo = phoneField.getText();
				String matricNo = matricField.getText();
				int yearStudy = (Integer) spinner.getValue();
				String faculty = facultyField.getText();
				String address = addressField.getText();
				String vehicleType = null;
				String type = "";
				if (CarRadioButton.isSelected()) {
					vehicleType = car.isType();
					type = car.isType();
				} else if (MotorRadioButton.isSelected()) {
					vehicleType = motor.isType();
					type = motor.isType();
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
					if (icNo.length()>14) {
						throw new Exception("IC number exceeds 14 characters.");
					}
					if (phoneNo.isEmpty()) {
						throw new Exception("Phone Number cannot be empty.");
					}
					if (phoneNo.length() >11) {
						throw new Exception("Phone Number exceeds 11 characters.");
					}
					if (matricNo.isEmpty()) {
						throw new Exception("Matric number cannot be empty");
					}
					if (matricNo.length() > 10) {
						throw new Exception("Matric number exceeds 10 characters.");
					}
					if (faculty.isEmpty()) {
						throw new Exception("Faculty cannot be empty.");
					}
					if (faculty.length() > 10 ) {
						throw new Exception("Faculty name exceeds 10 characters.");
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
					if (plateNo.length() > 12) {
						throw new Exception("Plate number exceeds 12 characters.");
					}
					if (color.isEmpty()) {
						throw new Exception("Vehicle color cannot be empty.");
					}
					
					if (!query.existStudent(matricNo)) {
						//invoke information into class
						if (address == null || address.trim().isEmpty() ) {
							student = new Student(icNo, name, matricNo, phoneNo, yearStudy, faculty);
						} else {
							student = new Student(icNo, name, matricNo, phoneNo, yearStudy, address, faculty);
						}
						
						vehicle = new Vehicle(plateNo, model, color, vehicleType);
															
						//invoke into information into database
						query.addStudent(student);
						query.addVehicle(student, vehicle);
						
						JOptionPane.showMessageDialog(null, "Student registered " + type + " successfully!"); 
					} else {
						JOptionPane.showMessageDialog(null, "Student already registered"); 
					}
					
					tabbedPane.setSelectedIndex(0);
					insertField.setText("");
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,  "Year invalid", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		
		//search based on input, if not register will prompt choice
		//if user registered, bring to Detials tab setSelectedIndex(3)
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = insertField.getText();
				try {
					if (input.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please input student matric number.","Error", JOptionPane.ERROR_MESSAGE);
					} 
					if (input.length() != 10) {
						JOptionPane.showMessageDialog(null, "Please input valid matric number.","Error", JOptionPane.ERROR_MESSAGE);
					}
					//Check input(matric no) if in database, if exist go to tab pane(3) display registered details
					else if (query.existStudent(input)) {
						student.matricNo = input;
						query.retrieveStudent(student);
						query.retrieveVehicle(student, vehicle);
								
						nameField_1.setText(student.getName());
						icField_1.setText(student.getIcNo());
						phoneField_1.setText(student.getPhoneNo());
						matricField_1.setText(student.matricNo);
						spinner_1.setValue(student.getYearStudy());
						facultyField_1.setText(student.getFaculty());
						addressField_1.setText(student.getAddress());
						modelField_1.setText(vehicle.getModel());
						plateField_1.setText(vehicle.getPlateNo());
						colorField_1.setText(vehicle.getColor());
						if ("Car".equals(vehicle.getVehicleType())) {
							CarRadioButton_1.setSelected(true);
						} else if ("Motorcycle".equals(vehicle.getVehicleType())) {
							MotorRadioButton_1.setSelected(true);
						}
						
						//open display page
						tabbedPane.setSelectedIndex(3);			
					} else {
						int response = JOptionPane.showConfirmDialog(null, "Student " + input + " not registered. Do you want to register?", "Register?", JOptionPane.YES_NO_OPTION);
						if (response == JOptionPane.YES_OPTION) {
							tabbedPane.setSelectedIndex(1); //bring to register page
							matricField.setText(input); //set the matricNo to the input
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		searchButton.setBounds(126, 216, 89, 23);
		MainPage.add(searchButton);
	}
}
