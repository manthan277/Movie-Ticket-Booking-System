import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class User implements ActionListener{
	JFrame frame;
	JLabel background, titleLabel;
	JTable table;
	JButton bookbtn, deletebtn, bckbtn,chatbtn; 
	String s1="";
	public void userMenu(String name)
	{
		s1=name;
		frame = new JFrame();
		//panel = new JPanel();
		frame.setSize(1000, 900);
		frame.setTitle("Movie Ticket Booking System");
		
		//background
		background = new JLabel();
		background.setIcon(new ImageIcon(new ImageIcon("D:\\Desktop\\movie1.jpeg").getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT)));
		Dimension size1 = background.getPreferredSize();
		background.setBounds(0, 0, size1.width, size1.height);
		
		//title
		titleLabel = new JLabel("User Menu");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(350, 100, sizeTitle.width, sizeTitle.height);

		//Details button
		bookbtn = new JButton("Book tickets");
		bookbtn.setBounds(400, 250, 150, 75);
		bookbtn.addActionListener(this);
		
		//Chat button
		chatbtn = new JButton("Chat");
		chatbtn.setBounds(400, 400, 150, 75);
		chatbtn.addActionListener(this);
		
		
		//Delete Button
		deletebtn = new JButton("Delete Booking");
		deletebtn.setBounds(400, 550, 150, 75);
		deletebtn.addActionListener(this);
		
		//Exit Button
		bckbtn = new JButton("Exit");
		bckbtn.setBounds(400, 700, 150, 75);
		bckbtn.addActionListener(this);
	
		frame.add(background);
		background.add(bookbtn);
		background.add(chatbtn);
		background.add(deletebtn);
		background.add(bckbtn);
		background.add(titleLabel);
		//frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bookbtn){
			frame.dispose();
			Booking b = new Booking();
			b.bookTickets();
		}
		else if(e.getSource()==chatbtn){
			//frame.dispose();
			try {
				Client s = new Client();
				s.go(s1);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==deletebtn){
			frame.dispose();
			Booking c = new Booking();
			c.deleteBooking();
		}
		else if(e.getSource()==bckbtn){
			frame.dispose();
			MainWindow u = new MainWindow();
			u.displayMainWindow();
		}
	}
}
