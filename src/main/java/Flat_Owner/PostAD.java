
package Flat_Owner;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PostAD extends JFrame
{
    
    JPanel panelPAD = new JPanel();
    JLabel dName = new JLabel();
    JTextField name = new JTextField();
    JLabel dLoc = new JLabel();
    JComboBox locList = new JComboBox();
    JLabel dAddress = new JLabel();
    JTextField address = new JTextField();
    JLabel dRoom = new JLabel();
    JTextField room = new JTextField();
    JLabel dPrice = new JLabel();
    JTextField price = new JTextField();
    JButton post = new JButton();
    String getUser;
    JLabel dCost = new JLabel();
    String[] locStrings = {"Nikunjo II", "Niketon", "Bashundhara", "Badda"};
    
    PostAD(String userString)
    {
        super("Bachelor's Housing Management System");
        getUser = userString;
        
        panelPAD = new JPanel();
        panelPAD.setLayout(null);
        panelPAD.setBackground(Color.BLACK);
        add(panelPAD);
        getContentPane();
        
        dName = new JLabel("Flat Name");
        dName.setBounds(0, 0, 400, 35);
        dName.setForeground(Color.WHITE);
        dName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelPAD.add(dName);
        
        name = new JTextField();
        name.setBounds(65, 7, 150, 20);
        panelPAD.add(name);
        
        dLoc = new JLabel("Location");
        dLoc.setBounds(0, 25, 400, 35);
        dLoc.setForeground(Color.WHITE);
        dLoc.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelPAD.add(dLoc);
        
        locList = new JComboBox(locStrings);
        locList.setBounds(65, 32, 120, 20);
        locList.setSelectedIndex(3);
        panelPAD.add(locList);
        
        dAddress = new JLabel("Address");
        dAddress.setBounds(0, 50, 400, 35);
        dAddress.setForeground(Color.WHITE);
        dAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelPAD.add(dAddress);
        
        address = new JTextField();
        address.setBounds(65, 57, 150, 20);
        panelPAD.add(address);
        
        dRoom = new JLabel("Number Of Rooms");
        dRoom.setBounds(0, 75, 400, 35);
        dRoom.setForeground(Color.WHITE);
        dRoom.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelPAD.add(dRoom);
        
        room = new JTextField();
        room.setBounds(120, 82, 30, 20);
        panelPAD.add(room);
        
        dPrice = new JLabel("Rent");
        dPrice.setBounds(0, 100, 400, 35);
        dPrice.setForeground(Color.WHITE);
        dPrice.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelPAD.add(dPrice);
        
        price = new JTextField();
        price.setBounds(65, 107, 70, 20);
        panelPAD.add(price);
        
        post = new JButton("Post AD");
        post.setBounds(55, 132, 80, 20);
        panelPAD.add(post);
        
        dCost = new JLabel("Cost: 5000");
        dCost.setBounds(140, 125, 400, 35);
        dCost.setForeground(Color.WHITE);
        dCost.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelPAD.add(dCost);
        
        HandlerClass handler = new HandlerClass();
	post.addActionListener(handler);
        
        
    }
    

    
    public class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==post)
                        {
                            
                            try 
                            {
                                Component flat = null;
                                File foAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\FlatOwner_Acc\\" + getUser +".txt");
                                Scanner scan = new Scanner(foAcc);
                                scan.nextLine();
                                scan.nextLine();
                                int x = Integer.parseInt(scan.nextLine().substring(9)); 
                                File fDetails = new File("C:\\BHMS\\src\\main\\java\\Flat_Owner\\Flat_Details\\"+ locList.getSelectedItem() +"\\"+ name.getText() + ".txt");
                                
                                if(fDetails.exists()) 
                                {
                                    
                                    JOptionPane.showMessageDialog(flat, "Flat Name Already Used. Please Try Again!");
                                }
                                else if(name.getText().equals(""))
                                {
                                    JOptionPane.showMessageDialog(flat, "Flat Name Blank! Please Try Again!");
                                }
                                else if(price.getText().equals(""))
                                {
                                    JOptionPane.showMessageDialog(flat, "Price Area Blank! Please Try Again!");
                                }
                                else
                                {
                                    if(x>=5000)
                                    {
                                        try
                                        {
                                            int y= x-5000;
                                            String oldC = "";
                                            FileWriter FD = new FileWriter(fDetails);

                                            FD.write("Flat Owner: "+ getUser);
                                            FD.write(System.getProperty("line.separator"));
                                            FD.write("Address: ");
                                            address.write(FD);
                                            FD.write(System.getProperty("line.separator"));
                                            FD.write("No. Of Rooms: ");
                                            room.write(FD);
                                            FD.write(System.getProperty("line.separator"));
                                            FD.write("Rent: ");
                                            price.write(FD);

                                            FD.close();

                                            BufferedReader reader = new BufferedReader(new FileReader(foAcc));
                                            String line = reader.readLine();
                                            while(line!= null)
                                            {
                                                oldC = oldC + line + System.lineSeparator();
                                                line = reader.readLine();
                                            }

                                            String newC = oldC.replaceAll(Integer.toString(x),Integer.toString(y)) + fDetails.getAbsolutePath();
                                            FileWriter writer = new FileWriter(foAcc);

                                            writer.write(newC);

                                            reader.close();
                                            writer.close();

                                            
                                            
                                            JOptionPane.showMessageDialog(flat, "AD Succesfully Posted!");

                                            dispose();
                                            FOGeneral general = new FOGeneral(getUser);
                                            general.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            general.setSize(550,400);
                                            general.setVisible(true);
                                            general.setLocation(350,150);
                                            general.setResizable(false);

                                        }
                                        catch (FileNotFoundException ex)
                                        {
                                            Logger.getLogger(PostAD.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (IOException ex) {
                                            Logger.getLogger(PostAD.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(flat, "Insufficient Balance, Terminating");
                                        dispose();
                                        FOGeneral general = new FOGeneral(getUser);
                                        general.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        general.setSize(550,400);
                                        general.setVisible(true);
                                        general.setLocation(350,150);
                                        general.setResizable(false);
                                    }
                                }
                            } 
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(PostAD.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                }
        }
}
