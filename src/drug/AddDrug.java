/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drug;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ahmed.tagalsir
 */
public class AddDrug  extends JFrame{
    
    JTextField textField;
    JComboBox c1;
    
    public AddDrug(){
         getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD DRUG DETAILS");
        
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
            
            JLabel Dname = new JLabel("NAME");
            Dname.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Dname.setBounds(60, 30, 150, 27);
            add(Dname);
            
            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            add(textField);
            
            
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
            
            JLabel Damount = new JLabel("AMOUNT");
            Damount.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Damount.setBounds(60, 80, 150, 27);
            add(Damount);
			
            JTextField textField_1 = new JTextField();
            textField_1.setBounds(200, 80, 150, 27);
            add(textField_1);
            
            JLabel Dtype = new JLabel("TYPE");
            Dtype.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Dtype.setBounds(60, 120, 150, 27);
            add(Dtype);

            
            JRadioButton NewRadioButton = new JRadioButton("DRINK");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 120, 70, 27);
            add(NewRadioButton);
	
            JRadioButton Caps = new JRadioButton("CAPSULES");
            Caps.setBackground(Color.WHITE);
            Caps.setBounds(280, 120, 70, 27);
            add(Caps);
            
            
            JLabel Ddisease = new JLabel("DISEASE");
            Ddisease.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Ddisease.setBounds(60, 170, 150, 27);
            add(Ddisease);
            
             JTextField textField_2 = new JTextField();
            textField_2.setBounds(200,170,150,30);
            add(textField_2);
            
            JLabel lblPath = new JLabel("Select Photo:");
             lblPath.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lblPath.setBounds(60, 220, 150, 27);
            add(lblPath);

           JTextField txtPath = new JTextField(15);  
           txtPath.setText("No File Uploaded");
           txtPath.setBounds(200, 220, 150, 27);
           add(txtPath);

           JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            JButton btnBrowse = new JButton("Browse");
            btnBrowse.setBounds(400, 220, 150, 27);
            add(btnBrowse);
            btnBrowse.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                    int r = j.showOpenDialog(null);
                 if (r == JFileChooser.APPROVE_OPTION)
 
            {
                // set the label to the path of the selected file
                txtPath.setText(j.getSelectedFile().getAbsolutePath());
            }
            // if the user cancelled the operation
            else
                txtPath.setText("the user cancelled the operation");
        }
             
            
            });
            
           
            
            Next.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                  String name = textField.getText();
                    String amount = textField_1.getText();
                    String dis = textField_2.getText();
                    
                  String type = null;
                    
                    if(NewRadioButton.isSelected()){
                        type = "drink";
                    
                    }else if(Caps.isSelected()){
                        type = "capsoule";
                    }
                    
                     File file = new File(txtPath.getText());
            FileInputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddDrug.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] rawBytes = null; 
        int imageLength = Integer.parseInt(String.valueOf(file.length())); 
        rawBytes = new byte[imageLength]; 
                 try {
                     input.read(rawBytes, 0, imageLength);
                 } catch (IOException ex) {
                     Logger.getLogger(AddDrug.class.getName()).log(Level.SEVERE, null, ex);
                 }
        
                   try {
                        conn c = new conn();
                      
                        
                        
                        String str = "INSERT INTO drug values( null,'"+name+"', '"+amount+"', '"+type+"','"+dis+"', '"+input+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                    
                    } catch(Exception ex) {
                        ex.printStackTrace();
        	    }  
             }
                
            });

            
            
    }
    
    
    
     public static void main(String[] args){
        new AddDrug().setVisible(true);
    }  
    
}
