
package Boot;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PreLogin extends JFrame
{
    JButton bAcc = new JButton();
    JButton foAcc = new JButton();
    JButton back = new JButton();
    JPanel panel = new JPanel();
    PreLogin()
    {
        super("Bachelor's Housing Management System");
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);
        getContentPane();
                
        bAcc = new JButton("Bachelor Account");
        bAcc.setBounds(150, 100, 150, 25);
        panel.add(bAcc);
		
	foAcc = new JButton("Flat Owner Account");
        foAcc.setBounds(150,150, 150, 25);
	panel.add(foAcc);
        
        back = new JButton("Back");
        back.setBounds(5, 5, 70, 20);
        panel.add(back);
        
        HandlerClass handler = new HandlerClass();
        bAcc.addActionListener(handler);
        foAcc.addActionListener(handler);
        back.addActionListener(handler);
    }
    
    private class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==bAcc)
                        {
                            dispose();
                            BLogin login = new BLogin();
                            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            login.setSize(450,300);
                            login.setVisible(true);
                            login.setLocation(450,200);
                            login.setResizable(false);
                            
                        }
                        
                        
                        else if(event.getSource()==foAcc)
                        {
                            dispose();
                            FOLogin login = new FOLogin();
                            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            login.setSize(450,300);
                            login.setVisible(true);
                            login.setLocation(450,200);
                            login.setResizable(false);
                        }
                        
                        else if(event.getSource()==back)
                        {
                            dispose();
                            Portal portal = new Portal();
                            portal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            portal.setSize(450,300);
                            portal.setVisible(true);
                            portal.setLocation(450,200);
                            portal.setResizable(false);
                            
                        }
                }
                         
                        
                        
        } 

}
    

