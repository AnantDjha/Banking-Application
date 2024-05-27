import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainPage extends JFrame{
    JLabel dashboardI,account,changeMp,contactUs,changePass,logout;
    JButton moneyTransfer,checkBal,accountOverview,depositMoney,miniStatement,accountActivity,cashWithdrawl,creditCard,balanceEnquiry,forgetPass,physicalCard;
    JButton back;
    JPasswordField tcreate;
    String pinHaiSahi;
    String acc;
    int totalBalanceInAcc;
    void removeLast(JTextField p)
    {
        String pass= p.getText();
        int t = pass.length()-1;
        p.setText(pass.substring(0,t));

    }
    MainPage(String acc,String nameH)
    {
        this.acc = acc;
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank","root","Anant@2004");
            String q = "select * from registration where accountNo = '"+acc+"'";
            String queryOfBalance = "select * from transaction where tokenId = '"+acc+"' and type in('deposit','withdraw','paid','receive')";
            PreparedStatement smt = c.prepareStatement(q);
            PreparedStatement smt2 = c.prepareStatement(queryOfBalance);
            ResultSet rs = smt.executeQuery();
            if(rs.next())
            {
                pinHaiSahi = rs.getString("mpin");
            }
            ResultSet rs2 = smt2.executeQuery();

            int dpAmount = 0;int wtAmount = 0;
            while(rs2.next())
            {
                if(rs2.getString("type").equals("deposit") || rs2.getString("type").equals("receive"))
                {
                    dpAmount = dpAmount+Integer.parseInt(rs2.getString("amount"));
                }
                else{
                    wtAmount = wtAmount+Integer.parseInt(rs2.getString("amount"));

                }
            }
            totalBalanceInAcc = dpAmount-wtAmount;

        }catch(Exception x)
        {
            x.printStackTrace();
        }
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.BLUE);
        menu.setBounds(0,0,d.width,60);
        menu.setLayout(null);
        add(menu);

//        Enter the password panel
        JPanel enterPin = new JPanel();
        enterPin.setBounds(650,200,500,320);
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
        name.setText(nameH.toUpperCase());
        name.setForeground(Color.white);
        name.setFont(new Font("Algerian",Font.PLAIN,25));
        enterPin.add(name);
        JLabel accountN = new JLabel("Account - "+acc);
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
                    String pinD = tcreate.getText();
                    if(pinD.equals(pinHaiSahi))
                    {
                        tcreate.setBorder(new LineBorder(Color.green));
                        checkBal.setText("Rs: "+totalBalanceInAcc);
                        enterPin.setVisible(false);

                        tcreate.setText("");
                        tcreate.setBorder(new LineBorder(Color.white));
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
                enterPin.setVisible(false);
                tcreate.setText("");
            }
        });



        ImageIcon dI = new ImageIcon(ClassLoader.getSystemResource("images/dashBoardMain.jpg"));
        Image dI2 = dI.getImage().getScaledInstance(500,d.height,Image.SCALE_SMOOTH);
        ImageIcon dI3 = new ImageIcon(dI2);

        JLabel dM = new JLabel(dI3);
        dM.setBounds(d.width-500,50,500,d.height-60);
        add(dM);


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



        JLabel div = new JLabel("<html><div style='background-color:blue; height:30px;width:7px;border-radius:5px;'>   </div></html>");
        div.setBounds(0,15,6,40);
        frame.add(div);
        dashboardI = new JLabel("Dashboard                 →",dashI3,JLabel.LEFT);
        dashboardI.setBounds(30,13,300,40);
        dashboardI.setFont(new Font("Rale-way",Font.BOLD,23));
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

        JPanel details = new JPanel();
        details.setLayout(null);
        details.setBounds(350,60,1080,300);
        details.setBackground(Color.WHITE);
        details.setBackground(new Color(0,0,0,150));
        add(details);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/mainImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(d.width-800,d.height-500,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel detailLbl = new JLabel(i3);
        detailLbl.setBounds(350,60,details.getWidth(),details.getHeight());
        add(detailLbl);

        // frame elements
        JLabel nameD = new JLabel();
        nameD.setBounds(60,100+20,300,30);
        nameD.setText(nameH.toUpperCase());
        nameD.setForeground(Color.white);
        nameD.setFont(new Font("Algerian",Font.PLAIN,25));
        details.add(nameD);
        JLabel accountNoḌ = new JLabel();
        accountNoḌ.setBounds(60,150+10,300,30);
        accountNoḌ.setText("Account - "+acc);
        accountNoḌ.setForeground(Color.white);
        accountNoḌ.setFont(new Font("",Font.BOLD,25));
        details.add(accountNoḌ);

        JLabel sav = new JLabel();
        sav.setBounds(60,70,300,30);
        sav.setText("Saving");
        sav.setForeground(Color.orange);
        sav.setFont(new Font("",Font.BOLD,20));
        details.add(sav);

        checkBal = new JButton("Check Balance");
        checkBal.setBackground(Color.BLUE);
        checkBal.setForeground(Color.WHITE);
        checkBal.setFont(new Font("",Font.BOLD,20));
        checkBal.setBounds(820,120,200,40);
        details.add(checkBal);
        checkBal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkBal.getText().equals("Check Balance"))
                {
                    enterPin.setVisible(true);

                }
                else{
                    checkBal.setText("Check Balance");
                }
            }
        });

        JPanel icons = new JPanel();
        icons.setBounds(450,430,970-100,400);
        icons.setLayout(null);
        icons.setBackground(Color.WHITE);
        add(icons);

        // icons panel elements
        JLabel iconsL = new JLabel("Pay & Access");
        iconsL.setFont(new Font("system",Font.BOLD,18));
        iconsL.setBounds(30,20,200,30);
        icons.add(iconsL);

