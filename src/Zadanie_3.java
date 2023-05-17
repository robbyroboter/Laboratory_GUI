import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.jfree.chart.*;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.math.*;

import static java.lang.Math.*;

public class Zadanie_3 extends JFrame {
    JButton b1,b2,b3,b4;
    JLabel l1, l2,l3,l4,l5,l6;
    JTextField t1, t2;
    String S;
    double x1,x2,f,x;
    eWork knopa=new  eWork();
    JFrame frame=new JFrame("MinimalStaticChart");

    // Настройка будущего поля
    public Zadanie_3 (String s) {
        super(s);
        setLayout(new FlowLayout());
        b1 =new JButton("Очистить");
        b2 =new JButton("Вычислить");
        b3 = new JButton("График");
        b4 = new JButton("Закрыть диаграмму");
        l1 =new JLabel("Вычислить f(x)=x^2cos(x)+sin(x^2)");
        l2 =new JLabel("Введите x слева:");
        l3 =new JLabel("Введите x справа:");
        l4 = new JLabel("          ");
        l5 = new JLabel("       ");
        l6 = new JLabel("   ");
        t1 = new JTextField(10);
        t2 = new JTextField(10);

        add(l2);
        add(t1);
        add(l4);
        add(b3);
        add(l3);
        add(t2);
        add(l6);
        add(l5);
        add(b4);
        add(l1);
        add(l6);
        add(b2);
        add(b1);

        b1.addActionListener(knopa);
        b2.addActionListener(knopa);
        b3.addActionListener(knopa);
        b4.addActionListener(knopa);
    }

    // Задание параметров полю
    public static void main(String args[]) {
        Zadanie_3 g = new Zadanie_3("Задание 3");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(450, 200);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
    }

    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==b1) {
                    t1.setText(null);
                    t2.setText(null);
                }

                if (e.getSource()==b2) {
                    x1=Double.parseDouble(t1.getText());
                    x2=Double.parseDouble(t2.getText());
                    x=(x2-x1);
                    f=(pow(x, 2) * cos(x)) + sin(pow(x, 2));
                    S=" f(x)= "+f;
                    JOptionPane.showMessageDialog(null,S);
                }
                if (e.getSource()==b3) {
                    double delta=0.5;
                    x1=Double.parseDouble(t1.getText());
                    x2=Double.parseDouble(t2.getText());
                    XYSeries series=new XYSeries("(pow(x, 2) * cos(x)) + sin(pow(x, 2))");
                    for (double i=x-delta;i<=x+delta;i+=2*delta/100){
                        series.add(i,(pow(x, 2) * cos(x)) + sin(pow(x, 2)));
                    }
                    XYDataset xyDataset=new XYSeriesCollection(series);
                    JFreeChart chart=ChartFactory.createXYLineChart("(pow(x, 2) * cos(x)) + sin(pow(x, 2))","x","(pow(x, 2) * cos(x)) + sin(pow(x, 2))",xyDataset, PlotOrientation.VERTICAL,true,true,true);

                    //Настройка диаграммы
                    chart.setBackgroundPaint(Color.white);
                    Plot plot=chart.getPlot();
                    plot.setBackgroundPaint(Color.white);
                    ((XYPlot)plot).setDomainGridlinePaint(Color.black);
                    ((XYPlot)plot).setRangeGridlinePaint(Color.black);
                    XYLineAndShapeRenderer renderer=(XYLineAndShapeRenderer) ((XYPlot)plot).getRenderer();
                    renderer.setSeriesPaint(0,Color.black);
                    renderer.setSeriesStroke(0,new BasicStroke(4.0f));
                    frame.getContentPane().add(new ChartPanel(chart));
                    frame.setSize(600,600);
                    frame.setVisible(true);
                }
                if (e.getSource()==b4){
                    frame.dispose();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Введите интервал в числовом формате");
            }
        }
    }
}
