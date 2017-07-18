/*
https://www.****.com/challenges/java-1d-array
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionArray1DPart2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SolutionArray1DPart2. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int array[] = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }
            String answer = "YES";
//            for (int j = 0; j < n; j++) {
//                System.out.print(j + "\t");
//            }
//            System.out.println();
//            for (int j = 0; j < n; j++) {
//                System.out.print(array[j] + "\t");
//            }
//            System.out.println();
            try {
            boolean isChanged;
            boolean isFirstJumpPossible = true;
            do {
                isChanged = false;
//                System.out.println("Рассматриваем позиции с 0 по " + (n - m - 1));
                for (int k = 0; k < n - m; k++) {
//                    System.out.println("Позиция: " + k);
                    if ((k == 0) || ((array[k] == 0) & (array[k - 1] != 0))) {
//                        System.out.println("Найдена новая группа нулей");
                        int startPos = k;
                        int endPos = k;
                        while ((endPos < n - 1) && (array[endPos + 1] == 0)) {
                            endPos++;
                        }
//                        System.out.println("Конечная позиция: " + endPos);
                        boolean canBeJumpedIn = false;
                        boolean canBeJumpedOut = false;
                        for (int j = startPos; j <= endPos; j++) {
                            if (j >= m) {
                                if (array[j - m] == 0) {
//                                    System.out.println("Можно впрыгнуть на позицию: " + j);
                                    canBeJumpedIn = true;
                                }
                            }
                            if (j + m < n) {
                                if (array[j + m] == 0) {
//                                    System.out.println("Можно выпрыгнуть с позиции: " + j);
                                    canBeJumpedOut = true;
                                }
                            }
                        }
                        if (!(canBeJumpedIn & canBeJumpedOut) & !(startPos == 0) & (endPos < n - m)) {
//                            System.out.println("Группа недоступна с одной из сторон, закрашиваем");
                            isChanged = true;
                            for (int j = startPos; j <= endPos; j++) {
                                array[j] = 1;
                            }
//                            for (int j = 0; j < n; j++) {
//                                    System.out.print(j + "\t");
//                                }
//                            System.out.println();
//                            for (int j = 0; j < n; j++) {
//                                    System.out.print(array[j] + "\t");
//                                }
//                            System.out.println();
                        }
                        if ((startPos == 0) & !canBeJumpedOut & (endPos < n - m)) {
//                            System.out.println("Невозможно выпрыгнуь из начальной группы нулей. Проигрыш");
                            isFirstJumpPossible = false;
                        }
                    }
                }
            } while (isChanged);
//                System.out.println("Ищем группы единиц");
            boolean isLongPeriodOfOnes = false;
            for (int k = 1; k < n; k++) {
                int startPos = 0;
                int endPos = 0;
                if ((array[k] == 1) & (array[k - 1] == 0)) {
//                        System.out.println("Найдена группа единиц, начальная позиция: " + k);
                    startPos = k;
                    endPos = k;
                    while ((endPos < n - 2) && (array[endPos + 1] == 1)) {
                        endPos++;
                    }
//                        System.out.println("Конечная позиция: " + endPos);
                    if (endPos - startPos > m - 2) {
//                            System.out.println("Группу невозможно перепрыгнуть");
                        isLongPeriodOfOnes = true;
                    }
                }
            }
//            System.out.println("Проверяем, есть ли в последнем отрезке 0, на который можно прыгнуть");
            boolean isGoodNullInTheEnd = false;
            for (int k = n - m; k < n; k++) {
//                System.out.println("Позиция: " + k);
                if (k >= m) {
                    if ((array[k] == 0) & (array[k - m] == 0)) {
//                        System.out.println("Можно прыгнуть");
                        isGoodNullInTheEnd = true;
                    }
                }
            }
            if (!isGoodNullInTheEnd) {
//                System.out.println("Прыгнуть на 0 в последнем отрезке нельзя, проверям, можно ли шагнуть в его начало");
                if ((m > 0) && ((array[n - m - 1] == 0) & (array[n - m] == 0))) {
//                    System.out.println("Можно");
                    isGoodNullInTheEnd = true;
                } else {
                    if ((m == 0) & !isLongPeriodOfOnes) {
//                        System.out.println("Стартовая точка и так находится в его начале");
                        isGoodNullInTheEnd = true;
                    }
                }
            }
            answer = (!isLongPeriodOfOnes & isGoodNullInTheEnd & isFirstJumpPossible) ? "YES" : "NO";
            }
            catch (ArrayIndexOutOfBoundsException e) {
                answer = "YES";
            }
            System.out.println(answer);
        }
    }
}