//        Money transfer button
        ImageIcon moneytransfer1 = new ImageIcon(ClassLoader.getSystemResource("images/moneyTransferIc.png"));
        Image moneytransfer2 = moneytransfer1.getImage().getScaledInstance(70,60,Image.SCALE_SMOOTH);
        ImageIcon moneytransfer3 = new ImageIcon(moneytransfer2);

        moneyTransfer = new JButton(moneytransfer3);
        moneyTransfer.setBounds(100+50,100,60,60);
        moneyTransfer.setBackground(Color.WHITE);
        moneyTransfer.setBorder(new LineBorder(Color.white));
        icons.add(moneyTransfer);
        moneyTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransferMoney(acc,nameH,pinHaiSahi,totalBalanceInAcc+"");
                setVisible(false);
            }
        });

        JLabel moneyTransferL = new JLabel("Money");
        moneyTransferL.setBounds(100+50,163,60,10);
        moneyTransferL.setHorizontalAlignment(JLabel.CENTER);
        moneyTransferL.setForeground(Color.magenta);
        icons.add(moneyTransferL);
        JLabel moneyTransferL2 = new JLabel("Transfer");
        moneyTransferL2.setBounds(100+50,175,60,10);
        moneyTransferL2.setHorizontalAlignment(JLabel.CENTER);
        moneyTransferL2.setForeground(Color.magenta);
        icons.add(moneyTransferL2);

//        account overview button
        ImageIcon accountOverview1 = new ImageIcon(ClassLoader.getSystemResource("images/accountOverview.jpg"));
        Image accountOverview2 = accountOverview1.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon accountOverview3 = new ImageIcon(accountOverview2);

        accountOverview = new JButton(accountOverview3);
        accountOverview.setBounds(250+20+50,100,60,60);
        accountOverview.setBackground(Color.WHITE);
        accountOverview.setBorder(new LineBorder(Color.white));
        icons.add(accountOverview);

        JLabel accountOverviewL = new JLabel("Account");
        accountOverviewL.setBounds(250+20+50,163,60,10);
        accountOverviewL.setHorizontalAlignment(JLabel.CENTER);
        accountOverviewL.setForeground(Color.magenta);
        icons.add(accountOverviewL);
        JLabel accountOverviewL2 = new JLabel("Overview");
        accountOverviewL2.setBounds(250+20+50,175,60,10);
        accountOverviewL2.setHorizontalAlignment(JLabel.CENTER);
        accountOverviewL2.setForeground(Color.magenta);
        icons.add(accountOverviewL2);

