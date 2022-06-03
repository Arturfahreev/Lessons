package tests;
//Выводит пары чисел, чья сумма кратна пяти
public class Test37DivFive {
    public static void main(String[] args) {
        int [] arr = new int[10];
        Array arrayInt = new Array(arr);
        int count = 0;
        for (int i = 0; i < arrayInt.array.length; i++) {
            arrayInt.array[i] = i + 1;
            System.out.print(arrayInt.array[i] + " ");
        }
        System.out.println();

        for (int n = 1; n < arrayInt.array.length; n++) {

            for (int i = 0; i < arrayInt.array.length - 1; i++) {
                for (int j = i + 1; j < arrayInt.array.length; j++) {
                    if ((arrayInt.array[i] + arrayInt.array[j] + arrayInt.f(n)) % 5 == 0) {
                        System.out.println(arrayInt.array[i] + " + " + arrayInt.array[j] + " = " + (arrayInt.array[i] + arrayInt.array[j]));
                        count++;
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }
}

class Array {
    public int[] array;

    Array (int[] array) {
        this.array = array;
    }

    int f (int n) {
        if (n > 1) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += array[i];
            }
            return sum;
        }
        else return 0;

    }


}
