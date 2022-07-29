package HW_2;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Задача 6:
// https://acmp.ru/index.asp?main=task&id_task=231

public class UnpackString {
    private String filePath;

    public UnpackString(String filePath) {
        this.filePath = filePath;
    }

    public void unpack() throws IOException {
        String firstString;
        ArrayList <String> listNum = new ArrayList<>();
        ArrayList <String> listCharacter = new ArrayList<>();
        String result = "";

        File file = new File(filePath);

        if (file.exists()) {
            int numberOfIteration = 0;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            firstString = bufferedReader.readLine();
            Pattern patternFirst = Pattern.compile("[A-Z]+");
            Pattern patternSecond = Pattern.compile("[0-9]+");
            Matcher matcherFirst = patternFirst.matcher(firstString);
            Matcher matcherSecond = patternSecond.matcher(firstString);
            while (matcherFirst.find() && matcherSecond.find()) {
                listCharacter.add(matcherFirst.group());
                listNum.add(matcherSecond.group());
            }
            for (int i = 0; i < listCharacter.size(); i++) {
                numberOfIteration = Integer.parseInt(listNum.get(i));
                for (int j = 0; j < numberOfIteration; j++) {
                    result = result + listCharacter.get(i);
                }
            }

            FileWriter fileWriter = new FileWriter("OUTPUT.TXT");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String lineTmp;
            int maxLineLengthInFile = 40;//размер блока
            int numTmp = 0;
            while (numTmp < result.length()){
                lineTmp = result.substring(numTmp,Math.min(numTmp += maxLineLengthInFile, result.length()));
                bufferedWriter.write(lineTmp);
                System.out.println(lineTmp);
            }
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public static void main(String[] args) throws IOException {
        UnpackString unpackString = new UnpackString("C:\\Users\\79527\\Documents\\JAVA projects\\9_Bell_Integratog_JavaSchool_homework\\1.txt");
        unpackString.unpack();
    }
}
