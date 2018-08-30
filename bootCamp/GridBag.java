import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class GridBag extends JFrame implements ActionListener{

	JLabel firstName, lastName, address, phoneNum, national, occ, com;
	JButton enter, clear, close;
	JTextArea area;
	JTextField firstNameField, addField, lastNameField, numField, occField, naField;
	JPanel leftPane, rightPane, centerPane,buttn, mainPanel, headerPanel;
	
	GridBagLayout gridL = new GridBagLayout();
	
	Connection con;
	PreparedStatement pstmt;

	public GridBag(){

	super("InfoMe");
	setBounds(0,35,1400,700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	GridBagConstraints cons = new GridBagConstraints();
	setLayout(new BorderLayout());
	
	mainPanel = new JPanel();
	
	headerPanel = new JPanel();
	ImageIcon headerIcon = new ImageIcon("images/memberHeader.png");
	JLabel headerLabel = new JLabel(headerIcon);
	headerPanel.add(headerLabel);
	add(headerPanel, BorderLayout.NORTH);
	
	leftPane = new JPanel ();
	leftPane.setLayout(gridL);

	// for the firstName
	firstName = new JLabel(" First Name ");
	cons.gridx = 0;
	cons.gridy = 0;
	leftPane.add(firstName, cons);
	

	// for the Name text field
	firstNameField = new JTextField(15);
	cons.gridx = 1;
	cons.gridy = 0;
	cons.insets = new Insets(5,5,5,5);
	leftPane.add(firstNameField, cons);
	
	// for the Last Name 
	lastName = new JLabel(" Last Name");
	cons.gridx = 0;
	cons.gridy = 1;
	leftPane.add(lastName, cons);

	// for the last name text field
	lastNameField = new JTextField(15);
	cons.gridx = 1;
	cons.gridy = 1;
	leftPane.add(lastNameField, cons);

	// for number input
	phoneNum = new JLabel(" Phone Number");
	cons.gridx = 0;
	cons.gridy = 3;
	leftPane.add(phoneNum, cons);
	
	// for number Text field
	numField = new JTextField(15);
	cons.gridx = 1;
	cons.gridy = 3;
	leftPane.add(numField, cons);
	
	mainPanel.add(leftPane);
	
	centerPane = new JPanel();
	centerPane.setLayout(gridL);
	
	// for the Occupation Name
 	occ = new JLabel(" Occupation");
	cons.gridx = 0;
	cons.gridy = 0;
	centerPane.add(occ, cons);
	

	// for the occupation text field
	occField = new JTextField(15);
	cons.gridx = 1;
	cons.gridy = 0;
	cons.insets = new Insets(5,5,5,5);
	centerPane.add(occField, cons);
	
	// for the address Label
	address= new JLabel("Address");
	cons.gridx = 0;
	cons.gridy = 1;
	centerPane.add(address, cons);
	

	// for the address text field
	addField = new JTextField(15);
	cons.gridx = 1;
	cons.gridy = 1;
	cons.insets = new Insets(5,5,5,5);
	centerPane.add(addField, cons);
	
	// for number input
	national = new JLabel("Nationality");
	cons.gridx = 0;
	cons.gridy = 2;
	centerPane.add(national, cons);
	
	// for number Text field
	naField = new JTextField(15);
	cons.gridx = 1;
	cons.gridy = 2;
	centerPane.add(naField, cons);
	mainPanel.add(centerPane);
	
	
	rightPane = new JPanel();
	rightPane.setLayout(gridL);
	
	com = new JLabel("Other Info");
	cons.gridx = 0;
	cons.gridy = 1;
	rightPane.add(com, cons);
	
	//for the longer text
	area = new JTextArea(5,15);
	cons.gridx = 1;
	cons.gridy = 1;
	rightPane.add(area, cons);

	//for the address name field
	address = new JLabel("State of Origin");
	cons.gridx = 0;
	cons.gridy = 0;
	rightPane.add(address, cons);

	
	// for the address Field
	addField = new JTextField(15);
	cons.gridx = 1;
	cons.gridy = 0;
	rightPane.add(addField, cons);
	mainPanel.add(rightPane);
	
	add(mainPanel, BorderLayout.CENTER);
	
	buttn = new JPanel();
        close = new JButton("CLOSE");
	enter = new JButton("ENTER");
	clear = new JButton("CLEAR");
	buttn.add(close);
	buttn.add(enter);
	buttn.add(clear);
	buttn.setBackground(Color.BLUE);
	add(buttn, BorderLayout.SOUTH);
	
	close.addActionListener(this);
	clear.addActionListener(this);
	enter.addActionListener(this);

}
	
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		if(source == close)
		{
			System.exit(0);
		}
		else if (source == clear)
		{
			firstNameField.setText(" ");
		        addField.setText(" ");
			lastNameField.setText(" ");
			numField.setText(" ");
			occField.setText(" ");
			naField.setText(" ");
		}
		else if(source == enter)
		{
			saveData();
		}
		
	}
	void saveData()
	{
		String firstMemberName = firstNameField.getText();
		String lastMemberName = lastNameField.getText();
		String addressMember = addField.getText();
		String phoneMember = numField.getText();
		String occMember = occField.getText();
		String otherinfo = area.getText();
		String nationality = naField.getText();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","manager","oracle");
			pstmt = con.prepareStatement("INSERT INTO membertable(firstname, lastname,address,phonenum,nationality,occupation,otherinfo) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, firstMemberName);
			pstmt.setString(2, lastMemberName);
			pstmt.setString(3, addressMember);
			pstmt.setString(4, phoneMember);
			pstmt.setString(5, occMember);
			pstmt.setString(6, otherinfo);
			pstmt.setString(7, nationality);
			pstmt.executeUpdate();
			con.close();
			JOptionPane.showMessageDialog(null, "Member Inserted Successfully!", "Data Entry", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException sqle)
		{
			System.out.println("Error: "+ sqle);
			JOptionPane.showMessageDialog(null, "Cannot Record Data!", "Data Entry", JOptionPane.WARNING_MESSAGE);
		}
		catch(Exception e)	
		{
			System.out.println("Error1 "+ e);
			JOptionPane.showMessageDialog(null, "Cannot Record Data!", "Data Entry", JOptionPane.WARNING_MESSAGE);
		}
	}
 	public static void main(String [] args )
	{
		GridBag bag = new GridBag();
        bag.setVisible(true);
	}
}