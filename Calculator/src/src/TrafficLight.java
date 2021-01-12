package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight implements ActionListener {


    JRadioButton B1 = new JRadioButton("RED");
    JRadioButton B2 = new JRadioButton("YELLOW");
    JRadioButton B3 = new JRadioButton("GREEN");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    public static void main(String[] args) {
        new TrafficLight();
    }

    TrafficLight() {
        try {

            p1.setBackground(Color.RED);
            p2.setBackground(Color.YELLOW);
            p3.setBackground(Color.GREEN);


            JFrame frame = new JFrame();
            frame.setSize(1000, 500);
            frame.setVisible(true);
            frame.setTitle("CALCULATOR");
            frame.setLayout(new GridLayout(4, 4, 1, 1));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(B1);
            frame.add(B2);
            frame.add(B3);
            frame.add(p1);
            frame.add(p2);
            frame.add(p3);
            B1.addActionListener(this);
            B2.addActionListener(this);
            B3.addActionListener(this);
            frame.setLayout(new GridLayout(1, 2, 1, 1));
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hi");
        if (B1.isSelected()) {
            p1.setVisible(true);
            p2.setVisible(false);
            p3.setVisible(false);
        }
        if (B2.isSelected()) {
            p1.setVisible(false);
            p2.setVisible(true);
            p3.setVisible(false);
        }
        if (B3.isSelected()) {
            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(true);
        }
    }
}