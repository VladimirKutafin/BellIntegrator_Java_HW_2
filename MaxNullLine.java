package HW_2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Задача 4:
// На вход подаётся строка из нулей и единиц,
// необходимо посчитать максимальное количество подряд идущих нулей.

public class MaxNullLine {
    private String line = "";

    public int maxNullLineCounter(String line) {
        List listNull = new ArrayList<String>();
        int counter = 0;
        Pattern pattern = Pattern.compile("(0+)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            listNull.add(matcher.group());
        }
        if (listNull.size() > 0) {
            int largestString = listNull.get(0).toString().length();
            int index = 0;

            for (int i = 0; i < listNull.size(); i++) {
                if (listNull.get(i).toString().length() > largestString) {
                    largestString = listNull.get(i).toString().length();
                    index = i;
                }
            }
            counter = listNull.get(index).toString().length();
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println("Введи число состоящее из нулей и единиц:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        MaxNullLine maxNullLine = new MaxNullLine();
        System.out.println("Максимальное кол-во нулей идущих подряд:   " + maxNullLine.maxNullLineCounter(line));

    }
}