//        Deposit money
        ImageIcon depositMoney1 = new ImageIcon(ClassLoader.getSystemResource("images/depositMoney.png"));
        Image depositMoney2 = depositMoney1.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon depositMoney3 = new ImageIcon(depositMoney2);

        depositMoney = new JButton(depositMoney3);
        depositMoney.setBounds(400+20+50,100,60,60);
        depositMoney.setBackground(Color.WHITE);
        depositMoney.setBorder(new LineBorder(Color.white));
        icons.add(depositMoney);
        depositMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Deposit(acc,nameH);
                setVisible(false);
            }
        });

        JLabel depositMoneyL = new JLabel("Deposit");
        depositMoneyL.setBounds(400+20+50,163,60,10);
        depositMoneyL.setHorizontalAlignment(JLabel.CENTER);
        depositMoneyL.setForeground(Color.magenta);
        icons.add(depositMoneyL);
        JLabel depositMoneyL2 = new JLabel("Money");
        depositMoneyL2.setBounds(400+20+50,175,60,13);
        depositMoneyL2.setHorizontalAlignment(JLabel.CENTER);
        depositMoneyL2.setForeground(Color.magenta);
        icons.add(depositMoneyL2);

//        statement button
        ImageIcon miniStatement1 = new ImageIcon(ClassLoader.getSystemResource("images/statementIc.png"));
        Image miniStatement2 = miniStatement1.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon miniStatement3 = new ImageIcon(miniStatement2);

        miniStatement = new JButton(miniStatement3);
        miniStatement.setBounds(550+20+50,100,60,60);
        miniStatement.setBackground(Color.WHITE);
        miniStatement.setBorder(new LineBorder(Color.white));
        icons.add(miniStatement);

        JLabel miniStatementL = new JLabel("Mini");
        miniStatementL.setBounds(550+20+50,163,60,10);
        miniStatementL.setHorizontalAlignment(JLabel.CENTER);
        miniStatementL.setForeground(Color.magenta);
        icons.add(miniStatementL);
        JLabel miniStatementL2 = new JLabel("Statement");
        miniStatementL2.setBounds(550+20+50,175,60,13);
        miniStatementL2.setHorizontalAlignment(JLabel.CENTER);
        miniStatementL2.setForeground(Color.magenta);
        icons.add(miniStatementL2);

//        Account activity button
        ImageIcon accountActivity1 = new ImageIcon(ClassLoader.getSystemResource("images/accountActivity.png"));
        Image accountActivity2 = accountActivity1.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon accountActivity3 = new ImageIcon(accountActivity2);

        accountActivity = new JButton(accountActivity3);
        accountActivity.setBounds(150,230,60,60);
        accountActivity.setBackground(Color.WHITE);
        accountActivity.setBorder(new LineBorder(Color.white));
        icons.add(accountActivity);

        JLabel accountActivityL = new JLabel("Account");
        accountActivityL.setBounds(150,293,60,10);
        accountActivityL.setHorizontalAlignment(JLabel.CENTER);
        accountActivityL.setForeground(Color.magenta);
        icons.add(accountActivityL);
        JLabel accountActivityL2 = new JLabel("Activity");
        accountActivityL2.setBounds(150,305,60,13);
        accountActivityL2.setHorizontalAlignment(JLabel.CENTER);
        accountActivityL2.setForeground(Color.magenta);
        icons.add(accountActivityL2);

//        cash withdrawl button

        ImageIcon cashWithdrawl1 = new ImageIcon(ClassLoader.getSystemResource("images/cashWithdrawl.jpg"));
        Image cashWithdrawl2 = cashWithdrawl1.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon cashWithdrawl3 = new ImageIcon(cashWithdrawl2);

        cashWithdrawl = new JButton(cashWithdrawl3);
        cashWithdrawl.setBounds(250+20+50,230,60,60);
        cashWithdrawl.setBackground(Color.WHITE);
        cashWithdrawl.setBorder(new LineBorder(Color.white));
        icons.add(cashWithdrawl);
        cashWithdrawl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CashWithdraw(acc,nameH,pinHaiSahi,totalBalanceInAcc+"");
                setVisible(false);
            }
        });

        JLabel cashWithdrawlL = new JLabel("Cash");
        cashWithdrawlL.setBounds(250+20+50,293,60,10);
        cashWithdrawlL.setHorizontalAlignment(JLabel.CENTER);
        cashWithdrawlL.setForeground(Color.magenta);
        icons.add(cashWithdrawlL);
        JLabel cashWithdrawlL2 = new JLabel("Withdraw");
        cashWithdrawlL2.setBounds(250+20+50,305,60,13);
        cashWithdrawlL2.setHorizontalAlignment(JLabel.CENTER);
        cashWithdrawlL2.setForeground(Color.magenta);
        icons.add(cashWithdrawlL2);

