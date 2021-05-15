
package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard(){
        
        mb = new JMenuBar();
        add(mb);
        
        m1 = new JMenu("HOTEL.MANAGEMENT");
        m1.setForeground(Color.red);
        mb.add(m1);
        
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.blue);
        mb.add(m2);
        
        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        
        mb.setBounds(0, 0, 1950, 30);
        
        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("hotel/manager/system/icons/third.jfif"));
        
        Image im2 = im1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel l1 = new JLabel(im3);
        l1.setBounds(0, 0, 1950, 1000);
        add(l1);
        
        JLabel l2 = new JLabel("THE CRIS GROUP WELCOME YOU");
        l2.setBounds(600, 60, 1000, 50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Tohama",Font.PLAIN,50));
        l1.add(l2);
        
        setLayout(null);
        setBounds(10, 10, 1900, 1050);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver().setVisible(true);
        }
    }
}
