package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class Withdraw extends JFrame implements ActionListener {

    JButton withdraw,back;
    String pinNumber;
    JTextField amount;
    Withdraw(String pinNumber){

        this.pinNumber=pinNumber;

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= il.getImage().getScaledInstance(750,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(140,260,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(135,300,290,25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(300,430,120,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(300,465,120,25);
        back.addActionListener(this);
        image.add(back);


        setLayout(null);
        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String withdrawAmount = amount.getText();
            Date date = new Date();
            if(withdrawAmount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else{
                Conn conn = new Conn();
                String query1 = "Select * from bank where pinNumber = '"+pinNumber+"'";
                String query2 = "insert into bank value ('"+pinNumber+"','"+date+"','Withdraw','"+ withdrawAmount +"')";
                try{
                    ResultSet rs  = conn.s.executeQuery(query1);
                    int balance =0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+= Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(ae.getSource()!=back && balance<Integer.parseInt(withdrawAmount)){
                        JOptionPane.showMessageDialog(null,"Insuficient Balance");
                    }else {
                        conn.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null,"Rs "+ withdrawAmount +" withdrawn successfully");

                    }

                }catch(Exception e){
                    System.out.println(e);
                }
            }

        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);

        }

    }

}

