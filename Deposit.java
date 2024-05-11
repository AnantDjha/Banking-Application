import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.time.*;
import java.sql.*;

public class Deposit extends JFrame implements KeyListener {
    JLabel dashboardI,changeMp,changePass,account,contactUs,logout;

    JButton back,submit;
    JLabel ldate,lFrom,lamount,warL;
    JTextField tamount,tFrom,tremark;
    Deposit(String acc , String nameH)
    {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(350,83,d.width-350,d.height-83);

        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.BLUE);
        menu.setBounds(0,0,d.width,60);
        menu.setLayout(null);
        add(menu);

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
        dashboardI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

        JPanel message = new JPanel();
        message.setBackground(new Color(60,60,60));
        message.setBounds(350+200+350,250,400,200);
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

        JLabel messL = new JLabel("The amount is successfully credited");
        messL.setForeground(Color.white);
        messL.setFont(new Font("system",Font.BOLD,17));
        messL.setBounds(55,60,300,30);
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
                new MainPage(acc,nameH);
                setVisible(false);
            }
        });


        JPanel information = new JPanel();
        information.setLayout(null);
        information.setBounds(350+350,60+60,800,250);
        information.setBackground(Color.GRAY);
        add(information);

//        information panel elements

        ImageIcon l1Chota = new ImageIcon(ClassLoader.getSystemResource("images/logoBank.png"));
        Image l2Chota = l1Chota.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon l3Chota = new ImageIcon(l2Chota);
        JLabel logoChota = new JLabel(l3Chota);
        logoChota.setBounds(100,30,120,150);
        information.add(logoChota);

        JLabel receiverLbl = new JLabel("Receiver name");
        receiverLbl.setBackground(Color.BLACK);
        receiverLbl.setBounds(300,80-10,100,10);
        receiverLbl.setFont(new Font("system",Font.BOLD,13));
        information.add(receiverLbl);

        JLabel receiverName = new JLabel(nameH.toUpperCase());
        receiverName.setForeground(Color.white);
        receiverName.setBounds(300,92-10,250,30);
        receiverName.setFont(new Font("system",Font.BOLD,20));
        information.add(receiverName);

        JLabel accountLbl = new JLabel("Account Number");
        accountLbl.setBackground(Color.BLACK);
        accountLbl.setBounds(300,160-10,150,10);
        accountLbl.setFont(new Font("system",Font.BOLD,13));
        information.add(accountLbl);

        JLabel accountNum = new JLabel("SAVING-"+acc);
        accountNum.setForeground(Color.white);
        accountNum.setBounds(300,172-10,250,30);
        accountNum.setFont(new Font("system",Font.BOLD,20));
        information.add(accountNum);

        JPanel transfer = new JPanel();
        transfer.setLayout(null);
        transfer.setBounds(350+350,340+60,800,500);
        transfer.setBackground(Color.GRAY);
        add(transfer);

