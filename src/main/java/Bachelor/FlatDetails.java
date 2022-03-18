package Bachelor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FlatDetails extends JFrame
{
    JPanel panelFD = new JPanel();
    JButton back = new JButton();
    JLabel dOName = new JLabel();
    JLabel dAddress = new JLabel();
    JLabel dNORooms = new JLabel();
    JLabel dRent = new JLabel();
    JButton book = new JButton();
    String getUser;
    String getLoc;
    String getFile;
    File fDetails;
    FlatDetails(String userString,String locString,String fileString) throws FileNotFoundException
    {
        super(fileString);
        getUser = userString;
        getLoc = locString;
        getFile = fileString;
        
        panelFD = new JPanel();
        panelFD.setLayout(null);
        panelFD.setBackground(Color.BLACK);
        add(panelFD);
        getContentPane();
        
        back = new JButton("Back");
        back.setBounds(0, 0, 70, 20);
        panelFD.add(back);
        
        fDetails = new File("C:\\BHMS\\src\\main\\java\\Flat_Owner\\Flat_Details\\"+getLoc+"\\"+getFile);
        Scanner scan = new Scanner(fDetails);
        
        dOName = new JLabel(scan.nextLine());
        dOName.setBounds(60, 30, 400, 35);
        dOName.setForeground(Color.WHITE);
        dOName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFD.add(dOName);
        
        dAddress = new JLabel(scan.nextLine());
        dAddress.setBounds(40, 45, 400, 35);
        dAddress.setForeground(Color.WHITE);
        dAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFD.add(dAddress);
        
        dNORooms = new JLabel(scan.nextLine());
        dNORooms.setBounds(75, 60, 400, 35);
        dNORooms.setForeground(Color.WHITE);
        dNORooms.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFD.add(dNORooms);
        
        dRent = new JLabel(scan.nextLine());
        dRent.setBounds(85, 75, 400, 35);
        dRent.setForeground(Color.WHITE);
        dRent.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelFD.add(dRent);
        
        book = new JButton("Book");
        book.setBounds(85, 102, 70, 25);
        panelFD.add(book);
        
        HandlerClass handler = new HandlerClass();
	back.addActionListener(handler);
        book.addActionListener(handler);
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
                                Logger.getLogger(FlatDetails.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else if(event.getSource()==book)
                        {
                            try 
                            {
                                String oldC = "";
                                File bAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\Bachelor_Acc\\"+getUser+".txt");
                                
                                BufferedReader reader = new BufferedReader(new FileReader(bAcc));
                                String line = reader.readLine();
                                while(line!= null)
                                {
                                    oldC = oldC + line + System.lineSeparator();
                                    line = reader.readLine();
                                }
                                
                                String newC = oldC + "PC" + System.lineSeparator() + fDetails.getAbsolutePath();
                                FileWriter writer = new FileWriter(bAcc);
                                
                                writer.write(newC);
                                
                                reader.close();
                                writer.close();
                                Component flat = null;
                                
                                JOptionPane.showMessageDialog(flat, "Booking Completed!");
                                
                                dispose();
                                BGeneral bg = new BGeneral(getUser);
                                bg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                bg.setSize(550,400);
                                bg.setVisible(true);
                                bg.setLocation(350,150);
                                bg.setResizable(false);
                                
                            } 
                            catch (IOException ex) 
                            {
                                Logger.getLogger(FlatDetails.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }
        }
}
