package tests;
/** Два целочисленных массива. Найти первое вхождение второго массива в первом массиве
 * и вывести индекс эл-та, с которого оно начинается.
 * (Например, {1, 2, 3, 4, 2, 3, 4} и {2, 3, 4} → Ответ: 1)
 */

public class Test33ArrInAnotherArr {
    public static void main(String[] args) {
       int[] arr1 = Test01.arrFillScan(Test01.scanInt());//Метод считывает числа и заполняет массив
       int[] arr2 = Test01.arrFillScan(Test01.scanInt());
       arrInAnotherArr(arr1, arr2);
    }
    public static void arrInAnotherArr (int[] arr1, int[] arr2) { //Сравниваем два массива, входит ли второй в первый
         int j = 0, index = 0;
         if (arr1.length > arr2.length) {
             for (int i = 0; i < arr1.length; i++) {
                 if (arr1[i] == arr2[j] ) {
                     j++;
                     if (j == arr2.length) {
                         index = (i - arr2.length + 1);
                         System.out.println("index: " + index);
                         break;
                     }
                 } else if ( arr1[i] != arr2[j]) {
                     j = 0;
                    } else System.out.println("Второй массив не входит в первый");
             }
         } else System.out.println ("Первый массив должен быть больше второго");
     }
}