//        credit card button

        ImageIcon creditCard1 = new ImageIcon(ClassLoader.getSystemResource("images/creditCard.jpg"));
        Image creditCard2 = creditCard1.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon creditCard3 = new ImageIcon(creditCard2);

        creditCard = new JButton(creditCard3);
        creditCard.setBounds(400+20+50,230,60,60);
        creditCard.setBackground(Color.WHITE);
        creditCard.setBorder(new LineBorder(Color.white));
        icons.add(creditCard);

        JLabel creditCardL = new JLabel("Credit");
        creditCardL.setBounds(400+20+50,293,60,10);
        creditCardL.setHorizontalAlignment(JLabel.CENTER);
        creditCardL.setForeground(Color.magenta);
        icons.add(creditCardL);
        JLabel creditCardL2 = new JLabel("card");
        creditCardL2.setBounds(400+20+50,305,60,13);
        creditCardL2.setHorizontalAlignment(JLabel.CENTER);
        creditCardL2.setForeground(Color.magenta);
        icons.add(creditCardL2);

//        balance enquiry button

        ImageIcon balanceEnquiry1 = new ImageIcon(ClassLoader.getSystemResource("images/balanceEnquiry.jpg"));
        Image balanceEnquiry2 = balanceEnquiry1.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
        ImageIcon balanceEnquiry3 = new ImageIcon(balanceEnquiry2);

        balanceEnquiry = new JButton(balanceEnquiry3);
        balanceEnquiry.setBounds(550+20+50,230,60,60);
        balanceEnquiry.setBackground(Color.WHITE);
        balanceEnquiry.setBorder(new LineBorder(Color.white));
        icons.add(balanceEnquiry);

        JLabel balanceEnquiryL = new JLabel("Balance");
        balanceEnquiryL.setBounds(550+20+50,293,60,10);
        balanceEnquiryL.setHorizontalAlignment(JLabel.CENTER);
        balanceEnquiryL.setForeground(Color.magenta);
        icons.add(balanceEnquiryL);
        JLabel balanceEnquiryL2 = new JLabel("Enquiry");
        balanceEnquiryL2.setBounds(550+20+50,305,60,13);
        balanceEnquiryL2.setHorizontalAlignment(JLabel.CENTER);
        balanceEnquiryL2.setForeground(Color.magenta);
        icons.add(balanceEnquiryL2);


        JPanel footer = new JPanel();
        footer.setLayout(null);
        footer.setBounds(350,950,1080,60);
        footer.setBackground(Color.WHITE);
        footer.setBackground(Color.BLACK);
        add(footer);

        ImageIcon forgetPass1 = new ImageIcon(ClassLoader.getSystemResource("images/forgetPass.png"));
        Image forgetPass2 = forgetPass1.getImage().getScaledInstance(40,30,Image.SCALE_SMOOTH);
        ImageIcon forgetPass3 = new ImageIcon(forgetPass2);

        forgetPass = new JButton("Forget Password",forgetPass3);
        forgetPass.setBounds(250+20+50,10,200,40);
        forgetPass.setBackground(Color.BLACK);
        forgetPass.setBorder(new LineBorder(Color.BLACK));
        forgetPass.setForeground(Color.WHITE);
        footer.add(forgetPass);

        ImageIcon physicalCard1 = new ImageIcon(ClassLoader.getSystemResource("images/physicalCard.jpg"));
        Image physicalCard2 = physicalCard1.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon physicalCard3 = new ImageIcon(physicalCard2);

        physicalCard = new JButton("Order physical card",physicalCard3);
        physicalCard.setBounds(250+20+50+200,10,200,40);
        physicalCard.setBackground(Color.BLACK);
        physicalCard.setBorder(new LineBorder(Color.BLACK));
        physicalCard.setForeground(Color.WHITE);
        footer.add(physicalCard);


        account.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        account.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == account)
                {
                    setVisible(false);
                    new Profile(acc);
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
        changeMp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changePass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int a = JOptionPane.showConfirmDialog(null,"Do you want to Logout?");
                if(a == 0){
                    setVisible(false);
                    new Login();
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
        contactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainPage("6400520604","Jha anant dinesh");
    }
}
