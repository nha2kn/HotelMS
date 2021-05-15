
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    
    ManagerInfo(){
        
        t1 = new JTable();
        t1.setBounds(0, 40, 1150, 500);
        add(t1);
        
        l1 = new JLabel("Name");
        l1.setBounds(40, 10, 70, 20);
        add(l1);
         
        l2 = new JLabel("Age");
        l2.setBounds(170, 10, 70, 20);
        add(l2);
         
        l3 = new JLabel("Gender");
        l3.setBounds(310, 10, 70, 20);
        add(l3);
         
        l4 = new JLabel("Department");
        l4.setBounds(450, 10, 70, 20);
        add(l4);
         
        l5 = new JLabel("Salary");
        l5.setBounds(600, 10, 70, 20);
        add(l5);
         
        l6 = new JLabel("Phone");
        l6.setBounds(750, 10, 70, 20);
        add(l6);
         
        l7 = new JLabel("Indentify");
        l7.setBounds(890, 10, 70, 20);
        add(l7);
         
        l8 = new JLabel("Email");
        l8.setBounds(1040, 10, 70, 20);
        add(l8);
        
        b1 = new JButton("Load Data");
        b1.setBounds(350, 560, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(530, 560, 120, 30);
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
                
                conn c = new conn();
                String str = "select * from employee where job = 'Manager'";
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
        new ManagerInfo().setVisible(true);
    }
}
