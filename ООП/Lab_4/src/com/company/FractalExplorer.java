package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

/**
 * This class is dedicated to let the user explore different fractal areas**/
public class FractalExplorer {
    private final int displaySize;
    private final JImageDisplay display;
    private final FractalGenerator fractalGenerator;
    private final Rectangle2D.Double range;

    /** Class constructor**/
    public FractalExplorer(int size) {
        displaySize = size;
        /* инициализация FractalGenerator и ранжированных объектов. */
        fractalGenerator = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractalGenerator.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);
    }

    /**Generates and displays GUI**/
    public void createAndShowGUI()
    {
        /* Настройки для использования BorderLayout в данном случае. **/
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("фракталы лаба 4");

        /* Выравнивание изображения по центру дисплея*/
        frame.add(display, BorderLayout.CENTER);

        /* Кнопка ресета. */
        JButton resBut = new JButton("вернуть обратнго");

        /* ресет при нажатии кнопки ресета. */
        Reset handler = new Reset();
        resBut.addActionListener(handler);

        /* выключает кнопку */
        frame.add(resBut, BorderLayout.SOUTH);

        /* клик мышью для увеличения. */
        Mouse click = new Mouse();
        display.addMouseListener(click);

        /* закрытие фрэйма по умолчанию */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* упаковывает изображение в окно */
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Displays the fractal. Loops through every pixel and sets its color depending on iterations number.
     * Then repaints JImageDisplay with all the new pixels
     */
    private void drawFractal()
    {
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){
                /* Find the coordinates xCoord and yCoord in the fractal's display area */
                double xCoord = FractalGenerator.getCoord(range.x,
                        range.x + range.width, displaySize, x);
                double yCoord = FractalGenerator.getCoord(range.y,
                        range.y + range.height, displaySize, y);
                /* Compute the number of iterations in the display area*/
                int iteration = fractalGenerator.numIterations(xCoord, yCoord);
                if (iteration == -1){
                    display.drawPixel(x, y, 0);
                }
                else {
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    /* Update the display with new pixels */
                    display.drawPixel(x, y, rgbColor);
                }
            }
        }
        /* Repaint JImageDisplay to match current contents of its image */
        display.repaint();
    }

    private class Reset implements ActionListener{
        /* Resets the range to the intial range and draws the fractal */
        public void actionPerformed(ActionEvent e) {
            fractalGenerator.getInitialRange(range);
            drawFractal();
        }
    }

    /**
    * Class dedicated to handle MouseListener events
     */
    private class Mouse extends MouseAdapter {
        /**
         * Having received a mouse click method maps the pixel that was clicked and calls recenterAndZoomRange()
         * Then redraws the fractal
         * **/
        public void mouseClicked(MouseEvent e) {
            /* Gets x coordinate of mouse click. */
            int x = e.getX();
            double xCoord = FractalGenerator.getCoord(range.x,
                    range.x + range.width, displaySize, x);

            /* Gets y coordinate of mouse click. */
            int y = e.getY();
            double yCoord = FractalGenerator.getCoord(range.y,
                    range.y + range.height, displaySize, y);
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    /**
     * Launches FractalExplorer
     */
    public static void main(String[] args) {
        FractalExplorer display = new FractalExplorer(400);
        display.createAndShowGUI();
        display.drawFractal();
    }
}
