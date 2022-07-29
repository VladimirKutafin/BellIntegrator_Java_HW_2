package HW_2;

import java.io.*;

// Задача 5
// https://acmp.ru/index.asp?main=task&id_task=70

public class LineDegree {
    private String filePath;

    public LineDegree(String filePath) {
        this.filePath = filePath;
    }

    public void action() throws IOException {
        String firstString;
        String secondString;
        String result = "";

        File file = new File(filePath);

        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            firstString = bufferedReader.readLine();
            secondString = bufferedReader.readLine();
            int secondStringToInt = Integer.parseInt(secondString);

            if (secondStringToInt > 0 && Math.abs(secondStringToInt) < 100001){
                while (secondStringToInt > 0 && result.length() < 1024) {
                    result = result + firstString;
                    secondStringToInt--;
                }
            }
            else if (secondStringToInt < 0 && (Math.abs(secondStringToInt) < 100001) && (firstString.length() >= Math.abs(secondStringToInt))){
                int lineLengthTmp = firstString.length()/Math.abs(secondStringToInt);
                char[] firstStringChar = firstString.toCharArray();
                for (int i = 0; i < lineLengthTmp; i++) {
                    result = result + firstStringChar[i];
                }
            }
            else {
                System.out.println("Number degree cant = 0");
                result = "NO SOLUTION";
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println(result);
        }
        else {
            System.out.println("File isnt exist");
        }

        if (result.length() > 1023) {
            char[] resultCharArr = result.toCharArray();
            result = "";
            for (int i = 0; i < 1023; i++){
                result = result + resultCharArr[i];
            }
        }

        FileWriter fileWriter = new FileWriter("OUTPUT.TXT");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(result);
        bufferedWriter.close();
        fileWriter.close();
    }


    public static void main(String[] args) throws IOException {
        LineDegree lineDegree = new LineDegree("C:\\Users\\79527\\Documents\\JAVA projects\\9_Bell_Integratog_JavaSchool_homework\\1.txt"); // введи путь до файла в конструктор
        lineDegree.action();
    }
}
