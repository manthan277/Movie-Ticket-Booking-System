import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Shows implements ActionListener{
	JFrame frame,f;
	JCheckBox c1,c2,c3,c4,c5;
	JLabel background, titleLabel, showLabel, theatreLabel, timeLabel, stageLabel, priceLabel, seatLabel;
	JButton backBtn, insertBtn;
	JTextField showTxt, theatreTxt, stageTxt, priceTxt, seatTxt;
	public void addshows()
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
		titleLabel = new JLabel("Add Shows");
		titleLabel.setFont (titleLabel.getFont().deriveFont (30.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(400, 100, 600, sizeTitle.height);

		showLabel = new JLabel("Show Name: ");
		showLabel.setFont (showLabel.getFont().deriveFont (15.0f));
		showLabel.setForeground(Color.WHITE);
		showLabel.setBounds(325, 185, 250, 50);
		theatreLabel = new JLabel("Theatre Name: ");		
		theatreLabel.setForeground(Color.WHITE);
		theatreLabel.setFont (theatreLabel.getFont().deriveFont (15.0f));
		theatreLabel.setBounds(325, 245, 250, 50);
		timeLabel = new JLabel("Show timing: ");
		timeLabel.setFont (timeLabel.getFont().deriveFont (15.0f));
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setBounds(325, 305, 250, 50);
		JPanel f = new JPanel();
		String s1[] = {"9AM", "12PM", "3PM", "6PM", "9PM"};
		c1 = new JCheckBox(s1[0]); 
		c2 = new JCheckBox(s1[1]); 
		c3 = new JCheckBox(s1[2]); 
		c4 = new JCheckBox(s1[3]); 
		c5 = new JCheckBox(s1[4]); 
	    c1.setBounds(475, 315, 60, 30);
	    c2.setBounds(535, 315, 60, 30);
	    c3.setBounds(596, 315, 60, 30);
	    c4.setBounds(657, 315, 60, 30);
	    c5.setBounds(717, 315, 60, 30);
	    f.add(c1);  f.add(c2);  f.add(c3);  f.add(c4);  f.add(c5);        
	    f.setLayout(null);    
	    f.setSize(400,500);    
	    f.setVisible(true);         
	    
	    stageLabel = new JLabel("Screen : ");
		stageLabel.setFont (stageLabel.getFont().deriveFont (15.0f));
		stageLabel.setForeground(Color.WHITE);
		stageLabel.setBounds(325, 365, 250, 50);
		seatLabel = new JLabel("Number of Seats: ");
		seatLabel.setFont (seatLabel.getFont().deriveFont (15.0f));
		seatLabel.setForeground(Color.WHITE);
		seatLabel.setBounds(325, 425, 250, 50);
		priceLabel = new JLabel("Price per Seat: ");
		priceLabel.setFont(priceLabel.getFont().deriveFont(15.0f));
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setBounds(325, 485, 250, 50);
	    
		showTxt = new JTextField();
		showTxt.setBounds(475, 195, 200, 30);
		theatreTxt = new JTextField();
		theatreTxt.setBounds(475, 255, 200, 30);
		stageTxt = new JTextField();
		stageTxt.setBounds(475, 375, 200, 30);
		seatTxt = new JTextField();
		seatTxt.setBounds(475, 435, 200, 30);
		priceTxt = new JTextField();
		priceTxt.setBounds(475, 495, 200, 30);
		insertBtn = new JButton("Add");
		insertBtn.setBounds(415, 575, 150, 75);
		
		frame.add(background);
		background.add(titleLabel);
		background.add(showLabel);
		background.add(timeLabel);
		background.add(c1);
		background.add(c2);
		background.add(c3);
		background.add(c4);
		background.add(c5);
		background.add(theatreLabel);
		background.add(seatLabel);
		background.add(priceLabel);
		background.add(stageLabel);
		background.add(showTxt);
		background.add(theatreTxt);
		background.add(seatTxt);
		background.add(priceTxt);
		background.add(stageTxt);
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
			String show = showTxt.getText();
			String theatre = theatreTxt.getText();
			String stage = stageTxt.getText();
			int seats = Integer.parseInt(seatTxt.getText());
			int price = Integer.parseInt(priceTxt.getText());
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_system","root","Oshan@1999");   
				Statement stmt=con.createStatement();
				if(c1.isSelected()) {
					String query = "insert into details values(null, '"+show+"', '"+theatre+"', '9AM', '"+stage+"', '"+seats+"', '"+price+"');";
		            stmt.executeUpdate(query);
				}
				if(c2.isSelected()) {
					String query = "insert into details values(null, '"+show+"', '"+theatre+"', '12PM', '"+stage+"', '"+seats+"', '"+price+"');";
		            stmt.executeUpdate(query);
				}
				if(c3.isSelected()) {
					String query = "insert into details values(null, '"+show+"', '"+theatre+"', '3PM', '"+stage+"', '"+seats+"', '"+price+"');";
		            stmt.executeUpdate(query);
				}
				if(c4.isSelected()) {
					String query = "insert into details values(null, '"+show+"', '"+theatre+"', '6PM', '"+stage+"', '"+seats+"', '"+price+"');";
		            stmt.executeUpdate(query);
				}
				if(c5.isSelected()) {
					String query = "insert into details values(null, '"+show+"', '"+theatre+"', '9PM', '"+stage+"', '"+seats+"', '"+price+"');";
		            stmt.executeUpdate(query);
				}
	            System.out.println("Inserted Successfully");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, "Inserted Successfully");
			frame.dispose();
			AdminWindow mw = new AdminWindow();
			mw.adminMenu();
		}
	}
}
