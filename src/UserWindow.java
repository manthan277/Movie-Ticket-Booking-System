import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class UserWindow implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton loginButton, signupButton, bckButton;
	JLabel background;
	JLabel titleLabel;
	public void displayUserWindow()
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
		titleLabel = new JLabel("User's Window");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(310, 100, sizeTitle.width, sizeTitle.height);
		
		//Log-in button
		loginButton = new JButton("Log-in");
		loginButton.setBounds(400, 250, 150, 75);
		loginButton.addActionListener(this);
		
		//Sign-up Button
		signupButton = new JButton("Sign-up");
		signupButton.setBounds(400, 400, 150, 75);
		signupButton.addActionListener(this);
		
		//Back button
		bckButton = new JButton("Back");
		bckButton.setBounds(400, 550, 150, 75);
		bckButton.addActionListener(this);

		frame.add(background);
		background.add(loginButton);
		background.add(bckButton);
		background.add(signupButton);
		background.add(titleLabel);
		//frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginButton){
			System.out.println("Login Successful!");
			frame.dispose();
			UserLogin l = new UserLogin();
			l.loginMenu();
		}
		else if(e.getSource()==signupButton){
			System.out.println("Sign up successful!");
			frame.dispose();
			SignUp s = new SignUp();
			s.signupMenu();
		}
		else if(e.getSource()==bckButton){
			frame.dispose();
			MainWindow s = new MainWindow();
			s.displayMainWindow();
		}
	}
}