//Сравнивается два массива, выводит true, если элементы совпадают
public class Test24EqualArrays {

    public static void main(String[] args) {
        int[][] array1 = {{1, 2, 4}, {5, 234}, {1, 23, 45, 3}
        };
        int[][] array2 = {{1, 2, 4}, {5, 23}, {1, 23, 45, 3}
        };
        System.out.println(task(array1, array2));
    }
    public static boolean task (int[][] array1, int[][] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            int[] row1 = array1[i];
            int[] row2 = array2[i];
            if (row1.length != row2.length) return false;

            for (int j = 0; j < row1.length; j++) {
                if (row1[j] != row2[j]) return false;
            }
        }
        return true;
    }
}
