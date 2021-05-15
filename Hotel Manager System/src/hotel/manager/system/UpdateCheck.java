
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener{

        JTextField t1,t2,t3,t4,t5;
        Choice c1;
        JButton b1,b2,b3;
        
    public UpdateCheck() {
        
        JLabel l1 = new JLabel("Check-In Details");
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
        
        JLabel available = new JLabel("name");
        available.setBounds(60, 180, 120, 30);
        add(available);
        
        t2 = new JTextField();
        t2.setBounds(220, 180, 150, 30);
        add(t2);
        
        JLabel status = new JLabel("Check-In");
        status.setBounds(60, 230, 120, 30);
        add(status);
        
        t3 = new JTextField();
        t3.setBounds(220, 230, 150, 30);
        add(t3);
        
        JLabel amount = new JLabel("Amount Paid");
        amount.setBounds(60, 280, 120, 30);
        add(amount);
        
        t4 = new JTextField();
        t4.setBounds(220, 280, 150, 30);
        add(t4);
        
        JLabel pending = new JLabel("Pending Anount");
        pending.setBounds(60, 330, 120, 30);
        add(pending);
        
        t5 = new JTextField();
        t5.setBounds(220, 330, 150, 30);
        add(t5);
        
        b1 = new JButton("Check");
        b1.setBounds(60, 400, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(200, 400, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(340, 400, 120, 30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/manager/system/icons/nine.png"));
        JLabel l9 = new JLabel(i1);
        l9.setBounds(400, 50, 500, 300);
        add(l9);
        
        setLayout(null);
        setBounds(500, 200, 900, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            
            try {
                String room = null;
                String deposit = null;
                int amountPaid;
                String price = null;

                conn c = new conn();
                String id = c1.getSelectedItem();
                String str = "select * from customer where number = '"+id+"'";
                
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                  t1.setText(rs.getString("room"));
                  t2.setText(rs.getString("name"));
                  t3.setText(rs.getString("status"));
                  t4.setText(rs.getString("deposit"));
                  room = rs.getString("room");
                  deposit = rs.getString("deposit");
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room ='"+room+"'");
                while(rs2.next()){
                  price = rs2.getString("price");
                  amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                  t5.setText(Integer.toString(amountPaid));
                }
                
            } catch (Exception e) {
            }
        }else if (ae.getSource()==b2) {
            try {
                conn c = new conn();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();
                
                String str = "update room set availability = '"+available+"', clean_status = '"+status+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Update Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
                
            } catch (Exception e) {
            }
            
        }else if (ae.getSource()==b3) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }
}
