
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CheckOut extends JFrame implements ActionListener{

        JTextField t1,t2,t3,t4,t5;
        Choice c1;
        JButton b1,b2,b3;
        
    public CheckOut() {
        
        JLabel l1 = new JLabel("Check-Out");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setBackground(Color.white);
        l1.setForeground(Color.blue);
        l1.setBounds(80, 20, 200, 30);
        add(l1);
        
        JLabel guestid = new JLabel("Customer-ID");
        guestid.setBounds(60, 80, 120, 30);
        add(guestid);
        
        c1 = new Choice();
        try {
            
            conn c = new conn();
            String str = "SELECT * FROM customer";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
            
        } catch (Exception e) {}
        c1.setBounds(220, 80, 150, 30);
        add(c1);
      
        JLabel age = new JLabel("Room Number");
        age.setBounds(60, 130, 120, 30);
        add(age);
        
        t1 = new JTextField();
        t1.setBounds(220, 130, 150, 30);
        add(t1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/manager/system/icons/seven.jpg"));
        JLabel l9 = new JLabel(i1);
        l9.setBounds(440, 50, 400, 200);
        add(l9);
        
        b1 = new JButton("Check Out");
        b1.setBounds(60, 200, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220, 200, 120, 30);
        b2.addActionListener(this);
        add(b2);
            
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("hotel/manager/system/icons/check.png"));
        Image i3 = i2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        b3 = new JButton(i4);
        b3.setBounds(380, 80, 25, 20);
        b3.addActionListener(this);
        add(b3);
        
        setLayout(null);
        setBounds(500, 200, 900, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number  = '"+id+"'";
            String str2 = "update room set availability = 'Available' where room = '"+room+"'";
            conn c = new conn();
            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Checkout Done");
                new Reception().setVisible(true);
                this.setVisible(false);
                
            } catch (Exception e) {
            }
        }else if (ae.getSource()==b2) {
                new Reception().setVisible(true);
                this.setVisible(false); 
            
        }else if (ae.getSource()==b3) {
            conn c = new conn();
            String id = c1.getSelectedItem();
            try {
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                }
            } catch (Exception e) {
            }
            
        }
    }
    
    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }
}
