package HW_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Задача 1:
// Быки и коровы

public class BullAndCow {
    private int length;
    private int[] computerArr;
    private int[] userArr;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void generateComputerArr(){
        computerArr = new int[length];
        int counter = 0;
        int numTmp = 0;
        while (counter<4){
             numTmp = (int) (Math.random() * 10);
            if ((numTmp != computerArr[0]) && (numTmp != computerArr[1]) && (numTmp != computerArr[2]) && (numTmp != computerArr[3])) {
                computerArr[counter] = numTmp;
                counter++;
            }
        }
    }

    public void setUserArr() {
        userArr = new int[length];
        int counter = 0;
        int numTmp = 0;
        Scanner scanner = new Scanner(System.in);
        while (counter < 4){
            System.out.println("Введи " + (counter+1) + "-e число: ");
            numTmp = scanner.nextInt();
            if ((numTmp != userArr[0]) && (numTmp != userArr[1]) && (numTmp != userArr[2]) && (numTmp != userArr[3])) {
                userArr[counter] = numTmp;
                counter++;
            }
        }
    }

    public void arrayComparation() {
        int counter = 0;
        List listTmp = new ArrayList<>();
        while(counter < length) {
            if (computerArr[counter] == userArr[counter]) {
                listTmp.add(computerArr[counter]);
            }
            counter++;
        }
        System.out.println("Пользователь угадал " + listTmp.size() + " цифры: " + listTmp.toString());
        System.out.println("computerArr = " + Arrays.toString(computerArr) +"\n"+ "userArr = " + Arrays.toString(userArr));
    }

    public static void main(String[] args) {
        BullAndCow bullAndCow = new BullAndCow();
        bullAndCow.setLength(4); // задай кол-во чисел для угадывания
        bullAndCow.generateComputerArr();
        bullAndCow.setUserArr();
        bullAndCow.arrayComparation();
    }
}
