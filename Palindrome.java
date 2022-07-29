package HW_2;

import java.util.Scanner;

// Задача 2:
// На вход программы подаётся строка,
// в результате должно быть выведено
// является ли входная строка палиндромом.

public class Palindrome {

    public static void main(String[] args) {
        System.out.println("Введи строку для проверки: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        StringBuffer buffer = new StringBuffer(line);
        String reversLine = String.valueOf(buffer.reverse());
        if(line.equals(reversLine)) {
            System.out.println("Эта строка является полидромом:   " + line);
        }
        else {
            System.out.println("Это бред, строка не полиндром   " + reversLine);
        }
    }
}
