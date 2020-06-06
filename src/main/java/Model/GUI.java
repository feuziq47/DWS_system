package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame{
    private JPanel background;
    private JButton A,B,C,D;
    private JLabel watch;
    private JTextField textField1, textField2, textField3;

    public GUI(){
        this.setTitle("DWS");
        this.setSize(600,650);

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
                System.out.println("A");
            }
        });
        B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("B");
            }
        });
        C.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("C");
            }
        });
        D.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("D");
            }
        });

        Color color = new Color(242,242,242);
        textField1.setBounds(50,200,120,100);
        textField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField1.setText("KOR");
        textField1.setBackground(color);

        textField2.setBounds(180,200,190,100);
        textField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField2.setText("01:17:12");
        textField2.setBackground(color);

        textField3.setBounds(50,320,300,100);
        textField3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField3.setText("----");
        textField3.setBackground(color);


        watch.add(textField1);
        watch.add(textField2);
        watch.add(textField3);

        background.add(watch);
        background.add(A);
        background.add(B);
        background.add(C);
        background.add(D);

        this.add(background);
        this.setVisible(true);
    }

}
