
package Flat_Owner;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangePassword extends JFrame
{
    JLabel oldPass = new JLabel();
    JLabel newPass = new JLabel();
    JPasswordField op = new JPasswordField();
    JPasswordField np = new JPasswordField();
    JButton submit = new JButton();
    JPanel panelCP = new JPanel();
    String readOldPass;
    String readNewPass;
    String getUser;
    
    ChangePassword(String userString)
    {
        super("");
        getUser = userString;
        
        panelCP = new JPanel();
        panelCP.setLayout(null);
        panelCP.setBackground(Color.BLACK);
        add(panelCP);
        getContentPane();
        
        oldPass = new JLabel("Old Password");
        oldPass.setBounds(10, 20, 400, 35);
        oldPass.setForeground(Color.WHITE);
        oldPass.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelCP.add(oldPass);
        
        op = new JPasswordField();
        op.setBounds(100, 27, 100, 20);
        panelCP.add(op);
        
        newPass = new JLabel("New Password");
        newPass.setBounds(10, 50, 400, 35);
        newPass.setForeground(Color.WHITE);
        newPass.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelCP.add(newPass);
        
        np = new JPasswordField();
        np.setBounds(100, 57, 100, 20);
        panelCP.add(np);
        
        submit = new JButton("Confirm");
        submit.setBounds(90, 87, 80, 25);
        panelCP.add(submit);
        
        HandlerClass handler = new HandlerClass();
	submit.addActionListener(handler);
        
    }
    
    public class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
                        if(event.getSource()==submit)
                        {
                            try 
                            {
                                String oldC = "";
                                
                                File foAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\FlatOwner_Acc\\" + getUser +".txt");
                                Scanner scan = new Scanner(foAcc);
                                char[] passOP = op.getPassword();
                                readOldPass = new String(passOP);
                                char[] passNP = np.getPassword();
                                readNewPass = new String(passNP);
                                String oldPass = scan.nextLine().substring(10);
                                System.out.println(oldPass);
                                System.out.println(readOldPass);
                                if(oldPass.equals(readOldPass))
                                {
                                    BufferedReader reader = new BufferedReader(new FileReader(foAcc));
                                    String line = reader.readLine();
                                    while(line!= null)
                                    {
                                        oldC = oldC + line + System.lineSeparator();
                                        line = reader.readLine();
                                    }
                                    
                                    String newC = oldC.replaceAll(readOldPass,readNewPass);
                                    FileWriter writer = new FileWriter(foAcc);

                                    writer.write(newC);
                                    

                                    reader.close();

                                    writer.close();
                                    Component cp = null;

                                    JOptionPane.showMessageDialog(cp, "Password Succesfully Changed!");
                                    
                                    dispose();
                                    
                                }
                                else
                                {
                                    Component icp = null;
                                    JOptionPane.showMessageDialog(icp, "Old Password is Invalid! Try again");
                                }
                                
                            } 
                            catch (FileNotFoundException ex) 
                            {
                                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }
        }
}
