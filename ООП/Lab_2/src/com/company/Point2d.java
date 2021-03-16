package com.company;

public class Point2d {
    /** двумерный класс точки **/
    private double xCoord;
    private double yCoord;

    /** Конструктор инициализации **/
    public Point2d ( double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    /** Конструктор по умолчанию **/
    public Point2d () {
        //Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }
    /** Получение значений координат точки **/
    public double getX () {
        return xCoord;
    }
    public double getY () {
        return yCoord;
    }
    /** Установка значений координат точки **/
    public void setX ( double val) {
        xCoord = val;
    }
    public void setY ( double val) {
        yCoord = val;
    }
}