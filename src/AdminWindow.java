import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminWindow implements ActionListener{
	JFrame frame;
	JLabel background, titleLabel;
	JTable table;
	JButton showbtn, bckbtn, chatbtn; 
	public void adminMenu()
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
		titleLabel = new JLabel("Admin's Window");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(310, 100, sizeTitle.width, sizeTitle.height);

		//Details button
		showbtn = new JButton("Add Show Details");
		showbtn.setBounds(400, 250, 150, 75);
		showbtn.addActionListener(this);
		
		//Chat button
		chatbtn = new JButton("Chat");
		chatbtn.setBounds(400, 400, 150, 75);
		chatbtn.addActionListener(this);
		
		//Exit Button
		bckbtn = new JButton("Exit");
		bckbtn.setBounds(400, 550, 150, 75);
		bckbtn.addActionListener(this);
	
		frame.add(background);
		background.add(showbtn);
		background.add(chatbtn);
		background.add(bckbtn);
		background.add(titleLabel);
		//frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==showbtn){
			frame.dispose();
			Shows t = new Shows();
			t.addshows();
		} 
		else if(e.getSource()==chatbtn){
			//frame.dispose();
			try {
				Server s = new Server();
				s.go();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==bckbtn){
			frame.dispose();
			MainWindow u = new MainWindow();
			u.displayMainWindow();
		}
	}
}
