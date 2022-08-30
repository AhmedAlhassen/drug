package drug;


import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddUser extends JFrame{ //Third Frame

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1;

        public AddUser(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD USER DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Passportno = new JLabel("NAME");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 30, 150, 27);
            add(Passportno);
            
            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            add(textField);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 280, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
			
            JLabel Pnrno = new JLabel("PASSWORD");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnrno.setBounds(60, 80, 150, 27);
            add(Pnrno);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 80, 150, 27);
            add(textField_1);
            
            
            
          
            		
           
			
            
	
            JLabel Mail = new JLabel("email");
            Mail.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Mail.setBounds(60, 170, 150, 27);
            add(Mail);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200,170,150,30);
            add(textField_4);
            
              JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 120, 150, 27);
            add(Address);
	
            textField_5 = new JTextField();
            textField_5.setBounds(200, 120, 150, 27);
            add(textField_5);
	
         
	
            
          
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD User DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            add(AddPassengers);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,480,410);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String name = textField.getText();
                    String age = textField_1.getText();
                 
                    String phone = textField_4.getText();
                    String aadhar = textField_5.getText();
                   
                   
                   
                    
                  
                            
                    
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO user values(  '"+name+"', '"+age+"','"+phone+"', '"+aadhar+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"User Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(530,200);
			
	}
        
    public static void main(String[] args){
        new AddUser();
    }   
}