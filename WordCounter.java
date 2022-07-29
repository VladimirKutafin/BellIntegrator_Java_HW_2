package HW_2;

// Задача 7:
// На вход подаётся текст, слова отделяются пробелами,
// для каждого слова необходимо вывести количество его повторений

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    private String text = "";

    public WordCounter(String text) {
        this.text = text;
    }

    public void count() {
        int counter = 0;
        String[] words = text.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!map.containsKey(word)){
                map.put(word, 1);
            }
            else {
                counter = map.get(word);
                counter++;
                map.put(word, counter);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry =  iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        WordCounter wordCounter = new WordCounter(text);
        wordCounter.count();
    }
}
