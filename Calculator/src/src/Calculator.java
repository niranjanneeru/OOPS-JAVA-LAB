package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator{
    public static void main(String[] args)
    {
        Operation obj = new Operation();
    }
}

class Operation extends JFrame implements ActionListener
{
    JFrame f;
    JTextField t;
    String s0,s1,s2;
    JButton b_add,b_sub,b_mul,b_div,b_bac,b_cle,b_eq,b_dot,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;

    public Operation()
    {
        t=new JTextField(15);
        s0=s1=s2="";

        b0=new JButton("0");
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");

        b_add=new JButton("+");
        b_sub=new JButton("-");
        b_mul=new JButton("*");
        b_div=new JButton("/");
        b_bac=new JButton("->");
        b_cle=new JButton("C");
        b_eq=new JButton("=");
        b_dot=new JButton(".");

        f=new JFrame("Calculator");
        //JPanel p=new JPanel();


        f.add(t);
        f.add(b_add);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b0);
        f.add(b_mul);
        f.add(b_div);
        f.add(b_sub);
        f.add(b_bac);
        f.add(b_cle);
        f.add(b_eq);
        f.add(b_dot);

        b_add.addActionListener(this);
        b_sub.addActionListener(this);
        b_mul.addActionListener(this);
        b_div.addActionListener(this);
        b_bac.addActionListener(this);
        b_cle.addActionListener(this);
        b_eq.addActionListener(this);
        b_dot.addActionListener(this);
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        f.setBackground(Color.blue);

        //f.add(p);

        f.setSize(200,220);
        f.setLayout(new FlowLayout());
        f.setVisible(true);

        //{System.out.println("Exception caught: "+exp);}
        //setSize(200,220);
        //f.show();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {

        try{
            String s=e.getActionCommand();
            if((s.charAt(0)>='0' && s.charAt(0)<='9') || s.charAt(0)=='.')
            {
                if(!s1.equals(""))
                    s2=s2+s;
                else
                    s0=s0+s;

                t.setText(s0+s1+s2);
            }
            else if(s.charAt(0)=='C')
            {
                s0=s1=s2="";
                t.setText(s0+s1+s2);
            }
            else if(s.charAt(0)=='=')
            {
                double x;

                if (s1.equals("+"))
                    x = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    x = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    x = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    x = (Double.parseDouble(s0) * Double.parseDouble(s2));

                t.setText(s0 + s1 + s2 + "=" + x);
                s0 = Double.toString(x);
                s1 = s2 = "";
            }
            else
            {

                double x;

                if (s1.equals("+"))
                    x = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    x = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    x = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    x = (Double.parseDouble(s0) * Double.parseDouble(s2));

                s0 = Double.toString(x);
                s1 = s;
                s2 = "";
            }

            // set the value of text
            t.setText(s0 + s1 + s2);
        }catch(Exception ex){System.out.println("Exceeption caught: "+ex);}
    }
}