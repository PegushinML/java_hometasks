package Java_8_task;

import Java_8_task.stream_interfaces.FilterCondition;
import Java_8_task.stream_interfaces.KeyCondition;
import Java_8_task.stream_interfaces.TransformCondition;
import Java_8_task.stream_interfaces.ValueCondition;

import java.util.*;

/**
 * Created by Maxim on 12/19/2016.
 */
public class Streams<T> {
    private final Collection<T> collection;

    private Streams(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T> Streams<T> of(Collection<T> collection) {
        return new Streams<T>(collection);
    }

    public Streams<T> filter(FilterCondition<? super T> filterCondition) {
        Collection<T> filteredCollection = new ArrayList<>();
        for(T element : collection) {
            filteredCollection.add(element);
            if(filterCondition.check(element)) {
                filteredCollection.remove(element);
            }
        }

        return new Streams<T>(filteredCollection);
    }

    public Streams<T> transform(TransformCondition<? super T> transformCondition) {
        Collection<T> transformedCollection = new ArrayList<>();
        for(T elem : collection) {
            transformedCollection.add((T) transformCondition.transform(elem));
        }
        return new Streams<T>(transformedCollection);
    }

    public Map<T, T> toMap(KeyCondition<T> cond1, ValueCondition<T> cond2) {
        Map<T, T> map = new HashMap<>();
        for(T elem : collection) {
            map.put(cond1.getKey(elem), cond2.getValue(elem));
        }
        return new HashMap<>();
    }
}

