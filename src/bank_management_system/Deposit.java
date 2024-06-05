package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener {

    JButton deposit,back;
    String pinNumber;
    JTextField amount;
    Deposit(String pinNumber){

        this.pinNumber=pinNumber;

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= il.getImage().getScaledInstance(750,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(140,260,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(135,300,290,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(300,430,120,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(300,465,120,25);
        back.addActionListener(this);
        image.add(back);


        setLayout(null);
        setSize(750,750);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String depositAmount= amount.getText();
            Date date = new Date();
            if(depositAmount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else{
                Conn conn = new Conn();
                String query = "insert into bank value ('"+pinNumber+"','"+date+"','Deposit','"+depositAmount+"')";
                try{
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+ depositAmount+" deposited successfully");

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

