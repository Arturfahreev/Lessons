package collections.bitSet;

import java.util.BitSet;

public class primeNumbers {
    public static void main(String[] args) {
        int numbers = 2_000_000_000;
        BitSet bitSet = new BitSet(numbers + 1);
        int i = 0;
        int k = 0;
        while (i < numbers) {
            bitSet.set(i);
            i++;
        }
        i = 2;

        while ((i * i) < numbers) {
            k = i * i;
            if (bitSet.get(k)) {
                while (k <= numbers) {
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }
        int c = 1;
        for (i = 1, k = 1; i < numbers; i++, k++) {

            if (bitSet.get(i)) {
                //System.out.print(c + " ");
                c++;
            }
            if (k % 10_000_000 == 0) {
                System.out.println(c);
                c = 1;
            }
        }


    }
}
