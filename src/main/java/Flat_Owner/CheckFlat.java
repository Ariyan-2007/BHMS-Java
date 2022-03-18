
package Flat_Owner;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CheckFlat extends JFrame
{
    JPanel panelCF = new JPanel();
    JLabel dFlatName = new JLabel();
    JLabel dAddress = new JLabel();
    JLabel dNORooms = new JLabel();
    JLabel dRent = new JLabel();
    JButton back = new JButton(); 
    
    String getUser;
    File foAcc;
    File fDetails;
    
    CheckFlat(String userString) throws FileNotFoundException, IOException
    {
        super("Bachelor's Housing Management System");
        getUser = userString;
        
        panelCF = new JPanel();
        panelCF.setLayout(null);
        panelCF.setBackground(Color.BLACK);
        add(panelCF);
        getContentPane();
        
        foAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\FlatOwner_Acc\\" + getUser +".txt");
        BufferedReader reader1 = new BufferedReader(new FileReader(foAcc));
        String count = reader1.readLine();
        String fd = count;
        while(count!= null)
        {
            count = reader1.readLine();
            if(count!= null)
            {
            fd = count;
            }
        }
        
        reader1.close();
        
        fDetails = new File(fd);
        Scanner scan = new Scanner(fDetails);
        
        dFlatName = new JLabel(scan.nextLine());
        dFlatName.setBounds(60, 30, 400, 35);
        dFlatName.setForeground(Color.WHITE);
        dFlatName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelCF.add(dFlatName);
        
        dAddress = new JLabel(scan.nextLine());
        dAddress.setBounds(40, 45, 400, 35);
        dAddress.setForeground(Color.WHITE);
        dAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelCF.add(dAddress);
        
        dNORooms = new JLabel(scan.nextLine());
        dNORooms.setBounds(75, 60, 400, 35);
        dNORooms.setForeground(Color.WHITE);
        dNORooms.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelCF.add(dNORooms);
        
        dRent = new JLabel(scan.nextLine());
        dRent.setBounds(85, 75, 400, 35);
        dRent.setForeground(Color.WHITE);
        dRent.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelCF.add(dRent);
        
        back = new JButton("Back");
        back.setBounds(0, 0, 70, 25);
        panelCF.add(back);
        
        HandlerClass handler = new HandlerClass();
	back.addActionListener(handler);
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
                                FOGeneral fg = new FOGeneral(getUser);
                                fg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                fg.setSize(550,400);
                                fg.setVisible(true);
                                fg.setLocation(350,150);
                                fg.setResizable(false);
                            } 
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(CheckFlat.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }
        }
}
