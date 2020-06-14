package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame{
    private JPanel background;
    private JButton A,B,C,D;
    private JLabel watch;
    private JTextField textField1, textField2, textField3,textField4,textField5,textField6,textField7,textField8;
    private DWS_controller dws;
    private ImageIcon img;

    public GUI(DWS_controller dws_controller){
        dws=dws_controller;
        this.setTitle("DWS");
        this.setSize(600,650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        img = new ImageIcon("C:\\Users\\feuzi\\IdeaProjects\\DWS_system\\src\\main\\resources\\clock.png");

        background = new JPanel();
        background.setSize(500,650);
        A = new JButton("A");
        B = new JButton("B");
        C = new JButton("C");
        D = new JButton("D");


        textField1= new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        watch = new JLabel(img);
        watch.setBounds(90,135, 400,370);
        watch.setBackground(Color.getHSBColor(64,85,85));
        watch.setOpaque(true);

        background.setLayout(null);

        // BUTTON
        A.setBounds(20,200,60,60);
        B.setBounds(500,200,60,60);
        C.setBounds(20,350,60,60);
        D.setBounds(500,350,60,60);

        A.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dws.pressButton(0);
            }
        });
        B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dws.pressButton(1);
            }
        });
        C.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dws.pressButton(2);
            }
        });
        D.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dws.pressButton(3);
            }
        });

        Color color=Color.getHSBColor(64,85,85);
        textField1.setBounds(35,60,120,100);
        textField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField1.setFont(new Font("Serif",Font.BOLD,30));
        textField1.setBackground(color);

        textField2.setBounds(165,60,70,100);
        textField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setFont(new Font("Serif",Font.BOLD,30));
        textField2.setBackground(color);

        textField3.setBounds(235,60,40,100);
        textField3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField3.setHorizontalAlignment(JTextField.CENTER);
        textField3.setFont(new Font("Serif",Font.BOLD,30));
        textField3.setBackground(color);

        textField4.setBounds(275,60,40,100);
        textField4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField4.setHorizontalAlignment(JTextField.CENTER);
        textField4.setFont(new Font("Serif",Font.BOLD,30));
        textField4.setBackground(color);

        textField5.setBounds(315,60,60,100);
        textField5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField5.setHorizontalAlignment(JTextField.CENTER);
        textField5.setFont(new Font("Serif",Font.BOLD,30));
        textField5.setBackground(color);

        textField6.setBounds(40,180,110,120);
        textField6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField6.setHorizontalAlignment(JTextField.CENTER);
        textField6.setFont(new Font("Serif",Font.BOLD,40));
        textField6.setBackground(color);

        textField7.setBounds(150,180,110,120);
        textField7.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField7.setHorizontalAlignment(JTextField.CENTER);
        textField7.setFont(new Font("Serif",Font.BOLD,40));
        textField7.setBackground(color);

        textField8.setBounds(260,180,110,120);
        textField8.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField8.setHorizontalAlignment(JTextField.CENTER);
        textField8.setFont(new Font("Serif",Font.BOLD,40));
        textField8.setBackground(color);




        watch.add(textField1);
        watch.add(textField2);
        watch.add(textField3);
        watch.add(textField4);
        watch.add(textField5);
        watch.add(textField6);
        watch.add(textField7);
        watch.add(textField8);

        background.add(watch);
        background.add(A);
        background.add(B);
        background.add(C);
        background.add(D);

        this.add(background);
        this.setVisible(true);
    }

    public void setDisplay1(String world){ textField1.setText(world); }
    public void setDisplay2(String currentYear){ textField2.setText(currentYear); }
    public void setDisplay3(String currentMonth) {textField3.setText(currentMonth);}
    public void setDisplay4(String currentDay) {textField4.setText(currentDay);}
    public void setDisplay5(String currentHour){ textField5.setText(currentHour); }
    public void setDisplay6(String currentMinute){ textField6.setText(currentMinute); }
    public void setDisplay7(String currentSecond){ textField7.setText(currentSecond); }
    public void setDisplay8(String str){ textField8.setText(str); }


    public JTextField getTextField(int i) {
        JTextField temp=null;
        switch (i) {
            case 1:
                temp=textField1;
                break;
            case 2:
                temp=textField2;
                break;
            case 3:
                temp=textField3;
                break;
            case 4:
                temp=textField4;
                break;
            case 5:
                temp=textField5;
                break;
            case 6:
                temp=textField6;
                break;
            case 7:
                temp=textField7;
                break;
            case 8:
                temp=textField8;
                break;
            default:
                break;
        }
        return temp;
    }
    public void setRed(JTextField jTextField){ jTextField.setForeground(Color.RED); }
    public void setBlack(JTextField jTextField){ jTextField.setForeground(Color.BLACK); }

    public JLabel getWatch() {
        return watch;
    }
    public void watchBLC(int i){
        switch(i){
            case 0:
                watch.setBackground(Color.getHSBColor(64,85,85));
                textField1.setBackground(Color.getHSBColor(64,85,85));
                textField2.setBackground(Color.getHSBColor(64,85,85));
                textField3.setBackground(Color.getHSBColor(64,85,85));
                textField4.setBackground(Color.getHSBColor(64,85,85));
                textField5.setBackground(Color.getHSBColor(64,85,85));
                textField6.setBackground(Color.getHSBColor(64,85,85));
                textField7.setBackground(Color.getHSBColor(64,85,85));
                textField8.setBackground(Color.getHSBColor(64,85,85));
                watch.setOpaque(true);

                break;
            case 1:
                watch.setBackground(Color.getHSBColor(64,60,60));
                textField1.setBackground(Color.getHSBColor(64,60,60));
                textField2.setBackground(Color.getHSBColor(64,60,60));
                textField3.setBackground(Color.getHSBColor(64,60,60));
                textField4.setBackground(Color.getHSBColor(64,60,60));
                textField5.setBackground(Color.getHSBColor(64,60,60));
                textField6.setBackground(Color.getHSBColor(64,60,60));
                textField7.setBackground(Color.getHSBColor(64,60,60));
                textField8.setBackground(Color.getHSBColor(64,60,60));

                watch.setOpaque(true);

                break;
            case 2:
                watch.setBackground(Color.getHSBColor(64,50,50));
                textField1.setBackground(Color.getHSBColor(64,50,50));
                textField2.setBackground(Color.getHSBColor(64,50,50));
                textField3.setBackground(Color.getHSBColor(64,50,50));
                textField4.setBackground(Color.getHSBColor(64,50,50));
                textField5.setBackground(Color.getHSBColor(64,50,50));
                textField6.setBackground(Color.getHSBColor(64,50,50));
                textField7.setBackground(Color.getHSBColor(64,50,50));
                textField8.setBackground(Color.getHSBColor(64,50,50));
                watch.setOpaque(true);

                break;
            case 3:
                watch.setBackground(Color.getHSBColor(64,90,90));
                textField1.setBackground(Color.getHSBColor(64,90,90));
                textField2.setBackground(Color.getHSBColor(64,90,90));
                textField3.setBackground(Color.getHSBColor(64,90,90));
                textField4.setBackground(Color.getHSBColor(64,90,90));
                textField5.setBackground(Color.getHSBColor(64,90,90));
                textField6.setBackground(Color.getHSBColor(64,90,90));
                textField7.setBackground(Color.getHSBColor(64,90,90));
                textField8.setBackground(Color.getHSBColor(64,90,90));

                watch.setOpaque(true);

                break;
            default:
                return;
        }
    }

}