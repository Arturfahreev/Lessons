package collections.projectQueue;

public interface InterfaceQueue<T> {
    void put (T o) throws QueueFullException;

    T get() throws QueueEmptyException;

}
