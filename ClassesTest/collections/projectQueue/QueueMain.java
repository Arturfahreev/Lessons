package collections.projectQueue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<Integer> intQueue = new Queue<>(new Integer[5]);
        Queue<Double> dobQueue = new Queue<>(new Double[5]);

        try {
            for (int i = 0; i < intQueue.object.length; i++) {
                intQueue.put(i);
                System.out.println("Добавлен " + i);

            }
        } catch (QueueFullException exc) {
            System.out.println(exc);

        }

        intQueue.printGet();

        try {
            for (int i = 0; i < dobQueue.object.length; i++) {
                double j = (double) i;
                dobQueue.put(j);
                System.out.println("Добавлен " + i);

            }
        } catch (QueueFullException exc) {
            System.out.println(exc);

        }

        dobQueue.printGet();


    }
}
