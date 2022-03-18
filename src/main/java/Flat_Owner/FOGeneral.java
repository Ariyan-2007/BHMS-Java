package Flat_Owner;

import Boot.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FOGeneral extends JFrame
{
    JPanel panelFO = new JPanel();
    JButton logOut = new JButton();
    JButton profile = new JButton();    
    JLabel welcome = new JLabel();
    JLabel bal = new JLabel();
    String getUser;
    String readFullName;
    String readBalance;
    JButton check = new JButton();
    JButton post = new JButton();
    
    
    public FOGeneral(String userString) throws FileNotFoundException
    {
        
        super("Bachelor's Housing Management System");
        getUser = userString;
        
        panelFO = new JPanel();
        panelFO.setLayout(null);
        panelFO.setBackground(Color.BLACK);
        add(panelFO);
        getContentPane();
        
        check = new JButton("Check Flat Details");
        check.setBounds(190, 200, 150, 30);
        panelFO.add(check);
        
        post = new JButton("Post Advertisement");
        post.setBounds(190, 250, 150, 30);
        panelFO.add(post);
        
        logOut = new JButton("Log Out");
        logOut.setBounds(450, 50, 80, 20);
        panelFO.add(logOut);
        
        profile = new JButton("Profile");
        profile.setBounds(365, 50, 80, 20);
        panelFO.add(profile);
        
        
        File foAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\FlatOwner_Acc\\" + userString +".txt"); 
        Scanner scan = new Scanner(foAcc);
        scan.nextLine();
        readFullName = scan.nextLine().substring(10);
        readBalance = scan.nextLine();
        
        welcome = new JLabel("Welcome "+readFullName);
        welcome.setBounds(365, 0, 400, 35);
        welcome.setForeground(Color.WHITE);
        welcome.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFO.add(welcome);
        
        bal = new JLabel(readBalance);
        bal.setBounds(365, 20, 400, 35);
        bal.setForeground(Color.WHITE);
        bal.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFO.add(bal);
        
        HandlerClass handler = new HandlerClass();
	logOut.addActionListener(handler);
        profile.addActionListener(handler);
        check.addActionListener(handler);
        post.addActionListener(handler);
        
    }
    
    public class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==logOut)
                        {
                            dispose();
                            Portal reboot = new Portal();
                            reboot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            reboot.setSize(450,300);
                            reboot.setVisible(true);
                            reboot.setLocation(450,200);
                            reboot.setResizable(false);
                            
                        }
                        
                        
                        else if(event.getSource()==profile)
                        {
                            try {
                                dispose();
                                FOProfile profilex = new FOProfile(getUser);
                                profilex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                profilex.setSize(450,300);
                                profilex.setVisible(true);
                                profilex.setLocation(450,200);
                                profilex.setResizable(false);
                            }
                            
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(FOGeneral.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        else if(event.getSource()==check)
                        {
                            try 
                            {
                                dispose();
                                CheckFlat checkx = new CheckFlat(getUser);
                                checkx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                checkx.setSize(250,200);
                                checkx.setVisible(true);
                                checkx.setLocation(450,200);
                                checkx.setResizable(false);
                            } 
                            catch (IOException ex) 
                            {
                                Logger.getLogger(FOGeneral.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                        else if(event.getSource()==post)
                        {
                            dispose();
                            PostAD postx = new PostAD(getUser);
                            postx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            postx.setSize(250,200);
                            postx.setVisible(true);
                            postx.setLocation(450,200);
                            postx.setResizable(false);
                        }
                            
                        
                        
                         
		} 
                
    }
}
