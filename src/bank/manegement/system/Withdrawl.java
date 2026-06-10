package bank.manegement.system;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Date;
//
//public class Withdrawl extends JFrame implements ActionListener {
//
//    String pin;
//    TextField textField;
//    JButton b1,b2;
//
//    Withdrawl(String pin){
//        this.pin = pin;
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
//        Image i2 = i1.getImage().getScaledInstance(1550,795,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0,0,1550,795);
//        add(image);
//
//        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS. 10,000");
//        label1.setForeground(Color.WHITE);
//        label1.setFont(new Font("System",Font.BOLD,16));
//        label1.setBounds(460,180,700,35);
//        image.add(label1);
//
//        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
//        label2.setForeground(Color.WHITE);
//        label2.setFont(new Font("System",Font.BOLD,16));
//        label2.setBounds(460,220,400,35);
//        image.add(label2);
//
//        textField = new TextField();
//        textField.setBounds(460,260,320,25);
//        textField.setFont(new Font("Raleway",Font.BOLD,22));
//        textField.setBackground(new Color(65,125,128));
//        textField.setForeground(Color.WHITE);
//        image.add(textField);
//
//        b1 = new JButton("WITHDRAWL");
//        b1.setBounds(700,350,150,31);
//        b1.setBackground(new Color(65,125,128));
//        b1.setForeground(Color.WHITE);
//        b1.addActionListener(this);
//        image.add(b1);
//
//        b2 = new JButton("BACK");
//        b2.setBounds(700,394,150,32);
//        b2.setBackground(new Color(65,125,128));
//        b2.setForeground(Color.WHITE);
//        b2.addActionListener(this);
//        image.add(b2);
//
//        setLayout(null);
//        setSize(2550,1600);
//        setLocation(0,0);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == b1) {
//            try {
//                String amount = textField.getText();
//                Date date = new Date();
//                if (textField.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
//                } else {
//                    Connector connector1 = new Connector();
//                    ResultSet resultSet = connector1.statement.executeQuery("select * from bank where pin = '" + pin + "'");
//                    int balance = 0;
//                    while (resultSet.next()) {
//                        if (resultSet.getString("type").equals("Deposit")) {
//                            balance += Integer.parseInt(resultSet.getString("amount"));
//                        }else if (resultSet.getString("type").equals("withdrawl")){
//                            balance = balance - Integer.parseInt(resultSet.getString("amount"));
//                        }
//                    }
//                    if (balance < Integer.parseInt(amount)){
//                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
//                        return;
//                    }
//
//                    connector1.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'withdrawl', '" + amount + "' )");
//                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
//                    setVisible(false);
//                    new Main_Class(pin);
//                }
//            } catch (Exception E) {
//
//            }
//            } else if (e.getSource()==b2) {
//            setVisible(false);
//            new Main_Class(pin);
//        }
//    }
//
//    public static void main(String[] args){
//        new Withdrawl("");
//
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    TextField textField;

    JButton b1, b2;
    Withdrawl(String pin){
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);


        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    Connector connector1 = new Connector();
                    ResultSet resultSet = connector1.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    connector1.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new Main_Class(pin);

                }

            } catch (Exception E) {
                E.printStackTrace();
                System.out.println("error: "+E);

            }
        } else if (e.getSource()==b2) {
            setVisible(false);
            new Main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
