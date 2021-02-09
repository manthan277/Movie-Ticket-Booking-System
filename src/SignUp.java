import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class SignUp implements ActionListener{
	JFrame frame;
	JLabel background, titleLabel;
	JButton backBtn, insertBtn;
	JLabel fnameLabel, lnameLabel, phoneLabel, cityLabel, usernameLabel, passwordLabel;
	JTextField fnameTxt, lnameTxt, phoneTxt, cityTxt, usernameTxt, passwordTxt;
	public void signupMenu()
	{
		frame = new JFrame();
		//panel = new JPanel();
		frame.setSize(1000, 700);
		frame.setTitle("Movie Ticket Booking System");
		
		//background
		background = new JLabel();
		background.setIcon(new ImageIcon(new ImageIcon("D:\\Desktop\\movie1.jpeg").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT)));
		Dimension size1 = background.getPreferredSize();
		background.setBounds(0, 0, size1.width, size1.height);
		
		//title
		titleLabel = new JLabel("Sign-Up");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(425, 100, 600, sizeTitle.height);

		fnameLabel = new JLabel("First Name: ");
		fnameLabel.setFont (fnameLabel.getFont().deriveFont (15.0f));
		fnameLabel.setForeground(Color.WHITE);
		fnameLabel.setBounds(325, 185, 250, 50);
		lnameLabel = new JLabel("Last Name: ");		
		lnameLabel.setForeground(Color.WHITE);
		lnameLabel.setFont (lnameLabel.getFont().deriveFont (15.0f));
		lnameLabel.setBounds(325, 245, 250, 50);
		phoneLabel = new JLabel("Mobile no: ");
		phoneLabel.setFont (phoneLabel.getFont().deriveFont (15.0f));
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setBounds(325, 305, 250, 50);
		cityLabel = new JLabel("City: ");
		cityLabel.setFont (cityLabel.getFont().deriveFont (15.0f));
		cityLabel.setForeground(Color.WHITE);
		cityLabel.setBounds(325, 365, 250, 50);
		usernameLabel = new JLabel("Username: ");
		usernameLabel.setFont (usernameLabel.getFont().deriveFont (15.0f));
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(325, 425, 250, 50);
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setFont(passwordLabel.getFont().deriveFont(15.0f));
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(325, 485, 250, 50);
		
		fnameTxt = new JTextField();
		fnameTxt.setBounds(475, 195, 200, 30);
		lnameTxt = new JTextField();
		lnameTxt.setBounds(475, 255, 200, 30);
		phoneTxt = new JTextField();
		phoneTxt.setBounds(475, 315, 200, 30);
		cityTxt = new JTextField();
		cityTxt.setBounds(475, 375, 200, 30);
		usernameTxt = new JTextField();
		usernameTxt.setBounds(475, 435, 200, 30);
		passwordTxt = new JTextField();
		passwordTxt.setBounds(475, 495, 200, 30);
		
		insertBtn = new JButton("Register");
		insertBtn.setBounds(415, 575, 150, 75);
		
		frame.add(background);
		background.add(titleLabel);
		background.add(fnameLabel);
		background.add(phoneLabel);
		background.add(lnameLabel);
		background.add(cityLabel);
		background.add(usernameLabel);
		background.add(passwordLabel);
		background.add(fnameTxt);
		background.add(lnameTxt);
		background.add(phoneTxt);
		background.add(usernameTxt);
		background.add(passwordTxt);
		background.add(cityTxt);
		background.add(insertBtn);
		insertBtn.addActionListener(this);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==insertBtn)
		{
			String f_name = fnameTxt.getText();
			String l_name = lnameTxt.getText();
			String city = cityTxt.getText();
			String phone = phoneTxt.getText();
			String username = usernameTxt.getText();
			String pass = passwordTxt.getText();
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_system","root","Oshan@1999");   
				Statement stmt=con.createStatement();
				String query = "insert into user values(null, '"+f_name+"', '"+l_name+"', "+phone+", '"+city+"', '"+username+"', '"+pass+"');";
	            stmt.executeUpdate(query);
	            System.out.println("Inserted Successfully");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, "Signed in Successfully");
			frame.dispose();
			UserLogin mw = new UserLogin();
			mw.loginMenu();
		}
	}
}
