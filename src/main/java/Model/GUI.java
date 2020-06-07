package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame{
    private JPanel background;
    private JButton A,B,C,D;
    private JLabel watch;
    private JTextField textField1, textField2, textField3,textField4,textField5,textField6,textField7;
    private DWS_controller dws;
    public GUI(DWS_controller dws_controller){
        dws=dws_controller;
        this.setTitle("DWS");
        this.setSize(600,650);

        background = new JPanel();
        A = new JButton("A");
        B = new JButton("B");
        C = new JButton("C");
        D = new JButton("D");
        watch = new JLabel();
        textField1= new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        watch.setBounds(90,0,394,600);
        background.setLayout(null);

        // BUTTON
        A.setBounds(31,200,60,60);
        B.setBounds(484,200,60,60);
        C.setBounds(31,350,60,60);
        D.setBounds(484,350,60,60);

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

        Color color = new Color(242,242,242);
        textField1.setBounds(50,200,120,100);
        textField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        textField1.setText("KOR");
        textField1.setBackground(color);

        textField2.setBounds(180,200,40,100);
        textField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        textField2.setText("01:17:12");
        textField2.setBackground(color);

        textField3.setBounds(230,200,20,100);
        textField3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        textField2.setText("01:17:12");
        textField3.setBackground(color);

        textField4.setBounds(260,200,20,100);
        textField4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        textField2.setText("01:17:12");
        textField4.setBackground(color);

        textField5.setBounds(50,320,20,100);
        textField5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        textField3.setText("----");
        textField5.setBackground(color);

        textField6.setBounds(80,320,20,100);
        textField6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        textField3.setText("----");
        textField6.setBackground(color);

        textField7.setBounds(110,320,20,100);
        textField7.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        textField3.setText("----");
        textField7.setBackground(color);



        watch.add(textField1);
        watch.add(textField2);
        watch.add(textField3);
        watch.add(textField4);
        watch.add(textField5);
        watch.add(textField6);
        watch.add(textField7);

        background.add(watch);
        background.add(A);
        background.add(B);
        background.add(C);
        background.add(D);

        this.add(background);
        this.setVisible(true);
    }

    public void setDisplay1(String world){
        textField1.setText(world);
    }

    public void setDisplay2(String currentYear){
        textField2.setText(currentYear);
    }
    public void setDisplay3(String currentMonth) {textField3.setText(currentMonth);}
    public void setDisplay4(String currentDay) {textField4.setText(currentDay);}
    public void setDisplay5(String currentHour){
        textField5.setText(currentHour);
    }
    public void setDisplay6(String currentMinute){
        textField6.setText(currentMinute);
    }
    public void setDisplay7(String currentSecond){
        textField7.setText(currentSecond);
    }

}
