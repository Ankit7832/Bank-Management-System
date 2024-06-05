package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinTextField, rePinTextField;
    JButton change,back;
    String pinNumber;
    PinChange(String pinNumber){

        this.pinNumber=pinNumber;

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= il.getImage().getScaledInstance(750,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setBounds(170,260,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel pintext = new JLabel("New PIN");
        pintext.setBounds(150,320,100,20);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        pinTextField.setBounds(290,320,130,25);
        image.add(pinTextField);

        JLabel rePintext = new JLabel("Re-Enter New PIN");
        rePintext.setBounds(150,360,200,20);
        rePintext.setFont(new Font("System",Font.BOLD,16));
        rePintext.setForeground(Color.WHITE);
        image.add(rePintext);

        rePinTextField = new JPasswordField();
        rePinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        rePinTextField.setBounds(290,360,130,25);
        image.add(rePinTextField);

        change = new JButton("Change");
        change.setBounds(300,430,120,25);
        change.addActionListener(this);
        image.add(change);

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

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==change){
            try{
                String newPin = pinTextField.getText();
                String rePin = rePinTextField.getText();

                if(!newPin.equals(rePin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN doesn't Match");
                    return;
                }
                if(newPin.equals("") || rePin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1="update bank set pinNumber = '"+rePin+"' where pinNumber = '"+pinNumber+"'";
                String query2="update login set pinNumber = '"+rePin+"' where pinNumber = '"+pinNumber+"'";
                String query3="update signupThree set pinNumber = '"+rePin+"' where pinNumber = '"+pinNumber+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new Transaction(rePin).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }

    }

}
