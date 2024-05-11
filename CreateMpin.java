import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CreateMpin extends JFrame implements ActionListener{

    JLabel heading,notMatched;
    JTextField tcreate,tconfirm;
    JButton btnCreate , back;
    String acc,nameH;
    void removeLast(JTextField p)
    {
        String pass= p.getText();
        int t = pass.length()-1;
        p.setText(pass.substring(0,t));

    }
    CreateMpin(String acc , String nameH)
    {
        this.nameH = nameH;
        this.acc = acc;
        // The main logo for Banking app
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("images/logoBank.png"));
        Image l2 = l1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel logo = new JLabel(l3);
        logo.setBounds(790,50,120,150);
        add(logo);

        //text after the main logo
        JLabel logoText = new JLabel("Banker");
        logoText.setBounds(913,100,200,30);
        logoText.setFont(new Font("Bodoni MT black",Font.BOLD,30));
        add(logoText);
        //second text for the main logo
        JLabel logoText2 = new JLabel("Banking basic application");
        logoText2.setBounds(916,120,250,30);
        logoText2.setFont(new Font("Agency FB",Font.PLAIN,20));
        add(logoText2);

        //creating the dimension for getting screen size
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
        frame.setBackground(new Color(0,0,0,100));
        frame.setLayout(null);
        lbl.add(frame);

        JTextField a = new JTextField();
        a.setBounds(0,0,1,1);
        frame.add(a);

        //creatina labels
        heading = new JLabel("Create 6 digits MPIN");
        heading.setFont(new Font("system",Font.BOLD,20));
        heading.setForeground(Color.WHITE);
        heading.setBounds(235,100,250,30);
        frame.add(heading);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tcreate.getText().equals("") && !tcreate.hasFocus())
                {
                    tcreate.setText("Enter MPIN");
                    tcreate.setForeground(Color.GRAY);

                }
                if(tconfirm.getText().equals("") && !tconfirm.hasFocus())
                {
                    tconfirm.setText("Enter MPIN");
                    tconfirm.setForeground(Color.GRAY);
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

        tcreate = new JTextField("Create MPIN");
        tcreate.setFont(new Font("ITALIC",Font.BOLD,16));
        tcreate.setForeground(Color.GRAY);
        tcreate.setBackground(Color.BLACK);
        tcreate.setBounds(235,170,200,40);
        tcreate.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(tcreate);
        tcreate.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!tcreate.getText().matches("\\d+"))
                {
                    tcreate.setText("");
                    tcreate.setForeground(Color.ORANGE);


                }
                if(tconfirm.getText().equals("") && !tconfirm.hasFocus())
                {
                    tconfirm.setText("Enter MPIN");
                    tconfirm.setForeground(Color.GRAY);

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
                String temp = "";
                tcreate.setBorder(new LineBorder(Color.WHITE));
                tconfirm.setBorder(new LineBorder(Color.WHITE));
                notMatched.setVisible(false);
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
                    while (!tcreate.getText().matches("\\d+")) {
                        removeLast(tcreate);
                    }

                    while (tcreate.getText().length() > 6) {
                        removeLast(tcreate);
                    }
                }
                else if(tcreate.getText().length() >= 6)
                    {
                        tconfirm.requestFocus();
                        if(!tconfirm.getText().matches("\\d+")){
                            tconfirm.setText("");
                            tconfirm.setForeground(Color.ORANGE);
                        }
                    }


            }
        });
        tconfirm = new JTextField("Confirm MPIN");
        tconfirm.setFont(new Font("ITALIC",Font.BOLD,16));
        tconfirm.setForeground(Color.GRAY);
        tconfirm.setBackground(Color.BLACK);
        tconfirm.setBounds(235,240,200,40);
        tconfirm.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(tconfirm);
        tconfirm.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!tconfirm.getText().matches("\\d+"))
                {
                    tconfirm.setText("");
                    tconfirm.setForeground(Color.ORANGE);


                }
                if(tcreate.getText().equals("") && !tcreate.hasFocus())
                {
                    tcreate.setText("Enter MPIN");
                    tcreate.setForeground(Color.GRAY);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(tconfirm.getText().equals(""))
                {
                    tconfirm.setText("Enter MPIN");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        tconfirm.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String temp = "";
                tcreate.setBorder(new LineBorder(Color.WHITE));
                tconfirm.setBorder(new LineBorder(Color.WHITE));
                notMatched.setVisible(false);
                if((!tconfirm.getText().matches("\\d+") && tconfirm.getText().length() > 0))
                {
                    removeLast(tconfirm);

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(!tconfirm.getText().matches("\\d+") || tconfirm.getText().length() > 6)
                {
                    while(!tconfirm.getText().matches("\\d+"))
                    {
                        removeLast(tconfirm);
                    }
                    while(tconfirm.getText().length() > 6)
                    {
                        removeLast(tconfirm);
                    }

                }
            }
        });
        notMatched = new JLabel("The create and confirm field does not matched");
        notMatched.setForeground(Color.red);
        notMatched.setBounds(750,760,400,20);
        notMatched.setFont(new Font("system",Font.BOLD,16));
        lbl.add(notMatched);
        notMatched.setVisible(false);


        back = new JButton("Back");
        back.setBounds(240,310,90,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        frame.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
        btnCreate = new JButton("Create");
        btnCreate.setBounds(340,310,90,30);
        btnCreate.setBackground(Color.BLUE);
        btnCreate.setForeground(Color.WHITE);
        frame.add(btnCreate);
        btnCreate.addActionListener(this);


        ImageIcon eye1 = new ImageIcon(ClassLoader.getSystemResource("images/eyee.png"));
        Image eye2 = eye1.getImage().getScaledInstance(15,10,Image.SCALE_DEFAULT);
        ImageIcon eye3 = new ImageIcon(eye2);

        JLabel alert = new JLabel("By choosing to login, you agree and accept all the appicable");
        alert.setBounds(170,460,400,15);
        alert.setForeground(Color.WHITE);
        frame.add(alert);
        JLabel alert1 = new JLabel("Terms and Condition, privacy and Policy");
        alert1.setBounds(220,470,400,20);
        alert1.setForeground(Color.WHITE);
        frame.add(alert1);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String sCreate = tcreate.getText();
        String sConfirm = tconfirm.getText();

        if(sCreate.isEmpty() || !sCreate.matches("\\d+"))
        {
            tcreate.setBorder(new LineBorder(Color.red));
        }
        else if(sCreate.length() < 6 )
        {
            tcreate.setBorder(new LineBorder(Color.red));

        }
        else if(sConfirm.isEmpty() || !sConfirm.matches("\\d+"))
        {
            tconfirm.setBorder(new LineBorder(Color.red));
        }
        else if(sConfirm.length() < 6 )
        {
            tconfirm.setBorder(new LineBorder(Color.red));

        }
        else if(!sCreate.equals(sConfirm))
        {
            notMatched.setVisible(true);
        }
        else
        {
            try
            {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "Anant@2004");
                String q = "update registration set mpin = '"+sCreate+"'  where accountNo = '"+acc+"' ";
                PreparedStatement smt = c.prepareStatement(q);
                smt.executeUpdate();
                new MainPage(acc,nameH);
                setVisible(false);
            }
            catch(Exception x)
            {
                x.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new CreateMpin("6400520604","jha anant dinesh");
    }
}
