import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MiniStatement extends JFrame {
    JLabel dashboardI,changeMp,changePass,account,contactUs,logout;
    MiniStatement()
    {
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

        JMenuBar mini = new JMenuBar();
        mini.setBounds(350,60,d.width-350,50);
        mini.setBackground(Color.gray);
        mini.setLayout(null);
        add(mini);
        JLabel lblMini = new JLabel("Mini Statement");
        lblMini.setFont(new Font("System",Font.BOLD,18));
        lblMini.setForeground(Color.WHITE);
        lblMini.setBounds(700,10,300,30);
        mini.add(lblMini);

        JPanel information = new JPanel();
        information.setBounds(350+380,110+30,800,250);
        information.setBackground(Color.WHITE);
        add(information);

        JMenuBar stat = new JMenuBar();
        stat.setBounds(350+380,60+250+50+30+30,800,30);
        stat.setBackground(Color.gray);
        stat.setLayout(null);
        add(stat);


        JPanel statement = new JPanel();
        statement.setLayout(null);


        JLabel a1 = new JLabel("Account                             Date                                Time                                Amount                              Type");
        a1.setBounds(5,2,800,20);
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("system",Font.BOLD,16));
        stat.add(a1);

        JScrollPane j = new JScrollPane(statement);
        j.setBounds(350+380,60+250+50+30+60,800,500);
        j.setBackground(Color.WHITE);
        add(j);
        JLabel ffddf = new JLabel("kdfsdkfksdmkd");
        ffddf.setBounds(22,200,100,20);
        j.setLayout(null);
        j.add(ffddf);






        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MiniStatement();
    }
}
