package tests;
/**
 * Ввести большое число и проверить является ли число простым.
 * Дополнительно использовать методы, ускоряющие проверку.
 *
 * 2147437843 - 12753 миллисекунд
 * 10000000019 - 58811 миллисекунд, 31883 миллисекунд (while c делением на 2), 21486 миллисекунд (проверка на 3),
 * 100000000019 - 238280 миллисекунд (проверка на 2, 3, 5), 296034 миллисекунд (проверка только на 2)
 */

import java.util.Scanner;

public class Test34PrimeSimpleTest235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long startTime = System.currentTimeMillis();
        long result = test(n);

        if (result == 0) System.out.println("Is prime");
        else System.out.println("Not prime, divider: " + result);

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent + " миллисекунд");
    }
    public static long test (long n) {
        long result = 0;
        long i = 2;
        while (i < (n / 2)) {

            if (n % i == 0) {
                result = i;
                return result;
            }
            if (i == 2) {
                i = i + 1;
            } else if (i == 3) {
                i = i + 2;
            } else {
                i = i + 2 + Number3.create() + Number5.create(); //Исключаем все четные числа и которые деляется на 3 и 5
                System.out.print(i + " ");
            }
        }
        return result;
    }
}

class Number3 {
   public static int count = 0;

    Number3() {
        count = count + 1;
    }

    public static int create() {
        Number3 numb = new Number3();
        if (count == 2) {
            count = 0;
            return 2;
        } else return 0;
    }
}

class Number5 {
    public static int count5 = -1;

    Number5() {
        count5 = count5 + 1;
    }

    public static int create() {
        Number5 numb1 = new Number5();
         if ( count5 == 6) {
             return 4;
         } else if (count5 == 7) {
             return -2;
         } else if (count5 == 8) {
             count5 = 0;
             return 4;
         }  else return 0;
    }
}
// Объяснение работы:
// (2) 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 41 43 45 47 49 51 53 55 57 59 61 63 65 67 69 71 73 75 77 79 81 83 85 87 89 91 93 95 97 99 101 103 105 107 109 111 113 115 117 119 121 123 125 127 129 131 133 135 Is prime
// (3) 5 7   11 13    17 19    23 25    29 31    35 37    41 43    47 49    53 55    59 61    65 67    71 73    77 79    83 85    89 91    95 97    101 103     107 109     113 115     119 121     125 127     131 133     137 Is prime
// (5) 5 7   11 13    17 19    23       29 31       37    41 43    47 49    53       59 61       67    71 73    77 79    83       89 91       97    101 103     107 109     113         119 121         127     131 133

// 7 =  5 +  2 + 0 + 0 (count == 1,      count2 == 0)
// 11 = 7 +  2 + 2 + 0 (count == 2 -> 0, count2 == 1) = начало цикла
// 13 = 11 + 2 + 0 + 0 (count == 1,      count2 == 2)
// 17 = 13 + 2 + 2 + 0 (count == 2 -> 0, count2 == 3) = 17
// 19 = 17 + 2 + 0 + 0 (count == 1,      count2 == 4)
// 23 = 19 + 2 + 2 + 0 (count == 2 -> 0, count2 == 5) = 23
// 29 = 23 + 2 + 0 + 4 (count == 1,      count2 == 6 -> 0 ( +4)
// 31 = 29 + 2 + 2  -2 (count == 2 -> 0, count2 == 7 -> 0 ( -2) )
// 37 = 31 + 2 + 0 + 4 (count == 1,      count2 == 8 -> 0)( +4) обнулили
// 41 = 37 + 2 + 2 + 0 (count == 2 -> 0, count2 == 1) пошел повтор цикла
// 43 = 41 + 2 + 0 + 0 (count == 1 ,     count2 == 2)
// 47 = 43 + 2 + 2 + 0 (count == 2 -> 0, count2 == 3)
// 49 = 47 + 2 + 0 + 0 (count == 1,      count2 == 4)
// 53 = 49 + 2 + 2 + 0 (count == 2 -> 0, count2 == 5)
// 59 = 53 + 2 + 0 + 4 (count == 1,      count2 == 6 -> 0 )
// 61 = 59 + 2 + 2 - 2 (count == 2 -> 0, count2 == 7 -> 0 ( -2) )
// 67 = 61 + 2 + 0 + 4 (count == 1,      count2 == 8 -> 0) (+4)
// 71 = 67 + 2 + 2 + 0 (count == 2 -> 0, count2 == 1) пошел повтор цикла
// 73 = 71 + 2 + 0 + 0 (count == 1 ,     count2 == 2)
// 77 = 73 + 2 + 2 + 0 (count == 2 -> 0, count2 == 3)