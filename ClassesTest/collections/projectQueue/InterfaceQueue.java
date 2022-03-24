package collections.projectQueue;

public interface InterfaceQueue<T extends Number> {
    void put (T o) throws QueueFullException;

    T get() throws QueueEmptyException;

}
