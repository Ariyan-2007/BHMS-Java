
package Bachelor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BProfile extends JFrame
{
    JButton back = new JButton();
    JPanel panelBP = new JPanel();
    JLabel displayName = new JLabel();
    JLabel displayBalance = new JLabel();
    String readFullName;
    String readBalance;
    String getUser;
    JButton change = new JButton();
    JButton insert = new JButton();
    public BProfile(String userString) throws FileNotFoundException
    {
        super("Bachelor's Housing Management System");
        getUser = userString;
        
        panelBP = new JPanel();
        panelBP.setLayout(null);
        panelBP.setBackground(Color.BLACK);
        add(panelBP);
        getContentPane();
        
        back = new JButton("Back");
        back.setBounds(5, 5, 70, 20);
        panelBP.add(back);
        
        File bAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\Bachelor_Acc\\" + userString +".txt"); 
        Scanner scan = new Scanner(bAcc);
        scan.nextLine();
        readFullName = scan.nextLine();
        readBalance = scan.nextLine();
        
        displayName = new JLabel(readFullName);
        displayName.setBounds(150, 80, 400, 35);
        displayName.setForeground(Color.WHITE);
        displayName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelBP.add(displayName);
        
        displayBalance = new JLabel(readBalance);
        displayBalance.setBounds(195, 100, 400, 35);
        displayBalance.setForeground(Color.WHITE);
        displayBalance.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelBP.add(displayBalance);
        
        change = new JButton("Change Password");
        change.setBounds(150, 185, 150, 30);
        panelBP.add(change);
        
        insert = new JButton("Insert Cash");
        insert.setBounds(175, 140, 100, 30);
        panelBP.add(insert);
        
        HandlerClass handler = new HandlerClass();
	back.addActionListener(handler);
        change.addActionListener(handler);
        insert.addActionListener(handler);
        
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
                                BGeneral bg = new BGeneral(getUser);
                                bg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                bg.setSize(550,400);
                                bg.setVisible(true);
                                bg.setLocation(350,150);
                                bg.setResizable(false);
                            } 
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(BProfile.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        else if(event.getSource()==insert)
                        {
                            dispose();
                            InsertCash insertx = new InsertCash(getUser);
                            insertx.setSize(200,125);
                            insertx.setVisible(true);
                            insertx.setLocation(550,250);
                            insertx.setResizable(false);
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
