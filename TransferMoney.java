import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class TransferMoney extends JFrame implements KeyListener {
    JLabel dashboardI, changeMp, changePass, account, contactUs, logout, warL, lFrom, lamount,warF,warF2, lamountHai,notSame,lconfirm,laccNumber
            ,warF11,warF211,warL11;
    JTextField tFrom, tamount;
    JPanel transfer,receiverDetails,information,enterPin,message,payAccount,ammt;
    String pinSahi, totalAmt ,accN,nameHN;
    JButton next;


    void payViaAccount(boolean var)
    {
        JPanel message2 = new JPanel();
        message2.setBackground(new Color(60,60,60));
        message2.setBounds(350+200+350,350+100,400,200);
        message2.setLayout(null);
        add(message2);

        JMenuBar b2 = new JMenuBar();
        b2.setBounds(0,0,400,40);
        b2.setBackground(Color.BLACK);
        b2.setLayout(null);
        message2.add(b2);

        JLabel t2 = new JLabel("Transaction");
        t2.setForeground(new Color(200,200,255));
        t2.setFont(new Font("system",Font.BOLD,20));
        t2.setBounds(20,3,300,30);
        b2.add(t2);

        JLabel messL2 = new JLabel("Unsuccesfull, Insufficient Balance");
        messL2.setForeground(Color.white);
        messL2.setFont(new Font("system",Font.BOLD,17));
        messL2.setBounds(65,60,300,30);
        message2.add(messL2);

        JButton ok2 = new JButton("OK");
        ok2.setBackground(Color.BLUE);
        ok2.setForeground(Color.white);
        ok2.setFont(new Font("system",Font.BOLD,15));
        ok2.setBounds(55,130,300,40);
        message2.add(ok2);
        message2.setVisible(false);

        payAccount = new JPanel();
        payAccount.setLayout(null);
        payAccount.setBounds(350 + 350, 340 + 60 + 20, 800, 300);
        payAccount.setBackground(Color.GRAY);
        add(payAccount);
        payAccount.setVisible(var);

        JLabel transferLbl = new JLabel("Account Details");
        transferLbl.setBounds(10, 20, 200, 30);
        transferLbl.setFont(new Font("system", Font.BOLD, 22));
        transferLbl.setForeground(Color.white);
        payAccount.add(transferLbl);

        JLabel from = new JLabel("Account Number");
        from.setBounds(50, 80, 200, 15);
        from.setFont(new Font("system", Font.BOLD, 15));
        payAccount.add(from);

        JTextField accNumber = new JTextField();
        accNumber.setBounds(50, 110 - 10, 700, 40);
        accNumber.setBackground(Color.gray);
        accNumber.setForeground(Color.WHITE);
        accNumber.setBorder(new LineBorder(Color.GRAY, 1, true));
        accNumber.setFont(new Font("system", Font.BOLD, 18));
        accNumber.setCaretColor(Color.white);
        payAccount.add(accNumber);
        laccNumber = new JLabel("__________________________________________________________________________________________________");
        laccNumber.setForeground(Color.black);
        laccNumber.setBounds(50, 140 - 10, 700, 20);
        payAccount.add(laccNumber);
        accNumber.addKeyListener(this);


        warF11 = new JLabel("No account is associated with this Number");
        warF11.setBounds(50, 153, 500, 10);
        warF11.setForeground(Color.red);
        payAccount.add(warF11);
        warF11.setVisible(false);
        warF211 = new JLabel("Enter valid Account  Number");
        warF211.setBounds(50, 153, 500, 10);
        warF211.setForeground(Color.red);
        payAccount.add(warF211);
        warF211.setVisible(false);

        JLabel confirm = new JLabel("Confirm account");
        confirm.setBounds(50, 80+100, 200, 15);
        confirm.setFont(new Font("system", Font.BOLD, 15));
        payAccount.add(confirm);


        JTextField tconfirm = new JTextField();
        tconfirm.setBounds(50, 110 - 10 + 100, 700, 40);
        tconfirm.setBackground(Color.gray);
        tconfirm.setForeground(Color.WHITE);
        tconfirm.setBorder(new LineBorder(Color.GRAY, 1, true));
        tconfirm.setFont(new Font("system", Font.BOLD, 18));
        tconfirm.setCaretColor(Color.white);
        payAccount.add(tconfirm);
        lconfirm = new JLabel("__________________________________________________________________________________________________");
        lconfirm.setForeground(Color.black);
        lconfirm.setBounds(50, 140 - 10+100, 700, 20);
        payAccount.add(lconfirm);
        notSame =new  JLabel("Confirm account number doesn't match");
        notSame.setBounds(50, 153+100, 500, 10);
        notSame.setForeground(Color.red);
        payAccount.add(notSame);
        notSame.setVisible(false);
        tconfirm.addKeyListener(this);


        ammt = new JPanel();
        ammt.setBounds(350 + 350, 340 + 60 + 20+330, 800, 200);
        ammt.setBackground(Color.GRAY);
        ammt.setLayout(null);
        add(ammt);
        ammt.setVisible(var);
        JLabel amountHai = new JLabel("Amount");
        amountHai.setBounds(50, 80-50, 200, 15);
        amountHai.setFont(new Font("system", Font.BOLD, 15));
        ammt.add(amountHai);

        JTextField tamountHai = new JTextField();
        tamountHai.setBounds(50, 110 - 10 -50, 700, 40);
        tamountHai.setBackground(Color.gray);
        tamountHai.setForeground(Color.WHITE);
        tamountHai.setBorder(new LineBorder(Color.GRAY, 1, true));
        tamountHai.setFont(new Font("system", Font.BOLD, 18));
        tamountHai.setCaretColor(Color.white);
        tamountHai.addKeyListener(this);
        ammt.add(tamountHai);
        lamountHai = new JLabel("__________________________________________________________________________________________________");
        lamountHai.setForeground(Color.black);
        lamountHai.setBounds(50, 140 - 10-50, 700, 20);
        ammt.add(lamountHai);

        warL11 = new JLabel("Enter valid Amount");
        warL11.setBounds(50, 153-50, 200, 10);
        warL11.setForeground(Color.red);
        ammt.add(warL11);
        warL11.setVisible(false);

        JButton vianext = new JButton("Next");
        vianext.setBounds(580, 140 - 10-50+60, 150, 30);
        vianext.setForeground(Color.WHITE);
        vianext.setBackground(Color.BLUE);
        ammt.add(vianext);
        ok2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamountHai.setEnabled(true);
                accNumber.setEnabled(true);
                vianext.setEnabled(true);
                message2.setVisible(false);
            }
        });

        vianext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sAccountNumber = accNumber.getText();
                String sCAN = tconfirm.getText();
                String sAmmt = tamountHai.getText();

                if (sAccountNumber.isEmpty()) {
                    laccNumber.setForeground(Color.RED);
                    accNumber.requestFocus();
                } else if (!sAccountNumber.matches("\\d+")) {
                    warF211.setText("Enter valid Number");
                    warF211.setVisible(true);
                } else if (sCAN.isEmpty()) {
                    lconfirm.setForeground(Color.red);
                    tconfirm.requestFocus();
                } else if (!sCAN.equals(sAccountNumber)) {
                    notSame.setVisible(true);
                } else if (sAmmt.isEmpty()) {
                    lamountHai.setForeground(Color.RED);
                    tamountHai.requestFocus();
                } else if (!sAmmt.matches("\\d+")) {
                    warL11.setVisible(true);
                } else if (Integer.parseInt(totalAmt) < Integer.parseInt(sAmmt)) {
                    vianext.setEnabled(false);
                    tamountHai.setEnabled(false);
                    accNumber.setEnabled(false);
                    message2.setVisible(true);
                } else {
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "Anant@2004");
                        String q = "select * from registration where accountNo = '" + sAccountNumber + "'";
                        PreparedStatement smt = c.prepareStatement(q);
                        ResultSet rs = smt.executeQuery();
                        if (!rs.next()) {
                            warF11.setVisible(true);
                        } else if (accN.equals(rs.getString("accountNo"))) {
                            warF211.setText("Enter receiver's account number");
                            warF211.setVisible(true);
                        }
                        else{
                            payAccount.setVisible(false);
                            ammt.setVisible(false);
                            receiverDetail(rs.getString("name"),rs.getString("accountNo"),sAmmt,accN,nameHN);
                        }


                    } catch (Exception x) {
                        x.printStackTrace();
                    }
                }
            }
        });

    }
    void removeLast(JTextField p)
    {
        String pass= p.getText();
        int t = pass.length()-1;
        p.setText(pass.substring(0,t));

    }
    public void enterPin(PreparedStatement s1 , PreparedStatement s2)
    {

        enterPin = new JPanel();
        enterPin.setBounds(850,300,500,320);
        enterPin.setBackground(Color.DARK_GRAY);
        enterPin.setLayout(null);
        add(enterPin);
        enterPin.setVisible(true);

        ImageIcon p1 = new ImageIcon(ClassLoader.getSystemResource("images/potoHai.jpg"));
        Image p2 = p1.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon p3 = new ImageIcon(p2);

        JLabel l = new JLabel(p3);
        l.setBounds(20,30,100,100);
        l.setBorder(new LineBorder(Color.ORANGE,2));
        enterPin.add(l);


        JLabel name = new JLabel();
        name.setBounds(60+90,30,300,30);
        name.setText("jha anant dinesh".toUpperCase());
        name.setForeground(Color.white);
        name.setFont(new Font("Algerian",Font.PLAIN,25));
        enterPin.add(name);
        JLabel accountN = new JLabel("Account - 03987367633");
        accountN.setBounds(60+90,60,300,30);
        accountN.setForeground(Color.white);
        accountN.setFont(new Font("",Font.BOLD,25));
        enterPin.add(accountN);

        JLabel lbl = new JLabel("Pin is Required for accessing this Feature");
        lbl.setBounds(90+10,140+10,300,30);
        lbl.setForeground(Color.ORANGE);
        lbl.setFont(new Font("system",Font.PLAIN,16));
        enterPin.add(lbl);

        JPasswordField tcreate = new JPasswordField();
        tcreate.setFont(new Font("ITALIC",Font.BOLD,20));
        tcreate.setForeground(Color.GRAY);
        tcreate.setBackground(Color.BLACK);
        tcreate.setBounds(40,200,420,40);
        tcreate.setHorizontalAlignment(SwingConstants.CENTER);
        tcreate.setCaretColor(Color.white);
        enterPin.add(tcreate);
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
                    String sAmount = tamount.getText();
                    if(pinSahi.equals(tcreate.getText()))
                    {
                       try
                       {
                           s1.executeUpdate();
                           s2.executeUpdate();
                           enterPin.setVisible(false);
                           information.setVisible(true);
                           receiverDetails.setVisible(true);
                           message.setVisible(true);



                       }catch(Exception x)
                       {
                           x.printStackTrace();
                       }
                    }
                    else{

                        tcreate.setBorder(new LineBorder(Color.red));

                    }

                }
            }
        });
    }
    public void receiverDetail(String name,String acc,String amt ,String secondAcc,String fromName)
    {
        receiverDetails = new JPanel();
        receiverDetails.setLayout(null);
        receiverDetails.setBounds(350 + 350, 340 + 60 + 60, 800, 400);
        receiverDetails.setBackground(Color.GRAY);
        add(receiverDetails);

        JLabel receiverDetailsLbl = new JLabel("Receiver Details");
        receiverDetailsLbl.setBounds(10, 20, 200, 30);
        receiverDetailsLbl.setFont(new Font("system", Font.BOLD, 22));
        receiverDetailsLbl.setForeground(Color.white);
        receiverDetails.add(receiverDetailsLbl);

        JLabel to = new JLabel("Receiver name");
        to.setBounds(50, 80, 200, 15);
        to.setFont(new Font("system", Font.BOLD, 15));
        receiverDetails.add(to);

        JTextField tTo = new JTextField(name.toUpperCase());
        tTo.setBounds(50, 110 - 10, 700, 40);
        tTo.setBackground(Color.gray);
        tTo.setForeground(Color.WHITE);
        tTo.setBorder(new LineBorder(Color.GRAY, 1, true));
        tTo.setFont(new Font("system", Font.BOLD, 18));
        tTo.setCaretColor(Color.white);
        tTo.setEnabled(false);
        receiverDetails.add(tTo);
        JLabel lTo = new JLabel("__________________________________________________________________________________________________");
        lTo.setForeground(Color.black);
        lTo.setBounds(50, 140 - 10, 700, 20);
        receiverDetails.add(lTo);

        JLabel accountN = new JLabel("Account Number");
        accountN.setBounds(50, 180, 200, 15);
        accountN.setFont(new Font("system", Font.BOLD, 15));
        receiverDetails.add(accountN);

        JTextField tAccountN = new JTextField(acc.charAt(0)+acc.charAt(1)+"xxxxx"+acc.substring(7));
        tAccountN.setBounds(50, 210 - 10, 700, 40);
        tAccountN.setBackground(Color.gray);
        tAccountN.setForeground(Color.WHITE);
        tAccountN.setBorder(new LineBorder(Color.GRAY, 1, true));
        tAccountN.setFont(new Font("system", Font.BOLD, 18));
        tAccountN.setCaretColor(Color.white);
        tAccountN.setEnabled(false);
        receiverDetails.add(tAccountN);
        JLabel lAccountN = new JLabel("__________________________________________________________________________________________________");
        lAccountN.setForeground(Color.black);
        lAccountN.setBounds(50, 240 - 10, 700, 20);
        receiverDetails.add(lAccountN);

        JButton confirm = new JButton("Confirm");
        confirm.setBounds(580, 300, 150, 30);
        confirm.setForeground(Color.WHITE);
        confirm.setBackground(Color.BLUE);
        receiverDetails.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sAccount  = acc;
                try
                {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank","root","Anant@2004");
                    String q1 = "insert into transaction values('"+acc+"','"+LocalDate.now()+"','"+LocalTime.now()+"','"+amt+"','receive','"+fromName+"')";
                    String q2 = "insert into transaction values('"+secondAcc+"','"+LocalDate.now()+"','"+LocalTime.now()+"','"+amt+"','paid','"+name+"')";

                    PreparedStatement smt1 = c.prepareStatement(q1);
                    PreparedStatement smt2 = c.prepareStatement(q2);

                    transfer.setVisible(false);
                    information.setVisible(false);
                    receiverDetails.setVisible(false);
                    enterPin(smt1,smt2);


                }
                catch(Exception x)
                {
                    x.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(580-170, 300, 150, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLUE);
        receiverDetails.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receiverDetails.setVisible(false);
                transfer.setVisible(true);
            }
        });
    }

    TransferMoney(String acc, String nameH,String pinSahiWala,String totalBalance) {

        pinSahi =pinSahiWala;
        totalAmt = totalBalance;
        nameHN = nameH;
        accN = acc;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.BLUE);
        menu.setBounds(0, 0, d.width, 60);
        menu.setLayout(null);
        add(menu);

        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("images/logoBank.png"));
        Image l2 = l1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel logo = new JLabel(l3);
        logo.setBounds(30, 5, 50, 50);
        menu.add(logo);
        JLabel logoText = new JLabel("Banker");
        logoText.setBounds(81, 17, 100, 15);
        logoText.setForeground(Color.WHITE);
        logoText.setFont(new Font("Bodoni MT black", Font.BOLD, 16));
        menu.add(logoText);

        JLabel logoText2 = new JLabel("Banking basic application");
        logoText2.setBounds(82, 30, 100, 13);
        logoText2.setForeground(Color.white);
        logoText2.setFont(new Font("Agency FB", Font.PLAIN, 13));
        menu.add(logoText2);

        message = new JPanel();
        message.setBackground(new Color(60,60,60));
        message.setBounds(350+200+350,350,400,200);
