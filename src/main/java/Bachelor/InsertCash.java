
package Bachelor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertCash extends JFrame 
{
    JLabel dAmount = new JLabel();
    JTextField amount = new JTextField();
    JButton submit = new JButton();
    JPanel panelIC = new JPanel();
    String getUser;
    String readBalance;
    InsertCash(String userString)
    {
        super("");
        getUser = userString;
        
        panelIC = new JPanel();
        panelIC.setLayout(null);
        panelIC.setBackground(Color.BLACK);
        add(panelIC);
        getContentPane();
        
        dAmount = new JLabel("Amount");
        dAmount.setBounds(10, 20, 400, 35);
        dAmount.setForeground(Color.WHITE);
        dAmount.setFont(new Font("Times New Roman", Font.BOLD, 12));
        panelIC.add(dAmount);
        
        amount = new JTextField();
        amount.setBounds(60, 27, 100, 20);
        panelIC.add(amount);
        
        submit = new JButton("Confirm");
        submit.setBounds(65, 57, 80, 25);
        panelIC.add(submit);
        
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
                                int x;
                                int y;
                                int sum;
                                String oldC = "";
                                
                                File bAcc = new File("C:\\BHMS\\src\\main\\java\\Boot\\Bachelor_Acc\\" + getUser +".txt");
                                Scanner scan = new Scanner(bAcc);
                                scan.nextLine();
                                scan.nextLine();
                                readBalance = scan.nextLine().substring(9);
                                x = Integer.parseInt(readBalance);
                                y = Integer.parseInt(amount.getText());
                                sum = x+y;
                                String newBalance = Integer.toString(sum);
                                
                                BufferedReader reader = new BufferedReader(new FileReader(bAcc));
                                String line = reader.readLine();
                                while(line!= null)
                                {
                                    oldC = oldC + line + System.lineSeparator();
                                    line = reader.readLine();
                                }
                                
                                String newC = oldC.replaceAll(readBalance,newBalance);
                                
                                FileWriter writer = new FileWriter(bAcc);
             
                                writer.write(newC);
                                Component signup = null;
                                
                                reader.close();
                 
                                writer.close();
                                
                                JOptionPane.showMessageDialog(signup, "Insertion Succesful!");
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
                                Logger.getLogger(InsertCash.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(InsertCash.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }
        }
}
