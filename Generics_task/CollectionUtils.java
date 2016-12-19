package Generics_task;

import java.util.*;

public class CollectionUtils {

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }



    public static<T> List<T> newArrayList() {
        return new ArrayList<T>();
    }



    public static<T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }



    public static<T> List<T> limit(List<? extends T> source, int size) {
        List<T> newList = new ArrayList<T>();
        for(T elem : source) {
            newList.add(elem);
            size = size - 1;
            if(size == 0) {
                break;
            }
        }
        return newList;
    }



    public static<T> void add(List<? super T> source, T o) {
        source.add(o);
    }



    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }



    public static<T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }



    public static<T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T elem : c2) {
            if(c1.contains(c2)) {
                return true;
            }
        }
        return false;
    }



    public static<T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> resultList = new ArrayList<T>();
        for(T elem : list) {
            if(elem.compareTo(min) >= 0 && elem.compareTo(max) <= 0) {
                resultList.add(elem);
            }
        }
        Collections.sort(resultList);
        return resultList;
    }



    public static<T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> resultList = new ArrayList<T>();
        for(T elem : list) {
            if(comparator.compare(elem, min) >= 0 && comparator.compare(elem, max) <= 0) {
                resultList.add(elem);
            }
        }
        Collections.sort(resultList, comparator);
        return resultList;
    }



}