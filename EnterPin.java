import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.nio.channels.ScatteringByteChannel;

public class EnterPin extends JFrame {
    JPasswordField tcreate;
    JButton back;
    void removeLast(JTextField p)
    {
        String pass= p.getText();
        int t = pass.length()-1;
        p.setText(pass.substring(0,t));

    }
    EnterPin(String acc , String nameH,String pinSahiHai)
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

        JPanel enterPin = new JPanel();
        enterPin.setBounds(700,320,500,320);
        enterPin.setBackground(new Color(0,0,0,120));
        enterPin.setBorder(new LineBorder(Color.WHITE));
        enterPin.setLayout(null);
        lbl.add(enterPin);
//        enterPin.setVisible(false);

        ImageIcon p1 = new ImageIcon(ClassLoader.getSystemResource("images/potoHai.jpg"));
        Image p2 = p1.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon p3 = new ImageIcon(p2);

        JLabel l = new JLabel(p3);
        l.setBounds(20,30,100,100);
        l.setBorder(new LineBorder(Color.ORANGE,2));
        enterPin.add(l);


        JLabel name = new JLabel();
        name.setBounds(60+90,30,300,30);
        name.setText(nameH.toUpperCase());
        name.setForeground(Color.white);
        name.setFont(new Font("Algerian",Font.PLAIN,25));
        enterPin.add(name);
        JLabel accountN = new JLabel("Account - "+acc);
        accountN.setBounds(60+90,60,300,30);
        accountN.setForeground(Color.white);
        accountN.setFont(new Font("",Font.BOLD,25));
        enterPin.add(accountN);

        JLabel lblPin = new JLabel(" Enter your transaction PIN to proceed");
        lblPin.setBounds(90+10+10,140+10,300,30);
        lblPin.setForeground(Color.ORANGE);
        lblPin.setFont(new Font("system",Font.PLAIN,16));
        enterPin.add(lblPin);

        tcreate = new JPasswordField();
        tcreate.setFont(new Font("ITALIC",Font.BOLD,20));
        tcreate.setForeground(Color.GRAY);
        tcreate.setBackground(Color.BLACK);
        tcreate.setBounds(40,200,420,40);
        tcreate.setHorizontalAlignment(SwingConstants.CENTER);
        enterPin.add(tcreate);
        tcreate.setCaretColor(Color.white);
        tcreate.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!tcreate.getText().matches("\\d+"))
                {
                    tcreate.setText("");
                    tcreate.setForeground(Color.ORANGE);


                }

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
        tcreate.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                tcreate.setForeground(Color.ORANGE);
                tcreate.setBorder(new LineBorder(Color.white));

                String temp = "";
                if((!tcreate.getText().matches("\\d+") && tcreate.getText().length() > 0))
                {
                    removeLast(tcreate);

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(((!tcreate.getText().matches("\\d+") && tcreate.getText().length() > 0)) || tcreate.getText().length() > 6) {
                    while (!tcreate.getText().matches("\\d+") && tcreate.getText().length() > 0) {
                        removeLast(tcreate);
                    }

                    while (tcreate.getText().length() > 6) {
                        removeLast(tcreate);
                    }
                }
                else if(tcreate.getText().length() == 6)
                {
                    if(pinSahiHai.equals(tcreate.getText()))
                    {
                        new MainPage(acc,nameH);
                        setVisible(false);
                    }
                    else{
                        tcreate.setBorder(new LineBorder(Color.red));
                    }
                }


            }
        });
        back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setBounds(200,120+20+90+30,100,30);
        enterPin.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                setVisible(false);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new EnterPin("74364244242","jha anant dinesh","123456");
    }
}
