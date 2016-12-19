package Java_8_task.stream_interfaces;

/**
 * Created by Maxim on 12/19/2016.
 */
public interface KeyCondition<T> {
    T getKey(T t);
}
