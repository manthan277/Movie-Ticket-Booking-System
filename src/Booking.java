import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Booking implements ActionListener{
	JFrame frame,f;
	JLabel background, titleLabel, drop, seat, nameLabel;
	JTextField seatTxt,nameTxt;
	JTable table;
	JButton showbtn, bckbtn, insbtn, dbtn; 
    String ins[] = {" "," "," "," "};
	public void bookTickets()
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
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(275, 185, 250, 50);
		nameTxt = new JTextField();
		nameTxt.setBounds(500, 195, 200, 30);
		
		
		//title
		titleLabel = new JLabel("Book Tickets");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(350, 100, sizeTitle.width, sizeTitle.height);

		//Combo Box
		drop = new JLabel("Select show of your choice: ");
		drop.setFont (drop.getFont().deriveFont (15.0f));
		drop.setForeground(Color.WHITE);
		drop.setBounds(275, 245, 250, 50);
		final JComboBox<String> combo=new JComboBox<String>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_system","root","Oshan@1999");   
			Statement stmt=con.createStatement();
			String query = "select * from details;";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String show = rs.getString(2);
				String theat = rs.getString(3);
				String time = rs.getString(4);
				int cost = rs.getInt(7);
				String s = show + " |" + theat + " |" + time + " |" + cost;
				//System.out.println(s);
				combo.addItem(s);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		combo.setBounds(500,255,250,30 );

		ActionListener cbActionListener = new ActionListener() {
	        //@Override
	        public void actionPerformed(ActionEvent e) {
	            String str = (String) combo.getSelectedItem();
	            String[] res = str.split("[|]", 0);
	            int i = 0;
	            for(String myStr: res) {
	               ins[i] = myStr;
	               //System.out.println(ins[i]);
	               i++;
	            }
	        }
	    };
	    combo.addActionListener(cbActionListener);
	    
		seat = new JLabel("Number of tickets: ");
		seat.setFont (drop.getFont().deriveFont (15.0f));
		seat.setForeground(Color.WHITE);
		seat.setBounds(275, 305, 250, 50);
		seatTxt = new JTextField();
		seatTxt.setBounds(500, 310, 200, 30);
		
		//Submit Button
		insbtn = new JButton("Book");
		insbtn.setBounds(325, 490, 150, 75);
		insbtn.addActionListener(this);
		
		//Back button
		bckbtn = new JButton("Cancel");
		bckbtn.setBounds(550, 490, 150, 75);
		bckbtn.addActionListener(this);
	
		frame.add(background);
		background.add(drop);
		background.add(bckbtn);
		background.add(combo);
		background.add(drop);
		background.add(seat);
		background.add(insbtn);
		background.add(seatTxt);
		background.add(titleLabel);
		background.add(nameTxt);
		background.add(nameLabel);
		//frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void deleteBooking()
	{
		frame = new JFrame();
		//panel = new JPanel();
		frame.setSize(1000, 700);
		frame.setTitle("Drama Ticket Booking System");
		
		//background
		background = new JLabel();
		background.setIcon(new ImageIcon(new ImageIcon("D:\\\\Desktop\\\\movie1.jpeg").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT)));
		Dimension size1 = background.getPreferredSize();
		background.setBounds(0, 0, size1.width, size1.height);
		
		//title
		titleLabel = new JLabel("Delete Booking");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (45.0f));
		titleLabel.setForeground(Color.WHITE);
		Dimension sizeTitle = titleLabel.getPreferredSize();
		titleLabel.setBounds(350, 100, sizeTitle.width, sizeTitle.height);

		nameLabel = new JLabel("Name: ");
		nameLabel.setFont (nameLabel.getFont().deriveFont (15.0f));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(325, 235, 200, 50);
		nameTxt = new JTextField();
		nameTxt.setBounds(475, 245, 200, 30);
		
		//Delete Button
		dbtn = new JButton("Delete");
		dbtn.setBounds(325, 400, 150, 75);
		dbtn.addActionListener(this);
		
		//Cancel button
		bckbtn = new JButton("Cancel");
		bckbtn.setBounds(550, 400, 150, 75);
		bckbtn.addActionListener(this);

		frame.add(background);
		background.add(titleLabel);
		background.add(nameLabel);
		background.add(nameTxt);
		background.add(dbtn);
		background.add(bckbtn);
		dbtn.addActionListener(this);
		bckbtn.addActionListener(this);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insbtn)
		{
			String name = nameTxt.getText();
			String show = ins[0];
			String theatre = ins[1];
			//String t = ins[2];
			int seat = Integer.parseInt(seatTxt.getText());
			int cost = Integer.parseInt(ins[3])*seat;
			
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_system","root","Oshan@1999");   
				Statement stmt=con.createStatement();
				String query = "insert into booking values(null, '"+name+"', '"+show+"', '"+theatre+"', '3PM', '"+seat+"', '"+cost+"');";
	            stmt.executeUpdate(query);
	            System.out.println("Inserted Successfully");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, "Seats booked");
			frame.dispose();
			User mw = new User();
			mw.userMenu("-1");
		}
		else if(e.getSource()==dbtn) {
			JOptionPane.showMessageDialog(frame, "Confirm");
			frame.dispose();
			try{  
				String name = nameTxt.getText();
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_system","root","Oshan@1999");   
				Statement stmt=con.createStatement();
				String query = "delete from booking where name='"+name+"';";
	            stmt.executeUpdate(query);
	            //System.out.println("Deleted Booking Successfully");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, "Booking deleted succesfully");
			frame.dispose();
			User mw = new User();
			mw.userMenu("-1");
		}
		else if(e.getSource()==bckbtn){
			frame.dispose();
			MainWindow u = new MainWindow();
			u.displayMainWindow();
		}
	}
}
