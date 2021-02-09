import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton adminButton, userButton, exitButton;
	JLabel background;
	JLabel titleLabel;
	public void displayMainWindow()
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
		titleLabel = new JLabel("Movie Ticket Booking System");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(175, 100, sizeTitle.width, sizeTitle.height);

		//Admin button
		adminButton = new JButton("Admin");
		adminButton.setBounds(400, 250, 150, 75);
		adminButton.addActionListener(this);
		
		//User Button
		userButton = new JButton("User");
		userButton.setBounds(400, 400, 150, 75);
		userButton.addActionListener(this);
		
		//Exit Button
		exitButton = new JButton("Exit");
		exitButton.setBounds(400, 550, 150, 75);
		exitButton.addActionListener(this);
		
		frame.add(background);
		background.add(adminButton);
		background.add(exitButton);
		background.add(userButton);
		background.add(titleLabel);
		//frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==adminButton){
			frame.dispose();
			AdminLogin a = new AdminLogin();
			a.loginMenu();
		}
		else if(e.getSource()==userButton){
			frame.dispose();
			UserWindow u = new UserWindow();
			u.displayUserWindow();
		}
		else if(e.getSource()==exitButton){
			frame.dispose();
		}
	}
}