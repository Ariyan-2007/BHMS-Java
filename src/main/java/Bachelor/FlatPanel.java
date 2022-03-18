
package Bachelor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class FlatPanel extends JFrame
{
    JPanel panelFP = new JPanel();
    JLabel dLoc = new JLabel();
    JComboBox locList = new JComboBox();
    String[] locStrings = {"Nikunjo II", "Niketon", "Bashundhara", "Badda"};
    JButton search = new JButton();
    String getUser;
    String getLoc;
    FlatPanel(String userString)
    {
        super("Bachelor's Housing Management System");
        getUser = userString; 
      
        panelFP = new JPanel();
        panelFP.setLayout(null);
        panelFP.setBackground(Color.BLACK);
        add(panelFP);
        getContentPane();
        
        dLoc = new JLabel("Location");
        dLoc.setBounds(0,0,400, 35);
        dLoc.setForeground(Color.WHITE);
        dLoc.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFP.add(dLoc);
        
        locList = new JComboBox(locStrings);
        locList.setBounds(65, 7, 120, 20);
        locList.setSelectedIndex(3);
        panelFP.add(locList);
                
        search = new JButton("Search");
        search.setBounds(75, 47, 80, 20);
        panelFP.add(search);
        
        HandlerClass handler = new HandlerClass();
	search.addActionListener(handler);
      
    }
    
    public class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==search)
                        {
                            getLoc = (String) locList.getSelectedItem();
                            dispose();
                            FlatList searchx = new FlatList(getUser,getLoc);
                            searchx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            searchx.setVisible(true);
                            searchx.pack();
                            searchx.setLocation(350,150);
                            searchx.setResizable(false);
                        
                        }
                }
        }
    
}
