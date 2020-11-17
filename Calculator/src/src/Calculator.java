package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.*;

public class Calculator implements ActionListener {
    private static final float BTN_FONT_SIZE = 20f;
    private static final String[][] BTN_LABELS = {
            {"(", ")", "<-", "CE"},
            {"7", "8", "9", "-"},
            {"4", "5", "6", "+"},
            {"1", "2", "3", "/"},
            {"0", "^", "*", "="}
    };
    int flag = 0;
    private JPanel mainPanel = new JPanel();
    JTextField label;

    public Calculator() {
        int rows = BTN_LABELS.length;
        int cols = BTN_LABELS[0].length;
        int gap = 4;
        mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        mainPanel.setLayout(new GridLayout(rows, cols, gap, gap));
        for (String[] btnLabelRow : BTN_LABELS) {
            for (String btnLabel : btnLabelRow) {
                JButton btn = createButton(btnLabel);
                btn.addActionListener(this);
                mainPanel.add(btn);
            }
        }
        label = new JTextField("0", 30);
        label.setPreferredSize(new Dimension(80, 35));
        label.setMaximumSize(new Dimension(200, 20));

    }

    private JButton createButton(String btnLabel) {
        JButton button = new JButton(btnLabel);
        button.setFont(button.getFont().deriveFont(BTN_FONT_SIZE));
        return button;
    }

    public JComponent getMainComponent() {
        return mainPanel;
    }

    public JTextField getTextField() {
        return label;
    }

    public static void main(String[] args) {
        Calculator mainPanel = new Calculator();
        JFrame frame = new JFrame("CalcEg");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel text = new JPanel();
        text.setLayout(new FlowLayout(27));

        text.add(mainPanel.getTextField());
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        frame.add(text, c);

        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        frame.getContentPane().add(mainPanel.getMainComponent(), c);

        frame.setSize(330, 330);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = ((JButton) e.getSource()).getText();
        if (id.equals("CE")) {
            label.setText("0");
        } else if (id.equals("=")) {
            flag = 1;
            String exp = label.getText();
            if (isOperator(exp.trim().charAt(0))) {
                exp = "0" + exp;
            }
            label.setText(evaluate(exp));
        } else if (id.equals("<-")) {

            label.setText(label.getText().substring(0, label.getText().length() - 1));
            if (label.getText().equals("")) {
                label.setText("0");
            }
        } else {
            if (label.getText().equals("0")) {
                if (id.charAt(0) != '(' && isOperator(id.trim().charAt(0))) {
                    label.setText(label.getText() + id);
                } else {
                    label.setText(id);
                }
            } else {
                label.setText(label.getText() + id);
            }
        }

    }

    int isp(char x) {
        switch (x) {
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 4;
            case '^':
                return 5;
            case '(':
                return 0;
        }
        return -1;
    }

    int icp(char x) {
        switch (x) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 3;
            case '^':
                return 6;
            case '(':
                return 9;
            case ')':
                return 0;
        }
        return -1;
    }

    private String evaluate(String text) {
        Stack<Character> operator = new Stack<>();
        operator.push('(');
        text = text + ')';
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int flag = 0;
        char x, item;
        while (i < text.length()) {
            item = text.charAt(i);
            i++;
            x = operator.pop();
            if (isOperand(item)) {
                flag = 0;
                builder.append(item);
                operator.push(x);
            } else if (item == ')') {
                flag = 0;
                while (x != '(') {
                    builder.append(" ");
                    builder.append(x);
                    builder.append(" ");
                    x = operator.pop();
                }
            } else if (flag == 1) {
                flag = 0;
                if (item == '-') {
                    builder.append('~');
                    builder.append(" ");
                }
                operator.push(x);
            } else if (isOperator(item)) {
                builder.append(" ");
                if (isp(x) >= icp(item)) {
                    while (isp(x) >= icp(item)) {
                        builder.append(x);
                        builder.append(" ");
                        x = operator.pop();
                    }
                    operator.push(x);
                    operator.push(item);
                } else if (isp(x) < icp(item)) {
                    operator.push(x);
                    operator.push(item);
                }
                flag = 1;
            } else {
                return "Invalid Expression";
            }

        }
        builder.append(" #");
        String value;
        try {
            value = value(builder.toString().trim());
        } catch (NumberFormatException e) {
            return "Invalid Characters";
        } catch (ArithmeticException e) {
            return "Arithmetic Error";
        } catch (EmptyStackException e) {
            return "Invalid Expression";
        }

        return value;

    }

    private String value(String exp) {
        String array[] = exp.split(" ");
        Stack<Integer> operand = new Stack<>();
        boolean flag = false;
        for (String op : array) {
            if (!op.trim().isBlank()) {
                char item = op.charAt(0);
                if (isOperand(item)) {
                    int val = 0;
                    try {
                        val = Integer.parseInt(op);
                    } catch (NumberFormatException ep) {
                        throw new NumberFormatException("Invalid Characters");
                    }
                    if (flag) {
                        flag = false;
                        operand.push((int) (-1 * val));
                    } else {
                        operand.push((int) val);
                    }
                } else if (isOperator(item)) {
                    Integer y = operand.pop();
                    Integer x = operand.pop();
                    if (item == '/') {
                        if (y == 0) {
                            throw new ArithmeticException("Zero Division Error");
                        }
                    }
                    operand.push((int) performCalc(x, y, item));
                } else if (item == '~') {
                    flag = true;
                } else if (item == '#') {
                    return operand.pop().toString();
                } else {
                    return "Invalid Expression";
                }
            }
        }
        return "Invalid Exp";
    }

    private double performCalc(Integer x, Integer y, char item) {
        switch (item) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '^':
                return Math.pow(x, y);
        }
        return 0;
    }

    private boolean isOperator(char item) {
        return item == '+' || item == '-' || item == '*' || item == '^' || item == '/' || item == '(';
    }


    private boolean isOperand(char item) {
        return item >= '0' && item <= '9';
    }
}