package com.company;

public class Point3d extends Point2d {
    /** трехмерный класс точки **/
    private double zCoord;

    /** Конструктор инициализации **/
    public Point3d (double x, double y, double z) {
        super(x,y);
        zCoord = z;
    }

    /** Конструктор по умолчанию **/
    public Point3d () {
        //Вызовите конструктор с двумя параметрами и определите источник.
        this(0.0, 0.0, 0.0);
    }
    /** Получение значений координат точки **/
    public double getZ () {
        return zCoord;
    }
    /** Установка значений координат точки **/
    public void setZ ( double val) {
        zCoord = val;
    }
    /** Сравнение 2 точек **/
    public boolean compare (Point3d point){
        return super.getX() == point.getX() && super.getY() == point.getY() && this.zCoord == point.getZ();
    }

    /** Расстояние между 2 точками **/
    public double distanceTo (Point3d point){
        double xOne = super.getX();
        double yOne = super.getY();
        double zOne = this.zCoord;
        double xTwo = point.getX();
        double yTwo = point.getY();
        double zTwo = point.getZ();
        double distance = Math.sqrt(Math.pow(xOne-xTwo,2)+Math.pow(yOne-yTwo,2)+Math.pow(zOne-zTwo,2));
        return distance;
    }
}


//package labwork.lab2;
//
//public class Point3d  {
//    /** трехмерный класс точки **/
//    private double xCoord;
//    private double yCoord;
//    private double zCoord;
//
//    /** Конструктор инициализации **/
//    public Point3d ( double x, double y, double z) {
//        xCoord = x;
//        yCoord = y;
//        zCoord = z;
//    }
//
//    /** Конструктор по умолчанию **/
//    public Point3d () {
//        //Вызовите конструктор с двумя параметрами и определите источник.
//        this(0.0, 0.0, 0.0);
//    }
//    /** Получение значений координат точки **/
//    public double getX () {
//        return xCoord;
//    }
//    public double getY () {
//        return yCoord;
//    }
//    public double getZ () {
//        return zCoord;
//    }
//    /** Установка значений координат точки **/
//    public void setX ( double val) {
//        xCoord = val;
//    }
//    public void setY ( double val) {
//        yCoord = val;
//    }
//    public void setZ ( double val) {
//        zCoord = val;
//    }
//    /** Сравнение 2 точек **/
//    public boolean compare (Point3d point){
//        return this.xCoord == point.getX() && this.yCoord == point.getY() && this.zCoord == point.getZ();
//    }
//
//    /** Расстояние между 2 точками **/
//    public double distanceTo (Point3d point){
//        double xOne = this.xCoord;
//        double yOne = this.yCoord;
//        double zOne = this.zCoord;
//        double xTwo = point.getX();
//        double yTwo = point.getY();
//        double zTwo = point.getZ();
//        double distance = Math.sqrt(Math.pow(xOne-xTwo,2)+Math.pow(yOne-yTwo,2)+Math.pow(zOne-zTwo,2));
//        return distance;
//    }
//}
