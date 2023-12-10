package GenericsInterfaces;

public interface GenMyQueue<T> {
    boolean offer(T object);
    T poll();
    T peek();
}
