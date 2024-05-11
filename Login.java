import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame{
    JLabel cardNo,password,forget,no,notFound;
    JTextField tCardNo ;
    JPasswordField  tPassword;
    JButton login,register;
    void removeLast(JTextField p)
    {
        String pass= p.getText();
        int t = pass.length()-1;
        p.setText(pass.substring(0,t));

    }
    Login()
    {
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

        JPanel hai = new JPanel();
        hai.setBounds(600,250-40,700,40);
        hai.setBackground(Color.BLACK);
        hai.setBorder(new LineBorder(Color.WHITE));
        lbl.add(hai);
        hai.setVisible(false);

        JPanel frame = new JPanel();
        frame.setSize(700,500);
        frame.setLocation(600,250);
        frame.setBorder(new LineBorder(Color.WHITE,2));
        frame.setBackground(new Color(0,0,0,100));
        frame.setLayout(null);
        lbl.add(frame);

//        Content under the pannel

        cardNo = new JLabel("Token Id:");
        cardNo.setForeground(Color.WHITE);
        cardNo.setBounds(140,150,150,30);
        cardNo.setFont(new Font("Algerian",Font.PLAIN,20));
        frame.add(cardNo);

        tCardNo = new JTextField();
        tCardNo.setBounds(300,150,200,30);
        tCardNo.setForeground(Color.WHITE);
        tCardNo.setFont(new Font("System",Font.BOLD,16));
//        tCardNo.setOpaque(false);
        tCardNo.setBackground(Color.BLACK);
        frame.add(tCardNo);
        tCardNo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                tCardNo.setBorder(new LineBorder(Color.white));
                hai.setVisible(false);
                if(!tCardNo.getText().matches("\\d+") && tCardNo.getText().length() > 0)
                {
                    removeLast(tCardNo);

                }

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(!tCardNo.getText().matches("\\d+") && tCardNo.getText().length() > 0)
                {
                    removeLast(tCardNo);

                }

            }
        });


        password = new JLabel("Password:");
        password.setForeground(Color.WHITE);
        password.setBounds(140,220,150,30);
        password.setFont(new Font("Algerian",Font.PLAIN,20));
        frame.add(password);
        tPassword = new JPasswordField();
        tPassword.setBounds(300,220,170,30);
        tPassword.setForeground(Color.WHITE);
        tPassword.setFont(new Font("System",Font.BOLD,16));
        tPassword.setBackground(Color.BLACK);
        frame.add(tPassword);
        tPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                tPassword.setBorder(new LineBorder(Color.WHITE));
                hai.setVisible(false);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        no = new JLabel("Invalid username or password");
        no.setBounds(600+180,760,350,30);
        no.setForeground(Color.red);
        no.setFont(new Font("",Font.BOLD,24));
        lbl.add(no);
        no.setVisible(false);

        ImageIcon eye1 = new ImageIcon(ClassLoader.getSystemResource("images/eyee.png"));
        Image eye2 = eye1.getImage().getScaledInstance(15,10,Image.SCALE_DEFAULT);
        ImageIcon eye3 = new ImageIcon(eye2);

        JButton eye = new JButton(eye3);
        eye.setBounds(470,220,30,30);
        eye.setBackground(new Color(0,0,0,100));
        eye.setBorder(new LineBorder(Color.WHITE,1));
        frame.add(eye);
        final char c = tPassword.getEchoChar();
        eye.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tPassword.getEchoChar() != (char)0){
                    tPassword.setEchoChar((char) 0);
                }
                else
                {
                    tPassword.setEchoChar(c);
                }}
        });

        login = new JButton("Submit");
        login.setForeground(Color.WHITE);
        login.setBounds(150,300,90,30);
        login.setBackground(Color.BLUE);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sToken = tCardNo.getText();
                String sPass = tPassword.getText();
                if(sToken.equals(""))
                {
                    tCardNo.setBorder(new LineBorder(Color.RED));
                    tCardNo.requestFocus();
                }
                else if(sPass.equals(""))
                {
                    tPassword.setBorder(new LineBorder(Color.red));
                    tPassword.requestFocus();
                }
                else{
                    try{
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank","root","Anant@2004");
                        String q = "select * from registration where tokenId = '"+sToken+"' and password = '"+sPass+"'";
                        PreparedStatement smt = c.prepareStatement(q);
                        ResultSet rs = smt.executeQuery();

                        if(!rs.next())
                        {
                            hai.setVisible(true);
                        }
                        else{
                            new EnterPin(rs.getString("accountNo"),rs.getString("name"),rs.getString("mpin"));
                            setVisible(false);
                        }
                    }catch(Exception x)
                    {
                        x.printStackTrace();
                    }
                }
            }
        });

        frame.add(login);
        register = new JButton("Register");
        register.setForeground(Color.WHITE);
        register.setBounds(250,300,90,30);
        register.setBackground(Color.BLUE);
        frame.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registrstion1();
                setVisible(false);
            }
        });

        forget = new JLabel("Forget Token/Password?");
        forget.setForeground(Color.ORANGE);
        forget.setBounds(150,280,200,20);
        forget.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(forget);
        forget.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {


            }

            @Override
            public void mouseEntered(MouseEvent e) {


            }

            @Override
            public void mouseExited(MouseEvent e) {


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
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(war);
        war.setVisible(false);

        tCardNo.setCaretColor(Color.white);
        tPassword.setCaretColor(Color.white);

        notFound = new JLabel("Invalid token or password");
//        notFound.setBounds(200,760,300,30);
        notFound.setFont(new Font("system",Font.BOLD,20));
        notFound.setForeground(Color.RED);
        hai.add(notFound);
//        notFound.setVisible(false);


        setVisible(true);
    }
    public static void main(String [] args)
    {
        new Login();
    }
}
