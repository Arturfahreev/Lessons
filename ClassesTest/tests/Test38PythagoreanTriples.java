package tests;

public class Test38PythagoreanTriples {
    public static void main(String[] args) {
        int adjacent = 0;
        int opposite = 0;

        for (int i = 1; i < 200; i++) {
            for (int j = 1; j < 100; j++) {
               double x = Math.pow(adjacent + i, 2) + Math.pow(opposite + j, 2);
               int z = (int) x;
               if (Math.sqrt(z) % 1 == 0 ) System.out.println((adjacent + i) + "^2 + " + (opposite + j) + "^2 = " + z);

            }

        }

    }
}
