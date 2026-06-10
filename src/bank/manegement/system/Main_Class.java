package bank.manegement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
   String pin;

    Main_Class(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,790,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,790);
        add(image);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        label.setBounds(430,180,700,35);
        image.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(410,255,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(700,255,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(410,300,150,35);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(700,300,150,35);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(410,345,150,35);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(700,345,150,35);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(700,390,150,35);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        image.add(b7);

        setLayout(null);
        setSize(1550,1600);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource()==b7) {
            System.exit(0);
        } else if (e.getSource()==b2) {
            new Withdrawl(pin);
            setVisible(false);
        }else if (e.getSource()==b6){
            new BalanceEnquriy(pin);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource()==b4) {
            new Mini(pin);
        }
    }

    public static void main(String[] args){
        new Main_Class("");
    }
}
