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

public class Zadanie_5 extends JFrame {

    // Задание параметров полю
    public static void main(String args[]) {
        XYSeries series0=new XYSeries("line0");
        double x=0,y=0,R=3;
        for (double i=-7;i<=-6;i+=0.05){
            series0.add(i,-9*i-58);
        }
        XYSeries series1=new XYSeries("line1");
        for (double i=-6;i<=-2;i+=0.05){
            series1.add(i,-0.5*i-7);
        }
        XYSeries series2=new XYSeries("line2");
        for (double i=-7;i<=1;i+=0.05){
            series2.add(i,-0.125*i+4.125);
        }
        XYSeries series3=new XYSeries("line3");
        for (double i=-4;i<=1;i+=0.05){
            series3.add(i,0.8*i+3.2);
        }
        XYSeries series4=new XYSeries("line4");
        for (double i=-4;i<=-2;i+=0.05){
            series4.add(i,-3*i-12);
        }
        XYSeries series5=new XYSeries("line5");
        for (double i=-7;i<=-2;i+=0.05){
            series5.add(1,i);
        }
        XYSeries series6=new XYSeries("line6");
        for (double i=1;i<=3;i+=0.05){
            series6.add(i,1.5*i-8.5);
        }
        XYSeries series7=new XYSeries("line7");
        for (double i=1;i<=3;i+=0.05){
            series7.add(i,0.5*i-2.5);
        }
        XYSeries series8=new XYSeries("line8");
        for (double i=3;i<=5;i+=0.05){
            series8.add(i,1.5*i-5.5);
        }
        XYSeries series9=new XYSeries("line9");
        for (double i=3;i<=6;i+=0.05){
            series9.add(i,0.33*i-5);
        }
        XYSeries series10=new XYSeries("line10");
        for (double i=5;i<=6;i+=0.05){
            series10.add(i,-5*i+27);
        }

        XYSeriesCollection xyDataset=new XYSeriesCollection();
        //Добавление в коллекцию
        xyDataset.addSeries(series0);
        xyDataset.addSeries(series1);
        xyDataset.addSeries(series2);
        xyDataset.addSeries(series3);
        xyDataset.addSeries(series4);
        xyDataset.addSeries(series5);
        xyDataset.addSeries(series6);
        xyDataset.addSeries(series7);
        xyDataset.addSeries(series8);
        xyDataset.addSeries(series9);
        xyDataset.addSeries(series10);

        JFreeChart chart=ChartFactory.createXYLineChart("Фигуры","x","y=kx+b",xyDataset, PlotOrientation.VERTICAL,true,true,true);

        //Настройка диаграммы
        chart.setBackgroundPaint(Color.white);//Фон диаграммы
        Plot plot=chart.getPlot();
        plot.setBackgroundPaint(Color.white);//Фон области построения диаграммы
        //Цвет линий сетки
        ((XYPlot)plot).setDomainGridlinePaint(Color.black);
        ((XYPlot)plot).setRangeGridlinePaint(Color.black);
        //Цвет рядов данных
        XYLineAndShapeRenderer renderer=(XYLineAndShapeRenderer) ((XYPlot)plot).getRenderer();
        renderer.setSeriesPaint(0,Color.black);
        renderer.setSeriesPaint(1,Color.black);
        renderer.setSeriesPaint(2,Color.black);
        renderer.setSeriesPaint(3,Color.black);
        renderer.setSeriesPaint(4,Color.black);
        renderer.setSeriesPaint(5,Color.black);
        renderer.setSeriesPaint(6,Color.black);
        renderer.setSeriesPaint(7,Color.black);
        renderer.setSeriesPaint(8,Color.black);
        renderer.setSeriesPaint(9,Color.black);
        renderer.setSeriesPaint(10,Color.black);
        renderer.setSeriesStroke(0,new BasicStroke(4.0f));
        renderer.setSeriesStroke(1,new BasicStroke(4.0f));
        renderer.setSeriesStroke(2,new BasicStroke(4.0f));
        renderer.setSeriesStroke(3,new BasicStroke(4.0f));
        renderer.setSeriesStroke(4,new BasicStroke(4.0f));
        renderer.setSeriesStroke(5,new BasicStroke(4.0f));
        renderer.setSeriesStroke(6,new BasicStroke(4.0f));
        renderer.setSeriesStroke(7,new BasicStroke(4.0f));
        renderer.setSeriesStroke(8,new BasicStroke(4.0f));
        renderer.setSeriesStroke(9,new BasicStroke(4.0f));
        renderer.setSeriesStroke(10,new BasicStroke(4.0f));
        //Создание окна для отображения диаграммы
        JFrame frame=new JFrame("График");
        frame.getContentPane().add(new ChartPanel(chart));
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}
