
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1,r2;
    ButtonGroup bg;
    
    AddCustomer(){
        l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(100, 10, 300, 30);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        l2 = new JLabel("ID");
        l2.setBounds(60, 70, 70, 20);
        add(l2);
        
        c1 = new JComboBox(new String[] {"Passport","Voter-id Card","Driving License","Indentify Card"});
        c1.setBounds(220, 70, 150, 25);
        add(c1);
         
        l3 = new JLabel("Number");
        l3.setBounds(60, 120, 70, 20);
        add(l3);
         
        t1 = new JTextField();
        t1.setBounds(220, 120, 150, 25);
        add(t1);
        
        l4 = new JLabel("Name");
        l4.setBounds(60, 170, 70, 20);
        add(l4);
         
        t2 = new JTextField();
        t2.setBounds(220, 170, 150, 25);
        add(t2);
        
        l5 = new JLabel("Gender");
        l5.setBounds(60, 220, 70, 20);
        add(l5);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(220, 220, 70, 25);
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBounds(300, 220, 70, 25);
        r2.setBackground(Color.white);
        add(r2);
        
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        
        l6 = new JLabel("Country");
        l6.setBounds(60, 270, 70, 20);
        add(l6);
         
        t3 = new JTextField();
        t3.setBounds(220, 270, 150, 25);
        add(t3);
        
        l7 = new JLabel("Allocated Room Number");
        l7.setBounds(60, 320, 150, 20);
        add(l7);
         
        c2 = new Choice();
        try {
            
            conn c = new conn();
            String str = "SELECT * FROM room";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room"));
            }
            
        } catch (Exception e) {}
        c2.setBounds(220, 320, 150, 25);
        add(c2);
        
        l8 = new JLabel("Check In");
        l8.setBounds(60, 370, 70, 20);
        add(l8);
        
        t4 = new JTextField();
        t4.setBounds(220, 370, 150, 25);
        add(t4);
        
        l9 = new JLabel("Deposit");
        l9.setBounds(60, 420, 70, 20);
        add(l9);
        
        t5 = new JTextField();
        t5.setBounds(220, 420, 150, 25);
        add(t5);
        
        b1 = new JButton("Add Customer");
        b1.setBounds(60, 470, 120, 25);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(220, 470, 120, 25);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/manager/system/icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(400, 50, 500, 400);
        add(l10);
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(500, 200, 900, 600);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            
            String id = (String)c1.getSelectedItem();
            String number = t1.getText();
            String name = t2 .getText();
            String gender = null;
            if(r1.isSelected()){
                gender = "Male";
            }else if(r2.isSelected()){
              gender = "Female";  
            }
            String country = t3.getText();
            String room = c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();
            
            String str = "insert into customer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
            String str2 = "update room set available = 'Occupied' where room ='"+room+"'";
            
            try {
                conn c = new conn();
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                
                new Reception().setVisible(true);
                this.setVisible(false);
                c.s.executeUpdate(str2);
            } catch (Exception e) {
                
            }
            
        }else if(ae.getSource()==b2){
                new Reception().setVisible(true);
                this.setVisible(false);
        }
    }
}


