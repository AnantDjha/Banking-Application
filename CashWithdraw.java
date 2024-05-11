import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;

public class CashWithdraw extends JFrame implements KeyListener {
    void removeLast(JTextField p)
    {
        String pass= p.getText();
        int t = pass.length()-1;
        p.setText(pass.substring(0,t));

    }
    JPanel information,transfer;
    JLabel dashboardI,changeMp,changePass,account,contactUs,logout;
    JLabel ldate,lFrom,lamount,warL;
    JTextField tamount,tFrom,tremark,tdate;
    JButton back,submit;
    JPasswordField tcreate;
    CashWithdraw(String acc , String nameH,String pinSahiWala,String totalBalance)
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        JMenuBar menu = new JMenuBar();

        JPanel message = new JPanel();
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
                new MainPage(acc,nameH);
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
                back.setEnabled(true);
                submit.setEnabled(true);
                message2.setVisible(false);
            }
        });

        JPanel enterPin = new JPanel();
        enterPin.setBounds(850,300,500,320);
        enterPin.setBackground(Color.DARK_GRAY);
        enterPin.setLayout(null);
        add(enterPin);
        enterPin.setVisible(false);

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

        tcreate = new JPasswordField();
        tcreate.setFont(new Font("ITALIC",Font.BOLD,20));
        tcreate.setForeground(Color.GRAY);
        tcreate.setBackground(Color.BLACK);
        tcreate.setBounds(40,200,420,40);
        tcreate.setHorizontalAlignment(SwingConstants.CENTER);
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
                    if(pinSahiWala.equals(tcreate.getText()) && Integer.parseInt(totalBalance) >= Integer.parseInt(sAmount))
                    {
                        try {
                            String q = "insert into transaction values('" + acc + "','" + tdate.getText() + "','" + LocalTime.now() + "','" + sAmount + "','withdraw','none')";
                            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "Anant@2004");
                            PreparedStatement smt = c.prepareStatement(q);
                            smt.executeUpdate();
                            message.setVisible(true);
                            transfer.setVisible(true);
                            information.setVisible(true);
                            enterPin.setVisible(false);
                        } catch (Exception x) {
                            x.printStackTrace();
                        }
                    }
                    else{

                            tcreate.setBorder(new LineBorder(Color.red));

                    }

                }
            }
        });

        menu.setBackground(Color.BLUE);
        menu.setBounds(0,0,d.width,60);
        menu.setLayout(null);
        add(menu);

        JLabel head = new JLabel("Cash withdrawal");
        head.setBounds(1000,15,250,30);
        head.setFont(new Font("System",Font.BOLD,24));
        head.setForeground(Color.white);
        menu.add(head);


        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("images/logoBank.png"));
        Image l2 = l1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel logo = new JLabel(l3);
        logo.setBounds(30,5,50,50);
        menu.add(logo);
        JLabel logoText = new JLabel("Banker");
        logoText.setBounds(81,17,100,15);
        logoText.setForeground(Color.WHITE);
        logoText.setFont(new Font("Bodoni MT black",Font.BOLD,16));
        menu.add(logoText);

        JLabel logoText2 = new JLabel("Banking basic application");
        logoText2.setBounds(82,30,100,13);
        logoText2.setForeground(Color.white);
        logoText2.setFont(new Font("Agency FB",Font.PLAIN,13));
        menu.add(logoText2);

        JPanel frame = new JPanel();
        frame.setBounds(0,60,350,d.height-60);
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        add(frame);

        ImageIcon dashI = new ImageIcon(ClassLoader.getSystemResource("images/dashboardLogo.jpg"));
        Image dashI2 = dashI.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon dashI3 = new ImageIcon(dashI2);



