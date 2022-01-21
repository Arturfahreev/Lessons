//Находится сумма числе между минимальным и максимальным в массиве
public class Test25SumBetweenMinAndMax {
    public static void main(String[] args) {
        //              0  1  2  3  4   5   6  7
        int[] values = {1, 15, 4, 0, 10, 14, 1, 5};
        System.out.println("min: " + findMinIndex(values));
        System.out.println("max: " + findMaxIndex(values));
        System.out.println(findSumBetweenMinAndMax(values));

    }
    public static int findSumBetweenMinAndMax (int[] values) {
        int minIndex = findMinIndex(values);
        int maxIndex = findMaxIndex(values);
        int result = 0;
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        for (int i = minIndex + 1; i < maxIndex; i++) {
            result += values[i];
        }
        return result;
    }

    public static int findMinIndex (int[] values){
        int minIndex = 0;
        int minValue = values[minIndex];
        for (int i = 0; i < values.length; i++) {
            if (minValue > values[i]){
                minValue = values[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public static int findMaxIndex (int[] values){
        int maxIndex = 0;
        int maxValue = values[maxIndex];
        for (int i = 0; i < values.length; i++) {
            if (maxValue < values[i]){
                maxValue = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
