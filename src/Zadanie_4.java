import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.util.Random;

public class Zadanie_4 extends JFrame {
    Random rand=new Random();
    JButton b1;
    JLabel l1, l2, l3,l4, l5, l6,l7, l8,l9;
    JTextField t1, t2, t3, t4, t5, t6,t7;
    eWork knopa=new  eWork();

    // Настройка будущего поля
    public Zadanie_4 (String s) {
        super(s);
        setLayout(new FlowLayout());
        b1 =new JButton("Записать");

        l1 =new JLabel("Вывести 7 случайных чисел");
        l2=new JLabel("                                       ");
        l3=new JLabel("                                                                      ");
        l4=new JLabel("                                                                      ");
        l5=new JLabel("                                                                      ");
        l6=new JLabel("                                                                      ");
        l7=new JLabel("                                                                      ");
        l8=new JLabel("                                                                      ");
        l9=new JLabel("                                       ");
        t1 =new JTextField(5);
        t2 =new JTextField(5);
        t3 =new JTextField(5);
        t4 =new JTextField(5);
        t5 =new JTextField(5);
        t6 =new JTextField(5);
        t7 =new JTextField(5);

        t1.disable();
        t2.disable();
        t3.disable();
        t4.disable();
        t5.disable();
        t6.disable();
        t7.disable();

        add(l1);
        add(l2);
        add(b1);
        add(l9);
        add(t1);
        add(l3);
        add(t2);
        add(l4);
        add(t3);
        add(l5);
        add(t4);
        add(l6);
        add(t5);
        add(l7);
        add(t6);
        add(l8);
        add(t7);

        b1.addActionListener(knopa);
    }

    // Задание параметров полю
    public static void main(String args[]) {
        Zadanie_4 g = new Zadanie_4("Задание 4");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(400, 200);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
    }

    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==b1) {
                    t1.setText(Integer.toString(rand.nextInt(10)));
                    t2.setText(Integer.toString(rand.nextInt(10)));
                    t3.setText(Integer.toString(rand.nextInt(10)));
                    t4.setText(Integer.toString(rand.nextInt(10)));
                    t5.setText(Integer.toString(rand.nextInt(10)));
                    t6.setText(Integer.toString(rand.nextInt(10)));
                    t7.setText(Integer.toString(rand.nextInt(10)));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Введите путь и строку");
            }
        }
    }
}
