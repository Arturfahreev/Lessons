package collections.projectQueue;

public class QueueFullException extends Exception {
    private int size;

    public QueueFullException (int size ) {
        this.size = size;
    }

    @Override
    public String toString () {
        return "Ошибка: максимальный размер массива: " + size;
    }
}
