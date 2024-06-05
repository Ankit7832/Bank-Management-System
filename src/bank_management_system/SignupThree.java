package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAcc,currentAcc,salaryAcc,fdAcc;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo;

    SignupThree(String formNo){
        this.formNo=formNo;
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,100,200,30);
        add(type);

        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setBounds(100,140,200,30);
        savingAcc.setBackground(Color.WHITE);
        savingAcc.setFont(new Font("Raleway",Font.BOLD,22));
        add(savingAcc);

        currentAcc = new JRadioButton("Current Account");
        currentAcc.setBounds(350,140,200,30);
        currentAcc.setBackground(Color.WHITE);
        currentAcc.setFont(new Font("Raleway",Font.BOLD,22));
        add(currentAcc);

        salaryAcc = new JRadioButton("Salary Account");
        salaryAcc.setBounds(100,180,200,30);
        salaryAcc.setBackground(Color.WHITE);
        salaryAcc.setFont(new Font("Raleway",Font.BOLD,22));
        add(salaryAcc);

        fdAcc = new JRadioButton("Fixed-Deposit Account");
        fdAcc.setBounds(350,180,300,30);
        fdAcc.setBackground(Color.WHITE);
        fdAcc.setFont(new Font("Raleway",Font.BOLD,22));
        add(fdAcc);

        ButtonGroup account = new ButtonGroup();
        account.add(savingAcc);
        account.add(salaryAcc);
        account.add(currentAcc);
        account.add(fdAcc);

        JLabel cardNo = new JLabel("Card Number :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,22));
        cardNo.setBounds(100,240,200,30);
        add(cardNo);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4208");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,240,300,30);
        add(number);

        JLabel cardDetail = new JLabel("Your 16-Digit Card Number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100,270,300,20);
        add(cardDetail);

        JLabel pinNo = new JLabel("Card Number :");
        pinNo.setFont(new Font("Raleway",Font.BOLD,22));
        pinNo.setBounds(100,320,200,30);
        add(pinNo);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(330,320,300,30);
        add(pinnumber);

        JLabel pinDetail = new JLabel("Your 4-Digit Pin Number");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(100,350,300,20);
        add(pinDetail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,400,400,30);
        add(services);

        c1= new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,440,150,30);
        add(c1);

        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,440,300,30);
        add(c2);

        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,490,200,30);
        add(c3);

        c4= new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,490,350,30);
        add(c4);

        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,540,150,30);
        add(c5);

        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,540,150,30);
        add(c6);

        c7= new JCheckBox("I here by declare that the above information that is provided is true to best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,600,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(220,650,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(450,650,100,30);
        cancel.addActionListener(this);
        add(cancel);


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(savingAcc.isSelected()){
                accountType="Saving Account";
            } else if (salaryAcc.isSelected()) {
                accountType="Salary Account";
            } else if (currentAcc.isSelected()) {
                accountType="Current Account";
            } else if (fdAcc.isSelected()) {
                accountType="Fixed-Deposit Account";
            }

            Random random = new Random();
            String cardNumber = ""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinNumber =""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility = "";
            if(c1.isSelected()){
                facility+= " ATM Card";
            }if (c2.isSelected()) {
                facility+= " Internet Banking";
            }if (c3.isSelected()) {
                facility+= " Mobile Banking";
            }if (c4.isSelected()) {
                facility+= " Email & SMS Alert";
            }if (c5.isSelected()) {
                facility+= " Cheque Book";
            }if (c6.isSelected()) {
                facility+= " E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                } else  {

                    Conn conn=new Conn();
                    String query1= "insert into signupThree values('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    conn.s.executeUpdate(query1);
                    String query2= "insert into login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number : " + cardNumber + "\n Pin : "+ pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);

                }
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);

        }

    }

}
