package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Используем массив на 3 элемента вместо 3 хаданных переменных
        Point3d[] points = new Point3d[3];
        double x,y,z;
        String coord;
        for (int i=0; i<3; i++){
            //Создаем 3 точки с заданными координатами
            System.out.println("Введите через пробел значения " + (int) (i+1) + " точки: ");
            coord = input.nextLine();
            x = Double.parseDouble(coord.split("\s")[0]);
            y = Double.parseDouble(coord.split("\s")[1]);
            z = Double.parseDouble(coord.split("\s")[2]);
            points[i] = new Point3d(x,y,z);
        }
        //Вычисляем площадь
        if (points[0].compare(points[1]) || points[1].compare(points[2]) || points[2].compare(points[0])){
            System.out.println("Некоторые точки совпадают!");
        }
        else System.out.println("Площадь треугольника: " + computeArea(points[0], points[1], points[2]));
    }
    public static int computeArea(Point3d one, Point3d two, Point3d three){
        //Вычисление площади через формулу Гирона
        double a = one.distanceTo(two);
        double b = two.distanceTo(three);
        double c = three.distanceTo(one);
        double P = (a+b+c)/2;
        double S = Math.sqrt(P*(P-a)*(P-b)*(P-c));
        return (int) Math.round(S);
    }
}