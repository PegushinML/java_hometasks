package Generics_task;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Maxim on 10/23/2016.
 */
public class CountMapImpl<E> implements CountMap<E> {
    private final Map<E,Integer> map;

    public CountMapImpl() {
        map = new TreeMap<E, Integer>();
    }

    public void add(E element) {
        if (map.containsKey(element)) {
            map.put(element, map.get(element) + 1);
        } else {
            map.put(element, 1);
        }
    }

    public int getCount(E element) {
        if(map.containsKey(element)) {
            return map.get(element);
        } else {
            return 0;
        }
    }

    public int remove(E element) {
        Integer count = 0;
        if (map.containsKey(element)) {
            count = map.get(element);
            map.remove(element);
        }
        return count;
    }

    public int size() {
        return map.size();
    }

    public void addAll(CountMap<E> source) {
        Map<E, Integer> sourceMap = source.toMap();
        map.putAll(sourceMap);
    }

    public Map toMap() {
        Map<E, Integer> newMap = new TreeMap<E, Integer>();
        newMap.putAll(map);
        return newMap;
    }

    public void toMap(Map destination) {
        destination.putAll(map);
    }
}
