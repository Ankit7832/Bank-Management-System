package bank_management_system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class SignupOne extends JFrame implements ActionListener {

    long random;

    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,single ,married;

    SignupOne(){
        setLayout(null);
        Random ran = new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO." + random);
        formNo.setBounds(140,20,600,40);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        add(formNo);

        JLabel personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setBounds(290,80,400,30);
        personalDetail.setFont(new Font("Raleway",Font.BOLD,22));
        add(personalDetail);

        JLabel name = new JLabel("Name:");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100,190,150,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);


        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100,240,150,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway",Font.BOLD,14));
        dobTextField.setBounds(300,240,400,30);
        add(dobTextField);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100,290,100,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("E-mail:");
        email.setBounds(100,340,100,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);


        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100,390,150,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        add(marital);

        single = new JRadioButton("Single");
        single.setBounds(300,390,100,30);
        single.setBackground(Color.WHITE);
        add(single);;

        married = new JRadioButton("Married");
        married.setBounds(450,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(single);
        maritalGroup.add(married);

        JLabel address = new JLabel("Address:");
        address.setBounds(100,440,100,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setBounds(100,490,100,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setBounds(100,540,100,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);


        JLabel pincode = new JLabel("Pin Code:");
        pincode.setBounds(100,590,100,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formNo = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dobTextField.getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender= "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if(single.isSelected()){
            marital = "Single";
        }else if(married.isSelected()){
            marital= "Married";
        }
        String address= addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode= pincodeTextField.getText();
         try{
             // we can give validation here
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null,"Name is required");
             }else{
                 Conn c = new Conn();
                 String query = "insert into signupOne values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                 c.s.executeUpdate(query);

                 setVisible(false);
                 new SignupTwo(formNo).setVisible(true);
             }
         }catch(Exception e){
             System.out.println(e);

         }

    }

}
