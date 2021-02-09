import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class UserLogin implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel background;
	JLabel titleLabel;
	JLabel uLabel, pLabel;
	JTextField uTxt, pTxt;
	JButton submitButton, bckButton;
	public void loginMenu()
	{
		frame = new JFrame();
		//panel = new JPanel();
		frame.setSize(1000, 700);
		frame.setTitle("Movie Ticket Booking System");
		
		//background
		background = new JLabel();
		background.setIcon(new ImageIcon(new ImageIcon("D:\\Desktop\\movie1.jpeg").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT)));
		//background.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\medical\\bg.jpg"));
		Dimension size1 = background.getPreferredSize();
		background.setBounds(0, 0, size1.width, size1.height);
		
		//title
		titleLabel = new JLabel("User's Login Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(310, 100, sizeTitle.width, sizeTitle.height);

		//Username
		uLabel = new JLabel("Username: ");
		uLabel.setFont(uLabel.getFont().deriveFont(20.0f));
		uLabel.setForeground(Color.WHITE);
		uLabel.setBounds(450, 260, 200, 40);
		uTxt = new JTextField();
		uTxt.setBounds(375, 300, 250, 35);
		
		//Password
		pLabel = new JLabel("Password: ");
		pLabel.setFont(pLabel.getFont().deriveFont(20.0f));
		pLabel.setForeground(Color.WHITE);
		pTxt = new JTextField();
		pLabel.setBounds(450, 360, 200, 40);
		pTxt.setBounds(375, 400, 250, 35);
		
		//Submit Button
		submitButton = new JButton("Submit");
		submitButton.setBounds(325, 490, 150, 75);
		submitButton.addActionListener(this);
		
		//Back button
		bckButton = new JButton("Back");
		bckButton.setBounds(550, 490, 150, 75);
		bckButton.addActionListener(this);

		
		frame.add(background);
		background.add(uLabel);
		background.add(pLabel);
		background.add(titleLabel);
		background.add(pTxt);
		background.add(uTxt);
		background.add(submitButton);
		background.add(bckButton);
		//frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bckButton){
			frame.dispose();
			UserWindow s = new UserWindow();
			s.displayUserWindow();
		}
		else if(e.getSource()==submitButton){
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_system","root","Oshan@1999");   
				Statement stmt=con.createStatement();
				String username = uTxt.getText();
				String password = pTxt.getText();
				String query = "select * from user where username='"+username+"';";
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next())
				{
					if(username.equals(rs.getString(6))==true)
					{
						if(password.equals(rs.getString(7))){
							JOptionPane.showMessageDialog(frame, "Log-in Successful");
							String name = rs.getString(2);
							frame.dispose();
							User mw = new User();
							mw.userMenu(name);
						}
						else{
							JOptionPane.showMessageDialog(frame, "Incorrect Password");
							//frame.dispose();
						}
					}
					else
						JOptionPane.showMessageDialog(frame, "Username does not exist");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
