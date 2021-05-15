package hotel.manager.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HotelManagerSystem extends JFrame  implements ActionListener{

    HotelManagerSystem() {
        setBounds(430, 170, 1024, 682);
        // setSize(400,400);
        //setLocation(300,300);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/manager/system/icons/first.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1024, 682);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20, 530, 800, 90);
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif", Font.PLAIN, 50));
        l1.add(l2);
        
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(830, 560, 150, 50);
        b1.addActionListener(this);
        l1.add(b1);
        
        setLayout(null);
        setVisible(true);
        
        while(true){
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                
            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                
            }
        }

        
    }

        public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        new HotelManagerSystem();

    }

}
