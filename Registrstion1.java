import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.util.Random;


public class Registrstion1 extends JFrame implements KeyListener{
    JLabel name ,mobile,email,card,otp,createP,confirmP ,no,pass,exist;
    JTextField tName,tMobile,tEmail,tCard,totp,tConfirm;
    JPasswordField tCreate;
    JButton get,login,submit;
    void removeLast(JTextField p)
    {
        String pass= p.getText();
        int t = pass.length()-1;
        p.setText(pass.substring(0,t));

    }
    public  static void sendMail(String fromE , String toE,String subject,String msg)
    {

                // Sender's email address
                String from = fromE;

                // Recipient's email address
                String to = toE;

                // Sender's email password (for authentication)
                String password = "9324831333A";

                // Setup properties for the SMTP server
                Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.outlook.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");

                // Create a session with the properties and an authenticator
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(from, password);
                    }
                });

                try {
                    // Create a default MimeMessage object
                    MimeMessage message = new MimeMessage(session);

                    // Set From: header field of the header
                    message.setFrom(new InternetAddress(from));

                    // Set To: header field of the header
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                    // Set Subject: header field
                    message.setSubject(subject);

                    // Now set the actual message
                    message.setText(msg);

                    // Send the message
                    Transport.send(message);

                } catch (MessagingException e) {
                    System.out.println(e);;
                }


    }

    Registrstion1()
    {
        Random r = new Random();
        long token = r.nextLong(1000000000,9999999999L);


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



        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width,d.height);

        JLabel alert2 = new JLabel("\uD83D\uDD12 Secure banking");
        alert2.setBounds(850,d.height-150,200,30);
        alert2.setFont(new Font("",Font.BOLD,20));
        alert2.setForeground(Color.BLUE);
        add(alert2);
        JLabel alert3 = new JLabel("Alert! Please dont share Otp, Pin or Password with others");
        alert3.setBounds(730,d.height-130,450,30);
        alert3.setFont(new Font("",Font.BOLD,16));
        alert3.setForeground(Color.BLUE);
        add(alert3);


        Dimension frameSize = getContentPane().getSize();
        JLabel lbl = new JLabel();
        getContentPane().add(lbl);
        lbl.setSize(frameSize);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/mainImage.jpg"));

        Image i2 = i1.getImage().getScaledInstance(d.width,d.height,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        lbl.setIcon(i3);

        JPanel frame = new JPanel();
        frame.setSize(700,500);
        frame.setLocation(600,250);
        frame.setBorder(new LineBorder(Color.WHITE,2));
        frame.setBackground(new Color(0,0,0,120));
        frame.setLayout(null);
        lbl.add(frame);

//        Content under the pannel
        name = new JLabel("Account Holder Name:");
        name.setForeground(Color.WHITE);
        name.setBounds(50+70,30+30,220,30);
        name.setFont(new Font("Algerian",Font.PLAIN,18));
        frame.add(name);

        tName = new JTextField();
        tName.setCaretColor(Color.WHITE);
//        tName.setHorizontalAlignment();
        tName.setBackground(Color.BLACK);
        tName.setForeground(Color.GRAY);
        tName.setBounds(280+70,30+30,200,30);
        tName.setFont(new Font("",Font.BOLD,16));
        frame.add(tName);
        tName.addKeyListener(this);

        card = new JLabel("Account No:");
        card.setForeground(Color.WHITE);
        card.setBounds(50+70,80+30,150,30);
        card.setFont(new Font("Algerian",Font.PLAIN,18));
        frame.add(card);

        tCard = new JTextField();
        tCard.setBackground(Color.BLACK);
        tCard.setForeground(Color.GRAY);
        tCard.setBounds(260+20+70,80+30,200,30);
        tCard.setFont(new Font("",Font.BOLD,16));
        frame.add(tCard);
        tCard.addKeyListener(this);

        mobile = new JLabel("Mobile No:");
        mobile.setForeground(Color.WHITE);
        mobile.setBounds(50+70,130+30,150,30);
        mobile.setFont(new Font("Algerian",Font.PLAIN,18));
        frame.add(mobile);

        tMobile = new JTextField();
        tMobile.setBackground(Color.BLACK);
        tMobile.setForeground(Color.GRAY);
        tMobile.setBounds(260+20+70,130+30,200,30);
        tMobile.setFont(new Font("",Font.BOLD,16));
        frame.add(tMobile);
        tMobile.addKeyListener(this);


        email = new JLabel("Email Id:");
        email.setForeground(Color.WHITE);
        email.setBounds(50+70,180+30,150,30);
        email.setFont(new Font("Algerian",Font.PLAIN,18));
        frame.add(email);

        tEmail = new JTextField();
        tEmail.setBackground(Color.BLACK);
        tEmail.setForeground(Color.GRAY);
        tEmail.setBounds(260+20+70,180+30,200,30);
        tEmail.setFont(new Font("",Font.BOLD,16));
        frame.add(tEmail);
        tEmail.addKeyListener(this);
//
//        otp = new JLabel("OTP:");
//        otp.setForeground(Color.WHITE);
//        otp.setBounds(480+30,180+30,50,30);
//        otp.setFont(new Font("Algerian",Font.PLAIN,18));
//        frame.add(otp);
//
//        totp = new JTextField();
//        totp.setBackground(Color.BLACK);
//        totp.setForeground(Color.GRAY);
//        totp.setBounds(540+30,180+30,200,30);
//        totp.setFont(new Font("",Font.BOLD,16));
//        frame.add(totp);

        createP = new JLabel("Create Password:");
        createP.setForeground(Color.WHITE);
        createP.setBounds(50+70,230+30,200,30);
        createP.setFont(new Font("Algerian",Font.PLAIN,18));
        frame.add(createP);

        tCreate = new JPasswordField();
        tCreate.setBackground(Color.BLACK);
        tCreate.setForeground(Color.GRAY);
        tCreate.setBounds(260+20+70,230+30,170,30);
        tCreate.setFont(new Font("",Font.BOLD,16));
        frame.add(tCreate);
        tCreate.addKeyListener(this);
        pass = new JLabel("length must be greater than 8");
        pass.setBounds(600+240,760,250,30);
        pass.setForeground(Color.ORANGE);
        pass.setFont(new Font("",Font.BOLD,16));
        lbl.add(pass);
        pass.setVisible(false);

        confirmP = new JLabel("Confirm Password:");
        confirmP.setForeground(Color.WHITE);
        confirmP.setBounds(50+70,280+30,200,30);
        confirmP.setFont(new Font("Algerian",Font.PLAIN,18));
        frame.add(confirmP);
        tConfirm = new JTextField();
        tConfirm.setBackground(Color.BLACK);
        tConfirm.setForeground(Color.GRAY);
        tConfirm.setBounds(260+20+70,280+30,200,30);
        tConfirm.setFont(new Font("",Font.BOLD,16));
        frame.add(tConfirm);
        tConfirm.addKeyListener(this);
        ImageIcon eye1 = new ImageIcon(ClassLoader.getSystemResource("images/eyee.png"));
        Image eye2 = eye1.getImage().getScaledInstance(15,10,Image.SCALE_DEFAULT);
        ImageIcon eye3 = new ImageIcon(eye2);

        JButton eye = new JButton(eye3);
        eye.setBounds(430+20+70,230+30,30,30);
        eye.setBackground(new Color(0,0,0,100));
        eye.setBorder(new LineBorder(Color.WHITE,1));
        frame.add(eye);
        final char c = tCreate.getEchoChar();
        eye.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tCreate.getEchoChar() != (char)0){
                    tCreate.setEchoChar((char) 0);
                }
                else
                {
                    tCreate.setEchoChar(c);
                }}
        });

        no = new JLabel("No Account found");
        no.setBounds(600+240,760,250,30);
        no.setForeground(Color.red);
        no.setFont(new Font("",Font.BOLD,24));
        lbl.add(no);
        no.setVisible(false);
        exist = new JLabel("User already exists");
        exist.setBounds(600+240,760,250,30);
        exist.setForeground(Color.ORANGE);
        exist.setFont(new Font("",Font.BOLD,24));
        lbl.add(exist);
        exist.setVisible(false);



        login = new JButton("Login");
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLUE);
        login.setBounds(130,340+30,100,30);
        frame.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                setVisible(false);
            }
        });

        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        submit.setBounds(240,340+30,100,30);
        frame.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sName = tName.getText().toLowerCase().trim();
                String sCard = tCard.getText();
                String sPhone = tMobile.getText();
                String sEmail = tEmail.getText().toLowerCase();
                String sCreate = tCreate.getText();
                String sConfirm = tConfirm.getText();
                if(sName.equals(""))
                {
                    tName.setBorder(new LineBorder(Color.red));
                    tName.requestFocus();
                }
                else if(sCard.equals(""))
                {
                    tCard.setBorder(new LineBorder(Color.red));
                    tCard.requestFocus();
                }else if(sPhone.equals("") || sPhone.length() != 10)
                {
                    tMobile.setBorder(new LineBorder(Color.red));
                    tMobile.requestFocus();

                }else if(sEmail.equals(""))
                {
                    tEmail.setBorder(new LineBorder(Color.red));
                    tEmail.requestFocus();

                }else if(sCreate.equals("") || sCreate.length() < 8)
                {
                    if(sCreate.length() < 8)
                    {
                        pass.setVisible(true);
                    }
                    tCreate.setBorder(new LineBorder(Color.red));
                    tCreate.requestFocus();
                }else if(sConfirm.equals(""))
                {
                    tConfirm.setBorder(new LineBorder(Color.red));
                    tConfirm.requestFocus();
                }else if (!sCreate.equals(sConfirm)) {
                    JOptionPane.showMessageDialog(frame,"password and confirm password not matched");

                }
                else{
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "Anant@2004");
                        String q = "select * from userInformation where name = '"+sName+"' and accountNumber = '"+sCard+"' and  phoneNumber = '"+sPhone+"' and email = '"+sEmail+"'";
                        PreparedStatement smt = c.prepareStatement(q);
                        ResultSet rs = smt.executeQuery();
                        String q2 = "select * from registration where phoneNo = '"+sPhone+"' or email = '"+sEmail+"'";
                        PreparedStatement smt2 = c.prepareStatement(q2);
                        ResultSet rs2 = smt2.executeQuery();

                        if(rs2.next())
                        {
                            exist.setVisible(true);
                        }
                        else if(rs.next())
                        {
                            String sToken = ""+token;
                            String q1 = "insert into registration values('"+sName+"','"+sCard+"','"+sPhone+"','"+sEmail+"','"+sCreate+"','"+sToken+"','')";
                            PreparedStatement smt1 = c.prepareStatement(q1);
                            smt1.executeUpdate();
                            JOptionPane.showMessageDialog(frame,"Your Token Id is:"+token);
                            setVisible(false);
                            new CreateMpin(sCard,sName);
                        }
                        else{
                            no.setVisible(true);
                        }
                    }
                    catch(Exception x)
                    {
                        x.printStackTrace();
                    }

                }

            }
        });

        JLabel alert = new JLabel("By choosing to login, you agree and accept all the appicable");
        alert.setBounds(170,460,400,15);
        alert.setForeground(Color.WHITE);
        frame.add(alert);
        JLabel alert1 = new JLabel("Terms and Condition, privacy and Policy");
        alert1.setBounds(220,470,400,20);
        alert1.setForeground(Color.WHITE);
        frame.add(alert1);

        JLabel war = new JLabel("Invalid Token or Password");
        war.setBounds(240,350,250,30);
        war.setFont(new Font("system",Font.BOLD,16));
        war.setForeground(Color.RED);
        war.setVisible(false);

        tName.setCaretColor(Color.WHITE);
        tMobile.setCaretColor(Color.WHITE);
        tCreate.setCaretColor(Color.WHITE);
        tConfirm.setCaretColor(Color.WHITE);
        tCard.setCaretColor(Color.WHITE);
        tEmail.setCaretColor(Color.WHITE);

        setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        no.setVisible(false);
        pass.setVisible(false);
        exist.setVisible(false);
       if(e.getSource() == tCard)
       {
           tCard.setBorder(new LineBorder(Color.WHITE));
           if(!tCard.getText().matches("\\d+") && tCard.getText().length() > 0)
           {
                   removeLast(tCard);

           }
       }
       else if(e.getSource() == tName)
       {
           tName.setBorder(new LineBorder(Color.white));
       }
       else if(e.getSource() == tMobile)
       {
           tMobile.setBorder(new LineBorder(Color.white));
           if(!tMobile.getText().matches("\\d+") && tMobile.getText().length() > 0)
           {
               removeLast(tMobile);
           }

       }
       else if(e.getSource() == tCreate)
       {
           tCreate.setBorder(new LineBorder(Color.WHITE));
       }
       else if(e.getSource() == tConfirm)
       {
           tConfirm.setBorder(new LineBorder(Color.WHITE));
       }

        
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == tCard)
        {
            if(!tCard.getText().matches("\\d+") && tCard.getText().length() > 0)
            {

                    removeLast(tCard);

            }
        }
        else if(e.getSource() == tEmail)
        {
            tEmail.setBorder(new LineBorder(Color.WHITE));

            if(tEmail.getText().charAt(tEmail.getText().length()-1) == ' ')
            {

                    removeLast(tEmail);

            }
        }
        else if(e.getSource() == tMobile){
            if (!tMobile.getText().matches("\\d+")) {
                removeLast(tMobile);
            }
        }


    }

    public static void main(String[] args) {
        new Registrstion1();
    }
}