//        transfer panel elements

        JLabel transferLbl = new JLabel("Transfer Details");
        transferLbl.setBounds(10,20,200,30);
        transferLbl.setFont(new Font("system",Font.BOLD,22));
        transferLbl.setForeground(Color.white);
        transfer.add(transferLbl);

        JLabel from = new JLabel("From (UPI id)");
        from.setBounds(50,80,200,15);
        from.setFont(new Font("system",Font.BOLD,15));
        transfer.add(from);

        tFrom = new JTextField();
        tFrom.setBounds(50,110-10,700,40);
        tFrom.setBackground(Color.gray);
        tFrom.setForeground(Color.WHITE);
        tFrom.setBorder(new LineBorder(Color.GRAY,1,true));
        tFrom.setFont(new Font("system",Font.BOLD,18));
        tFrom.setCaretColor(Color.white);
        transfer.add(tFrom);
        lFrom = new JLabel("__________________________________________________________________________________________________");
        lFrom.setForeground(Color.black);
        lFrom.setBounds(50,140-10,700,20);
        transfer.add(lFrom);

        JLabel amount = new JLabel("Amount");
        amount.setBounds(50,180,200,15);
        amount.setFont(new Font("system",Font.BOLD,15));
        transfer.add(amount);

        tamount = new JTextField();
        tamount.setBounds(50,210-10,700,40);
        tamount.setBackground(Color.gray);
        tamount.setForeground(Color.WHITE);
        tamount.setBorder(new LineBorder(Color.GRAY,1,true));
        tamount.setFont(new Font("system",Font.BOLD,18));
        tamount.setCaretColor(Color.white);
        transfer.add(tamount);
        lamount = new JLabel("__________________________________________________________________________________________________");
        lamount.setForeground(Color.black);
        lamount.setBounds(50,240-10,700,20);
        transfer.add(lamount);
        warL = new JLabel("Enter valid Amount");
        warL.setBounds(50,253,200,10);
        warL.setForeground(Color.red);
        transfer.add(warL);
        warL.setVisible(false);


        JLabel date = new JLabel("Date");
        date.setBounds(50,180+100,200,15);
        date.setFont(new Font("system",Font.BOLD,15));
        transfer.add(date);


        JTextField tdate = new JTextField(""+LocalDate.now());
        tdate.setBounds(50,210-10+100,700,40);
        tdate.setBackground(Color.gray);
        tdate.setForeground(Color.WHITE);
        tdate.setEditable(false);
        tdate.setBorder(new LineBorder(Color.GRAY,1,true));
        tdate.setFont(new Font("system",Font.BOLD,18));
        tdate.setCaretColor(Color.white);
        transfer.add(tdate);
        ldate = new JLabel("__________________________________________________________________________________________________");
        ldate.setForeground(Color.black);
        ldate.setBounds(50,240-10+100,700,20);
        transfer.add(ldate);

        JLabel remark = new JLabel("Remarks");
        remark.setBounds(50,180+100+100,200,15);
        remark.setFont(new Font("system",Font.BOLD,15));
        transfer.add(remark);


        tremark = new JTextField("Fund Transfer");
        tremark.setBounds(50,210-10+100+100,700,40);
        tremark.setBackground(Color.gray);
        tremark.setForeground(Color.WHITE);
        tremark.setBorder(new LineBorder(Color.GRAY,1,true));
        tremark.setFont(new Font("system",Font.BOLD,18));
        tremark.setCaretColor(Color.white);
        transfer.add(tremark);
        JLabel lremark = new JLabel("__________________________________________________________________________________________________");
        lremark.setForeground(Color.black);
        lremark.setBounds(50,240-10+100+100,700,20);
        transfer.add(lremark);

        back = new JButton("Back");
        back.setBounds(590+350+350,870+60,100,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage(acc,nameH);
                setVisible(false);
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(590+350+110+350,870+60,100,30);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sFrom = tFrom.getText();
                String sAmount = tamount.getText();
                String sRemark = tremark.getText();
                if (sFrom.isBlank())
                {
                    lFrom.setForeground(Color.RED);
                    tFrom.requestFocus();
                }
                else if(sAmount.isBlank()) {
                    lamount.setForeground(Color.RED);
                    tamount.requestFocus();
                }
                else if(!sAmount.matches("\\d+"))
                {
                    lamount.setForeground(Color.RED);
                    warL.setVisible(true);
                    tamount.requestFocus();
                }
                else{
                    try {
                        String q = "insert into transaction values('"+acc+"','"+tdate.getText()+"','"+LocalTime.now()+"','"+sAmount+"','deposit','"+sFrom+"')";
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank","root","Anant@2004");
                        PreparedStatement smt = c.prepareStatement(q);
                        smt.executeUpdate();

                        message.setVisible(true);
                        tamount.setEnabled(false);
                        tFrom.setEnabled(false);
                        tremark.setEnabled(false);
                        back.setEnabled(false);
                        submit.setEnabled(false);
                    }
                    catch(Exception x)
                    {
                        x.printStackTrace();
                    }
                }
            }
        });


        tFrom.addKeyListener(this);
        tamount.addKeyListener(this);
        tremark.addKeyListener(this);



        setLayout(null);
        setVisible(true);
    }
    public void keyTyped(KeyEvent e)
    {
        lFrom.setForeground(Color.BLACK);
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
        new Deposit("473273625632","jha anant dinesh");
    }
}
