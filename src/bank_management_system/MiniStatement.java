package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinNumber;

    MiniStatement(String pinNumber){

        this.pinNumber=pinNumber;

        JLabel mini = new JLabel();
        mini.setBounds(20,120,400,300);
        add(mini);


        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel cardNumber = new JLabel();
        cardNumber.setBounds(20,50,300,20);
        add(cardNumber);

        JLabel balance  = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn conn= new Conn();
            ResultSet rs= conn.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
            while(rs.next()){
                cardNumber.setText("Card Number :"+ rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+  rs.getString("cardNumber").substring(12));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            int bal =0;
            ResultSet rs= conn.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText()+ "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>");
                if(rs.getString("type").equals("Deposit")){
                    bal+= Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Account Balance is : "+bal);

        }catch (Exception e){
            System.out.println(e);
        }

        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
}
