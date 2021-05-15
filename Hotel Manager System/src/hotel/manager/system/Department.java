
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JCheckBox c2;
    Choice c1;
    
    Department(){
        
        JLabel check = new JLabel("Department");
        check.setFont(new Font("Tahoma",Font.PLAIN,20));
        check.setBackground(Color.white);
        check.setForeground(Color.blue);
        check.setBounds(200, 10, 200, 30);
        add(check);
        
        t1 = new JTable();
        t1.setBounds(0, 110, 600, 200);
        add(t1);
        
        l1 = new JLabel("Department");
        l1.setBounds(50, 80, 100, 20);
        add(l1);
         
        l2 = new JLabel("Budget");
        l2.setBounds(370, 80, 100, 20);
        add(l2);
       
        b1 = new JButton("Submit");
        b1.setBounds(100, 500, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(300, 500, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(420, 200, 700, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            try {
                String str = "select * from department";
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
        new Department().setVisible(true);
    }
}
