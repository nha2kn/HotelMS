
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5;
    
    Room(){
        
        t1 = new JTable();
        t1.setBounds(0, 40, 500, 400);
        add(t1);
        
        l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 90, 20);
        add(l1);
         
        l2 = new JLabel("Availability");
        l2.setBounds(110, 10, 70, 20);
        add(l2);
         
        l3 = new JLabel("Status");
        l3.setBounds(210, 10, 70, 20);
        add(l3);
         
        l4 = new JLabel("Price");
        l4.setBounds(310, 10, 70, 20);
        add(l4);
        
        l5 = new JLabel("Bed Type");
        l5.setBounds(410, 10, 70, 20);
        add(l5);
        
        b1 = new JButton("Load Data");
        b1.setBounds(100, 460, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(250, 460, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/manager/system/icons/eight.jfif"));
        JLabel l6 = new JLabel(i1);
        l6.setBounds(510, 10, 450, 520);
        add(l6);
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(450, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            try {
                
                conn c = new conn();
                String str = "select * from room"; 
                ResultSet rs = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
            }
            
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Room().setVisible(true);
    }
}
