import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Zadanie_1 extends JFrame {
    JButton b1,b2;
    JLabel l1, l2;
    JTextField t1, t2;
    String str,path;
    eWork knopa=new  eWork();

    // Настройка будущего поля
    public Zadanie_1 (String s) {
        super(s);
        setLayout(new FlowLayout());
        b1 =new JButton("Записать");
        b2 =new JButton("Очистить");

        l1 =new JLabel("Введите строку");
        l2 =new JLabel("Введите путь к файлу");
        //D:\\практика вуз\\Информатика\\Lab_GUI_files\\Zadanie_1.txt
        t1 =new JTextField(30);
        t1.setDocument(new JTextFieldLimit(25));

        t2 =new JTextField(40);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);

        b1.addActionListener(knopa);
        b2.addActionListener(knopa);
    }

    // Задание параметров полю
    public static void main(String args[]) {
        Zadanie_1 g = new Zadanie_1("Задание 1");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(480, 250);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
    }

    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==b1) {
                    str = t1.getText();
                    path = t2.getText();
                    //Переменные для записи данных в файл
                    File file=new File(path);
                    FileOutputStream file_Out_Str=new FileOutputStream(file,true);
                    OutputStreamWriter fWr = new OutputStreamWriter(file_Out_Str);
                    BufferedWriter file_BW = new BufferedWriter(fWr);

                    file_BW.write(str);
                    file_BW.newLine();
                    file_BW.close();
                }

                if (e.getSource()==b2) {
                    t1.setText(null);
                    t2.setText(null);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Введите путь и строку");
            }
        }
    }

    // для лимитирования ввода символов
    public class JTextFieldLimit extends PlainDocument {
        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }
}