//        message.setBorder(new LineBorder(Color.BLACK,4,true));
        message.setLayout(null);
        add(message);

        JMenuBar b = new JMenuBar();
        b.setBounds(0,0,400,40);
        b.setBackground(Color.BLACK);
        b.setLayout(null);
        message.add(b);

        JLabel t = new JLabel("Transaction");
        t.setForeground(new Color(200,200,255));
        t.setFont(new Font("system",Font.BOLD,20));
        t.setBounds(20,3,300,30);
        b.add(t);

        JLabel messL = new JLabel("The Transaction was successful");
        messL.setForeground(Color.white);
        messL.setFont(new Font("system",Font.BOLD,17));
        messL.setBounds(65,60,300,30);
        message.add(messL);

        JButton ok = new JButton("OK");
        ok.setBackground(Color.BLUE);
        ok.setForeground(Color.white);
        ok.setFont(new Font("system",Font.BOLD,15));
        ok.setBounds(55,130,300,40);
        message.add(ok);
        message.setVisible(false);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.setVisible(false);
                new MainPage(accN,nameHN);
                setVisible(false);
            }
        });

        JPanel message2 = new JPanel();
        message2.setBackground(new Color(60,60,60));
        message2.setBounds(350+200+350,350,400,200);
        message2.setLayout(null);
        add(message2);

        JMenuBar b2 = new JMenuBar();
        b2.setBounds(0,0,400,40);
        b2.setBackground(Color.BLACK);
        b2.setLayout(null);
        message2.add(b2);

        JLabel t2 = new JLabel("Transaction");
        t2.setForeground(new Color(200,200,255));
        t2.setFont(new Font("system",Font.BOLD,20));
        t2.setBounds(20,3,300,30);
        b2.add(t2);

        JLabel messL2 = new JLabel("Unsuccesfull, Insufficient Balance");
        messL2.setForeground(Color.white);
        messL2.setFont(new Font("system",Font.BOLD,17));
        messL2.setBounds(65,60,300,30);
        message2.add(messL2);

        JButton ok2 = new JButton("OK");
        ok2.setBackground(Color.BLUE);
        ok2.setForeground(Color.white);
        ok2.setFont(new Font("system",Font.BOLD,15));
        ok2.setBounds(55,130,300,40);
        message2.add(ok2);
        message2.setVisible(false);
        ok2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamount.setEnabled(true);
                tFrom.setEnabled(true);
                next.setEnabled(true);
                message2.setVisible(false);
            }
        });

        JPanel frame = new JPanel();
        frame.setBounds(0, 60, 350, d.height - 60);
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        add(frame);

        ImageIcon dashI = new ImageIcon(ClassLoader.getSystemResource("images/dashboardLogo.jpg"));
        Image dashI2 = dashI.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon dashI3 = new ImageIcon(dashI2);


        dashboardI = new JLabel("Dashboard", dashI3, JLabel.LEFT);
        dashboardI.setBounds(40, 13, 250, 40);
        dashboardI.setFont(new Font("Rale-way", Font.BOLD, 20));
        dashboardI.setBorder(new LineBorder(Color.white));
        dashboardI.setBackground(Color.BLUE);
        frame.add(dashboardI);

        account = new JLabel("Profile", dashI3, JLabel.LEFT);
        account.setBounds(40, 70, 250, 40);
        account.setFont(new Font("Rale-way", Font.BOLD, 20));
        account.setBorder(new LineBorder(Color.white));
        account.setBackground(Color.BLUE);
        frame.add(account);

        changeMp = new JLabel("Change MPIN", dashI3, JLabel.LEFT);
        changeMp.setBounds(40, 125, 250, 40);
        changeMp.setFont(new Font("Rale-way", Font.BOLD, 20));
        changeMp.setBorder(new LineBorder(Color.white));
        changeMp.setBackground(Color.BLUE);
        frame.add(changeMp);

        contactUs = new JLabel("Contact us", dashI3, JLabel.LEFT);
        contactUs.setBounds(40, 180, 250, 40);
        contactUs.setFont(new Font("Rale-way", Font.BOLD, 20));
        contactUs.setBorder(new LineBorder(Color.white));
        contactUs.setBackground(Color.BLUE);
        frame.add(contactUs);

        changePass = new JLabel("Change password", dashI3, JLabel.LEFT);
        changePass.setBounds(40, 235, 250, 40);
        changePass.setFont(new Font("Rale-way", Font.BOLD, 20));
        changePass.setBorder(new LineBorder(Color.white));
        changePass.setBackground(Color.BLUE);
        frame.add(changePass);

        logout = new JLabel("Logout", JLabel.CENTER);
        logout.setBounds(25, 850, 300, 40);
        logout.setFont(new Font("Rale-way", Font.BOLD, 20));
        logout.setBorder(new LineBorder(Color.white));
        logout.setBackground(Color.BLUE);
        logout.setOpaque(true);
        logout.setBackground(new Color(200, 240, 255, 120));
        frame.add(logout);

        JButton payViaToken = new JButton("Pay via mobile number");
        payViaToken.setBounds(350 + 450, 60 + 30, 300, 40);
        payViaToken.setBackground(Color.BLUE);
        payViaToken.setForeground(Color.white);
        payViaToken.setFont(new Font("system", Font.BOLD, 16));
        add(payViaToken);
        payViaToken.setEnabled(false);


        JButton payViaAccount = new JButton("Pay via Account number");
        payViaAccount.setBounds(350 + 450 + 300, 60 + 30, 300, 40);
        payViaAccount.setBackground(Color.GRAY);
        payViaAccount.setForeground(Color.white);
        payViaAccount.setFont(new Font("system", Font.BOLD, 16));
        add(payViaAccount);

        payViaAccount(false);

        information = new JPanel();
        information.setLayout(null);
        information.setBounds(350 + 350, 60 + 60 + 30, 800, 250);
        information.setBackground(Color.GRAY);
        add(information);
        {
            ImageIcon l1Chota = new ImageIcon(ClassLoader.getSystemResource("images/logoBank.png"));
            Image l2Chota = l1Chota.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
            ImageIcon l3Chota = new ImageIcon(l2Chota);
            JLabel logoChota = new JLabel(l3Chota);
            logoChota.setBounds(100, 30, 120, 150);
            information.add(logoChota);

            JLabel receiverLbl = new JLabel("From");
            receiverLbl.setBackground(Color.BLACK);
            receiverLbl.setBounds(300, 80 - 10, 100, 10);
            receiverLbl.setFont(new Font("system", Font.BOLD, 13));
            information.add(receiverLbl);

            JLabel receiverName = new JLabel(nameH.toUpperCase());
            receiverName.setForeground(Color.white);
            receiverName.setBounds(300, 92 - 10, 250, 30);
            receiverName.setFont(new Font("system", Font.BOLD, 20));
            information.add(receiverName);

            JLabel accountLbl = new JLabel("Account Number");
            accountLbl.setBackground(Color.BLACK);
            accountLbl.setBounds(300, 160 - 10, 150, 10);
            accountLbl.setFont(new Font("system", Font.BOLD, 13));
            information.add(accountLbl);

            JLabel accountNum = new JLabel("SAVING-" + acc);
            accountNum.setForeground(Color.white);
            accountNum.setBounds(300, 172 - 10, 250, 30);
            accountNum.setFont(new Font("system", Font.BOLD, 20));
            information.add(accountNum);

        }

        transfer = new JPanel();
        transfer.setLayout(null);
        transfer.setBounds(350 + 350, 340 + 60 + 30, 800, 400);
        transfer.setBackground(Color.GRAY);
        add(transfer);

        JLabel transferLbl = new JLabel("Transfer Details");
        transferLbl.setBounds(10, 20, 200, 30);
        transferLbl.setFont(new Font("system", Font.BOLD, 22));
        transferLbl.setForeground(Color.white);
        transfer.add(transferLbl);

        JLabel from = new JLabel("Mobile number");
        from.setBounds(50, 80, 200, 15);
        from.setFont(new Font("system", Font.BOLD, 15));
        transfer.add(from);

        tFrom = new JTextField();
        tFrom.setBounds(50, 110 - 10, 700, 40);
        tFrom.setBackground(Color.gray);
        tFrom.setForeground(Color.WHITE);
        tFrom.setBorder(new LineBorder(Color.GRAY, 1, true));
        tFrom.setFont(new Font("system", Font.BOLD, 18));
        tFrom.setCaretColor(Color.white);
        transfer.add(tFrom);
        lFrom = new JLabel("__________________________________________________________________________________________________");
        lFrom.setForeground(Color.black);
        lFrom.setBounds(50, 140 - 10, 700, 20);
        transfer.add(lFrom);

        warF = new JLabel("No account is associated with this Number");
        warF.setBounds(50, 153, 500, 10);
        warF.setForeground(Color.red);
        transfer.add(warF);
        warF.setVisible(false);
        warF2 = new JLabel("Enter valid Mobile Number");
        warF2.setBounds(50, 153, 500, 10);
        warF2.setForeground(Color.red);
        transfer.add(warF2);
        warF2.setVisible(false);

        JLabel amount = new JLabel("Amount");
        amount.setBounds(50, 180, 200, 15);
        amount.setFont(new Font("system", Font.BOLD, 15));
        transfer.add(amount);

        tamount = new JTextField();
        tamount.setBounds(50, 210 - 10, 700, 40);
        tamount.setBackground(Color.gray);
        tamount.setForeground(Color.WHITE);
        tamount.setBorder(new LineBorder(Color.GRAY, 1, true));
        tamount.setFont(new Font("system", Font.BOLD, 18));
        tamount.setCaretColor(Color.white);
        transfer.add(tamount);
        lamount = new JLabel("__________________________________________________________________________________________________");
        lamount.setForeground(Color.black);
        lamount.setBounds(50, 240 - 10, 700, 20);
        transfer.add(lamount);
        warL = new JLabel("Enter valid Amount");
        warL.setBounds(50, 253, 200, 10);
        warL.setForeground(Color.red);
        transfer.add(warL);
        warL.setVisible(false);

        next = new JButton("Next");
        next.setBounds(580, 300, 150, 30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLUE);
        transfer.add(next);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sToken = tFrom.getText();
                String sAmt = tamount.getText();

                if (sToken.isEmpty()) {
                    lFrom.setForeground(Color.RED);
                    tFrom.requestFocus();
                } else if (!sToken.matches("\\d+")) {
                    warF2.setText("Enter valid Number");
                    warF2.setVisible(true);
                } else if (sAmt.isEmpty()) {
                    lamount.setForeground(Color.RED);
                    tamount.requestFocus();
                } else if (!sAmt.matches("\\d+")) {

                    warL.setVisible(true);
                } else if (Integer.parseInt(totalAmt) < Integer.parseInt(sAmt)) {
                    next.setEnabled(false);
                    tamount.setEnabled(false);
                    tFrom.setEnabled(false);
                    message2.setVisible(true);
                } else {
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "Anant@2004");
                        String q = "select * from registration where phoneNo = '" + sToken + "'";
                        PreparedStatement smt = c.prepareStatement(q);
                        ResultSet rs = smt.executeQuery();
                        if (!rs.next()) {
                            warF.setVisible(true);
                        } else if (acc.equals(rs.getString("accountNo"))) {
                            warF2.setText("Enter receiver's Mobile number");
                            warF2.setVisible(true);
                        }
                        else{
                            transfer.setVisible(false);
                            receiverDetail(rs.getString("name"),rs.getString("accountNo"),sAmt,acc,nameH);
                        }


                    } catch (Exception x) {
                        x.printStackTrace();
                    }
                }
            }
        });
        payViaToken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payViaToken.setEnabled(false);
                payViaToken.setBackground(Color.BLUE);
                payViaAccount.setBackground(Color.gray);
                payViaAccount.setEnabled(true);
                transfer.setVisible(true);
                payAccount.setVisible(false);
                ammt.setVisible(false);
            }
        });
        payViaAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payViaAccount.setEnabled(false);
                payViaAccount.setBackground(Color.BLUE);
                payViaToken.setBackground(Color.gray);
                payViaToken.setEnabled(true);
                transfer.setVisible(false);
                payAccount.setVisible(true);
                ammt.setVisible(true);

            }
        });

        tFrom.addKeyListener(this);
        tamount.addKeyListener(this);

        dashboardI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        account.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changeMp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changePass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    setLayout(null);

    setVisible(true);

}
    public void keyTyped(KeyEvent e)
    {
        lFrom.setForeground(Color.BLACK);
        lamount.setForeground(Color.BLACK);
        warL.setVisible(false);
        warF.setVisible(false);
        warF2.setVisible(false);
        lamountHai.setForeground(Color.BLACK);
        lconfirm.setForeground(Color.BLACK);
        laccNumber.setForeground(Color.BLACK);
        notSame.setVisible(false);
        warL11.setVisible(false);
        warF11.setVisible(false);
        warF211.setVisible(false);
    }
    public void keyReleased(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e)
    {

    }

    public static void main(String[] args) {
        new TransferMoney("6400520604","jha anant dinesh","932483","1000");
    }
}
