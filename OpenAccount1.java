import com.mysql.cj.log.Log;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyListener;
import java.sql.*;
import java.awt.event.*;
public class OpenAccount1 extends JFrame implements KeyListener {
    JLabel name,phone,email,address,city,state,pincode,gender,lGender,lPhone,lPin;
    JTextField tname , tPhone,tEmail,tAddress,tCity,tState,tPincode;
    JRadioButton male , female;
    JButton next,cancel;
    OpenAccount1()
    {
        ImageIcon s1 = new ImageIcon(ClassLoader.getSystemResource("images/saving.jpg"));
        Image s2 = s1.getImage().getScaledInstance(600,500,Image.SCALE_SMOOTH);
        ImageIcon s3 = new ImageIcon(s2);
        JLabel saving = new JLabel(s3);
        saving.setBounds(880+250+50,300,600,500);
//        add(saving);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("images/logoBank.png"));
        Image l2 = l1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel logo = new JLabel(l3);
        logo.setBounds(790,50,120,150);
        add(logo);
        JLabel logoText = new JLabel("Banker");
        logoText.setBounds(913,100,200,30);
        logoText.setFont(new Font("Bodoni MT black",Font.BOLD,30));
        add(logoText);

        JLabel logoText2 = new JLabel("Banking basic application");
        logoText2.setBounds(916,120,250,30);
        logoText2.setFont(new Font("Agency FB",Font.PLAIN,20));
        add(logoText2);

        name = new JLabel("Name:");
        name.setBounds(750,250,100,30);
        name.setFont(new Font("raleway",Font.BOLD,20));
        add(name);

        email = new JLabel("Email:");
        email.setBounds(750,300,100,30);
        email.setFont(new Font("raleway",Font.BOLD,20));
        add(email);

        phone = new JLabel("Phone No:");
        phone.setBounds(750,350,100,30);
        phone.setFont(new Font("raleway",Font.BOLD,20));
        add(phone);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        gender = new JLabel("Gender:");
        gender.setBounds(750,400,100,30);
        gender.setFont(new Font("raleway",Font.BOLD,18));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(880,400,100,30);
        male.setFont(new Font("raleway",Font.BOLD,20));
        add(male);
        male.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lGender.setVisible(false);
            }
        });
        female = new JRadioButton("Female");
        female.setBounds(1000,400,100,30);
        female.setFont(new Font("raleway",Font.BOLD,20));
        add(female);
        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lGender.setVisible(false);

            }
        });

        lGender = new JLabel("Please select gender");
        lGender.setBounds(885,432,200,10);
        lGender.setForeground(Color.red);
        add(lGender);
        lGender.setVisible(false);

        address = new JLabel("Address:");
        address.setBounds(750,450,100,30);
        address.setFont(new Font("raleway",Font.BOLD,20));
        add(address);

        city = new JLabel("City:");
        city.setBounds(750,500,100,30);
        city.setFont(new Font("raleway",Font.BOLD,20));
        add(city);

        state = new JLabel("State:");
        state.setBounds(750,550,100,30);
        state.setFont(new Font("raleway",Font.BOLD,20));
        add(state);

        pincode = new JLabel("Pincode:");
        pincode.setBounds(750,600,100,30);
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        add(pincode);

        tname = new JTextField();
        tname.setBounds(880,250,250,30);
        tname.setFont(new Font("raleway",Font.BOLD,20));
        add(tname);

        tPhone = new JTextField();
        tPhone.setBounds(880,350,250,30);
        tPhone.setFont(new Font("raleway",Font.BOLD,20));
        add(tPhone);

        lPhone = new JLabel("Enter valid Phone Number");
        lPhone.setBounds(885,382,200,10);
        lPhone.setForeground(Color.red);
        add(lPhone);
        lPhone.setVisible(false);


        tEmail = new JTextField();
        tEmail.setBounds(880,300,250,30);
        tEmail.setFont(new Font("raleway",Font.BOLD,20));
        add(tEmail);

        tAddress = new JTextField();
        tAddress.setBounds(880,450,250,30);
        tAddress.setFont(new Font("raleway",Font.BOLD,20));
        add(tAddress);

        tCity = new JTextField();
        tCity.setBounds(880,500,250,30);
        tCity.setFont(new Font("raleway",Font.BOLD,20));
        add(tCity);

        tState = new JTextField();
        tState.setBounds(880,550,250,30);
        tState.setFont(new Font("raleway",Font.BOLD,20));
        add(tState);

        tPincode = new JTextField();
        tPincode.setBounds(880,600,250,30);
        tPincode.setFont(new Font("raleway",Font.BOLD,20));
        add(tPincode);

        cancel = new JButton("Cancel");
        cancel.setBounds(930,660,90,30);
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                setVisible(false);
            }
        });

        next = new JButton("Next");
        next.setBounds(1030,660,90,30);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.white);
        add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sname = tname.getText();
                String sPhone = tPhone.getText();
                String sEmail = tEmail.getText();
                String sAddress = tAddress.getText();
                String sCity = tCity.getText();
                String sState = tState.getText();
                String sPincode = tPincode.getText();
                String sGender = null;
                if(male.isSelected())
                {
                    sGender = "Male";
                }
                else if(female.isSelected())
                {
                    sGender = "Female";
                }
                else{
                    lGender.setVisible(true);
                }
                if(sname.isBlank())
                {
                    tname.setBorder(new LineBorder(Color.red));
                    tname.requestFocus();
                }
                else if(sEmail.isBlank())
                {
                    tEmail.setBorder(new LineBorder(Color.red));
                    tEmail.requestFocus();
                }
                else if(sPhone.isBlank() || !sPhone.matches("\\d+") || sPhone.length() < 10)
                {
                    if(!sPhone.matches("\\d+") || sPhone.length() < 10)
                    {
                        lPhone.setVisible(true);
                    }
                    tPhone.setBorder(new LineBorder(Color.red));
                    tPhone.requestFocus();
                }
                else if(sAddress.isBlank())
                {
                    tAddress.setBorder(new LineBorder(Color.red));
                    tAddress.requestFocus();
                }
                else if(sCity.isEmpty())
                {
                    tCity.setBorder(new LineBorder(Color.red));
                    tCity.requestFocus();
                }else if(sState.isEmpty())
                {
                    tState.setBorder(new LineBorder(Color.red));
                    tState.requestFocus();
                }else if(sPincode.isEmpty() || !sPincode.matches("\\d+"))
                {
                    tPincode.setBorder(new LineBorder(Color.red));
                    tPincode.requestFocus();
                }
                else {
                    try
                    {
                        String q = "select * from userInformation where phoneNumber = '"+sPhone+"' or email = '"+sEmail+"'";
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "Anant@2004");
                        PreparedStatement smt = c.prepareStatement(q);
                        ResultSet rs = smt.executeQuery();
                        if(rs.next())
                        {
                            JOptionPane.showMessageDialog(null,"The Account with given information already exists");
                        }
                        else{
                            String [] transfer = {sname,sPhone,sEmail,sGender,sAddress,sCity,sState,sPincode};
                            new OpenAccount2(transfer);
                            setVisible(false);
                        }
                    }
                    catch(Exception x)
                    {
                        x.printStackTrace();
                    }

                }
            }
        });
        tname.addKeyListener(this);
        tPincode.addKeyListener(this);
        tPhone.addKeyListener(this);
        tEmail.addKeyListener(this);
        tAddress.addKeyListener(this);
        tCity.addKeyListener(this);
        tState.addKeyListener(this);
        tname.setBorder(new LineBorder(Color.BLACK));
        tPhone.setBorder(new LineBorder(Color.BLACK));
        tEmail.setBorder(new LineBorder(Color.BLACK));
        tAddress.setBorder(new LineBorder(Color.BLACK));
        tCity.setBorder(new LineBorder(Color.BLACK));
        tState.setBorder(new LineBorder(Color.BLACK));
        tPincode.setBorder(new LineBorder(Color.BLACK));


        setLayout(null);
        setVisible(true);
    }
    public void keyTyped(KeyEvent e)
    {
        tname.setBorder(new LineBorder(Color.BLACK));
        tPhone.setBorder(new LineBorder(Color.BLACK));
        tEmail.setBorder(new LineBorder(Color.BLACK));
        tAddress.setBorder(new LineBorder(Color.BLACK));
        tCity.setBorder(new LineBorder(Color.BLACK));
        tState.setBorder(new LineBorder(Color.BLACK));
        tPincode.setBorder(new LineBorder(Color.BLACK));
        lPhone.setVisible(false);


    }
    public void keyReleased(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e)
    {

    }
    public static void main(String[] args) {
        new OpenAccount1();
    }
}
