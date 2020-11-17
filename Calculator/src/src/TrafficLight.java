package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TrafficLight {

    static TrafficSignal red = new TrafficSignal(Color.red);
    static TrafficSignal yellow = new TrafficSignal(Color.yellow);
    static TrafficSignal green = new TrafficSignal(Color.green);
    static JRadioButton red_RB = new JRadioButton();
    static JRadioButton yellow_RB = new JRadioButton();
    static JRadioButton green_RB = new JRadioButton();


    public TrafficLight() {
    }

    public static void main(String[] args) {
        new TrafficLight();
        JFrame f = new JFrame("Traffic Light");
        JPanel lights = new JPanel(new GridLayout(3, 2));

        red_RB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    red.active = true;
                    green.active = false;
                    yellow.active = false;
                } else {
                    red.active = false;
                }
                updateStatus();
            }
        });

        yellow_RB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    green.active = false;
                    red.active = false;
                    yellow.active = true;
                } else {
                    yellow.active = false;
                }
                updateStatus();
            }
        });
        green_RB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    green.active = true;
                    red.active = false;
                    yellow.active = false;
                } else {
                    green.active = false;
                }
                updateStatus();
            }
        });
        lights.add(red);
        lights.add(red_RB);
        lights.add(yellow);
        lights.add(yellow_RB);
        lights.add(green);
        lights.add(green_RB);


        f.setContentPane(lights);
        f.setSize(400, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static void updateStatus() {
        green.paint(green.getGraphics());
        red.paint(red.getGraphics());
        yellow.paint(yellow.getGraphics());
        green_RB.setSelected(green.active);
        red_RB.setSelected(red.active);
        yellow_RB.setSelected(yellow.active);
    }
}


class TrafficSignal extends JPanel {

    Color color;
    int radius = 75;
    int border = 10;
    boolean active;


    TrafficSignal(Color color) {
        this.color = color;
        active = false;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (active) {
            g.setColor(color.brighter().brighter());
        } else {
            g.setColor(color.darker().darker().darker().darker().darker());
        }
        g.fillOval(border, border, 2 * radius, 2 * radius);
    }
}