//        JLabel div = new JLabel("<html><div style='background-color:blue; height:30px;width:7px;border-radius:5px;'>   </div></html>");
//        div.setBounds(0,15,6,40);
//        frame.add(div);
        dashboardI = new JLabel("Dashboard",dashI3,JLabel.LEFT);
        dashboardI.setBounds(40,13,250,40);
        dashboardI.setFont(new Font("Rale-way",Font.BOLD,20));
        dashboardI.setBorder(new LineBorder(Color.white));
        dashboardI.setBackground(Color.BLUE);
        frame.add(dashboardI);

        account = new JLabel("Profile",dashI3,JLabel.LEFT);
        account.setBounds(40,70,250,40);
        account.setFont(new Font("Rale-way",Font.BOLD,20));
        account.setBorder(new LineBorder(Color.white));
        account.setBackground(Color.BLUE);
        frame.add(account);

        changeMp = new JLabel("Change MPIN",dashI3,JLabel.LEFT);
        changeMp.setBounds(40,125,250,40);
        changeMp.setFont(new Font("Rale-way",Font.BOLD,20));
        changeMp.setBorder(new LineBorder(Color.white));
        changeMp.setBackground(Color.BLUE);
        frame.add(changeMp);

        contactUs = new JLabel("Contact us",dashI3,JLabel.LEFT);
        contactUs.setBounds(40,180,250,40);
        contactUs.setFont(new Font("Rale-way",Font.BOLD,20));
        contactUs.setBorder(new LineBorder(Color.white));
        contactUs.setBackground(Color.BLUE);
        frame.add(contactUs);

        changePass = new JLabel("Change password",dashI3,JLabel.LEFT);
        changePass.setBounds(40,235,250,40);
        changePass.setFont(new Font("Rale-way",Font.BOLD,20));
        changePass.setBorder(new LineBorder(Color.white));
        changePass.setBackground(Color.BLUE);
        frame.add(changePass);

        logout = new JLabel("Logout",JLabel.CENTER);
        logout.setBounds(25,850,300,40);
        logout.setFont(new Font("Rale-way",Font.BOLD,20));
        logout.setBorder(new LineBorder(Color.white));
        logout.setBackground(Color.BLUE);
        logout.setOpaque(true);
        logout.setBackground(new Color(200,240,255,120));
        frame.add(logout);

        // deposite page menubar
        JMenuBar wMenu = new JMenuBar();
        wMenu.setBounds(350,60,d.width-350,50);
        wMenu.setBackground(Color.GRAY);
        wMenu.setLayout(null);
        add(wMenu);

        JLabel wMenuLbl = new JLabel("Withdraw cash at ATM: self");
        wMenuLbl.setForeground(new Color(130,200,255));
        wMenuLbl.setFont(new Font("",Font.BOLD,20));
        wMenuLbl.setBounds(620,10,300,30);
        wMenu.add(wMenuLbl);

        information = new JPanel();
        information.setLayout(null);
        information.setBounds(350+350,60+100,800,250);
        information.setBackground(Color.GRAY);
        add(information);

//        information panel elements

        ImageIcon l11 = new ImageIcon(ClassLoader.getSystemResource("images/logoBank.png"));
        Image l22 = l11.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon l33 = new ImageIcon(l22);
        JLabel logo2 = new JLabel(l33);
        logo2.setBounds(100,30,120,150);
        information.add(logo2);

        JLabel receiverLbl = new JLabel("From");
        receiverLbl.setBackground(Color.BLACK);
        receiverLbl.setBounds(300,80-10,100,10);
        receiverLbl.setFont(new Font("system",Font.BOLD,13));
        information.add(receiverLbl);

        JLabel receiverName = new JLabel(acc);
        receiverName.setForeground(Color.white);
        receiverName.setBounds(300,92-10,250,30);
        receiverName.setFont(new Font("system",Font.BOLD,20));
        information.add(receiverName);

        JLabel accountLbl = new JLabel("Details");
        accountLbl.setBackground(Color.BLACK);
        accountLbl.setBounds(300,160-10,150,10);
        accountLbl.setFont(new Font("system",Font.BOLD,13));
        information.add(accountLbl);

        JLabel accountNum = new JLabel("SAVING | "+nameH.toUpperCase());
        accountNum.setForeground(Color.white);
        accountNum.setBounds(300,172-10,400,30);
        accountNum.setFont(new Font("system",Font.BOLD,20));
        information.add(accountNum);

        transfer = new JPanel();
        transfer.setLayout(null);
        transfer.setBounds(350+350,340+100+20,800,330);
        transfer.setBackground(Color.GRAY);
        add(transfer);

