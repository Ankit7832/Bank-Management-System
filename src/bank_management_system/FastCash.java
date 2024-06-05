package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton Rs100Button,Rs500Button, Rs1000Button, Rs2000Button,Rs5000Button ,Rs10000Button,backButton;
    String pinNumber;

    FastCash(String pinNumber){
        this.pinNumber=pinNumber;

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= il.getImage().getScaledInstance(750,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(170,260,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        Rs100Button = new JButton("Rs 100");
        Rs100Button.setBounds(150, 300, 120, 30);
        Rs100Button.setFont(new Font("System",Font.BOLD,12));
        Rs100Button.addActionListener(this);
        image.add(Rs100Button);


        Rs500Button = new JButton("Rs 500");
        Rs500Button.setBounds(300, 300, 120, 30);
        Rs500Button.setFont(new Font("System",Font.BOLD,12));
        Rs500Button.addActionListener(this);
        image.add(Rs500Button);

        Rs1000Button = new JButton("Rs 1000");
        Rs1000Button.setBounds(150, 350, 120, 30);
        Rs1000Button.setFont(new Font("System",Font.BOLD,12));
        Rs1000Button.addActionListener(this);
        image.add(Rs1000Button);

        Rs2000Button = new JButton("Rs 2000");
        Rs2000Button.setBounds(300, 350, 120, 30);
        Rs2000Button.setFont(new Font("System",Font.BOLD,12));
        Rs2000Button.addActionListener(this);
        image.add(Rs2000Button);

        Rs5000Button = new JButton("Rs 5000");
        Rs5000Button.setBounds(150, 400, 120, 30);
        Rs5000Button.setFont(new Font("System",Font.BOLD,12));
        Rs5000Button.addActionListener(this);
        image.add(Rs5000Button);

        Rs10000Button = new JButton("Rs 10000");
        Rs10000Button.setBounds(300, 400, 120, 30);
        Rs10000Button.setFont(new Font("System",Font.BOLD,12));
        Rs10000Button.addActionListener(this);
        image.add(Rs10000Button);


        backButton = new JButton("Back");
        backButton.setBounds(300, 450, 120, 30);
        backButton.setFont(new Font("System",Font.BOLD,12));
        backButton.addActionListener(this);
        image.add(backButton);


        setLayout(null);
        setSize(750,750);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == backButton){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }else{
            String amount =  ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            String query1 = "Select * from bank where pinNumber = '"+pinNumber+"'";
            try{

                ResultSet rs = conn.s.executeQuery(query1);
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource()!=backButton && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insuficient Balance");
                    return;
                }
                Date date = new Date();
                String query2 = "insert into bank value ('"+pinNumber+"','"+date+"','Withdraw','"+ amount +"')";
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" debited");
                setVisible(false);
                new Transaction(pinNumber);

            }catch(Exception e){
                System.out.println(e);

            }
        }
    }


}
