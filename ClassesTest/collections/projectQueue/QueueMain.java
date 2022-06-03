package collections.projectQueue;
//Создается очередь на основании дженериков

public class QueueMain {
    public static void main(String[] args) throws QueueFullException {

        Queue<Integer> intQueue = new Queue<>(new Integer[5]);
        Queue<Double> dobQueue = new Queue<>(new Double[5]);

        try {
            for (int i = 0; i < intQueue.object.length; i++) {
                intQueue.put(i);
                System.out.println("Добавлен " + i);
                if (i == intQueue.object.length - 1) System.out.println();
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }

        intQueue.printGet();

        try {
            for (int i = 0; i < dobQueue.object.length; i++) {
                dobQueue.put((double) i);
                System.out.println("Добавлен " + i);
                if (i == dobQueue.object.length - 1) System.out.println();
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }

        dobQueue.printGet();

    }

}
