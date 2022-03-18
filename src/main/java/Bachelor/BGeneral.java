
package Bachelor;


import Boot.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BGeneral extends  JFrame
        
{
    JPanel panelB = new JPanel();
    JButton logOut = new JButton();
    JButton profile = new JButton();    
    JLabel welcome = new JLabel();
    JLabel bal = new JLabel();
    String getUser;
    String readFullName;
    String readBalance;
    JButton search = new JButton();
    JButton booked = new JButton();
    File bAcc;
    
    public BGeneral(String userString) throws FileNotFoundException
    {
        
        super("Bachelor's Housing Management System");
        getUser = userString;
        
        panelB = new JPanel();
        panelB.setLayout(null);
        panelB.setBackground(Color.BLACK);
        add(panelB);
        getContentPane();
        
        search = new JButton("Search Flat");
        search.setBounds(200, 200, 130, 30);
        panelB.add(search);
        
        booked = new JButton("Booked Flat");
        booked.setBounds(200, 250, 130, 30);
        panelB.add(booked);
        
        logOut = new JButton("Log Out");
        logOut.setBounds(450, 50, 80, 20);
        panelB.add(logOut);
        
        profile = new JButton("Profile");
        profile.setBounds(365, 50, 80, 20);
        panelB.add(profile);
        
        
        bAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\Bachelor_Acc\\" + userString +".txt"); 
        Scanner scan = new Scanner(bAcc);
        scan.nextLine();
        readFullName = scan.nextLine().substring(10);
        readBalance = scan.nextLine();
        
        welcome = new JLabel("Welcome "+readFullName);
        welcome.setBounds(365, 0, 400, 35);
        welcome.setForeground(Color.WHITE);
        welcome.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelB.add(welcome);
        
        bal = new JLabel(readBalance);
        bal.setBounds(365, 20, 400, 35);
        bal.setForeground(Color.WHITE);
        bal.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelB.add(bal);
        
        HandlerClass handler = new HandlerClass();
	logOut.addActionListener(handler);
        profile.addActionListener(handler);
        search.addActionListener(handler);
        booked.addActionListener(handler);
        
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
                                BProfile profilex = new BProfile(getUser);
                                profilex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                profilex.setSize(450,300);
                                profilex.setVisible(true);
                                profilex.setLocation(450,200);
                                profilex.setResizable(false);
                            }
                            
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(BGeneral.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        else if(event.getSource()==search)
                        {
                            dispose();
                            FlatPanel searchx = new FlatPanel(getUser);
                            searchx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            searchx.setSize(250,130);
                            searchx.setVisible(true);
                            searchx.setLocation(450,200);
                            searchx.setResizable(false);
                        }
                        
                        else if(event.getSource()==booked)
                        {
                            try 
                            {
                                Component flat = null;
                                BufferedReader reader = new BufferedReader(new FileReader(bAcc));
                                Scanner scan = new Scanner(bAcc);
                                scan.nextLine();
                                scan.nextLine();
                                scan.nextLine();
                                scan.nextLine();
                                String fDetails = scan.nextLine();
                                scan.reset();
                                String line = reader.readLine();
                                while(line!=null)
                                {
                                    if(line.equals("Payment Confirmed!"))
                                    {
                                        
                                        JOptionPane.showMessageDialog(flat, "Booking Already Confirmed!");
                                        break;
                                        
                                    }
                                    
                                    else if(line.equals(fDetails))
                                    {
                                        dispose();
                                        BookedFlat bookedx = new BookedFlat(getUser);
                                        bookedx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        bookedx.setSize(250,200);
                                        bookedx.setVisible(true);
                                        bookedx.setLocation(450,200);
                                        bookedx.setResizable(false);
                                        break;
                                    }
                                   
                                    
                                    line = reader.readLine();
                                    
                                }
                                reader.close();
                                
                                if(line==null)
                                JOptionPane.showMessageDialog(flat, "No Available Booking!");
                                
                            } 
                            catch (IOException ex) 
                            {
                                Logger.getLogger(BGeneral.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                            
                        
                        
                         
		} 
                
    }
    
}
