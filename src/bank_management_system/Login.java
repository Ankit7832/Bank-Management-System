package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField userTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/bankLogin.jpg"));
        Image i2= il.getImage().getScaledInstance(720,415, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,720,415);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        label.add(text);

        JLabel userId = new JLabel("Card No.");
        userId.setFont(new Font("Raleway",Font.BOLD,20));
        userId.setBounds(50,120,100,30);
        label.add(userId);

        userTextField = new JTextField();
        userTextField.setBounds(150,120,230,30);
        userTextField.setFont(new Font("Arial", Font.BOLD,14));
        label.add(userTextField);

        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(50,180,100,30);
        label.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(150,180,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
        label.add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(150,250,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        label.add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(280,250,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        label.add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(150,300,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        label.add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(720,415);
        setVisible(true);
        setLocation(350,200);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear){
            userTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource()==login) {

            Conn conn = new Conn();
            String cardNumber = userTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "Select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
            try{
                ResultSet rs =conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number and Pin");
                }

            }catch(Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()==signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}
