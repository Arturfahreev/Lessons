package com.company;
import java.util.Scanner;

//Два целочисленных массива. Найти первое вхождение второго массива в первом массиве
// и вывести индекс эл-та, с которого оно начинается.
//(Например, {1, 2, 3, 4, 2, 3, 4} и {2, 3, 4} → Ответ: 1)

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество чисел в 1-ом массиве:");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];


        System.out.println("Введите числа в 1-ом массиве:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        } //заполнение 1-го массива

        System.out.println("Введите количество чисел во 2-ом массиве:");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        System.out.println("Введите числа во 2-ом массиве:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        } //заполнение 2-го массива

        int j = 0;
        int index = -1;

        for (int i = 0; i < n1; i++) {
            if (arr1[i] == arr2[j]) {
                index = i - j;
                j++;
                if (j == arr2.length) {
                    System.out.println("Индекс элемента:" + " " + index);
                    break;
                }

            }

        }
    }

}

//            for (int j = 0; j < n1 ; j++) {
//
//                    if (arr2[i] == arr1[j]) {
//                        int x = i;
//                        int y = j;
//                        number = arr1[j];
//
//                        while (arr2[x] == arr1[y]){
//                            if (x < n2 - 1) {
//                                x++;
//                            }
//                            if (y < n1 - 1) {
//                                y++;
//                            }
//                            count++;
//
//                            if (count == n2) {
//                                System.out.println(count);
//                                break;
//                            }
//
////                            if (count < n2) {
////                                count = 0;
////                            }
//                        }
//
//                    }
//
//                }
//
//            }
//        }
//
//    }
//}
