import java.util.*;

public class block3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задания: ");
        String zadanie = sc.nextLine();
        switch (zadanie) {
            case "1" :
                number1(sc);
                break;
            case "2" :
            	System.out.println(number2(sc));
                break;
            case "3" :
                System.out.println(number3(sc));
                break;
            case "4":
                number4(sc);
                break;
            case "5":
                System.out.println(number5(sc));
                break;
            case "6":
                System.out.println(number6(sc));
                break;
            case "7":
                System.out.println(number7(sc));
                break;
            case "8":
                number8(sc);
                break;
            case "9":
                System.out.println(number9(sc));
                break;
            case "10":
                System.out.println(number10(sc));
                break;
        }
        sc.close();
    }
    public static void number1(Scanner sc){
        System.out.print("Введите а: ");
        double a = sc.nextInt();
        System.out.print("Введите b: ");
        double b = sc.nextInt();
        System.out.print("Введите c: ");
        double c = sc.nextInt();
        double dis = Math.pow(b,2)+4*a*c;
        if (a!=0) {
            System.out.print(a + "x^2 ");
        }
        else if (a==1){ //вывод уравнения
            System.out.print("x^2 ");
        }

        if (b!=0){
            System.out.print(b +"x ");
        }
        else if (b==1){
            System.out.print("x ");
        }
        if (c!=0){
            System.out.print(c+" = 0 ");
        }
        if (dis<0 || a==0 || b==0){
            System.out.println("решений нет");
        }
        else if (dis==0){
            System.out.println("существует одно решение");
            System.out.println((-1*b)/(2*a));
        }
        else if (dis>0){
            System.out.println("существует два решения");
            System.out.println("X1 = "+(Math.pow(dis,0.5)-1*b)/(2*a)+" X2 = "+(-1*(Math.pow(dis,0.5))-1*b)/(2*a));
        }
    }
    public static int number2(Scanner sc){
    	System.out.println("Введите строку");
    	String str = sc.nextLine();
    	int ind1 = str.indexOf("zip");
    	int ind2;
    	if (ind1 == -1){
    		ind2 = ind1;
    	}
    	else {
    		ind2 = str.indexOf("zip", ind1+3);
    	}
    	return ind2;
    }
    public static boolean number3(Scanner sc){
        int sum = 0;
        System.out.println("Введите число");
        int a = sc.nextInt();
        for (int i = 0; i < a; i++){
            if (a%i == 0)
                sum += i;
        }
        boolean z;
        if (a == sum)
            z = true;
        else
            z = false;
        return z;
    }
    public static void number4(Scanner sc){
        String str=sc.nextLine(); //ввод строки
        int x=str.length(); //длинна строки
        String result0=str.substring(0,1);
        String result1=str.substring(x-1,x); //определение 1 и последний символ в строке
        boolean y=result0.equals(result1); //сравнение 1го и последнего символа
        if (x<2){ //ограничение по длинне строки
            System.out.print("несовместимо");
        }
        else if (y==true){ //1 и последний символ не должны быть равны
            System.out.print("два это пара");
        }
        else {
            String newstr=str.replaceFirst(result0,result1); //замена 1го символа на последний
            System.out.print(newstr.substring(0,x-1)+result0);//обрезка строки до предпоследнего символа +1 символ
        }
    }
    public static Boolean number5(Scanner sc){
        String str=sc.nextLine(); //ввод
        int x=0;
        boolean y=false;
        if (str.charAt(0)=='#'){ //проверка на #
            for (int i=1;i<str.length();i++){ //проверка каждого символа на условие
                if ((str.charAt(i)>='0'&& str.charAt(i)<='9') || (str.charAt(i)>='A' && str.charAt(i)<='F') || (str.charAt(i)>='a' && str.charAt(i)<='f')){
                    x+=1;
                }
            }
            if (x==6 && str.length()==7){ //проверка строки на длинну и выполнение условия для всех символов
                y=true;
            }
            else {
                y=false;
            }
        }
        return y;
    }
    public static Boolean number6(Scanner sc){
        String str1=sc.nextLine();
        String str2=sc.nextLine();  //ввод строк
        int x1=0;
        int x2=0;
        int y1=0;
        int y2=0;
        boolean povt1=false;
        boolean povt2=false;
        for (int i=0;i<str1.length();i++){ //проверка на уникальность каждого символа
            int x=str1.charAt(i);
            for (int d=0;d<str1.length();d++){ //символ сравнивается с каждым символом строки
                if (x==str1.charAt(d)){
                    x1+=1;
                }
                if (x1>1){ //если есть повтор, то это фиксируется
                    povt1=true;
                }
            }
            if (x1==1){ //считается количесвто уникальных символов
                y1+=1;
            }
        }
        if (povt1==true){ //добавляются дублирующиеся символы
            y1+=1;
        }
        for (int i=0;i<str2.length();i++){ //такая же проверка для 2 строки
            int x=str2.charAt(i);
            for (int d=0;d<str2.length();d++){
                if (x==str2.charAt(d)){
                    x2+=1;
                }
                if (x2>1){
                    povt2=true;
                }
            }
            if (x2==1) {
                y2 += 1;
            }
        }
        if (povt2==true){
            y2+=1;
        }
        boolean a=false;
        if (y1==y2){ //сравнение количества уникальных элементов строк
            a=true;
        }
        else {
            a=false;
        }
        return a;
    }
    public static Boolean number7(Scanner sc){
        int x = sc.nextInt();
        int dlin=0;
        int left=0;
        int right=0;
        boolean z;
        int x1=x*x;
        int y=x1;
        while (x1 > 0){ //определение длинны числа
            x1=x1/10;
            dlin++;
        }
        if (dlin%2==0){ //случай при четной длинне числа
            dlin=dlin/2;
            left=(int)(y/Math.pow( 10, dlin )); //нахождение левой части
            right=(int)(y%Math.pow( 10, dlin )); //нахождение правой части
        }
        else { //нечётная длинна числа
            dlin=dlin/2;
            left=(int) (y/Math.pow( 10, dlin+1 )); //нахождение левой части
            right=(int)(y%Math.pow( 10, dlin+1 )); //нахождение правой части
        }
        if (left+right==x){ //сравнение суммы и данного числа
            z=true;
        }
        else {
            z=false;
        }
        return z;
    }
    public static void number8(Scanner sc){
        String str=sc.nextLine();
        int n=str.length();
        int sum=0;
        int max=0;
        for (int i=0; i<n; i++ ){ //проверка элементов строки на 0
            if (str.charAt(i)=='0'){
                sum++;
            }
            else {
                if (sum>max){ //вычисление максимальной последовательности
                    max=sum;
                    sum=0;
                }
                else{
                    sum=0;
                }
            }
        }
        System.out.print("0".repeat(max)); //вывод максимальной последовательности
    }
    public static int number9(Scanner sc){
        int x = sc.nextInt();
        int prov=0;
        int prov2=0;
        int konez=0;
        int k=0;
        for (int i=2; i<x; i++){ //проверка самого число на простое (перебор делением на все числа до данного)
            if (x%i==0) {
                prov++;
            }
        }
        if (prov!=0){ //если число не простое то проверяются числа после данного
            k=x+1;
            while (prov2==0){ //тело проверки
                for (int t=2; t<k;t++){
                    if(k%t==0){
                        prov2++;
                        k++;
                    }
                }
            }
        }
        if (prov==0) {
            konez = x;
        }
        else {
            konez=k;
        }
        return konez;
    }
    public static boolean number10(Scanner sc){
        System.out.println("Введите x");
        int x = sc.nextInt();
        System.out.println("Введите y");
        int y = sc.nextInt();
        System.out.println("Введите z");
        int z = sc.nextInt();
        boolean kon=false;
        if (x<y+z || y<x+z || z<x+y){ //проверка на стороны треугольника
            if (x>y && x>z){ //проверка по т. Пифагора если х наибольший
                if (x*x==y*y+z*z){
                    kon=true;
                }
            }
            else if (y>x && y>z){ //проверка по т. Пифагора если у наибольший
                if (y*y==x*x+z*z){
                    kon=true;
                }
            }
            else if (z>x && z>y){ //проверка по т. Пифагора если z наибольший
                if (z*z==x*x+y*y){
                    kon=true;
                }
            }
            else {
                System.out.print("Числа не являются длинами сторон треугольника");
            }
        }
        return kon;
    }
}