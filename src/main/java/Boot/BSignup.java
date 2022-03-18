package Boot;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class BSignup extends JFrame
{
    JButton back = new JButton();
    JButton signup2 = new JButton();
    JPanel panel3 = new JPanel();
    JLabel firstName = new JLabel();
    JTextField first = new JTextField();
    JLabel lastName = new JLabel();
    JTextField last = new JTextField();
    JLabel username = new JLabel(); 
    JTextField user = new JTextField();
    JLabel password = new JLabel();
    JPasswordField pass = new JPasswordField();
    BSignup()
    {
        super("Bachelor's Housing Management System");
        
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(Color.BLACK);
        add(panel3);
        getContentPane();
        
        firstName= new JLabel ("First Name");
        firstName.setBounds(80, 43, 400, 35);
        firstName.setForeground(Color.WHITE);
        firstName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panel3.add(firstName);
        
        first = new JTextField();
        first.setBounds(145, 50, 70, 20);
        panel3.add(first);
        
        lastName= new JLabel ("Last Name");
        lastName.setBounds(220, 43, 400, 35);
        lastName.setForeground(Color.WHITE);
        lastName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panel3.add(lastName);
        
        last = new JTextField();
        last.setBounds(285, 50, 70, 20);
        panel3.add(last);
        
        username = new JLabel("Username");
        username.setBounds(100, 93, 400, 35);
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panel3.add(username);
        
        user = new JTextField();
        user.setBounds(165, 100, 150, 20);
        panel3.add(user);
        
        
        password = new JLabel("Password");
        password.setBounds(100, 143, 400, 35);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panel3.add(password);
        
        pass = new JPasswordField();
        pass.setBounds(165, 150, 150, 20);
        panel3.add(pass);
        
        
        signup2 = new JButton("Sign Up");
        signup2.setBounds(165, 200, 80, 20);
        panel3.add(signup2);
        
        back = new JButton("Back");
        back.setBounds(5, 5, 70, 20);
        panel3.add(back);
        
        HandlerClass handler = new HandlerClass();
	signup2.addActionListener(handler);
        back.addActionListener(handler);
        
    }
    
    public class HandlerClass implements ActionListener
	{
            
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==signup2)
                        {
                            Component signup = null;
                            String filename = ".txt";
                            File bAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\Bachelor_Acc\\" + user.getText() + filename);
                            
                            if(bAcc.exists())
                            {
                                JOptionPane.showMessageDialog(signup, "Username Taken. Please Try Again!");
                            }
                            
                            else
                            {
                                
                            
                                try 
                                {
                                
                                String balance = "Balance: 0";
                                String fullString = "Fullname: ";
                                String passString = "Password: ";
                            
                                FileWriter bAccount = new FileWriter("C:\\BHMS\\src\\main\\java\\Boot\\Bachelor_Acc\\" + user.getText() + filename);
                                bAccount.write(passString);
                                pass.write(bAccount);
                                bAccount.write(System.getProperty("line.separator"));
                                bAccount.write(fullString);
                                first.write(bAccount);
                                bAccount.write(" ");
                                last.write(bAccount);
                                bAccount.write(System.getProperty("line.separator"));
                                bAccount.write(balance);
                                bAccount.close();
                                
                                
                                JOptionPane.showMessageDialog(signup, "Sign Up Succesfull!");
                                dispose();
                                Portal portal = new Portal();
                                portal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                portal.setSize(450,300);
                                portal.setVisible(true);
                                portal.setLocation(450,200);
                                portal.setResizable(false);
                                } 
                                
                                catch (IOException iOException) 
                                {
                                
                                }
                            }
                        }
                        
                        
                        else if(event.getSource()==back)
                        {
                            dispose();
                            PreSignup signup = new PreSignup();
                            signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            signup.setSize(450,300);
                            signup.setVisible(true);
                            signup.setLocation(450,200);
                            signup.setResizable(false);

                            
                        }
                         
                        
                        
		} 
    }
    
}
