import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Zadanie_2 extends JFrame {

    String line;
    ArrayList<Object> list = new ArrayList<>();

    JButton b1, b2, b3,b4;
    JLabel l1, l2,l3, l4,l5;
    JTextField t1, t2,t3,t4,t5;
    String name, surname, fathersname, date, study;
    eWork knopa = new eWork();


    // Настройка будущего поля
    public Zadanie_2(String s){
        super(s);
        setLayout(new FlowLayout());
        b1 = new JButton("Записать");
        b2 = new JButton("Скрыть");
        b3 = new JButton("Загрузить");
        b4 = new JButton("Открыть форму");

        l1 = new JLabel("Имя");
        l2 = new JLabel("Фамилия");
        l3 = new JLabel("Отчество");
        l4 = new JLabel("Дата рождения");
        l5 = new JLabel("Учебное заведение");


        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);


        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);

        add(b4);
        add(b2);
        add(b1);
        add(b3);

        //Делать невидимыми
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        l5.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);
        t4.setVisible(false);
        t5.setVisible(false);

        b1.addActionListener(knopa);
        b2.addActionListener(knopa);
        b3.addActionListener(knopa);
        b4.addActionListener(knopa);
    }

    // Задание параметров полю
    public static void main(String args[]) {
        Zadanie_2 g = new Zadanie_2("Задание 2");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(150, 400);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
    }

    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == b1) {
                    File file = new File("D:\\практика вуз\\Информатика\\Lab_GUI_files\\Zadanie_2.txt");


                    //Переменные для записи данных в файл
                    FileOutputStream file_Out_Str = new FileOutputStream(file, true);
                    OutputStreamWriter fWr = new OutputStreamWriter(file_Out_Str);
                    BufferedWriter file_BW = new BufferedWriter(fWr);

                    name = t1.getText();
                    surname = t2.getText();
                    fathersname = t3.getText();
                    date = t4.getText();
                    study = t5.getText();


                    file_BW.write(name+";"+surname+";"+fathersname+";"+date+";"+study);
                    file_BW.newLine();
                    file_BW.close();
                }

                if (e.getSource() == b3) {
                    File file = new File("D:\\практика вуз\\Информатика\\Lab_GUI_files\\Zadanie_2.txt");

                    //Переменные для чтения файла
                    FileInputStream file_In_Str  = new FileInputStream(file);
                    InputStreamReader fRe=new InputStreamReader(file_In_Str);
                    BufferedReader file_BR = new BufferedReader(fRe);

                    while((line = file_BR.readLine()) != null) {

                        String[] str=line.split(";");
                        Collections.addAll(list, str);
                    }

                    //Перевод листа в массив строк
                    String[] array = list.toArray(new String[list.size()]);


                    //Задание текста полям ввода
                    t1.setText(array[0]);
                    t2.setText(array[1]);
                    t3.setText(array[2]);
                    t4.setText(array[3]);
                    t5.setText(array[4]);
                }

                if (e.getSource() == b2) {
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                    t4.setText(null);
                    t5.setText(null);

                    l1.setVisible(false);
                    l2.setVisible(false);
                    l3.setVisible(false);
                    l4.setVisible(false);
                    l5.setVisible(false);

                    t1.setVisible(false);
                    t1.revalidate();
                    t1.repaint();
                    t2.setVisible(false);
                    t2.revalidate();
                    t2.repaint();
                    t3.setVisible(false);
                    t3.revalidate();
                    t3.repaint();
                    t4.setVisible(false);
                    t4.revalidate();
                    t4.repaint();
                    t5.setVisible(false);
                    t5.revalidate();
                    t5.repaint();
                }

                if (e.getSource() == b4) {

                    l1.setVisible(true);
                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    l5.setVisible(true);

                    t1.setVisible(true);
                    t1.revalidate();
                    t1.repaint();
                    t2.setVisible(true);
                    t2.revalidate();
                    t2.repaint();
                    t3.setVisible(true);
                    t3.revalidate();
                    t3.repaint();
                    t4.setVisible(true);
                    t4.revalidate();
                    t4.repaint();
                    t5.setVisible(true);
                    t5.revalidate();
                    t5.repaint();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Заполните пустые поля");
            }
        }
    }
}
