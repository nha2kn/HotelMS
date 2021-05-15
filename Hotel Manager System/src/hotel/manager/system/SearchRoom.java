
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JComboBox c1;
    JCheckBox c2;
    
    SearchRoom(){
        
        JLabel check = new JLabel("Search For Room");
        check.setFont(new Font("Tahoma",Font.PLAIN,20));
        check.setBackground(Color.white);
        check.setForeground(Color.blue);
        check.setBounds(450, 10, 200, 30);
        add(check);
        
        JLabel type = new JLabel("Room Bed Type");
        type.setBounds(30, 70, 150, 30);
        add(type);
        
        c1 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c1.setBounds(150, 70, 150, 30);
        add(c1);
        
        c2 = new JCheckBox("Only display Available");
        c2.setBounds(700, 70, 300, 30);
        c2.setBackground(Color.white);
        add(c2);
        
        t1 = new JTable();
        t1.setBounds(0, 130, 1150, 400);
        add(t1);
        
        l1 = new JLabel("Room Number");
        l1.setBounds(100, 110, 100, 20);
        add(l1);
         
        l2 = new JLabel("Availability");
        l2.setBounds(300, 110, 100, 20);
        add(l2);
         
        l3 = new JLabel("Cleaning Status");
        l3.setBounds(500, 110, 100, 20);
        add(l3);
         
        l4 = new JLabel("Price");
        l4.setBounds(750, 110, 100, 20);
        add(l4);
         
        l5 = new JLabel("Bed Type");
        l5.setBounds(950, 110, 100, 20);
        add(l5);
        
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
                String str = "select * from room where bed_type  = '"+c1.getSelectedItem()+"'";
                String str2 = "select * from room where availability = 'Available' and bed_type = '"+c1.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs;
                
                if(c2.isSelected()){
                    rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }
}
