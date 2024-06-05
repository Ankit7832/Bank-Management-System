package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton depositButton, withdrawButton, fastCashButton ,balanceInquiryButton, exitButton, miniStatementButton, pinChangeButton;
    String pinNumber;
    Transaction(String pinNumber){
        this.pinNumber=pinNumber;

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= il.getImage().getScaledInstance(750,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(170,260,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(150, 300, 120, 30);
        depositButton.setFont(new Font("System",Font.BOLD,12));
        depositButton.addActionListener(this);
        image.add(depositButton);


        withdrawButton = new JButton("Withdraw ");
        withdrawButton.setBounds(300, 300, 120, 30);
        withdrawButton.setFont(new Font("System",Font.BOLD,12));
        withdrawButton.addActionListener(this);
        image.add(withdrawButton);

        balanceInquiryButton = new JButton("Balance");
        balanceInquiryButton.setBounds(150, 350, 120, 30);
        balanceInquiryButton.setFont(new Font("System",Font.BOLD,12));
        balanceInquiryButton.addActionListener(this);
        image.add(balanceInquiryButton);

        miniStatementButton = new JButton("Mini-Statement");
        miniStatementButton.setBounds(300, 350, 120, 30);
        miniStatementButton.setFont(new Font("System",Font.BOLD,12));
        miniStatementButton.addActionListener(this);
        image.add(miniStatementButton);

        fastCashButton = new JButton("Fast Cash");
        fastCashButton.setBounds(150, 400, 120, 30);
        fastCashButton.setFont(new Font("System",Font.BOLD,12));
        fastCashButton.addActionListener(this);
        image.add(fastCashButton);

        pinChangeButton = new JButton("Pin Change");
        pinChangeButton.setBounds(300, 400, 120, 30);
        pinChangeButton.setFont(new Font("System",Font.BOLD,12));
        pinChangeButton.addActionListener(this);
        image.add(pinChangeButton);


        exitButton = new JButton("Exit");
        exitButton.setBounds(300, 450, 120, 30);
        exitButton.setFont(new Font("System",Font.BOLD,12));
        exitButton.addActionListener(this);
        image.add(exitButton);


        setLayout(null);
        setSize(750,750);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == depositButton){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);

        } else if(ae.getSource() == withdrawButton){
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        } else if(ae.getSource() == balanceInquiryButton){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if(ae.getSource() == miniStatementButton){
            new MiniStatement(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastCashButton){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if(ae.getSource() == pinChangeButton){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if(ae.getSource() == exitButton){
            JOptionPane.showMessageDialog(null, "Exit button clicked!");
            System.exit(0);
        }
    }


}
