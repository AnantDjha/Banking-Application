import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class OpenAccount2 extends JFrame implements KeyListener,ActionListener{
    JLabel religion , category,income,qualification,occupation,pan,aadhar,alert;
    JTextField tReligion , tCategory,tIncome,tQualification,tOccupation,tPan,tAadhar;
    JCheckBox atmCard,internetBanking,mobileBanking,eStat,cheque,sms,declare;
    JButton cancel,submit;
    OpenAccount2(String [] transfer)
    {
        Random r = new Random();
        long account = r.nextLong(1000000000,10000000000L);
        long card = r.nextLong(10000000000000L,100000000000000L);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        JPanel frame = new JPanel();
        frame.setBounds(510,250,880,600);
        frame.setBorder(new LineBorder(Color.BLACK));
        frame.setLayout(null);
        add(frame);

        religion = new JLabel("Religion:");
        religion.setBounds(50,50,150,30);
        religion.setFont(new Font("rale-way",Font.BOLD,20));
        frame.add(religion);

        alert = new JLabel("** All fields are mandatory");
        alert.setBounds(350,5,200,30);
        alert.setForeground(Color.red);
        alert.setFont(new Font("",Font.BOLD,14));
        frame.add(alert);
        alert.setVisible(false);

        tReligion = new JTextField();
        tReligion.setBounds(160+50,50,200,30);
        tReligion.setFont(new Font("",Font.BOLD,17));
        frame.add(tReligion);

        category = new JLabel("Category:");
        category.setBounds(460,50,150,30);
        category.setFont(new Font("rale-way",Font.BOLD,20));
        frame.add(category);
        tCategory = new JTextField();
        tCategory.setBounds(570+50,50,200,30);
        tCategory.setFont(new Font("",Font.BOLD,17));
        frame.add(tCategory);

        qualification = new JLabel("Qualification:");
        qualification.setBounds(50,100,150,30);
        qualification.setFont(new Font("rale-way",Font.BOLD,20));
        frame.add(qualification);
        tQualification = new JTextField();
        tQualification.setBounds(160+50,100,200,30);
        tQualification.setFont(new Font("",Font.BOLD,17));
        frame.add(tQualification);

        occupation = new JLabel("Occupation:");
        occupation.setBounds(460,100,150,30);
        occupation.setFont(new Font("rale-way",Font.BOLD,20));
        frame.add(occupation);
        tOccupation = new JTextField();
        tOccupation.setBounds(570+50,100,200,30);
        tOccupation.setFont(new Font("",Font.BOLD,17));
        frame.add(tOccupation);


        pan = new JLabel("PAN:");
        pan.setBounds(50,150,150,30);
        pan.setFont(new Font("rale-way",Font.BOLD,20));
        frame.add(pan);
        tPan = new JTextField();
        tPan.setBounds(160+50,150,200,30);
        tPan.setFont(new Font("",Font.BOLD,17));
        frame.add(tPan);

        aadhar = new JLabel("Aadhaar no:");
        aadhar.setBounds(460,150,150,30);
        aadhar.setFont(new Font("rale-way",Font.BOLD,20));
        frame.add(aadhar);
        tAadhar = new JTextField();
        tAadhar.setBounds(570+50,150,200,30);
        tAadhar.setFont(new Font("",Font.BOLD,17));
        frame.add(tAadhar);

        income = new JLabel("Income:");
        income.setBounds(50,200,150,30);
        income.setFont(new Font("rale-way",Font.BOLD,20));
        frame.add(income);
        tIncome = new JTextField();
        tIncome.setBounds(160+50,200,200,30);
        tIncome.setFont(new Font("",Font.BOLD,17));
        frame.add(tIncome);

        JLabel service = new JLabel("Service Required");
        service.setBounds(50,270,200,30);
        service.setFont(new Font("rale-way",Font.BOLD,20));
        frame.add(service);
        atmCard = new JCheckBox("ATM card");
        atmCard.setBounds(100,310,150,30);
        atmCard.setFont(new Font("Time New Roman",Font.BOLD,16));
        frame.add(atmCard);

        mobileBanking = new JCheckBox("Mobile banking");
        mobileBanking.setBounds(100,360,150,30);
        mobileBanking.setFont(new Font("Time New Roman",Font.BOLD,16));
        frame.add(mobileBanking);

        cheque = new JCheckBox("Cheque Book");
        cheque.setBounds(100,410,150,30);
        cheque.setFont(new Font("Time New Roman",Font.BOLD,16));
        frame.add(cheque);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(300,310,160,30);
        internetBanking.setFont(new Font("Time New Roman",Font.BOLD,16));
        frame.add(internetBanking);

        eStat = new JCheckBox("E-Statement");
        eStat.setBounds(300,360,150,30);
        eStat.setFont(new Font("Time New Roman",Font.BOLD,16));
        frame.add(eStat);

        sms = new JCheckBox("Email alert");
        sms.setBounds(300,410,150,30);
        sms.setFont(new Font("Time New Roman",Font.BOLD,16));
        frame.add(sms);

        declare = new JCheckBox("I hereby declare that the above mentioned detail is correct");
        declare.setBounds(50,500,400,20);
        declare.setFont(new Font("",Font.BOLD,13));
        frame.add(declare);
        declare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(declare.isSelected())
                {
                    submit.setBackground(Color.BLUE);
                    submit.setForeground(Color.WHITE);
                    submit.setEnabled(true);
                }
                else{
                    submit.setBackground(Color.gray);
                    submit.setForeground(Color.WHITE);
                    submit.setEnabled(false);
                }
            }
        });

        cancel = new JButton("back");
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.white);
        cancel.setBounds(590,500,100,30);
        frame.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OpenAccount1();
                setVisible(false);
            }
        });
        submit = new JButton("Submit");
        submit.setBackground(Color.GRAY);
        submit.setForeground(Color.white);
        submit.setBounds(700,500,100,30);
        submit.setEnabled(false);
        frame.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sAccount = account+"";
                String sCard = card+"";
                String sReligion = tReligion.getText().toLowerCase();
                String sCategory = tCategory.getText().toLowerCase();
                String sIncome = tIncome.getText().toLowerCase();
                String sQualify = tQualification.getText().toLowerCase();
                String sOccu = tOccupation.getText().toLowerCase();
                String sPan = tPan.getText().toLowerCase();
                String sAadhar = tAadhar.getText().toLowerCase();
                String sService = "";
                if(atmCard.isSelected())
                {
                    sService = sService+atmCard.getText()+" ";
                }if(internetBanking.isSelected())
                {
                    sService = sService+internetBanking.getText()+" ";
                }if(mobileBanking.isSelected())
                {
                    sService = sService+mobileBanking.getText()+" ";
                }if(eStat.isSelected())
                {
                    sService = sService+eStat.getText()+" ";
                }if(cheque.isSelected())
                {
                    sService = sService+cheque.getText()+" ";
                }if(sms.isSelected())
                {
                    sService = sService+sms.getText()+" ";
                }

                if(sReligion.isBlank())
                {
                    alert.setVisible(true);

                } else if (sCategory.isBlank()) {
                    alert.setVisible(true);


                }else if (sIncome.isBlank()) {
                    alert.setVisible(true);

                }else if (sQualify.isBlank()) {
                    alert.setVisible(true);

                }else if (sOccu.isBlank()) {
                    alert.setVisible(true);

                }else if (sPan.isBlank()) {
                    alert.setVisible(true);

                }else if (sAadhar.isBlank()) {
                    alert.setVisible(true);

                }else if (sService.isBlank()) {
                    alert.setVisible(true);

                }
                else {
                    try
                    {
                        String q = "insert into userInformation values('"+transfer[0]+"','"+transfer[1]+"','"+transfer[2]+"'," +
                                "'"+transfer[3]+"','"+transfer[4]+"','"+transfer[5]+"','"+transfer[6]+"','"+transfer[7]+"','"+sReligion+"','"+sCategory+"'," +
                                "'"+sIncome+"','"+sQualify+"','"+sOccu+"','"+sPan+"','"+sAadhar+"','"+sService+"','"+sAccount+"','"+sCard+"')";
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "Anant@2004");
                        PreparedStatement smt = c.prepareStatement(q);
                        smt.executeUpdate();
                        JOptionPane.showMessageDialog(frame,"Account :"+sAccount);
                        new Login();
                        new Deposit(sAccount,transfer[0]);
                        setVisible(false);
                    }
                    catch(Exception x)
                    {
                        x.printStackTrace();
                    }
                }
            }
        });
        tReligion.addKeyListener(this);
        tCategory.addKeyListener(this);
        tAadhar.addKeyListener(this);
        tPan.addKeyListener(this);
        tIncome.addKeyListener(this);
        tOccupation.addKeyListener(this);
        tQualification.addKeyListener(this);

        atmCard.addActionListener(this);
        mobileBanking.addActionListener(this);
        eStat.addActionListener(this);
        internetBanking.addActionListener(this);
        cheque.addActionListener(this);
        sms.addActionListener(this);

        setLayout(null);
        setVisible(true);

    }
    public void keyTyped(KeyEvent e)
    {
        alert.setVisible(false);
    }
    public void keyReleased(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e)
    {

    }
    public void actionPerformed(ActionEvent e)
    {
        alert.setVisible(false);

    }
    public static void main(String[] args) {
        new OpenAccount2(new String[]{""});
    }
}
