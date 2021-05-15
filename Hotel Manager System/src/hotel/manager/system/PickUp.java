
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class PickUp extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JCheckBox c2;
    Choice c1;
    
    PickUp(){
        
        JLabel check = new JLabel("Pick Up Service");
        check.setFont(new Font("Tahoma",Font.PLAIN,20));
        check.setBackground(Color.white);
        check.setForeground(Color.blue);
        check.setBounds(450, 10, 200, 30);
        add(check);
        
        JLabel type = new JLabel("Type Of Car");
        type.setBounds(40, 70, 90, 30);
        add(type);
        
        t1 = new JTable();
        t1.setBounds(0, 130, 1150, 300);
        add(t1);
        
        c1 = new Choice();
        try {
            
            conn c = new conn();
            String str = "SELECT * FROM driver";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
            
        } catch (Exception e) {}
        c1.setBounds(140, 73, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Only display Available");
        c2.setBounds(700, 70, 300, 30);
        c2.setBackground(Color.white);
        add(c2);
        
        l1 = new JLabel("Name");
        l1.setBounds(50, 110, 100, 20);
        add(l1);
         
        l2 = new JLabel("Age");
        l2.setBounds(200, 110, 100, 20);
        add(l2);
         
        l3 = new JLabel("Gender");
        l3.setBounds(370, 110, 100, 20);
        add(l3);
         
        l4 = new JLabel("Company");
        l4.setBounds(530, 110, 100, 20);
        add(l4);
         
        l5 = new JLabel("Brand");
        l5.setBounds(680, 110, 100, 20);
        add(l5);
        
        l6 = new JLabel("Availablility");
        l6.setBounds(850, 110, 100, 20);
        add(l6);
        
        l7 = new JLabel("Location");
        l7.setBounds(1010, 110, 100, 20);
        add(l7);
        
        b1 = new JButton("Submit");
        b1.setBounds(400, 560, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(600, 560, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(420, 200, 1165, 650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            try {
                String str = "select * from driver where brand  = '"+c1.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new PickUp().setVisible(true);
    }
}
