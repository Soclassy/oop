package lab1;
import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку для ее инвертирования и проверки на палиндромность");
        String inputString = in.nextLine();
        System.out.println(reverseString(inputString));
        System.out.println(palindrome(inputString));
        in.close();
    }
    public static String reverseString(String string) {
        /*Инвертирование строки*/
        StringBuilder finalString = new StringBuilder();
        for (int pos = string.length() - 1; pos > -1; pos--) {
            finalString.append(string.charAt(pos));
        }
        return "Инвертированная строка:\n" + finalString.toString();
    }
    public static String palindrome(String string) {
        /*Проверка на палиндромность*/
        StringBuilder finalString = new StringBuilder();
        for (int pos = string.length() - 1; pos > -1; pos--) {
            finalString.append(string.charAt(pos));
        }
        return (finalString.toString().equals(string)? "Палиндром":"Не палиндром");
    }
}