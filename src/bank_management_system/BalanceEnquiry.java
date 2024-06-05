package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    BalanceEnquiry(String pinNumber){

        this.pinNumber=pinNumber;

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= il.getImage().getScaledInstance(750,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);


        back = new JButton("Back");
        back.setBounds(300,465,120,25);
        back.addActionListener(this);
        image.add(back);


        int balance =0;
        Conn conn = new Conn();
        String query1 = "Select * from bank where pinNumber = '"+pinNumber+"'";
        try{

            ResultSet rs = conn.s.executeQuery(query1);
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is : "+balance);
        text.setBounds(140,260,400,20);
        text.setFont(new Font("System",Font.BOLD,12));
        text.setForeground(Color.WHITE);
        image.add(text);

        setLayout(null);
        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }

    }


}
