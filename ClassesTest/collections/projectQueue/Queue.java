package collections.projectQueue;

import java.util.Random;

public class Queue<T extends Number> implements InterfaceQueue<T> {
    T[] object;
    private int putLock, getLock;
    private int size;

    public Queue (T[] object) {
        this.object = object;
        putLock = getLock = 0;
    }


    @Override
    public void put(T o) throws QueueFullException {
        if (object.length == putLock) {
            throw new QueueFullException(object.length);
        }
        object[putLock++] = o;
        System.out.print("Класс: " + object.getClass().getName() + " ");
    }

    @Override
    public T get() throws QueueEmptyException {
        if (getLock == putLock) {
            throw new QueueEmptyException();
        }
        return object[getLock++];
    }

    public void printGet () {
        try {
            for (int i = 0; i < object.length; i++) {
                T n = this.get();
                System.out.println("Получен " + n + " " + object.getClass().getName());
                if (i == object.length - 1) System.out.println();
            }

        } catch (QueueEmptyException exc) {
            System.out.println(exc);

        }
    }
}
