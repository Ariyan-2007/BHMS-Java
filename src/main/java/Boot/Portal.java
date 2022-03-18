package Boot;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Portal extends JFrame
{
	JButton login1 = new JButton();
	JButton signup1 = new JButton();
	JPanel panel1 = new JPanel();
        JLabel headline = new JLabel();
        
	public Portal()
	{
		super("Bachelor's Housing Management System");
                
                
                panel1 = new JPanel();
                panel1.setLayout(null);
                panel1.setBackground(Color.BLACK);
                add(panel1);
                getContentPane();
                
                headline = new JLabel("Welcome To Bachelor's Housing Management System");
                headline.setBounds(40, 50, 400, 35);
                headline.setForeground(Color.WHITE);
                headline.setFont(new Font("Times New Roman", Font.BOLD, 15));
                panel1.add(headline);
                        
		login1 = new JButton("Login");
                login1.setBounds(165, 150, 100, 35);
		panel1.add(login1);
		
		signup1 = new JButton("Sign Up");
                signup1.setBounds(165,200, 100, 35);
		panel1.add(signup1);
		
		HandlerClass handler = new HandlerClass();
		login1.addActionListener(handler);
		signup1.addActionListener(handler);
		
	}
	
	private class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==login1)
                        {
                            dispose();
                            PreLogin login = new PreLogin();
                            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            login.setSize(450,300);
                            login.setVisible(true);
                            login.setLocation(450,200);
                            login.setResizable(false);
                            
                        }
                        
                        
                        else if(event.getSource()==signup1)
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