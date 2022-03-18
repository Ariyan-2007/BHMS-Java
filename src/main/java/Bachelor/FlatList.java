package Bachelor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlatList extends JFrame
{
    String getUser;
    String getLoc;
    JPanel panelFL = new JPanel();
    int fLength;
    JButton[] fileButton;
    FlatList(String userString,String locString)
    {
        super("Bachelor's Housing Management System");
        getUser = userString;
        getLoc = locString;
        
        panelFL = new JPanel(new GridLayout(5,5));
        panelFL.setBackground(Color.BLACK);
        add(panelFL);
        getContentPane();
        
        File folder = new File("C:\\BHMS\\src\\main\\java\\Flat_Owner\\Flat_Details\\"+getLoc);
        File[] listOfFiles = folder.listFiles();
        fLength = listOfFiles.length;
        fileButton = new JButton[listOfFiles.length];

        HandlerClass handler = new HandlerClass();
        for (int i = 0; i < listOfFiles.length; i++) 
        {
            fileButton[i] = new JButton(listOfFiles[i].getName());
            fileButton[i].setSize(80, 80);
            panelFL.add(fileButton[i]);
            fileButton[i].addActionListener(handler);
        }
        
	
    }
    
    public class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                    for(int i=0; i<fLength;i++ )
                    {
                        if(event.getSource()==fileButton[i])
                        {
                            try 
                            {
                                dispose();
                                FlatDetails fB = new FlatDetails(getUser,getLoc,fileButton[i].getText());
                                fB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                fB.setSize(250,170);
                                fB.setVisible(true);
                                fB.setLocation(350,150);
                                fB.setResizable(false);
                            } 
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(FlatList.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        
                    }
                }
        }
}
