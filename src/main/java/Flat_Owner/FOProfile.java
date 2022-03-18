
package Flat_Owner;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FOProfile extends JFrame 
{
    JButton back = new JButton();
    JPanel panelFOP = new JPanel();
    JLabel displayName = new JLabel();
    JLabel displayBalance = new JLabel();
    String readFullName;
    String readBalance;
    String getUser;
    JButton change = new JButton();
    
    public FOProfile(String userString) throws FileNotFoundException
    {
        super("Bachelor's Housing Management System");
        getUser = userString;
        
        panelFOP = new JPanel();
        panelFOP.setLayout(null);
        panelFOP.setBackground(Color.BLACK);
        add(panelFOP);
        getContentPane();
        
        back = new JButton("Back");
        back.setBounds(5, 5, 70, 20);
        panelFOP.add(back);
        
        File foAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\FlatOwner_Acc\\" + userString +".txt"); 
        Scanner scan = new Scanner(foAcc);
        scan.nextLine();
        readFullName = scan.nextLine();
        readBalance = scan.nextLine();
        
        displayName = new JLabel(readFullName);
        displayName.setBounds(150, 80, 400, 35);
        displayName.setForeground(Color.WHITE);
        displayName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFOP.add(displayName);
        
        displayBalance = new JLabel(readBalance);
        displayBalance.setBounds(195, 100, 400, 35);
        displayBalance.setForeground(Color.WHITE);
        displayBalance.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFOP.add(displayBalance);
        
        change = new JButton("Change Password");
        change.setBounds(140, 185, 150, 30);
        panelFOP.add(change);
        
        
        
        HandlerClass handler = new HandlerClass();
	back.addActionListener(handler);
        change.addActionListener(handler);
        
        
    }
    
    public class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==back)
                        {
                            try 
                            {
                                dispose();
                                FOGeneral bg = new FOGeneral(getUser);
                                bg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                bg.setSize(550,400);
                                bg.setVisible(true);
                                bg.setLocation(350,150);
                                bg.setResizable(false);
                            } 
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(FOProfile.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        
                        else if(event.getSource()==change)
                        {
                            
                            ChangePassword changex = new ChangePassword(getUser);
                            changex.setSize(250,175);
                            changex.setVisible(true);
                            changex.setLocation(550,250);
                            changex.setResizable(false);
                        }
                }
    }
    
}