//        transfer panel elements

        JLabel withdrawalLbl = new JLabel("Withdrawal Details");
        withdrawalLbl.setBounds(10,20,200,30);
        withdrawalLbl.setFont(new Font("system",Font.BOLD,22));
        withdrawalLbl.setForeground(Color.white);
        transfer.add(withdrawalLbl);



        JLabel amount = new JLabel("Amount");
        amount.setBounds(50,80,200,15);
        amount.setFont(new Font("system",Font.BOLD,15));
        transfer.add(amount);

        tamount = new JTextField();
        tamount.setBounds(50,110-10,700,40);
        tamount.setBackground(Color.gray);
        tamount.setForeground(Color.WHITE);
        tamount.setBorder(new LineBorder(Color.GRAY,1,true));
        tamount.setFont(new Font("system",Font.BOLD,18));
        tamount.setCaretColor(Color.white);
        tamount.addKeyListener(this);
        transfer.add(tamount);
        lamount = new JLabel("__________________________________________________________________________________________________");
        lamount.setForeground(Color.black);
        lamount.setBounds(50,140-10,700,20);
        transfer.add(lamount);

        warL = new JLabel("Enter valid Amount");
        warL.setBounds(50,153,200,10);
        warL.setForeground(Color.red);
        transfer.add(warL);
        warL.setVisible(false);



        JLabel date = new JLabel("Date");
        date.setBounds(50,80+100,200,15);
        date.setFont(new Font("system",Font.BOLD,15));
        transfer.add(date);


        tdate = new JTextField(""+ LocalDate.now());
        tdate.setBounds(50,110-10+100,700,40);
        tdate.setBackground(Color.gray);
        tdate.setForeground(Color.WHITE);
        tdate.setEditable(false);
        tdate.setBorder(new LineBorder(Color.GRAY,1,true));
        tdate.setFont(new Font("system",Font.BOLD,18));
        tdate.setCaretColor(Color.white);
        transfer.add(tdate);
        ldate = new JLabel("__________________________________________________________________________________________________");
        ldate.setForeground(Color.black);
        ldate.setBounds(50,140-10+100,700,20);
        transfer.add(ldate);

        back = new JButton("Back");
        back.setBounds(590+350+350,840,100,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(590+350+110+350,840,100,30);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sAmount = tamount.getText();

                if(sAmount.isBlank()) {
                    lamount.setForeground(Color.RED);
                    tamount.requestFocus();
                }
                else if(!sAmount.matches("\\d+"))
                {
                    lamount.setForeground(Color.RED);
                    warL.setVisible(true);
                    tamount.requestFocus();
                }
                else if (Integer.parseInt(tamount.getText()) > Integer.parseInt(totalBalance))
                {
                    message2.setVisible(true);

                    tamount.setEnabled(false);
                    back.setEnabled(false);
                    submit.setEnabled(false);
                }
                else{
                    enterPin.setVisible(true);
                    tamount.setEnabled(false);
                    back.setEnabled(false);
                    submit.setEnabled(false);
                    information.setVisible(false);
                    transfer.setVisible(false);
                    submit.setVisible(false);
                    back.setVisible(false);

                }
            }
        });

        setLayout(null);
        setVisible(true);

    }
    public void keyTyped(KeyEvent e)
    {
        lamount.setForeground(Color.BLACK);
        warL.setVisible(false);
    }
    public void keyReleased(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e)
    {

    }
    public static void main(String[] args) {
        new CashWithdraw("123242432432","jha anant dinesh","123456","1000");
    }
}
