package Boot;

import Bachelor.BGeneral;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BLogin extends JFrame
{
    JButton back = new JButton();
    JButton login2 = new JButton();
    JPanel panel2 = new JPanel();
    JLabel username = new JLabel();
    JTextField user = new JTextField();
    String getUser;
    JLabel password = new JLabel();
    JPasswordField pass = new JPasswordField();
    public BLogin()
    {
        super("Bachelor's Housing Management System");
        
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.BLACK);
        add(panel2);
        getContentPane();
        
        username = new JLabel("Username");
        username.setBounds(100, 93, 400, 35);
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panel2.add(username);
        
        user = new JTextField();
        user.setBounds(165, 100, 150, 20);
        panel2.add(user);
        
        
        password = new JLabel("Password");
        password.setBounds(100, 143, 400, 35);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panel2.add(password);
        
        pass = new JPasswordField();
        pass.setBounds(165, 150, 150, 20);
        panel2.add(pass);
        
        login2 = new JButton("Login");
        login2.setBounds(165, 200, 80, 20);
        panel2.add(login2);
        
        back = new JButton("Back");
        back.setBounds(5, 5, 70, 20);
        panel2.add(back);
        
        HandlerClass handler = new HandlerClass();
	login2.addActionListener(handler);
        back.addActionListener(handler);
    }
    public class HandlerClass implements ActionListener
	{
                   
                  
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==login2)
                        {
                            Component login = null;
                              String filename = ".txt";
                              
                              File bAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\Bachelor_Acc\\" + user.getText() + filename);
             
                            if(bAcc.exists())
                            {
                                try {
                                    Scanner scan = new Scanner(bAcc);
                                    String passv1 = "Password: ";
                                    char[] passvc = pass.getPassword();
                                    String passv2 = new String(passvc);
                                    String passv4 = passv1.concat(passv2);
                                    String passv3 = scan.nextLine();
                                    
                                    if(passv3.equals(passv4))
                                    {
                                        dispose();
                                        getUser = user.getText();
                                        BGeneral general = new BGeneral(getUser);
                                        general.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        general.setSize(550,400);
                                        general.setVisible(true);
                                        general.setLocation(350,150);
                                        general.setResizable(false);
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(login, "Wrong Password.. Please Try Again");
                                    }
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(BLogin.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(login, "Username Doesn't Exist.. Please Try Again");
                            }
                        }
                        
                        
                        else if(event.getSource()==back)
                        {
                            dispose();
                            PreLogin login = new PreLogin();
                            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            login.setSize(450,300);
                            login.setVisible(true);
                            login.setLocation(450,200);
                            login.setResizable(false);

                            
                        }
                         
                        
                        
		} 
    }
}
