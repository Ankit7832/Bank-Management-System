package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField qualificationTextField,panNumberTextField,aadhaarNumberTextField;
    JRadioButton yesSenior,noSenior,yesExisting ,noExisting;
    JComboBox religionBox,categoryBox,incomeBox,educationBox,occupationBox;
    JButton next;
    String formNo;

    SignupTwo(String formNo){
        this.formNo=formNo;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel aditionalDetail = new JLabel("Page 2: Additional Details");
        aditionalDetail.setBounds(290,80,400,30);
        aditionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
        add(aditionalDetail);

        JLabel religion = new JLabel("Religion");
        religion.setBounds(100,140,100,30);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        add(religion);

        religionBox = new JComboBox(new String[]{"Select","Hindu","Muslim","Sikh","Christain","Other"});
        religionBox.setBounds(300,140,400,30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);


        JLabel category = new JLabel("Category");
        category.setBounds(100,190,150,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        add(category);

        categoryBox = new JComboBox(new String[]{"Select","ST","SC","OBC","GENERAL"});
        categoryBox.setBounds(300,190,400,30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        JLabel income = new JLabel("Income");
        income.setBounds(100,240,150,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);

        incomeBox = new JComboBox(new String[]{"Null","< 1,50,000","< 2,50,000","< 5,00,000","> 5,00,000"});
        incomeBox.setBounds(300,240,400,30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel education = new JLabel("Education");
        education.setBounds(100,290,100,30);
        education.setFont(new Font("Raleway",Font.BOLD,20));
        add(education);

        educationBox = new JComboBox(new String[]{"Non-Graduation","Graduate","Post-Graduate","Doctrate","Other"});
        educationBox.setBounds(300,290,400,30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(100,340,200,30);
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        add(qualification);

        qualificationTextField = new JTextField();
        qualificationTextField.setFont(new Font("Raleway",Font.BOLD,14));
        qualificationTextField.setBounds(300,340,400,30);
        add(qualificationTextField);


        JLabel occupation = new JLabel("Occupation");
        occupation.setBounds(100,390,150,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupation);

        occupationBox = new JComboBox(new String[]{"Salaried","Self-Employed","Business","Student","Other"});
        occupationBox.setBounds(300,390,400,30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel panNumber = new JLabel("Pan Number");
        panNumber.setBounds(100,440,200,30);
        panNumber.setFont(new Font("Raleway",Font.BOLD,20));
        add(panNumber);

        panNumberTextField = new JTextField();
        panNumberTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panNumberTextField.setBounds(300,440,400,30);
        add(panNumberTextField);

        JLabel aadhaarNumber = new JLabel("Aadhaar Number");
        aadhaarNumber.setBounds(100,490,200,30);
        aadhaarNumber.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadhaarNumber);

        aadhaarNumberTextField = new JTextField();
        aadhaarNumberTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadhaarNumberTextField.setBounds(300,490,400,30);
        add(aadhaarNumberTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen");
        seniorCitizen.setBounds(100,540,200,30);
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        add(seniorCitizen);

        yesSenior = new JRadioButton("Yes");
        yesSenior.setBounds(300,540,100,30);
        yesSenior.setBackground(Color.WHITE);
        add(yesSenior);;

        noSenior = new JRadioButton("No");
        noSenior.setBounds(450,540,100,30);
        noSenior.setBackground(Color.WHITE);
        add(noSenior);

        ButtonGroup SeniorGroup = new ButtonGroup();
        SeniorGroup.add(yesSenior);
        SeniorGroup.add(noSenior);


        JLabel existingAcc = new JLabel("Existing Account");
        existingAcc.setBounds(100,590,200,30);
        existingAcc.setFont(new Font("Raleway",Font.BOLD,20));
        add(existingAcc);

        yesExisting = new JRadioButton("Yes");
        yesExisting.setBounds(300,590,100,30);
        yesExisting.setBackground(Color.WHITE);
        add(yesExisting);;

        noExisting = new JRadioButton("No");
        noExisting.setBounds(450,590,100,30);
        noExisting.setBackground(Color.WHITE);
        add(noExisting);

        ButtonGroup ExistingAccGroup = new ButtonGroup();
        ExistingAccGroup.add(yesExisting);
        ExistingAccGroup.add(noExisting);



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
        String religion = ""+religionBox.getSelectedItem();
        String category = "" + categoryBox.getSelectedItem();
        String income = "" + incomeBox.getSelectedItem();
        String education = "" + educationBox.getSelectedItem();
        String occupation = "" + occupationBox.getSelectedItem();
        String seniorCitizen = null;
        if(yesSenior.isSelected()){
            seniorCitizen="Yes";
        }else if(noSenior.isSelected()){
            seniorCitizen= "No";
        }
        String existingAcc = null;
        if(yesExisting.isSelected()){
            existingAcc="Yes";
        } else if (noExisting.isSelected()) {
            existingAcc="No";
        }
        String panNumber = panNumberTextField.getText();
        String aadhaarNumber= aadhaarNumberTextField.getText();

        try{
            Conn c = new Conn();
            String query = "insert into signupTwo values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+panNumber+"','"+aadhaarNumber+"','"+seniorCitizen+"','"+existingAcc+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignupThree(formNo).setVisible(true);


        }catch (Exception e){
            System.out.println(e);

        }

    }



}
