import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.security.PrivilegedExceptionAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Profile extends JFrame {
    JLabel dashboardI,changeMp,changePass,account,contactUs,logout;
    String sName,sEmail,sPhone,sToken,sPan,sAdhar,sAdd,sGender;
    Profile(String acc)
    {
        try
        {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank","root","Anant@2004");
            String q = "select * from userInformation where accountNumber = '"+acc+"'";
            String q2 = "select * from registration where accountNo = '"+acc+"'";
            PreparedStatement smt = c.prepareStatement(q);
            PreparedStatement smt2 = c.prepareStatement(q2);
            ResultSet rs1 = smt.executeQuery();
            ResultSet rs2 = smt2.executeQuery();

            rs2.next();
            rs1.next();

            sToken = rs2.getString("tokenId");
            sName = rs1.getString("name");
            sPhone = rs1.getString("phoneNumber");
            sEmail = rs1.getString("email");
            sPan = rs1.getString("pan");
            sAdd = rs1.getString("address");
            sAdhar = rs1.getString("aadhaar");
            sGender = rs1.getString("gender");
        }
        catch(Exception x)
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
        div.setBounds(0,68,6,40);
        frame.add(div);
        dashboardI = new JLabel("Dashboard",dashI3,JLabel.LEFT);
        dashboardI.setBounds(40,13,250,40);
        dashboardI.setFont(new Font("Rale-way",Font.BOLD,23));
        dashboardI.setBorder(new LineBorder(Color.white));
        dashboardI.setBackground(Color.BLUE);
        frame.add(dashboardI);

        account = new JLabel("Profile                                ",dashI3,JLabel.LEFT);
        account.setBounds(30,70,300,40);
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

        JPanel informationPanel = new JPanel();
        informationPanel.setBounds(350+350,60+100,900,700);
        informationPanel.setBackground(Color.WHITE);
        informationPanel.setLayout(null);
        add(informationPanel);
        {

            ImageIcon p1 = new ImageIcon(ClassLoader.getSystemResource("images/profileIc.png"));
            Image p2 = p1.getImage().getScaledInstance(150,170,Image.SCALE_SMOOTH);
            ImageIcon p3 = new ImageIcon(p2);

            JLabel just = new JLabel(p3);
            just.setBounds(100,100,150,170);
            informationPanel.add(just);

            JLabel barname = new JLabel("Name:");
            barname.setFont(new Font("system",Font.BOLD,18));
            barname.setBounds(350,70,100,20);
            informationPanel.add(barname);

            JLabel barnameVal = new JLabel(sName.toUpperCase());
            barnameVal.setBounds(450,70,200,20);
            barnameVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(barnameVal);

            JLabel barnameDash = new JLabel("__________________________________________________");
            barnameDash.setBounds(450,80,400,20);
            barnameDash.setForeground(Color.GRAY);
            informationPanel.add(barnameDash);

            JLabel bardob = new JLabel("D.O.B:");
            bardob.setFont(new Font("system",Font.BOLD,18));
            bardob.setBounds(350,70+30+20,100,20);
            informationPanel.add(bardob);

            JLabel bardobVal = new JLabel("xx-xx-xx".toUpperCase());
            bardobVal.setBounds(450,70+30+20,200,20);
            bardobVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(bardobVal);

            JLabel bardobDash = new JLabel("__________________________________________________");
            bardobDash.setBounds(450,80+30+20,400,20);
            bardobDash.setForeground(Color.GRAY);
            informationPanel.add(bardobDash);

            JLabel bargender = new JLabel("Gender:");
            bargender.setFont(new Font("system",Font.BOLD,18));
            bargender.setBounds(350,70+30+20+50,100,20);
            informationPanel.add(bargender);

            JLabel bargenderVal = new JLabel(sGender.toUpperCase());
            bargenderVal.setBounds(450,70+30+20+50,200,20);
            bargenderVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(bargenderVal);

            JLabel bargenderDash = new JLabel("__________________________________________________");
            bargenderDash.setBounds(450,80+30+20+50,400,20);
            bargenderDash.setForeground(Color.GRAY);
            informationPanel.add(bargenderDash);

            JLabel barphone = new JLabel("Phone:");
            barphone.setFont(new Font("system",Font.BOLD,18));
            barphone.setBounds(350,70+30+20+50+50,100,20);
            informationPanel.add(barphone);

            JLabel barphoneVal = new JLabel(sPhone.charAt(0)+"xxxxxxx"+sPhone.substring(8));
            barphoneVal.setBounds(450,70+30+20+50+50,200,20);
            barphoneVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(barphoneVal);

            JLabel barphoneDash = new JLabel("__________________________________________________");
            barphoneDash.setBounds(450,80+30+20+50+50,400,20);
            barphoneDash.setForeground(Color.GRAY);
            informationPanel.add(barphoneDash);

            JLabel baremail = new JLabel("Email:");
            baremail.setFont(new Font("system",Font.BOLD,18));
            baremail.setBounds(350,70+30+20+50+50+50,100,20);
            informationPanel.add(baremail);

            JLabel baremailVal = new JLabel("xxxxxxxx"+sEmail.substring(8));
            baremailVal.setBounds(450,70+30+20+50+50+50,300,20);
            baremailVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(baremailVal);

            JLabel baremailDash = new JLabel("__________________________________________________");
            baremailDash.setBounds(450,80+30+20+50+50+50,400,20);
            baremailDash.setForeground(Color.GRAY);
            informationPanel.add(baremailDash);

            JLabel baradd = new JLabel("Address:");
            baradd.setFont(new Font("system",Font.BOLD,18));
            baradd.setBounds(50,70+30+20+50+50+50+50+10,100,20);
            informationPanel.add(baradd);

            JLabel baraddVal = new JLabel(sAdd.toUpperCase());
            baraddVal.setBounds(150,70+30+20+50+50+50+50+10,700,20);
            baraddVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(baraddVal);

            JLabel baraddDash = new JLabel("_______________________________________________________________________________________________________");
            baraddDash.setBounds(150,80+30+20+50+50+50+50+10,670,20);
            baraddDash.setForeground(Color.GRAY);
            informationPanel.add(baraddDash);
        }

        JMenuBar informationBar1 = new JMenuBar();
        informationBar1.setLayout(null);
        informationBar1.setBounds(0,0,900,50);
        informationBar1.setBackground(Color.gray);
        informationPanel.add(informationBar1);
        {
            JLabel personalDetails = new JLabel("Personal Details");
            personalDetails.setForeground(Color.WHITE);
            personalDetails.setBounds(10,10,200,30);
            personalDetails.setFont(new Font("System",Font.BOLD,20));
            informationBar1.add(personalDetails);

        }

        JMenuBar informationBar2 = new JMenuBar();
        informationBar2.setLayout(null);
        informationBar2.setBounds(0,350+30,900,50);
        informationBar2.setBackground(Color.gray);
        informationPanel.add(informationBar2);
        {
            JLabel barpan = new JLabel("PAN:");
            barpan.setFont(new Font("system",Font.BOLD,18));
            barpan.setBounds(50,400+50,100,20);
            informationPanel.add(barpan);

            JLabel barpanVal = new JLabel(sPan.charAt(0)+"xxxxxxx"+sPan.toUpperCase().substring(8));
            barpanVal.setBounds(150,400+50,700,20);
            barpanVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(barpanVal);

            JLabel barpanDash = new JLabel("_______________________________________________________________________________________________________");
            barpanDash.setBounds(150,410+50,670,20);
            barpanDash.setForeground(Color.GRAY);
            informationPanel.add(barpanDash);

            JLabel baradhar = new JLabel("Aadhaar:");
            baradhar.setFont(new Font("system",Font.BOLD,18));
            baradhar.setBounds(50,400+50+50,100,20);
            informationPanel.add(baradhar);

            JLabel baradharVal = new JLabel(sAdhar.charAt(0)+sAdhar.charAt(1)+"xxxxxx"+sAdhar.toUpperCase().substring(8));
            baradharVal.setBounds(150,400+50+50,700,20);
            baradharVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(baradharVal);

            JLabel baradharDash = new JLabel("_______________________________________________________________________________________________________");
            baradharDash.setBounds(150,410+50+50,670,20);
            baradharDash.setForeground(Color.GRAY);
            informationPanel.add(baradharDash);

            JLabel baracc = new JLabel("Account:");
            baracc.setFont(new Font("system",Font.BOLD,18));
            baracc.setBounds(50,400+50+50+50,100,20);
            informationPanel.add(baracc);

            JLabel baraccVal = new JLabel(acc.charAt(0)+"xxxxxxx"+acc.toUpperCase().substring(8));
            baraccVal.setBounds(150,400+50+50+50,700,20);
            baraccVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(baraccVal);

            JLabel baraccDash = new JLabel("_______________________________________________________________________________________________________");
            baraccDash.setBounds(150,410+50+50+50,670,20);
            baraccDash.setForeground(Color.GRAY);
            informationPanel.add(baraccDash);

            JLabel bartoken = new JLabel("Token:");
            bartoken.setFont(new Font("system",Font.BOLD,18));
            bartoken.setBounds(50,400+50+50+50+50,100,20);
            informationPanel.add(bartoken);

            JLabel bartokenVal = new JLabel(sToken);
            bartokenVal.setBounds(150,400+50+50+50+50,700,20);
            bartokenVal.setFont(new Font("system",Font.BOLD,16));
            informationPanel.add(bartokenVal);

            JLabel bartokenDash = new JLabel("_______________________________________________________________________________________________________");
            bartokenDash.setBounds(150,410+50+50+50+50,670,20);
            bartokenDash.setForeground(Color.GRAY);
            informationPanel.add(bartokenDash);
        }


        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Profile("6400520604");
    }
}
