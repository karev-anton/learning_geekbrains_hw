
package com.GeekBrains.lesson2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)  {
        int counter=0;
        //Задать целочисленный массив, состоящий из элементов 0 и 1.
        int[] test_array = new int[]{1, 0, 1, 1, 0, 1, 0, 0, 1};

        //С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Массив  до   модификации:"+ Arrays.toString(test_array));
        while (counter<test_array.length)

        {
            test_array[counter] =Math.abs(test_array[counter]-1);
            counter++;
        }
        System.out.println("Массив после модификации:"+ Arrays.toString(test_array)+"\n");

        // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] test_array2 = new int[8];
        int i=0;
        for  (int counter2 = 1; counter2<test_array2.length; counter2++)
        {
            test_array2[counter2]=test_array2[counter2-1]+3;

        }
        System.out.println("Заполненный массив:"+ Arrays.toString(test_array2)+"\n");

        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        i=0;
        int[] test_array3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Массив до    умножения:"+ Arrays.toString(test_array3));
        while (i<test_array3.length)
        {
            if (test_array3[i] <6)
            {
            test_array3[i]*=2;
            }
            i++;
        }
        System.out.println("Массив после умножения:"+ Arrays.toString(test_array3)+"\n");

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] test_array4 = new int[6][6];
        i=0;
        int j=0;
        System.out.println("Массив до заполнения диагоналей:"+"\n"+Arrays.deepToString(test_array4) .replace("],"
                ,"\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "+"\n"));
        System.out.println("Размерность массива:"+test_array4.length);
        while (i<test_array4.length)
        {
            //основная диагональ
            test_array4[i][i]= 1;
            // вручную подобранная формула для побочной диагонали =)
            j= test_array4.length-i-1;
            test_array4[i][j]=1;
            i++;
        }

        System.out.println("Массив после заполнения диагоналей:"+"\n"+Arrays.deepToString(test_array4) .replace("],"
                ,"\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "+"\n"));

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        boolean swapped = true;
        int[] test_array5 = new int[] {1, 5, -10, -11, 11, 4, 5, 2, 28, 8, 39, 1 };
        int tmp=0;
        System.out.println("Массив для поиска min и max:"+ Arrays.toString(test_array5)+"\n");
        while (swapped) {
            swapped = false;
            j++;
            for (int k = 0; k < test_array5.length - j; k++) {
                if (test_array5[k] > test_array5[k + 1]) {
                    tmp = test_array5[k];
                    test_array5[k] = test_array5[k + 1];
                    test_array5[k + 1] = tmp;
                    swapped = true;
                }

            }
        }
        System.out.println("Минимальное значение:"+ test_array5[0]);
        System.out.println("Максимально значение:"+ test_array5[test_array5.length-1]+"\n");

      /*  6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
      метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
      Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
      граница показана символами ||, эти символы в массив не входят.
       */

        int[] checkBalance = new int[] {2, 2, 2, 1, 2, 2,10, 1};
        System.out.println("Массив для поиска частей одинаковой суммы:"+Arrays.toString(checkBalance));
        System.out.println("Массив содержит место с одинаковой суммой: "+isArrayHaveEqualSide (checkBalance)+"\n");

        //   7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        //   при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

        int[] array_moved = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int z=-25;
//        int z=7;
        System.out.println("Сдвиг массива на:"+z);
        System.out.println("Массив до сдвига:"+Arrays.toString(array_moved));
        System.out.println("Массив после сдвига:"+Arrays.toString(arrayMoover(array_moved,z)));
    }

    //Метод для поиска равных частей

    static boolean isArrayHaveEqualSide (int [] test_array7)
    {
        boolean result=false;
        int n = test_array7.length;
        // Формируем  массив с суммой с левой стороны
        int[] prefixSum = new int[n];
        prefixSum[0] = test_array7[0];
        for (int i = 1; i < n; i++)
        {
            prefixSum[i] = prefixSum[i - 1] + test_array7[i];
        }
        // Формируем массив с суммой с правой стороны
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = test_array7[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            suffixSum[i] = suffixSum[i + 1] + test_array7[i];
        }
        // Попарно сравниваем элементы получившихся массивов
        for (int i = 1; i < n - 1; i++) {
           // System.out.println(prefixSum[i]);
           // System.out.println(suffixSum[i]);

            if (prefixSum[i-1] == suffixSum[i]) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }


    //Метод используется для сдвига всех позиций массива вправо на z
    static int[] arrayMoover (int [] test_array7, int z)
    {

        if (z>0) {
            while (z > 0) {
                int tmp = test_array7[test_array7.length - 1];
                for (int i = test_array7.length - 1; i > 0; i--) {
                    //System.out.println(i);
                    test_array7[i] = test_array7[i - 1];
                }
                test_array7[0] = tmp;
                z--;
            }
        }
        else
        {
            while (z < 0) {
                int tmp = test_array7[0];
                for (int i =1 ; i < test_array7.length; i++) {
                   //System.out.println(i);
                   test_array7[i-1]=test_array7[i];
                }
                test_array7[test_array7.length - 1] = tmp;
                z++;
            }
        }
        return test_array7;
    }

}
