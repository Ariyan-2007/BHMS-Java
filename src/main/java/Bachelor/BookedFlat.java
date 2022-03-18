
package Bachelor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookedFlat extends JFrame
{
    JPanel panelBF = new JPanel();
    JLabel dFlatName = new JLabel();
    JLabel dAddress = new JLabel();
    JLabel dNORooms = new JLabel();
    JLabel dRent = new JLabel();
    JButton confirm = new JButton(); 
    
    String getUser;
    File bAcc;
    File foAcc;
    File fDetails;
    String getOwner;
    
    
    BookedFlat(String userString) throws FileNotFoundException, IOException
    {
        super("Bachelor's Housing Managemenet System");
        getUser = userString;
        
        panelBF = new JPanel();
        panelBF.setLayout(null);
        panelBF.setBackground(Color.BLACK);
        add(panelBF);
        getContentPane();
        
        bAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\Bachelor_Acc\\" + getUser +".txt");
        BufferedReader reader1 = new BufferedReader(new FileReader(bAcc));
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
        getOwner = scan.nextLine().substring(12);
        
        dFlatName = new JLabel(fDetails.getName().substring(0, fDetails.getName().length() - 4));
        dFlatName.setBounds(90, 30, 400, 35);
        dFlatName.setForeground(Color.WHITE);
        dFlatName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelBF.add(dFlatName);
        
        dAddress = new JLabel(scan.nextLine());
        dAddress.setBounds(40, 45, 400, 35);
        dAddress.setForeground(Color.WHITE);
        dAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelBF.add(dAddress);
        
        dNORooms = new JLabel(scan.nextLine());
        dNORooms.setBounds(75, 60, 400, 35);
        dNORooms.setForeground(Color.WHITE);
        dNORooms.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelBF.add(dNORooms);
        
        dRent = new JLabel(scan.nextLine());
        dRent.setBounds(85, 75, 400, 35);
        dRent.setForeground(Color.WHITE);
        dRent.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelBF.add(dRent);
        
        confirm = new JButton("Confirm Payment");
        confirm.setBounds(40, 102, 150, 25);
        panelBF.add(confirm);
        
        HandlerClass handler = new HandlerClass();
	confirm.addActionListener(handler);
        
        
        
    }
    
    public class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==confirm)
                        {
                            try 
                            {
                                String oldC = "";
                                Component flat = null;
                                int x = Integer.parseInt(dRent.getText().substring(6));
                                Scanner scan1 = new Scanner(bAcc);
                                scan1.nextLine();
                                scan1.nextLine();
                                int y = Integer.parseInt(scan1.nextLine().substring(9)) ;
                                
                                if(y>=x)
                                {
                                    BufferedReader reader2 = new BufferedReader(new FileReader(bAcc));
                                    String line = reader2.readLine();
                                    while(line!= null)
                                    {
                                        oldC = oldC + line + System.lineSeparator();
                                        line = reader2.readLine();
                                    }

                                    String newC = oldC.replaceAll(Integer.toString(y),Integer.toString(y-x));
                                    newC = newC.replaceAll("PC", "Payment Confirmed!");
                                    
                                    
                                    FileWriter writer = new FileWriter(bAcc);
                                    writer.write(newC);
                                    reader2.close();
                                    writer.close();
                                    
                                    JOptionPane.showMessageDialog(flat, "Payment Confirmed!");
                                    dispose();
                                    BGeneral bg = new BGeneral(getUser);
                                    bg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    bg.setSize(550,400);
                                    bg.setVisible(true);
                                    bg.setLocation(350,150);
                                    bg.setResizable(false);
                                }
                                else
                                {
                                    
                                    JOptionPane.showMessageDialog(flat, "Insufficient Balance! Terminating Request");
                                    dispose();
                                    BGeneral bg = new BGeneral(getUser);
                                    bg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    bg.setSize(550,400);
                                    bg.setVisible(true);
                                    bg.setLocation(350,150);
                                    bg.setResizable(false);
                                }
                            } 
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(BookedFlat.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                            catch (IOException ex) 
                            {
                                Logger.getLogger(BookedFlat.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                }
        }
}
