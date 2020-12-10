package lab1;

import java.util.Scanner;

public class Primes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean a;
        for (int n = 2; n<101; n++){ //Перебираем значения от 2 до 101
            a = isPrime(n);
            if (a == true)
                System.out.println(n);
        }
    }
    public static boolean isPrime(int n) { //проверяем на простоту
        int b = 0;
        boolean c;
        c = true;
        for(int i = 2; i<n; i++){
            int a = n%i;
            if (a == 0)
                b += 1;
        }
        if (b > 0)
            c = false;
        else if (b == 0)
            c = true;
        return c;
    }
}